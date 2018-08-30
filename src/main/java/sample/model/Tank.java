package sample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "tank")
public class Tank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column (name ="code")

    private String code;

    @Column (name = "capacity")

    private double capacity;

    @OneToOne (mappedBy = "tank", fetch = FetchType.LAZY)
    @JsonIgnore
    private Wine contents;

    public Tank(){

    }

    public Tank(int id, String code, double capacity) {
        this.id = id;
        this.code = code;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public Wine getContents() {
        return contents;
    }

    public void setContents(Wine contents) {
        this.contents = contents;
    }
}
