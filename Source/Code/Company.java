import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * 
 */

/**
 * @author Mark
 *
 */
public class Company {
	private ArrayList<Employee> _employees;
	
	Company() {
		setEmployees(null);
	}
	
	Company(String fileName) {
		try {
			setEmployees(EmployeeReader.read(fileName));
		} catch (FileNotFoundException e) {
			// Catch FileNotFoundException and print stack trace
			System.out.print("Error: File not found: " + fileName + "\n");
		}
	}

    //================================================================================
    // Get Accessors
    //================================================================================
	
	/**
	 * @return the _employees member variable
	 */
	public ArrayList<Employee> getEmployees() {
		return _employees;
	}

	public Employee getFirstManager() {
		for (Employee employee : this._employees) {
			if(employee.getRole() == Role.MANAGER) {
				return employee;
			}
		}	
		return null;
	}
	
	public Employee getFirstEmployee() {
		for (Employee employee : this._employees) {
			if(employee.getRole() == Role.EMPLOYEE) {
				return employee;
			}
		}	
		return null;
	}
	
	public Employee getFirstTrainee() {
		for (Employee employee : this._employees) {
			if(employee.getRole() == Role.TRAINEE) {
				return employee;
			}
		}	
		return null;
	}

    //================================================================================
    // Set Modifiers
    //================================================================================
	
	/**
	 * @param employees the _employees ArrayList to set
	 */
	public void setEmployees(ArrayList<Employee> employees) {
		this._employees = employees;
	}
	
    //================================================================================
    // Member Functions
    //================================================================================
	
	public void listAllEmployees() {
		for (Employee employee : _employees) {
		    System.out.print(employee);
		}
	}
	
	public void listEmployeesOlderThan(String date) {
		try {
			Date inDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			System.out.println(inDate);
			for (Employee employee : _employees) {
				if(employee.getBirthDate().after(inDate)) {
					System.out.print(employee);
				}
			}
		} catch (ParseException e) {
			// Catch ParseException and ask user to re-enter correct format
			System.out.print("Error: Unable to parse date - Incorrect input format. \n Please try again with the format: dd-MM-yyyy \n");
		}
	}
	
	public void getEmployee(String name) {
		for (Employee employee : _employees) {
			if(employee.getFirstName().toUpperCase().equals(name.trim().toUpperCase())  || employee.getFullName().toUpperCase().equals(name.trim().toUpperCase())) {
			    System.out.print(employee);
			    return;
			}
		}
		System.out.println("Error: No employee found matching the name: " + name.trim());
	}
	
	public void printStructure() {
		System.out.println("Organisational Hierarchy ");
		System.out.println("================================================================================");
		String indent;
		for (Employee employee : _employees) {
			indent = "";
			for(int i = 0; i < employee.getLevel(); i++) {
				indent += "--";
			}
			System.out.println(indent + ">" + employee.getFullName() + " (" + employee.getRole() + ")");
		}
		System.out.println("================================================================================");
	}
	
	public void printHighestEarnings() {
		Collections.sort(this._employees);
		System.out.println("Highest Earnings by Tier");
		System.out.println("================================================================================");
		System.out.println("Managers: " + this.getFirstManager().getFullNameSalary());
		System.out.println("Employees: " + this.getFirstEmployee().getFullNameSalary());
		System.out.println("Trainees: " + this.getFirstTrainee().getFullNameSalary());
		System.out.println("================================================================================");
	}
	
	
}
