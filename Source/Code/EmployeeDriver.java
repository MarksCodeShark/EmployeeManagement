/**
 * 
 */

/**
 * @author Mark
 *
 */
public final class EmployeeDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the Employee Management Application!");
		System.out.println("================================================================================");
		System.out.print("Loading in Employees... ");
		Company localCompany = new Company("Employees.csv");
		System.out.print(" Loaded!\n");
		boolean run = true;
		while(run) {
			displayMenu();
			String selection = System.console().readLine();
	        switch (selection.toUpperCase()) {
            case "1" : searchEmployee(localCompany);
                     break;
            case "2" : searchEmployeeDoB(localCompany);
                     break;
            case "3" :  localCompany.printStructure();
                     break;
            case "4" :  localCompany.printHighestEarnings();
            		 break;
            case "5" :  localCompany.listAllEmployees();
            		 break;
            case "x" :  System.exit(0);
   		 			break;
            default: System.out.println("Invalid selection. Please try again.");;
                     break;
        }
		}
	}

	public static void displayMenu() {
		clearScreen();
		System.out.println("What would you like to do?");
		System.out.println("================================================================================");
		System.out.println("1. Search for an Employee");
		System.out.println("2. List all Employee's born after date");
		System.out.println("3. Display organisational structure");
		System.out.println("4. Display highest earnings per tier");
		System.out.println("5. Display all Employee records");
		System.out.println("");
		System.out.println("x. Exit");
		System.out.println("");
		System.out.println("Please enter the number/letter of your choice: ");
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}
	
	public static void searchEmployee(Company localCompany) {
		System.out.println("Please enter the name of the Employee you'd like to search for: ");
		String input = System.console().readLine().trim();
		localCompany.getEmployee(input);
	}
	
	public static void searchEmployeeDoB(Company localCompany) {
		System.out.println("Please enter minimum date of birth in the format 'dd-mm-yyyy'");
		String input = System.console().readLine().trim();
		localCompany.listEmployeesOlderThan(input);		
	}
}
