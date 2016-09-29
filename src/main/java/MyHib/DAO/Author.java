package MyHib.DAO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Ниф on 26.09.2016.
 */
@Entity
@Table(name = "author")
public class Author implements Serializable {
    private int id;
    private String name;
    private Set<Book> bookSet ;

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



    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable
            (name = "bookauthor"
                    , joinColumns = @JoinColumn(name = "idauthor")
                    , inverseJoinColumns = @JoinColumn(name ="idbook")
            )
    public Set<Book> getBookSet() {
        return bookSet;
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
