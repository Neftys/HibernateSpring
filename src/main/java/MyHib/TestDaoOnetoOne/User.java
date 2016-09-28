package MyHib.TestDaoOnetoOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * Created by tu_gevelav on 27.09.2016.
 */
@Entity
@Table (name ="user")
public class User {
    private int id;
    private String name;
    private Address address;


    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "address"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "idUser", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
