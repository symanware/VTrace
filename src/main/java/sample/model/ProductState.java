package sample.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "productState")
public class ProductState implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column (name = "description")
    private String description;

    public ProductState(){

    }

    public ProductState(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
