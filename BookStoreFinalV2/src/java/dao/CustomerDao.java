/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Customer;
import java.util.List;

/**
 *
 * @author ngocv
 */
public interface CustomerDao {
        public List<Customer> getAllCustomers();
        public Customer getCustomerById(String id);
        public Boolean deleteCustomer(String id);
}
