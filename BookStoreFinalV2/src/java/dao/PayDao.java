/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bookstore.model.BookCart;
import entities.Customer;

/**
 *
 * @author ngocv
 */
public interface PayDao {

    public Boolean saveOrderInfo(Customer customer,BookCart books);

//    public Boolean saveOrderDetail(OrderInfo orderInfo, Book books);
//       public Integer getOrderInfoId(String  c);
//    public OrderInfo getOrderInfo(String order);

}
