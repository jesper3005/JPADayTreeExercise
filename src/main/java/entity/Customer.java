/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

/**
 *
 * @author Jesper
 */
@Entity
@Table(name = "customers")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCustomernumber", query = "SELECT c FROM Customer c WHERE c.customernumber = :customernumber")
    , @NamedQuery(name = "Customer.findByCustomername", query = "SELECT c FROM Customer c WHERE c.customername = :customername")
    , @NamedQuery(name = "Customer.findByContactlastname", query = "SELECT c FROM Customer c WHERE c.contactlastname = :contactlastname")
    , @NamedQuery(name = "Customer.findByContactfirstname", query = "SELECT c FROM Customer c WHERE c.contactfirstname = :contactfirstname")
    , @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customer.findByAddressline1", query = "SELECT c FROM Customer c WHERE c.addressline1 = :addressline1")
    , @NamedQuery(name = "Customer.findByAddressline2", query = "SELECT c FROM Customer c WHERE c.addressline2 = :addressline2")
    , @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM Customer c WHERE c.city = :city")
    , @NamedQuery(name = "Customer.findByState", query = "SELECT c FROM Customer c WHERE c.state = :state")
    , @NamedQuery(name = "Customer.findByPostalcode", query = "SELECT c FROM Customer c WHERE c.postalcode = :postalcode")
    , @NamedQuery(name = "Customer.findByCountry", query = "SELECT c FROM Customer c WHERE c.country = :country")
    , @NamedQuery(name = "Customer.findByCreditlimit", query = "SELECT c FROM Customer c WHERE c.creditlimit = :creditlimit")
    , @NamedQuery(name = "Customer.findAllNames", query = "SELECT c.customername FROM Customer c ORDER BY c.customername ASC")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customernumber", nullable = false)
    private Integer customernumber;
    @Column(name = "customername", length = 50)
    private String customername;
    @Column(name = "contactlastname", length = 50)
    private String contactlastname;
    @Column(name = "contactfirstname", length = 50)
    private String contactfirstname;
    @Column(name = "phone", length = 50)
    private String phone;
    @Column(name = "addressline1", length = 50)
    private String addressline1;
    @Column(name = "addressline2", length = 50)
    private String addressline2;
    @Column(name = "city", length = 50)
    private String city;
    @Column(name = "state", length = 50)
    private String state;
    @Column(name = "postalcode", length = 15)
    private String postalcode;
    @Column(name = "country", length = 50)
    private String country;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "creditlimit", precision = 22)
    private Double creditlimit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Collection<Payment> paymentCollection;
    @OneToMany(mappedBy = "customer")
    private Collection<OrderClassic> orderClassicCollection;
    @JoinColumn(name = "salesrepemployeenumber", referencedColumnName = "employeenumber")
    @ManyToOne
    private Employee employee;

    public Customer(String customername, String city) {
        this.customername = customername;
        this.city = city;
    }
    

    public Customer() {
    }

    public Customer(Integer customernumber) {
        this.customernumber = customernumber;
    }

    public Integer getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(Integer customernumber) {
        this.customernumber = customernumber;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getContactlastname() {
        return contactlastname;
    }

    public void setContactlastname(String contactlastname) {
        this.contactlastname = contactlastname;
    }

    public String getContactfirstname() {
        return contactfirstname;
    }

    public void setContactfirstname(String contactfirstname) {
        this.contactfirstname = contactfirstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(Double creditlimit) {
        this.creditlimit = creditlimit;
    }

    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public Collection<OrderClassic> getOrderClassicCollection() {
        return orderClassicCollection;
    }

    public void setOrderClassicCollection(Collection<OrderClassic> orderClassicCollection) {
        this.orderClassicCollection = orderClassicCollection;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customernumber != null ? customernumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customernumber == null && other.customernumber != null) || (this.customernumber != null && !this.customernumber.equals(other.customernumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.classicmodels.Customer[ customernumber=" + customernumber + " ]";
    }
    
}
