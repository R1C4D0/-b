package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    //    test should randomly call StudentArrayDeque and ArrayDequeSolution methods until they disagree on an output
    @Test
    public void testRandomOperations() {
        StudentArrayDeque<Integer> studentDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solutionDeque = new ArrayDequeSolution<>();
        int operations = 1000; // 随机操作次数

        StringBuilder message = new StringBuilder();

        for (int i = 0; i < operations; i++) {
            int operation = StdRandom.uniform(4);
            Integer value;

            switch (operation) {
                case 0:
                    value = StdRandom.uniform(100);
                    studentDeque.addFirst(value);
                    solutionDeque.addFirst(value);
                    message.append("addFirst(").append(value).append(")\n");
                    break;
                case 1:
                    value = StdRandom.uniform(100);
                    studentDeque.addLast(value);
                    solutionDeque.addLast(value);
                    message.append("addLast(").append(value).append(")\n");
                    break;
                case 2:
                    if (!studentDeque.isEmpty() && !solutionDeque.isEmpty()) {
                        Integer studentValue = studentDeque.removeFirst();
                        Integer solutionValue = solutionDeque.removeFirst();
                        message.append("removeFirst()\n");
                        assertEquals(message.toString(), studentValue, solutionValue);
                    }
                    break;
                case 3:
                    if (!studentDeque.isEmpty() && !solutionDeque.isEmpty()) {
                        Integer studentValue = studentDeque.removeLast();
                        Integer solutionValue = solutionDeque.removeLast();
                        message.append("removeLast()\n");
                        assertEquals(message.toString(), studentValue, solutionValue);
                    }
                    break;
            }
        }
    }
}
