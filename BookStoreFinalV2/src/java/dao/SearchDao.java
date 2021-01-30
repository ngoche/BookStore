/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Account;
import entities.Book;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface SearchDao {
    public List<Book> searchBook(String name);
    public List<Book> resultSearchBook(List<Book> list,Integer offset,Integer maxResults);
    public List<Book> searchBookByName(String name);
    public List<Book> searchBookByCategory(String name);
    public List<Book> searchBookByAuthor(String name);
    public List<Book> searchBookByPublisher(String name);
    
    public List<Account> resultSearchCustomer(List<Account> list,Integer offset,Integer maxResults);
    public List<Account> searchCusByUser(String name);
    public List<Account> searchCusByName(String name);
    public List<Account> searchCusByType(String name);
    public List<Account> searchCusByAddress(String name);
}
