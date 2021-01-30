/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.CustomerType;
import java.util.List;

/**
 *
 * @author DuongNguyen
 */
public interface CustomerTypeDao {
        public CustomerType getCustomerTypeById(String id);
        public List<CustomerType> getAllCustomerType();
        Boolean insertCusType(CustomerType type);
        Boolean updateCusType(CustomerType type);
        Boolean deleteCusType(String id);
}
