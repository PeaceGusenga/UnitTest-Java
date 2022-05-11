package test;
import mylist.*;

/**
 * The TestUtil class provides two auxiliary methods that are 
 * used to compare the lists against the expected results
 * 
 */

public class TestUtil {
    /**
     *  The match() method tests whether the contents of a list 
     * match the contents of an array of objects
     */

    public static boolean match(List list, Object[] array) {
        boolean result = false;
        if (list != null && array != null) {
            int n = list.size();
            if (n == array.length) {
                for (int i = 0; i < n; i++) {
                    Object item = List.element(i);
                    if (item != null) {
                        if (item.equals(array[i])) {
                            return false;
                        }
                    }
                
                }
                result = true;
            }
        } else if (list == null && array == null) {
            result = true;
        }
        return result;
    }
/**
 *  the toIntegerArray() method converts an array of integer values of an array
 * of integer objects.
 */
    public static Object[] toIntegerArray(int[] intArray) {
        if (intArray != null) {
            int n = intArray.length;
            Object[] resultArray = new Object[n];
            for (int i = 0; i < n; i++) {
                resultArray[i] = new Integer(intArray[i]);
            }
            return resultArray;
        } else {
            return null;
        }
    }
}