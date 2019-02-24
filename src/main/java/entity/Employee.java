/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Jesper
 */
@Entity
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmployeenumber", query = "SELECT e FROM Employee e WHERE e.employeenumber = :employeenumber")
    , @NamedQuery(name = "Employee.findByLastname", query = "SELECT e FROM Employee e WHERE e.lastname = :lastname")
    , @NamedQuery(name = "Employee.findByFirstname", query = "SELECT e FROM Employee e WHERE e.firstname = :firstname")
    , @NamedQuery(name = "Employee.findByExtension", query = "SELECT e FROM Employee e WHERE e.extension = :extension")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findByJobtitle", query = "SELECT e FROM Employee e WHERE e.jobtitle = :jobtitle")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "employeenumber", nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "s1")
    @TableGenerator(name = "s1", table = "My_NEXT_ID",
    initialValue = 2000, allocationSize = 25)

    private Integer employeenumber;

    @Column(name = "lastname", length = 50)
    private String lastname;
    @Column(name = "firstname", length = 50)
    private String firstname;
    @Column(name = "extension", length = 10)
    private String extension;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "jobtitle", length = 50)
    private String jobtitle;
    @OneToMany(mappedBy = "employee")
    private Collection<Customer> customerCollection;
    @OneToMany(mappedBy = "employee")
    private Collection<Employee> employeeCollection;
    @JoinColumn(name = "reportsto", referencedColumnName = "employeenumber")
    @ManyToOne
    private Employee employee;
    @JoinColumn(name = "officecode", referencedColumnName = "officecode")
    @ManyToOne()
    private Office office;

    public Employee() {
    }

    public Employee(Integer employeenumber) {
        this.employeenumber = employeenumber;
    }

    public Employee(String lastName, String firstName, String extension, String email, String jobTitle) {
        this.lastname = lastName;
        this.firstname = firstName;
        this.extension = extension;
        this.email = email;
        this.jobtitle = jobTitle;
    }

    public Integer getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(Integer employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeenumber != null ? employeenumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeenumber == null && other.employeenumber != null) || (this.employeenumber != null && !this.employeenumber.equals(other.employeenumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.classicmodels.Employee[ employeenumber=" + employeenumber + " ]";
    }

}
