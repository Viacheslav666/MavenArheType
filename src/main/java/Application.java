import java.sql.*;
public class Application {
    public static void main(String[] args) {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        System.out.println(employeeDAO.getAllEmployee());
        employeeDAO.getAllEmployee().forEach(System.out::println);
        employeeDAO.getEmployee(1);
        employeeDAO.updateEmployee(2);
        employeeDAO.deleteEmployee(3);


        final String user = "postgres";
        final String password = "Glad917746.";
        final String URL = "jdbc:postgresql://localhost:5432/skyPro";

        try {
            final Connection connection = DriverManager.getConnection(URL, user, password);
            PreparedStatement statement = connection.prepareStatement("SELECT  * FROM employee INNER JOIN city ON employee.city_id = city.city_id WHERE id = 1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOfemployee = resultSet.getInt("id");
                System.out.println("ID сотрудника " + idOfemployee);
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                String city = resultSet.getString("city_name");
                System.out.println("Имя сотрудника " + firstName);
                System.out.println("Фамилия сотрудника " + lastName);
                System.out.println("Пол сотрудника " + gender);
                System.out.println("Город сотрудника " + city);
            }
            System.out.println("Соедение установленно");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключение к базе данных");
            e.printStackTrace();
        }
    }
}
