package sample.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "grapeComponent")
public class GrapeComponent implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private int id;

    @Column (name = "percentage")

    private double percentage;

    @Column (name = "year")

    private String year;

    @Column (name = "variety")

    private String variety;

    @Column (name = "region")

    private String region;
    public GrapeComponent(){

    }

    public GrapeComponent(int id, double percentage, String year, String variety, String region) {
        this.id = id;
        this.percentage = percentage;
        this.year = year;
        this.variety = variety;
        this.region = region;
    }

    public GrapeComponent(double percentage, String year, String region, String variety){

        this.percentage = percentage;
        this.year = year;
        this.variety = variety;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
