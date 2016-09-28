package MyHib.TestDaoOnetoOne;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
/**
 * Created by tu_gevelav on 27.09.2016.
 */
@Entity
@Table(name = "address")
public class Address {

    private int id;
    private String arg1;
    private User user;


    @Id
    @Column (name= "idAdress")
    @GeneratedValue(strategy = IDENTITY)
    public int getId() {
        return id;
    }

    @Column(name="name")
    public String getArg1() {
        return arg1;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "address", cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address() {
    }

    public Address(String arg1) {
        this.arg1 = arg1;

    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }



    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", arg1='" + arg1 + '\'' +
                "user"+user.getName()+
                '}';
    }
}
