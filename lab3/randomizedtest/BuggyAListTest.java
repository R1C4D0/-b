package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;

import static org.junit.Assert.*;

public class BuggyAListTest {
    @org.junit.Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> bl = new BuggyAList<>();
        bl.addLast(5);
        bl.addLast(10);
        bl.addLast(15);
        assertEquals(15, (int) bl.getLast());
        assertEquals(3, bl.size());
        assertEquals(5, (int) bl.get(0));
        assertEquals(10, (int) bl.get(1));
        assertEquals(15, (int) bl.get(2));
        assertEquals(15, (int) bl.removeLast());
        assertEquals(10, (int) bl.removeLast());
        assertEquals(5, (int) bl.removeLast());
        assertEquals(0, bl.size());
    }

    @org.junit.Test
    public void testInsertAndSize() {
        BuggyAList<Integer> bl = new BuggyAList<>();
        bl.addLast(5);
        bl.addLast(10);
        bl.addLast(15);
        bl.addLast(20);
        bl.addLast(25);
        bl.addLast(30);
        bl.addLast(35);
        bl.addLast(40);
        bl.addLast(45);
        bl.addLast(50);
        assertEquals(10, bl.size());
        assertEquals(5, (int) bl.get(0));
        assertEquals(10, (int) bl.get(1));
        assertEquals(15, (int) bl.get(2));
        assertEquals(20, (int) bl.get(3));
        assertEquals(25, (int) bl.get(4));
        assertEquals(30, (int) bl.get(5));
        assertEquals(35, (int) bl.get(6));
        assertEquals(40, (int) bl.get(7));
        assertEquals(45, (int) bl.get(8));
        assertEquals(50, (int) bl.get(9));
    }

    @org.junit.Test
    public void testResize() {
        BuggyAList<Integer> bl = new BuggyAList<>();
        bl.addLast(5);
        bl.addLast(10);
        bl.addLast(15);
        bl.addLast(20);
        bl.addLast(25);
        bl.addLast(30);
        bl.addLast(35);
        bl.addLast(40);
        bl.addLast(45);
        bl.addLast(50);
    }
//    集合测试，随机测试
    @org.junit.Test
    public void testRandom() {
        BuggyAList<Integer> bl = new BuggyAList<>();
        AListNoResizing<Integer> al = new AListNoResizing<>();
        for (int i = 0; i < 10000; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.25) {
                int randVal = StdRandom.uniform(100);
                bl.addLast(randVal);
                al.addLast(randVal);
            } else if (numberBetweenZeroAndOne < 0.5) {
                assertEquals(al.size(), bl.size());
                if (al.size() > 0) {
                    assertEquals(al.removeLast(), bl.removeLast());
                }
            } else if (numberBetweenZeroAndOne < 0.75) {
                if (al.size() > 0) {
                int randIndex = StdRandom.uniform(al.size());
                assertEquals(al.get(randIndex), bl.get(randIndex));
                }
            } else {
                assertEquals(al.size(), bl.size());
            }
        }
    }
}