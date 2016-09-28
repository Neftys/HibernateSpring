package MyHib.DAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by tu_gevelav on 28.09.2016.
 */
@Entity
@Table(name = "genre")
public class Genre {

    private int id;
    private String name;
    private List<Book> arrayList = new ArrayList<Book>();

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }

    @Id
    @Column(name = "idgenre")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable
            (name = "bookgenre"
                    , joinColumns = @JoinColumn(name = "idgenre")
                    , inverseJoinColumns = @JoinColumn(name ="idbook")
            )
    public List<Book> getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<Book> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", arrayList size= " + arrayList.size() +
                '}';
    }
}
