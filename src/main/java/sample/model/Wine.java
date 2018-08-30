package sample.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "wine")
public class Wine implements Serializable {

    private static final long serialVersionUID = -6892434771833441384L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "wine_id")
    private int id;

    @Column (name = "lotCode")

    private String lotCode;

    @Column(name = "volume")

    private double volume;

    @Column (name = "description")

    private String description;



    @OneToOne
    private Tank tank;



    @ManyToOne
    private ProductState productState;



    @ManyToOne
    private Owner owner;



    @ManyToMany
    private Set<GrapeComponent> components;

    public Wine(){
        this.tank = new Tank();
        this.components = new HashSet<GrapeComponent>();
    }

    public Wine(int id, String lotCode, double volume, String description, Tank tank, ProductState productState, Owner owner, Set<GrapeComponent> components) {
        this.id = id;
        this.lotCode = lotCode;
        this.volume = volume;
        this.description = description;
        this.tank = tank;
        this.productState = productState;
        this.owner = owner;
        this.components = components;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public ProductState getProductState() {
        return productState;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Set<GrapeComponent> getComponents() {
        return components;
    }

    public void setComponents(Set<GrapeComponent> components) {
        this.components = components;
    }

}
