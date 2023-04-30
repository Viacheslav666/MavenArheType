import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "city")

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "City_id")
    private int cityId;
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(mappedBy = "cityId", cascade = CascadeType.ALL)
    private List<Employee> employees;


    public City() {

    }
    public City( String cityName) {
        this.cityName = cityName;
    }
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId && Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
