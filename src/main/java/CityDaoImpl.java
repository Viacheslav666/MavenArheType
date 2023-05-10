import javax.persistence.*;
import java.util.List;

public class CityDaoImpl implements CityDAO{
    private static EntityManager createEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public List<City> getAllCity() {
        EntityManager entityManager =createEntityManager();
        Query query =  entityManager.createNativeQuery("SELECT * FROM city", City.class);
        return query.getResultList();
    }

    @Override
    public City getCity(int id) {
        EntityManager entityManager = createEntityManager();
        return entityManager.find(City.class, id);
    }

    @Override
    public City createCity(City city) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(city);
        transaction.commit();
        entityManager.close();

        return city;
    }

    @Override
    public City updateCity(City city) {
        EntityManager entityManager = createEntityManager();
        entityManager.merge(city);
        entityManager.close();
        return city;
    }

    @Override
    public void deleteCity(City city) {
        EntityManager entityManager = createEntityManager();
        entityManager.remove(city);
        entityManager.close();
    }
}
