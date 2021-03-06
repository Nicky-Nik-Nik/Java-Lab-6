package by.bntu.fitr.poisit.lab06.model.service;

import by.bntu.fitr.poisit.lab06.exception.InvalidRangeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayServiceTest {

    ArrayService service = new ArrayService();

    @Test
    void findMaxAbsIndex1() {
        int expected = 3;
        double[] array = {12.3, 120.4, 458.3, -987.24, 58.3, 975.154, 56.8, -874.12, 12.0};
        int actual = service.findMaxAbsIndex(array);
        assertEquals(expected, actual);
    }

    @Test
    void findMaxAbsIndex2() {
        int expected = 0;
        double[] array = {1225.3, 120.4, 458.3, -987.24, 58.3, 975.154, 56.8, -874.12, 12.0};
        int actual = service.findMaxAbsIndex(array);
        assertEquals(expected, actual);
    }

    @Test
    void calculateAmountThatMore1() {
        int expected = 3;
        double[] array = {1225.3, 120.4, 458.3, -987.24, 58.3, 975.154, 56.8, -874.12, 12.0};
        int actual = service.calculateAmountThatMore(array, 300);
        assertEquals(expected, actual);
    }

    @Test
    void calculateAmountThatMore2() {
        int expected = 0;
        double[] array = {1225.3, 120.4, 458.3, -987.24, 58.3, 975.154, 56.8, -874.12, 12.0};
        int actual = service.calculateAmountThatMore(array, 1225.3);
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplyAfterBiggestAbs1() {
        double expected = 0.0;
        double[] array = {1225.3, 120.4, 458.3, -987.24, 58.3, 975.154, 56.8, 0, 12.0};
        double actual = service.calculateMultiplyAfterBiggestAbs(array);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void calculateMultiplyAfterBiggestAbs2() {
        double expected = -1_930_317.85;
        double[] array = {125.3, 120.4, 458.3, -987.24, 58.3, 97.154, 56.8, -0.5, 12.0};
        double actual = service.calculateMultiplyAfterBiggestAbs(array);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void rfind() {
        int expected = 5;
        int actual = service.rfind(new int[]{5, 1, 3, 4, 1, 1, 6}, 1);
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumAllPositive1() {
        int expected = 25;
        int actual = service.calculateSumAllPositive(new int[]{-5, 2, 13, 0, 10, -2, -125});
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumAllPositive2() {
        int expected = 0;
        int actual = service.calculateSumAllPositive(new int[]{-5, -2, -13, 0, -10, -2, -125});
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumAfterLast1() {
        int expected = 13;
        int actual = service.calculateSumAfterLast(new int[]{24, 0, 123, 1, 0, 5, 6, 2}, 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumAfterLast2() {
        int expected = 0;
        int actual = service.calculateSumAfterLast(new int[]{2, 0, 123, 1, 0, 5, 6, 2}, 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculateQuantityInRange1() {
        int expected = 4;
        try {
            int actual = service.calculateQuantityInRange(
                    new double[]{5.2, 3.8, 1.2, 5.5, 13.3, 24.2}, 1.2, 5.5);
            assertEquals(expected, actual);
        } catch (InvalidRangeException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void calculateQuantityInRange2() {
        assertThrows(InvalidRangeException.class, () ->
                service.calculateQuantityInRange(new double[]{1}, 5.5, 1.1));
    }
}