package deque;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void sizeAfterAddingElements() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        assertEquals(2, deque.size());
    }

    @Test
    public void sizeAfterRemovingElements() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.removeFirst();
        assertEquals(1, deque.size());
    }

    @Test
    public void isEmptyOnNewDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void isEmptyAfterAddingAndRemovingElements() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.removeFirst();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void addFirstAndRetrieve() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        assertEquals(Integer.valueOf(1), deque.get(0));
    }

    @Test
    public void addLastAndRetrieve() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        assertEquals(Integer.valueOf(1), deque.get(0));
    }

    @Test
    public void removeFirstFromEmptyDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertNull(deque.removeFirst());
    }

    @Test
    public void removeLastFromEmptyDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertNull(deque.removeLast());
    }

    @Test
    public void getWithInvalidIndex() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        assertNull(deque.get(-1));
        assertNull(deque.get(1));
    }

    @Test
    public void printDequeWithElements() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.printDeque(); // Expected output: "1 2"
    }

    @Test
    public void iteratorTraversal() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        Iterator<Integer> iterator = deque.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertFalse(iterator.hasNext());
    }
}