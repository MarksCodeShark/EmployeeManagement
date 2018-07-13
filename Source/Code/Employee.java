/**
 * @author  Mark Coetzer
 * @version 1.0
 * @since   2018-07-14 
 */

import java.lang.Comparable;
import java.util.Date;

 class Employee implements Comparable<Employee> {
     
    private int _empID;
    private String _fName;
    private String _lName;
    private Role _role;
    private Float _salary;
    private Date _birthDate;
    private Employee _reportsTo;

    //================================================================================
    // Constructors
    //================================================================================

    Employee(int empID, String fName, String lName, Role role, Float salary, Date birthDate, Employee reportsTo) {
        this._empID = empID;
        this._fName = fName;
        this._lName = lName;
        this._role = role;
        this._salary = salary;
        this._birthDate = birthDate;
        this._reportsTo = reportsTo;
    }

    //================================================================================
    // Get Accessors
    //================================================================================

    public int getEmployeeId() {
        return this._empID;
    }

    public String getFirstName() {
        return this._fName;
    }

    public String getLastName() {
        return this._lName;
    }

    public Role getRole() {
        return this._role;
    }

    public Float getSalary() {
        return this._salary;
    }

    public Date getBirthDate() {
        return this._birthDate;
    }

    public Employee getReportsTo() {
        return this._reportsTo;
    }

    //================================================================================
    // Set Modifiers
    //================================================================================

    public void setEmployeeId(int empID) {
        this._empID = empID;
    }

    public void setFirstName(String fName) {
        this._fName = fName;
    }

    public void getLastName(String lName) {
        this._lName = lName;
    }

    public void setRole(Role role) {
        this._role = role;
    }

    public void setSalary(Float salary) {
        this._salary = salary;
    }

    public void setBirthDate(Date birthDate) {
        this._birthDate = birthDate;
    }

    public void setReportsTo(Employee reportsTo) {
        this._reportsTo = reportsTo;
    }

    //================================================================================
    // Member Functions
    //================================================================================

    public int compareTo(Employee emp) {
        Float compSalary = emp.getSalary();  
        if(this._salary == compSalary)  
            return 0;  
        else if(this._salary > compSalary)  
            return 1;  
        else  
            return -1;  
    }  
 }