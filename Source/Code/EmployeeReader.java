/**
 * @author  Mark Coetzer
 * @version 1.0
 * @since   2018-07-14 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeReader {
    public static void read(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Employees.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
             System.out.print(scanner.next()+"|");
        }
        scanner.close();
    }
 }