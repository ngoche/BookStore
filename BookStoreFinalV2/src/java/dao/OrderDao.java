/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Employee;
import entities.OrderInfo;
import java.util.List;

/**
 *
 * @author DuongNguyen
 */
public interface OrderDao {
    public List<OrderInfo> getAllOrder();
    public List<OrderInfo> getOrderByCustomer(String idCustomer);
    public OrderInfo getOrderById(String id);
    public Boolean confirmOrder(OrderInfo o);
    public Boolean deleteOrder(String id);
    
}
