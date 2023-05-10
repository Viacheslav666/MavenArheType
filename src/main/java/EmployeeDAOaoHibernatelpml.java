import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.List;

public class EmployeeDAOaoHibernatelpml implements EmployeeDAO{

    private static EntityManager createEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return entityManagerFactory.createEntityManager();
    }


    @Override
    public List<Employee> getAllEmployee() {
        EntityManager entityManager =createEntityManager();
       Query query =  entityManager.createNativeQuery("SELECT * FROM employee", Employee.class);
      return query.getResultList();

    }

    @Override
    public Employee getEmployee(int id) {
        EntityManager entityManager = createEntityManager();
        return entityManager.find(Employee.class, id);


    }

    @Override
    public void createEmployee(Employee employee) {
EntityManager entityManager = createEntityManager();
         EntityTransaction transaction = entityManager.getTransaction();
         transaction.begin();
         entityManager.persist(employee);
         transaction.commit();
         entityManager.close();
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManager entityManager = createEntityManager();
        entityManager.merge(employee);
        entityManager.close();

    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityManager entityManager = createEntityManager();
        entityManager.remove(employee);
        entityManager.close();
    }
}
