package MyHib.DAO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tu_gevelav on 22.09.2016.
 */

@Entity
@Table(name = "book")
public class Book implements Serializable {
    private int id;
    private String name;
    private List<Genre> genreList =new ArrayList<Genre>();
    private Set<Author> authorSet =new HashSet<Author>();

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idBook")
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }



    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable
            (name = "bookgenre"
                    , joinColumns = @JoinColumn(name = "idbook")
                    , inverseJoinColumns = @JoinColumn(name ="idgenre")
            )
    public List<Genre> getGenreList() {
        return genreList;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable
            (name = "bookauthor"
                    , joinColumns = @JoinColumn(name = "idbook")
                    , inverseJoinColumns = @JoinColumn(name ="idauthor")
            )
    public Set<Author> getAuthorSet() {
        return authorSet;
    }




    public void setGenreList(List<Genre> arrayList) {
        this.genreList = arrayList;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //        ", arrayList= size " + genreList.size() +
                '}';
    }
}