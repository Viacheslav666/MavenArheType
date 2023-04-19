import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    final String user = "postgres";
    final String password = "Glad917746.";
    final String URL = "jdbc:postgresql://localhost:5432/skyPro";

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM employee");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idEmployee = resultSet.getInt("id");
                String firstNameEmployee = resultSet.getString("first_name");
                String lastNameEmployee = resultSet.getString("last_name");
                String genderEmployee = resultSet.getString("gender");
                int ageEmployee = resultSet.getInt("age");
                int cityIdEmployee = resultSet.getInt("city_id");
                employees.add(new Employee(firstNameEmployee, lastNameEmployee, genderEmployee, ageEmployee, cityIdEmployee));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключение к БД");
        }
        return employees;
    }

    @Override
    public Employee getEmployee(int id) {
        try (final Connection connection = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM employee WHERE employee.id = id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstNameEmployee = resultSet.getString("first_name");
                String lastNameEmployee = resultSet.getString("last_name");
                String genderEmployee = resultSet.getString("gender");
                int ageEmployee = resultSet.getInt("age");
                int cityIdEmployee = resultSet.getInt("city_id");

                return new Employee(firstNameEmployee, lastNameEmployee, genderEmployee, ageEmployee, cityIdEmployee);
            }
        } catch (SQLException e) {
            System.out.println("Соеденение не установленно");
        }
        return null;
    }

    @Override
    public void createEmployee(Employee employee) {
        try (Connection connection = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO employee(first_name, last_name, gender, age, citu_id) VALUES ('Petr', 'Petrod', 'men', '21','1')");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateEmployee(int id) {
        try (Connection connection = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE employee.id = id");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();

        }


    }

    @Override
    public void deleteEmployee(int id) {
        try (Connection connection = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement statement = connection.prepareStatement("UPDATE employee SET last_name ='Ilin' WHERE employee.id = id");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    }