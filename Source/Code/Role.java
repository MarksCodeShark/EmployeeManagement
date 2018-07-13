/**
 * @author  Mark Coetzer
 * @version 1.0
 * @since   2018-07-14 
 */

public enum Role {
    MANAGER {
        @Override public String toString() {
            return "Manager";
        }
    },

    EMPLOYEE {
        @Override public String toString() {
            return "Employee";
        }
    },

    TRAINEE {
        @Override public String toString() {
            return "Trainee";
        }
    }
}