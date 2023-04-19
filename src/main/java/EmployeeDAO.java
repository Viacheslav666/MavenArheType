import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployee();

    public Employee getEmployee(int id);

    public void createEmployee(Employee employee);

    public void updateEmployee(int id);

    public void deleteEmployee(int id);

}
