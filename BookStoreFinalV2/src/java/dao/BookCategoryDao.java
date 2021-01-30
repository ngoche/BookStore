
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.BookCategory;
import java.util.List;

/**
 *
 * @author ngocv
 */
public interface BookCategoryDao {

    public List<BookCategory> getAllBookCategorys();
    public String getNameCategoryById(String id);
    public BookCategory getBookCategoryById(String id);
    Boolean insertCategory(BookCategory cate);
    Boolean deleteCategory(String id);
    Boolean updateCategory(BookCategory cate);


}
