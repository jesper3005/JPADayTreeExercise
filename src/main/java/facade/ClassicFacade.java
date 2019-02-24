/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import entity.Employee;
import entity.Office;
import entity.OrderClassic;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import mappers.CustomerSimple;

/**
 *
 * @author Jesper
 */
public class ClassicFacade {

    EntityManagerFactory emf;

    public ClassicFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Employee createEmployee(String lastName, String firstName, String extension, String email, String jobTitle, String officeCode) {
        Employee emp = new Employee(lastName, firstName, extension, email, jobTitle);
        EntityManager em = emf.createEntityManager();
        Office of = em.find(Office.class, officeCode);
        emp.setOffice(of);

        try {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return emp;
    }

    public Customer findCustomer(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Customer c = em.find(Customer.class, id);

            em.getTransaction().commit();
            return c;
        } finally {
            em.close();
        }
    }

    public Customer updateCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }

    public long employeeCountBAD() {
        EntityManager em = emf.createEntityManager();
        try {
            return (long) em.createNamedQuery("Employee.findAll").getResultList().size();
        } finally {
            em.close();
        }
    }

    public long employeeCount() {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createNamedQuery("select count (e) from Employee e");
            return (long) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        
        try {
            
            Query q = em.createNamedQuery("Employee.findAll");
            return (List<Employee>) q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Customer> getCustomerInCity(String city) {
        EntityManager em = emf.createEntityManager();
        
        try {
            Query q = em.createNamedQuery("Customer.findByCity");
            q.setParameter("city", city);
            return (List<Customer>) q.getResultList();
            
        } finally {
            em.close();
        }
    }
    
    
    public List<OrderClassic> getOrdersOnHold(String status) {
        EntityManager em = emf.createEntityManager();
        
        try {
            Query q = em.createNamedQuery("OrderClassic.findByStatus");
            q.setParameter("status", status);
            return (List<OrderClassic>) q.getResultList();
            
        } finally {
            em.close();
        }
    }
    
    public List<OrderClassic> getOrdersOnHoldByCustomer(String status, int id) {
        EntityManager em = emf.createEntityManager();
        
        try {
            Query q = em.createNamedQuery("OrderClassic.findByStatusCustomer");
            q.setParameter("status", status);
            q.setParameter("id", id);
            return (List<OrderClassic>) q.getResultList();
            
        } finally {
            em.close();
        }
    }
    
    public List<String> getCustomerNamesSorted() {
        EntityManager em = emf.createEntityManager();
        
        try {
            Query q = em.createNamedQuery("Customer.findAllNames");
            return (List<String>) q.getResultList();
            
        } finally {
            em.close();
        }
    }
    
//    public List<CustomerSimple> getCustomersSimple() {
//        EntityManager em = emf.createEntityManager();
//        
//        try {
//            Query q = em.createNamedQuery("Customer.findAll");
//            List<CustomerSimple> list = (List<Customer>) q.getResultList();
//            return list;
//        } finally {
//            em.close();
//        }
//    }
}
