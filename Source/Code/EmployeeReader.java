import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.ParseException;

/**
 * The EmplyeeReader program exposes an interface that
 * allows a user to access and read an input file of
 * employees.
 *
 * @author  Mark Coetzer
 * @version 1.0
 * @since   2018-07-14 
 */
public class EmployeeReader {

    /**
     * This is the read method which takes a file name as input and reads the 
     * data into an Arrraylist of Employees.
     * NOTE: It expects the input format as: employeeId, firstName, lastName, Role, "Salary", dateOfBirth, reportsTo"
     * E.g. 1,John,Smith,Manager,58500.00,01/01/1990,John Smith
     *
     * @param fileName The file name and path if not in directory.
     * @return ArrayList of Employees.
     * @exception FileNotFoundException On file not found error.
     * @see FileNotFoundException
     */
    public static ArrayList<Employee> read(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        scanner.useDelimiter(",");
        String[] tokensVal;
        ArrayList<String> reportsToList = new ArrayList<String>();
        ArrayList<Employee> returnEmployees = new ArrayList<Employee>();
        while(scanner.hasNextLine()) {
            tokensVal = scanner.nextLine().split(",");
            try {
                returnEmployees.add(new Employee(tokensVal[0], tokensVal[1], tokensVal[2], tokensVal[3], tokensVal[4], tokensVal[5]));
                reportsToList.add(tokensVal[6]);
            } catch (ParseException e) {
                System.out.println("Error: Could not parse values");
            }
        }
        scanner.close();
        int count = 0;
		for (String reportsTo : reportsToList) {
			if(!reportsTo.trim().toUpperCase().equals("NONE") && !reportsTo.trim().equals("")) {
				for (Employee employee : returnEmployees) {
					if(employee.getFullName().toUpperCase().equals(reportsTo.trim().toUpperCase())) {
						returnEmployees.get(count).setReportsTo(employee);
						returnEmployees.get(count).setLevel(employee.getLevel() + 1);
						break;
					}
				}
			} else {
				returnEmployees.get(count).setReportsTo(null);
			}
			count++;
		}
        
        return returnEmployees;
    }
}