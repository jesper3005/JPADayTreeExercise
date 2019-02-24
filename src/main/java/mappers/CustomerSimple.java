/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

/**
 *
 * @author Jesper
 */
public class CustomerSimple {

    public String firstName;
    public String lastName;
    public String customerName;

    public CustomerSimple(String firstName, String lastName, String customerName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerName = customerName;
    }

}
