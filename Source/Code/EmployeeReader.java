/**
 * The EmplyeeReader program exposes an interface that
 * allows a user to access and read an input file of
 * employees.
 *
 * @author  Mark Coetzer
 * @version 1.0
 * @since   2018-07-14 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeReader {

    /**
     * This is the read method which takes a file name as input and reads the 
     * data into an Arrraylist of Employees.
     *
     * @param fileName The file name and path if not in directory.
     * @return ArrayList of Employees.
     * @exception FileNotFoundException On file not found error.
     * @see FileNotFoundException
     */
    public static void read(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
             System.out.print(scanner.next()+"|");
        }
        scanner.close();
    }
 }