import java.lang.Comparable;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * The Employee class implements the Employee type
 *
 * @author  Mark Coetzer
 * @version 1.0
 * @since   2018-07-14 
 */
 class Employee implements Comparable<Employee> { 
	//================================================================================
	// Member Variables
	//================================================================================
	 
	/**
	 *  The Employee ID
	 */
    private int _empID; 
    
	/**
	 *  The Employee's first name
	 */
    private String _fName;
    
	/**
	 *  The Employee's last name
	 */
    private String _lName;
    
	/**
	 *  The Employee's Role in the company
	 *  @see Role
	 */
    private Role _role;
    
	/**
	 *  The Employee's salary
	 */
    private Float _salary;
    
	/**
	 *  The Employee's date of birth
	 */
    private Date _birthDate;
    
	/**
	 *  Who the Employee reports to
	 */
    private Employee _reportsTo;
    
	/**
	 *  The organisational level of the Employee
	 */
    private int _level;

    //================================================================================
    // Constructors
    //================================================================================

    /**
     * Constructor that instantiates an Employee object by explicitly listing all properties
     * @param empID Employee ID
     * @param fName First name
     * @param lName Last name
     * @param role Role
     * @param salary Salary
     * @param birthDate Date of Birth
     * @param reportsTo Superior Employee
     */
    Employee(int empID, String fName, String lName, Role role, Float salary, Date birthDate, Employee reportsTo) {
        this._empID = empID;
        this._fName = fName;
        this._lName = lName;
        this._role = role;
        this._salary = salary;
        this._birthDate = birthDate;
        if(reportsTo != null) {
        	this._reportsTo = reportsTo;
        } else {
        	this._reportsTo = null;
        }
        this._level = 0;
    }
    
    /**
     * Constructor that instantiates an Employee object by explicitly listing all properties except for reportsTo
     * @param empID Employee ID
     * @param fName First name
     * @param lName Last name
     * @param role Role
     * @param salary Salary
     * @param birthDate Date of Birth
     */
    Employee(int empID, String fName, String lName, Role role, Float salary, Date birthDate) {
        this._empID = empID;
        this._fName = fName;
        this._lName = lName;
        this._role = role;
        this._salary = salary;
        this._birthDate = birthDate;
        this._reportsTo = null;
        this._level = 0;
    }

    /**
     * Constructor that instantiates an Employee object by explicitly listing all properties in terms of Strings
     * @see String
     * @param empID Employee ID
     * @param fName First name
     * @param lName Last name
     * @param role Role
     * @param salary Salary
     * @param birthDate Date of Birth
     * @throws ParseException
     */
    Employee(String empID, String fName, String lName, String role, String salary, String birthDate) throws ParseException {
        this._empID = Integer.parseInt(empID);
        this._fName = fName;
        this._lName = lName;
        switch (role.toUpperCase()) {
            case "MANAGER" :  this._role = Role.MANAGER;
                     break;
            case "EMPLOYEE" :  this._role = Role.EMPLOYEE;
                     break;
            case "TRAINEE" :  this._role = Role.TRAINEE;
                     break;
            default: this._role = Role.EMPLOYEE;
                     break;
        }
        this._salary = Float.valueOf(salary);
        this._birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
        this._reportsTo = null;
        this._level = 0;
    }

    //================================================================================
    // Get Accessors
    //================================================================================

    /**
     * Get method for Employee ID
     * @return Employee ID
     */
    public int getEmployeeId() {
        return this._empID;
    }

    /**
     * Get method for First Name
     * @return First Name
     */
    public String getFirstName() {
        return this._fName;
    }

    /**
     * Get method for Last Name
     * @return Last Name
     */
    public String getLastName() {
        return this._lName;
    }

    /**
     * Get method for Role
     * @return Role
     */
    public Role getRole() {
        return this._role;
    }

    /**
     * Get method for Salary
     * @return Salary
     */
    public Float getSalary() {
        return this._salary;
    }

    /**
     * Get method for Date of Birth
     * @return Date of Birth
     */
    public Date getBirthDate() {
        return this._birthDate;
    }

    /**
     * Get method for Reports To
     * @return Reports To
     */
    public Employee getReportsTo() {
        return this._reportsTo;
    }
    
    /**
     * Get method for Organisational Level
     * @return Organisational Level
     */
    public int getLevel() {
    	return this._level;
    }
    
    /**
     * Get method for Full Name
     * @return First Name + Second Name
     */
    public String getFullName() {
    	return this._fName + " " + this._lName;
    }
    
    /**
     * Get method for Full Name and Salary
     * @return First Name + Second Name + Salary
     */
    public String getFullNameSalary() {
    	return this.getFullName() + " R" + String.format("%.02f", this._salary);
    }

    //================================================================================
    // Set Modifiers
    //================================================================================

    /**
     * Set Modifier for Employee ID
     * @param empID Employee ID
     */
    public void setEmployeeId(int empID) {
        this._empID = empID;
    }

    /**
     * Set Modifier for First Name
     * @param fName First Name
     */
    public void setFirstName(String fName) {
        this._fName = fName;
    }

    /**
     * Set Modifier for Last Name
     * @param lName Last Name
     */
    public void setLastName(String lName) {
        this._lName = lName;
    }

    /**
     * Set Modifier for Role
     * @param role Role
     */
    public void setRole(Role role) {
        this._role = role;
    }

    /**
     * Set Modifier for Salary
     * @param salary Salary
     */
    public void setSalary(Float salary) {
        this._salary = salary;
    }

    /**
     * Set Modifier for Date of Birth
     * @param birthDate Date of Birth
     */
    public void setBirthDate(Date birthDate) {
        this._birthDate = birthDate;
    }

    /**
     * Set Modifier for Reports To
     * @param reportsTo Superior Employee
     */
    public void setReportsTo(Employee reportsTo) {
        this._reportsTo = reportsTo;
    }
    
    /**
     * Set Modifier for Organisational Level
     * @param level Organisational Level
     */
    public void setLevel(int level) {
    	this._level = level;
    }

    //================================================================================
    // Member Functions
    //================================================================================
    
    /**
     * Overwrite of the toString method <br>
     * This method displays all the properties of an Employee
     * in a neat and legible output.
     * <br>
     * @return
     * Employee Details for Employee ID: empID <br>
     * =========================================  <br>
     * Name: empFullName  <br>
     * Date of Birth: empDoB  <br>
     * Role: empRole <br>
     * Salary: empSalaty <br>
     * Reports to: empReportsTo <br>
     * =========================================
     */
    @Override public String toString() {
    	String returnString = "Employee Details for Employee ID: " + this._empID + "\n";
    	returnString += "================================================================================\n";
    	returnString += "Name: " + this._fName + " " + this._lName + "\n";
    	returnString += "Date of Birth: " + new SimpleDateFormat("dd-MM-yyyy").format(this._birthDate) + "\n";
    	returnString += "Role: " + this._role + "\n";
    	returnString += "Salary: R" + String.format("%.02f", this._salary) + "\n";
    	if(this._reportsTo != null) {
        	returnString += "Reports to: " + this._reportsTo.getFullName() + "\n";
    	} else {
    		returnString += "Reports to: NULL \n";
    	}
    	returnString += "================================================================================\n";
        return returnString;
    }
    
    /**
     * This is the implementation of the Comparable interface <br>
     * This class is compared by the salary member variable
     * @see _salary
     * @param emp Employee to compare with
     * @return 
     * 0 : Equal <br>
     * 1 : Smaller <br>
     * 2 : Larger <br>
     */
    public int compareTo(Employee emp) {
        Float compSalary = emp.getSalary();  
        if(this._salary == compSalary)  
            return 0;  
        else if(this._salary < compSalary)  
            return 1;  
        else  
            return -1;  
    }  
}