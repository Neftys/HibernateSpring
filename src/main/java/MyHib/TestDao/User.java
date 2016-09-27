package MyHib.TestDao;

import javax.persistence.*;


/**
 * Created by tu_gevelav on 27.09.2016.
 */
@Entity
@Table (name ="user")
public class User {
    private int id;
    private String name;


    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
