/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Account;
import entities.Customer;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface AccountDao {

    public Account getAccountIdByUser(String username);

    public Customer getData(int id);

    public boolean ModifyAccount(Account a, Customer c);

    public Account getAccountByUser(String username);

    public Customer getCustomerById(Integer id);

    public Boolean DeleteAccount(String username);

    public Boolean DeleteCostomer(Integer id);

    public List<Account> getAllAccount();
}
