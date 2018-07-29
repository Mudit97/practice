
import java.util.*;


public class EmployeeDataService implements DataService<Employee , Integer> {

    private  Set<Employee> employeeHashSet = new HashSet<Employee>();
    private static EmployeeDataService eds = new EmployeeDataService();

    @Override
    public  boolean add(Employee e){
        return employeeHashSet.add(e);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList= new ArrayList<>();
        for(Employee E: employeeHashSet)
            employeeList.add(E);
        return employeeList;
    }

    @Override
    public boolean removeAll() {
        if(employeeHashSet.isEmpty())return false;
        employeeHashSet.clear();
        return true;
    }

    @Override
    public boolean remove(Employee e){
        return  employeeHashSet.remove(e);
    }

    @Override
    public Employee findById(Integer id){
        for(Employee E: employeeHashSet){
            if(id == E.getId()){
                return E;
            }
        }
        return null;
    }

    @Override
    public boolean removeById(Integer id) {
        for(Employee E: employeeHashSet)
            if (id == E.getId())
                return employeeHashSet.remove(E);
        return false;
    }

    public List<Employee> findByName(String name){
        List<Employee> employeeList= new ArrayList<Employee>();
        for(Employee e : employeeHashSet){
            if(e.getName().toLowerCase().equals(name.toLowerCase())){
            //    System.out.println("Added to list");
                employeeList.add(e);
            }
        }
        return employeeList;
    }

    public  List<Employee> employeeInSalaryRange(float lower, float upper){
        List<Employee> employeeList= new ArrayList<Employee>();
        for(Employee E: employeeHashSet){
            if(E.getSalary() >= lower && E.getSalary()<= upper){
                employeeList.add(E);
            }
        }
        return employeeList;
    }

    private EmployeeDataService() {                         // private constructor to make singleton class
    }

    public static EmployeeDataService getInstance(){        //making the single object through getInstance method
        return eds;
    }
}
