package bookstore.model;

import java.io.Serializable;


public class BookToInsert implements Serializable{

    private int isbn;
    private String bookName;
    private float price;
    private String pictureThumb;
    private int publishYear;
    private String language;
    private Integer status;
    private float discount;
    private int totalPage;
    private String description;
    private Integer authorId;
    private Integer bookCategoryId;
    private Integer publisherId;

    public BookToInsert() {
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPictureThumb() {
        return pictureThumb;
    }

    public void setPictureThumb(String pictureThumb) {
        this.pictureThumb = pictureThumb;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(Integer bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public BookToInsert(int isbn, String bookName, float price, String pictureThumb, int publishYear, String language, Integer status, float discount, int totalPage, String description, Integer authorId, Integer bookCategoryId, Integer publisherId) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.price = price;
        this.pictureThumb = pictureThumb;
        this.publishYear = publishYear;
        this.language = language;
        this.status = status;
        this.discount = discount;
        this.totalPage = totalPage;
        this.description = description;
        this.authorId = authorId;
        this.bookCategoryId = bookCategoryId;
        this.publisherId = publisherId;
    }

}
