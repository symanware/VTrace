package sample.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "owner")
public class Owner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column (name = "name")

    private String name;

    @Column (name = "emailAddress")

    private String emailAddress;
    public Owner(){

    }

    public Owner(int id, String name, String emailAddress) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
    }

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
