package MyHib.DAO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ниф on 26.09.2016.
 */
@Entity
@Table(name = "author")
public class Author implements Serializable {
    private int id;
    private String name;
    private List<Book> bookList ;

    public Author( String name) {

        this.name = name;
    }

    public Author() {
    }

    @Id
    @Column(name = "idAuthor")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Transient
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
