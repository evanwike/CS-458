package tests;

import org.junit.jupiter.api.Test;
import programs.PrimeNumber;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTest {

    @Test
    void testCase1() {
        PrimeNumber.isPrimeNumber(17);
    }

    @Test
    void testCase2() {
        PrimeNumber.isPrimeNumber(11);
    }

    @Test
    void testCase3() {
        PrimeNumber.isPrimeNumber(4);
    }

    @Test
    void testCase4() {
        PrimeNumber.isPrimeNumber(0);
    }
}