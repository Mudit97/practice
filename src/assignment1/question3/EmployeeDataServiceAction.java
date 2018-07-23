package assignment1.question3;

import java.util.List;

public class EmployeeDataServiceAction {

    private static EmployeeDataService eds = EmployeeDataService.getInstance();

    public static void main(String[] args) {
        Employee e = new Employee(1, "Abc", 25000);
        eds.add(e);
        Employee e2 = new Employee(2,"asjdf", 14203);
        eds.add(e2);
        Employee e3 = new Employee(3,"ajahf",74362);
        eds.add(e3);
        eds.add(e2);
        eds.remove(e2);
        eds.add(e2);
        Employee e5 = eds.findById(3);
        System.out.println(e5.getId()+" "+e5.getName()+" "+e5.getSalary());
        Employee e4 = new Employee(6,"Abc", 50000);
        eds.add(e4);
        String name="Abc";
        List<Employee> employeeList = eds.findByName(name);
        for(int i=0; i<employeeList.size(); i++){
            Employee e11 = employeeList.get(i);
            System.out.println(e11.getId()+" "+e11.getName()+" "+e11.getSalary());
        }
    }
}
