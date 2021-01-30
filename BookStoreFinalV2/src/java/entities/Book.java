package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Book")
@XmlRootElement
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Isbn")
    private Integer isbn;
    @Size(max = 100)
    @Column(name = "BookName")
    private String bookName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private float price;
    @Size(max = 100)
    @Column(name = "PictureThumb")
    private String pictureThumb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PublishYear")
    private int publishYear;
    @Size(max = 100)
    @Column(name = "Language")
    private String language;
    @Column(name = "Status")
    private Integer status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Discount")
    private float discount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TotalPage")
    private int totalPage;
    @Size(max = 255)
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Collection<OrderDetail> orderDetailCollection;
    @JoinColumn(name = "AuthorId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Author authorId;
    @JoinColumn(name = "BookCategoryId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private BookCategory bookCategoryId;
    @JoinColumn(name = "PublisherId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Publisher publisherId;

    public Book() {
    }

    public Book(Integer isbn) {
        this.isbn = isbn;
    }

    public Book(Integer isbn, float price, int publishYear, float discount, int totalPage) {
        this.isbn = isbn;
        this.price = price;
        this.publishYear = publishYear;
        this.discount = discount;
        this.totalPage = totalPage;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
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

    @XmlTransient
    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
    }

    public BookCategory getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(BookCategory bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

   
    @Override
    public String toString() {
        return "entities.Book[ isbn=" + isbn + " ]";
    }
    
}
