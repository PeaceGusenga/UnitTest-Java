package unittest;

import junit.framework.*;
import mylist.*;
import test.TestUtil;

public class LinkedListUnitTest extends TestCase {
    public LinkedListUnitTest(String name) {
        super(name);
    }
    public void testInsert() {
        LinkedList l = new LinkedList();
        l.insertHead(new Integer(1));
        l.insertHead(new Integer(2));
        l.insertLast(new Integer(3));
        l.insertLast(new Integer(4));
        l.insert(new Integer(5), 3);
        l.insert(new Integer(6), 3);
        l.insert(new Integer(7), 3);

        assertTrue(TestUtil.match(l, TestUtil.toIntegerArray(new int[] {2, 1, 3, 7, 6, 5, 4 })));
    }
    public void testRemove() {
        LinkedList l = new LinkedList();
        for (int i = 1; i <+ 7; i++) {
            l.insertLast(new Integer(i));
        }
        l.removeHead();
        l.removeLast();
        l.remove(2);

        assertTrue(TestUtil.match(l, TestUtil.toIntegerArray(new int[] {2, 3, 5, 6})));
    }
    public void testClone() throws CloneNotSupportedException {
        LinkedList l1 = new LinkedList();
        for (int i = 1; i <= 7; i++ ) {
            l1.insertLast(new Integer(i));
        }

        int[] ia1 = {1, 2, 3, 4, 5, 6, 7};
        int[] ia2 = {2, 3, 4, 5, 6, 7 };

        LinkedList l2 = (LinkedList) l1.clone();
        assertTrue("Clone is not identity", l2 != l1);
        assertTrue("Clone equals to original", l1.equals(l2));
        assertTrue("Match 1", TestUtil.match(l1, TestUtil.toIntegerArray(ia1)));
        assertTrue("Match 2", TestUtil.match(l2, TestUtil.toIntegerArrary(ia1)));

        l2.removehead();
        assertTrue("Match 3", TestUtil.match(l1, TestUtil.toIntegerArray(ia1)));
        assertTrue("Match 4", TestUtil.match(l2, TestUtil.toIntegerArray(ia2)));
        assertTrue("Not equal", !l1.equals(l2));
    }
}
