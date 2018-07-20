import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * The Company class implements the Company type. <br>
 * This class creates a logical container for Employees
 * and exposes functions to easily manipulate and interact
 * with said Employees
 * @see Employee
 * 
 * @author  Mark Coetzer
 * @version 1.0
 * @since   2018-07-14 
 */
public class Company {
	//================================================================================
	// Member Variables
	//================================================================================
	
	/**
	 * The list of all Employees
	 */
	private ArrayList<Employee> _employees;
	
    //================================================================================
    // Constructors
    //================================================================================
	
	/**
	 * Default empty constructor that initialises _employees to null
	 */
	Company() {
		setEmployees(null);
	}
	
	/**
	 * Constructor that accepts a file name to initialise _employees from
	 * @param fileName
	 */
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
	 * Get method for Employees List
	 * @return the _employees member variable
	 */
	public ArrayList<Employee> getEmployees() {
		return _employees;
	}

	/**
	 * Get method for the first Manager
	 * @return the first occurring Manager in a sorted list
	 */
	public Employee getFirstManager() {
		for (Employee employee : this._employees) {
			if(employee.getRole() == Role.MANAGER) {
				return employee;
			}
		}	
		return null;
	}
	
	/**
	 * Get method for the first Employee
	 * @return the first occurring Employee in a sorted list
	 */
	public Employee getFirstEmployee() {
		for (Employee employee : this._employees) {
			if(employee.getRole() == Role.EMPLOYEE) {
				return employee;
			}
		}	
		return null;
	}
	
	/**
	 * Get method for the first Trainee
	 * @return the first occurring Trainee in a sorted list
	 */
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
	 * Set Modifier for Employees List
	 * @param employees the ArrayList to set _employees to
	 */
	public void setEmployees(ArrayList<Employee> employees) {
		this._employees = employees;
	}
	
    //================================================================================
    // Member Functions
    //================================================================================
	
	/**
	 * Displays all Employees to System.out
	 */
	public void listAllEmployees() {
		for (Employee employee : _employees) {
		    System.out.print(employee);
		}
	}
	
	/**
	 * Displays all Employees older than given date
	 * @param date String date in the format 'dd-MM-yyyy'
	 */
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
	
	/**
	 * Searches and displays Employee by input name
	 * @param name First / Full name of employee to search for
	 */
	public void getEmployee(String name) {
		for (Employee employee : _employees) {
			if(employee.getFirstName().toUpperCase().equals(name.trim().toUpperCase())  || employee.getFullName().toUpperCase().equals(name.trim().toUpperCase())) {
			    System.out.print(employee);
			    return;
			}
		}
		System.out.println("Error: No employee found matching the name: " + name.trim());
	}
	
	/**
	 * Prints organisation structure based on the reportsTo and level attributes
	 */
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
	
	/**
	 * Sorts the Employees list by salary and then displays the highest earner of each tier
	 */
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
