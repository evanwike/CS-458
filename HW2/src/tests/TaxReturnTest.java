package tests;

import org.junit.jupiter.api.Test;
import programs.TaxReturn;

class TaxReturnTest {

    @Test
    void testCase1() {
        TaxReturn tr = new TaxReturn(1, 1);
        System.out.println("Your tax is " + tr.getTax());
    }

    @Test
    void testCase2() {
        TaxReturn tr = new TaxReturn(30000, 1);
        System.out.println("Your tax is " + tr.getTax());
    }
    @Test
    void testCase3() {
        TaxReturn tr = new TaxReturn(60000, 1);
        System.out.println("Your tax is " + tr.getTax());
    }
    @Test
    void testCase4() {
        TaxReturn tr = new TaxReturn(1, 2);
        System.out.println("Your tax is " + tr.getTax());
    }
    @Test
    void testCase5() {
        TaxReturn tr = new TaxReturn(40000, 2);
        System.out.println("Your tax is " + tr.getTax());
    }
    @Test
    void testCase6() {
        TaxReturn tr = new TaxReturn(90000, 2);
        System.out.println("Your tax is " + tr.getTax());
    }
}