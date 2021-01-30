/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Account;
import entities.Customer;
import bookstore.model.CustomerInfo;

/**
 *
 * @author Acer
 */
public interface LoginDao {

    public Account getAccountByUserAndPass(String username, String password);

    public Account getAccountByUser(String username);

    public Boolean checkAccountExistsed(String userName);

    public Boolean createAccount(CustomerInfo acc);

    public Boolean checkAdmin(String username, String pass);

}
