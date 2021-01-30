/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Author;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface AuthorDao {

    public List<Author> getAllAuthors();

    public String getNameAuthorById(String id);

    public Author getAuthorById(String id);

    Boolean insertAuthor(Author author);

    Boolean updateAuthor(Author author);

    Boolean deleteAuthor(String Id);
}
