import java.util.List;

public interface CityDAO {


    public List<City> getAllCity();

    public City getCity(int id);

    public City createCity(City city);

    public City updateCity(City city);

    public void deleteCity(City city);



}

