package IntList;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntListExercisesTest {

    @Test
    public void squarePrimes() {
        IntList L = IntList.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        boolean b = IntListExercises.squarePrimes(L);
        assertTrue(b);
        assertEquals("1 -> 4 -> 9 -> 4 -> 25 -> 6 -> 49 -> 8 -> 9", L.toString());
    }
}