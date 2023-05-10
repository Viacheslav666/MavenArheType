import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.Collection;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOaoHibernatelpml();
        CityDAO cityDAO = new CityDaoImpl();
        City perm = new City("Perm");
        cityDAO.createCity(perm);
        System.out.println(perm.getCityName());


 Employee employee = new Employee("Петр", "Петрова", "men", 32, perm);
        Employee employee1 = new Employee("Kirill", "Подгообунский", "men", 32, perm);
 employeeDAO.createEmployee(employee);
 employeeDAO.createEmployee(employee1);
 perm.setEmployees(List.of(employee1, employee));
 City updateCity = cityDAO.updateCity(perm);
        System.out.println(employeeDAO.getAllEmployee().contains(updateCity.getEmployees()));
        cityDAO.deleteCity(perm);


    }
}
