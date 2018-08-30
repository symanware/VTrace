package sample.model;

import java.util.Objects;

/**
 *
 */
public class GrapeComponentYearVariety implements Comparable {
    private String year;
    private String variety;

    public GrapeComponentYearVariety(String year, String variety) {
        this.year = year;
        this.variety = variety;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrapeComponentYearVariety that = (GrapeComponentYearVariety) o;
        return year == that.year &&
                Objects.equals(variety, that.variety);
    }

    @Override
    public int hashCode() {

        return Objects.hash(year, variety);
    }

    @Override
    public int compareTo(Object o) {
        if (this.equals(o)) {
            return 0;
        } else {
            GrapeComponentYearVariety that = (GrapeComponentYearVariety) o;
            if (that.getYear() != this.year)
                return that.getYear().compareTo(this.getYear());
            else {
                return that.getVariety().compareTo(this.getVariety());
            }
        }
    }

    @Override
    public String toString() {
        return "" + year + ",'" + variety + "'";
    }
}
