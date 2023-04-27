import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployee();

    public Employee getEmployee(int id);

    public void createEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(Employee employee);

}
