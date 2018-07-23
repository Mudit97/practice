package assignment1.question3;

import java.util.*;
//import java.util.List;


public class EmployeeDataService {

    private  Map<Integer,Employee> employeeHashMap = new HashMap<Integer, Employee>();
    private static EmployeeDataService eds = new EmployeeDataService();

    public  boolean add(Employee e){
        if(employeeHashMap.containsKey(e.getId())){
            System.out.println("User already exists");
            return false;
        }
        else{
            employeeHashMap.put(e.getId(), e);
            return true;
        }
    }

    public  boolean remove(Employee e){
        if(employeeHashMap.containsKey(e.getId())){
            System.out.println("Removing user" + e.toString());
            employeeHashMap.remove(e.getId());
            return true;
        }
        else{
            System.out.println("User does not exist");
            return false;
        }
    }
    public Employee findById(int id){
        if(employeeHashMap.containsKey(id)){
            return employeeHashMap.get(id);
        }
        else{
            System.out.println("User does not exist");
            return null;
        }
    }
    public List<Employee> findByName(String name){
        List<Employee> employeeList= new ArrayList<Employee>();
        for(Employee e : employeeHashMap.values()){
            if(e.getName()==name)
                employeeList.add(employeeHashMap.get(e.getId()));
        }
        return employeeList;
    }

    private EmployeeDataService() {
    }

    public static EmployeeDataService getInstance(){
        return eds;
    }
}
