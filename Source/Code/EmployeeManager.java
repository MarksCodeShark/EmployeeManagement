/**
 * The EmplyeeManager program implements an application that
 * allows a user to read an input file of employees and perform
 * various search tasks on said employees.
 *
 * @author  Mark Coetzer
 * @version 1.0
 * @since   2018-07-14 
 */

import java.io.FileNotFoundException;

 public class EmployeeManager {
     
     /**
      * TODO: Complete this JavaDoc Stub
      * @param args The command line arguments
      */
     public static void main(String[] args) {
         try {
            EmployeeReader.read("Employees.csv");
         } catch (FileNotFoundException e) {
            // TODO: Do something with file not found    
         }
     }
 }