/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Customer;
import facade.ClassicFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jesper
 */
public class tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        ClassicFacade facade = new ClassicFacade(emf);
        
// *****************************************************************************
        
//        //Find and update customer
//        Customer c1 = facade.findCustomer(121);
//        c1.setCustomername("NEW NAME");
//        facade.updateCustomer(c1);

// *****************************************************************************
        
//        //Find all employees
//        System.out.println(facade.getAllEmployees());

// *****************************************************************************

//        //Find customer by city
//        System.out.println(facade.getCustomerInCity("NYC"));

// *************************** Find orders by status ***********************

//        System.out.println(facade.getOrdersOnHold("On Hold"));

// ************************* Find orders On Hold by customer ID **********************

//        System.out.println(facade.getOrdersOnHoldByCustomer("On Hold", 144));

        System.out.println(facade.employeeCountBAD());

    }
}
