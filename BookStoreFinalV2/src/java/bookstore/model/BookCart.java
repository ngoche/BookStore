package bookstore.model;

import entities.Book;
import entities.Book;
import java.util.List;


public class BookCart extends Book {

    private int numberOfBook;
    private float totalPrice;
    private List list;

    public BookCart() {
    }
    public BookCart(int numberOfBook, float totalPrice, List list) {
        this.numberOfBook = numberOfBook;
        this.totalPrice = totalPrice;
        this.list = list;
    }

    public int getNumberOfBook() {
        return numberOfBook;
    }

    public void setNumberOfBook(int numberOfBook) {
        this.numberOfBook = numberOfBook;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

   

}
