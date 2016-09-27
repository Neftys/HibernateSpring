package MyHib.DAO;

import javax.persistence.*;

/**
 * Created by Ниф on 26.09.2016.
 */
@Entity
@Table(name = "author")
public class Author {
    private int id;
    private String name;

    public Author( String name) {

        this.name = name;
    }

    public Author() {
    }

    @Id
    @Column(name = "id")
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
}
