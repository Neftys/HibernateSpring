package MyHib.DAO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tu_gevelav on 22.09.2016.
 */

@Entity
@Table(name = "book")
public class Book implements Serializable {
    private int id;
    private String name;
    private List<Genre> arrayList ;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable
            (name = "bookgenre"
                    , joinColumns = @JoinColumn(name = "idbook")
                    , inverseJoinColumns = @JoinColumn(name ="idgenre")
            )
    public List<Genre> getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<Genre> arrayList) {
        this.arrayList = arrayList;
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
                ", arrayList= size " + arrayList.size() +
                '}';
    }
}
