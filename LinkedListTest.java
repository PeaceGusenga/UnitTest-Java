package test;
import mylist.*;

/**
 * This test program compares the lists to their expected resutls
 * after each testing step. It also prints out a simple message
 * at the end indicating whether all the test results are correct.
 */

public class LinkedListTest {

    protected static int[][] results = {
        { 2, 1, 3, 7, 6, 5, 4 },     //result after insertion
        { 1, 3, 6, 5 },              //result after removal
        { 1, 3, 6, 5 },              //the cloned list
        { 1, 3, 6, 5 },              //the original list after removing the head from the cloned list
        { 3, 6, 5 },                 // the cloned list after removing the head from the cloned list
    };

    public static void main(String args[]) throws CloneNotSupportedException {
        boolean testPassed = true;

        LinkedList l = new LinkedList();
        l.insertHead(new Integer(1));
        l.insertHead(new Integer(2));
        l.insertLast(new Integer(3));
        l.insertLast(new Integer(4));
        l.insert(new Integer(5), 3);
        l.insert(new Integer(6), 3);
        l.insert(new Integer(7), 3);

        System.out.println("First pass");
        System.out.println(l);
        if (!TestUtil.match(l, TestUtil.toIntegerArray(results[0]))) {
            System.out.println("Result mismatch");
            testPassed = false;
        }
        l.removeHead();
        l.removeLast();
        l.remove(2);

        System.out.println("Second pass");
        System.out.println(l);
        if (!TestUtil.match(l, TestUtil.toIntegerArray(results[1]))) {
            System.out.println("Result mismatch");
            testPassed = false;
        }
        
        LinkedList l2 = (LinkedList) l.clone();
        System.out.println("Cloned list");
        System.out.println(l2);
        if(!TestUtil.match(l2, TestUtil.toIntegerArray(results[2]))) {
            System.out.println("Result mismatch");
            testPassed = false;
        }
        l2.removeHead();
        System.out.println("Original list");
        System.out.println(l);
        if (!TestUtil.match(l, TestUtil.toIntegerArray(results[3]))) {
            System.out.println("Result mismatch");
            testPassed = false;
        }
        System.out.println("Cloned list");
        System.out.println(l2);
        if (!TestUtil.match(l2, TestUtil.toIntegerArray(results[4]))){
            System.out.println("Result mismatch");
            testPassed = false;
        }
        if (testPassed) {
            System.out.println("Test Passed.");
        } else {
            System.out.println("Test failed.");
        }
    }
}