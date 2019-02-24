/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jesper
 */
@Entity
@Table(name = "orders")
@NamedQueries({
    @NamedQuery(name = "OrderClassic.findAll", query = "SELECT o FROM OrderClassic o")
    , @NamedQuery(name = "OrderClassic.findByOrdernumber", query = "SELECT o FROM OrderClassic o WHERE o.ordernumber = :ordernumber")
    , @NamedQuery(name = "OrderClassic.findByOrderdate", query = "SELECT o FROM OrderClassic o WHERE o.orderdate = :orderdate")
    , @NamedQuery(name = "OrderClassic.findByRequireddate", query = "SELECT o FROM OrderClassic o WHERE o.requireddate = :requireddate")
    , @NamedQuery(name = "OrderClassic.findByShippeddate", query = "SELECT o FROM OrderClassic o WHERE o.shippeddate = :shippeddate")
    , @NamedQuery(name = "OrderClassic.findByStatus", query = "SELECT o FROM OrderClassic o WHERE o.status = :status")
    , @NamedQuery(name = "OrderClassic.findByStatusCustomer", query = "SELECT o FROM OrderClassic o WHERE o.status = :status AND o.customer.customernumber = :id")})
public class OrderClassic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ordernumber", nullable = false)
    private Integer ordernumber;
    @Column(name = "orderdate")
    @Temporal(TemporalType.DATE)
    private Date orderdate;
    @Column(name = "requireddate")
    @Temporal(TemporalType.DATE)
    private Date requireddate;
    @Column(name = "shippeddate")
    @Temporal(TemporalType.DATE)
    private Date shippeddate;
    @Column(name = "status", length = 15)
    private String status;
    @Lob
    @Column(name = "comments", length = 65535)
    private String comments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderClassic")
    private Collection<Orderdetail> orderdetailCollection;
    @JoinColumn(name = "customernumber", referencedColumnName = "customernumber")
    @ManyToOne
    private Customer customer;

    public OrderClassic() {
    }

    public OrderClassic(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getRequireddate() {
        return requireddate;
    }

    public void setRequireddate(Date requireddate) {
        this.requireddate = requireddate;
    }

    public Date getShippeddate() {
        return shippeddate;
    }

    public void setShippeddate(Date shippeddate) {
        this.shippeddate = shippeddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Collection<Orderdetail> getOrderdetailCollection() {
        return orderdetailCollection;
    }

    public void setOrderdetailCollection(Collection<Orderdetail> orderdetailCollection) {
        this.orderdetailCollection = orderdetailCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordernumber != null ? ordernumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderClassic)) {
            return false;
        }
        OrderClassic other = (OrderClassic) object;
        if ((this.ordernumber == null && other.ordernumber != null) || (this.ordernumber != null && !this.ordernumber.equals(other.ordernumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.classicmodels.OrderClassic[ ordernumber=" + ordernumber + " ]";
    }
    
}
