
package assignment1.question3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDataServiceAction {

    private static EmployeeDataService eds = EmployeeDataService.getInstance();

    public static void main(String[] args) {
        System.out.println("1. Add a new employee\n2. Remove an employee by ID \n3. Find employee by ID \n4. Find employees by Name \n" +
                "5. Find employees in a salary range\n6. Remove all employees\n7.Get all employees\n8. Abort");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: {
                    boolean success = eds.add(getEmployeeDataFromUser());
                    if (success) System.out.println("Employee added successfully");
                    else System.out.println("Employee already exists");
                    break;
                }
                case 2: {
                    System.out.println("Enter id of employee to be removed: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    boolean b = eds.removeById(id);
                    if(b) System.out.println("Employee removed successfully");
                    else System.out.println("ID not found");
                    break;
                }
                case 3: {
                    System.out.println("Enter id of employee to be found: ");
                    String idString = scanner.nextLine();
                    int id = Integer.parseInt(idString);
                    Employee E = eds.findById(id);
                    System.out.println(E.toString());
                    break;
                }
                case 4: {
                    System.out.println("Enter the name: ");
                    String name =  scanner.nextLine();
                    List<Employee> employeeList = new ArrayList<>();
                            employeeList = eds.findByName(name);
                    for(Employee E: employeeList){
                        System.out.println(E.toString());
                    }
                    break;
                }
                case 5:{
                    System.out.println("Enter lower and upper range");
                    float lower = Float.parseFloat(scanner.nextLine());
                    float upper = Float.parseFloat(scanner.nextLine());
                    List<Employee> employeeList = eds.employeeInSalaryRange(lower, upper);
                    for(Employee E: employeeList){
                        System.out.println(E.toString());
                    }
                    break;
                }
                case 6:{
                    //System.out.println("Removing all employees....");
                    boolean success = eds.removeAll();
                    if(success) System.out.println("Removing all employees...");
                    else System.out.println("Employee List already empty");
                    break;
                }
                case 7:{
                    List<Employee> employeeList=eds.getAll();
                    for(Employee E: employeeList){
                        System.out.println(E.toString());
                    }
                    break;
                }
                case 8:{
                    System.exit(0);
                }
            }
        }while(true);
    }

    private static Employee getEmployeeDataFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Id, Name and Salary: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        String name = scanner.nextLine();
        float salary = Float.parseFloat(scanner.nextLine());
        return new Employee(id,name,salary);
    }
}

