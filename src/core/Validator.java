/*
 * Validator.java
 *
 * this class provides a static method for checking whether the input string
 * contains a valid integer
 * 
 */

package core;

/**
 *
 * @author admin
 */
public class Validator {

    public static boolean isNumber(String s) {
        try{
            Integer.parseInt(s);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
