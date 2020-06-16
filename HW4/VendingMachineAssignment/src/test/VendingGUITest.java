package test;

import gui.VendingGUI;
import junit.extensions.jfcunit.*;
import junit.extensions.jfcunit.finder.*;
import junit.extensions.jfcunit.eventdata.*;
import vending.Drink;
import vending.VendingMachine;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class VendingGUITest extends JFCTestCase {
    private VendingGUI gui;
    private TestHelper helper;
    private Random random;

    public VendingGUITest() { super(); }

    protected void setUp( ) throws Exception {
        super.setUp();
        helper = new JFCTestHelper();
        random = new Random();
        VendingMachine vending = new VendingMachine();
        vending.setDrink(VendingMachine.COFFEE, 85, 3);
        vending.setDrink(VendingMachine.JUICE, 60, 2);
        vending.setDrink(VendingMachine.SODA, 115, 4);
        gui = new VendingGUI(vending);
        gui.pack();
        gui.setVisible(true);
    }

    protected void tearDown( ) throws Exception {
        gui = null;
        super.tearDown();
    }

    private Component getComponent(String name) {
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, name);
        return finder.find(gui, 0);
    }

    private void select(String name) throws Exception {
        JRadioButton btnSelect = (JRadioButton) getComponent(name + "Button");
        assertNotNull(String.format("Couldn't find the %s button.", name), btnSelect);

        if (!btnSelect.isSelected())
            helper.enterClickAndLeave(new MouseEventData(this, btnSelect));
    }

    private void insertCoin(String name) throws Exception {
        select(name);
        JButton btnInsert = (JButton) getComponent("InsertCoinButton");
        assertNotNull("Couldn't find the Insert button.", btnInsert);
        helper.enterClickAndLeave(new MouseEventData(this, btnInsert));
    }

    private void returnCoins() throws Exception {
        JButton btnReturn = (JButton) getComponent("ReturnCoinsButton");
        assertNotNull("Couldn't find the Return button.", btnReturn);
        helper.enterClickAndLeave(new MouseEventData(this, btnReturn));
    }

    private void purchase() throws Exception {
        JButton btnPurchase = (JButton) getComponent("PurchaseButton");
        assertNotNull("Couldn't find the Purchase button.", btnPurchase);
        helper.enterClickAndLeave(new MouseEventData(this, btnPurchase));
    }

    private String getDepositText() {
        JTextField txtDeposit = (JTextField) getComponent("DepositTextField");
        return txtDeposit.getText();
    }

    private String getInfoText() {
        JTextField txtInfo = (JTextField) getComponent("InfoTextField");
        return txtInfo.getText();
    }

    // TESTS: Nickel, Dime, Quarter, Dollar, InsertCoin
    // Inserts a random # of the currently selected coin and tests to ensure the correct deposit
    // is reflected in both the UI and in the VendingMachine.
    private void testCoin(String name, int expected) {
        int n = random.nextInt(5) + 1;

        try {
            for (int i = 0; i < n; i++)
                insertCoin(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test that the correct amount of money has been deposited
        assertEquals(expected * n, gui.getVendingMachine().getDeposit());
        // Test that the correct amount of money is being displayed
        assertEquals(String.format("%d cents", expected * n), getDepositText());
    }

    // Individual coin tests
    // Calls testCoin for each coin type and ensures the proper amount was added to the deposit
    public void testNickels() { testCoin("Nickel", 5); }
    public void testDimes() { testCoin("Dime", 10); }
    public void testQuarters() { testCoin("Quarter", 25); }
    public void testDollars() { testCoin("Dollar", 100); }

    // Inserts a random # of each coin and ensures that the correct deposit is reflected
    // in both the UI and in the VendingMachine.  All coins are tested individually above,
    // but combinations increase the coverage.
    public void testCoins() {
        int expected = 0;
        int n = random.nextInt(5);

        try {
            for (int i = 0; i < n; i++)
                insertCoin("Nickel");
            expected += 5 * n;

            n = random.nextInt(5);
            for (int i = 0; i < n; i++)
                insertCoin("Dime");
            expected += 10 * n;

            n = random.nextInt(5);
            for (int i = 0; i < n; i++)
                insertCoin("Quarter");
            expected += 25 * n;

            n = random.nextInt(5);
            for (int i = 0; i < n; i++)
                insertCoin("Dollar");
            expected += 100 * n;
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test that the correct amount of money has been deposited
        assertEquals(expected, gui.getVendingMachine().getDeposit());
        // Test that the correct amount of money is being displayed
        assertEquals(String.format("%d cents", expected), getDepositText());
    }

    // TESTS: Coffee, InsertCoin, Purchase
    // Selects Coffee, then tests the boundaries of the purchase price with various coin combinations.
    // Attempts purchases with:
    //      - Deposit < Price: tests for correct error message and that the count isn't decremented
    //      - Deposit = Price: tests for correct message and that the count is decremented
    //      - Deposit > Price: tests for correct message and change, and that the count is decremented
    public void testPurchaseCoffee() {
        Drink coffee = gui.getVendingMachine().getCoffee();

        try {
            // Lower boundary
            select("Coffee");
            insertCoin("Quarter");
            insertCoin("Quarter");
            insertCoin("Quarter");
            insertCoin("Nickel");
            purchase();
            assertEquals("Your deposit is not enough.", getInfoText());
            assertEquals(3, coffee.getCount());

            // Exact change
            insertCoin("Nickel");
            purchase();
            assertEquals("Thank you for your business.", getInfoText());
            assertEquals(2, coffee.getCount());

            // Upper boundary
            insertCoin("Dollar");
            purchase();
            assertEquals("Your change is 15 cents. Thank you for your business.", getInfoText());
            assertEquals(1, coffee.getCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TESTS: Juice, InsertCoin, Purchase
    // Selects Juice, then tests the boundaries of the purchase price with various coin combinations.
    // Attempts purchases with:
    //      - Deposit < Price: tests for correct error message and that the count isn't decremented
    //      - Deposit = Price: tests for correct message and that the count is decremented
    //      - Deposit > Price: tests for correct message and change, and that the count is decremented
    // Attempts to purchase when count = 0, tests for correct "Sold Out" message and that the count
    // isn't decremented further.
    public void testPurchaseJuice() {
        Drink juice = gui.getVendingMachine().getJuice();

        try {
            // Lower Boundary
            select("Juice");
            insertCoin("Quarter");
            insertCoin("Quarter");
            purchase();
            assertEquals("Your deposit is not enough.", getInfoText());
            assertEquals(2, juice.getCount());

            // Exact change
            insertCoin("Dime");
            purchase();
            assertEquals("Thank you for your business.", getInfoText());
            assertEquals(1, juice.getCount());

            // Upper boundary
            insertCoin("Dollar");
            purchase();
            assertEquals("Your change is 40 cents. Thank you for your business.", getInfoText());
            assertEquals(0, juice.getCount());

            // Sold out
            insertCoin("Dollar");
            purchase();
            assertEquals("Sorry, juice is sold out.", getInfoText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TESTS: Soda, InsertCoin, Purchase
    // Selects Soda, then tests the boundaries of the purchase price with various coin combinations.
    // Attempts purchases with:
    //      - Deposit < Price: tests for correct error message and that the count isn't decremented
    //      - Deposit = Price: tests for correct message and that the count is decremented
    //      - Deposit > Price: tests for correct message and change, and that the count is decremented
    // Attempts to purchase when count = 0, tests for correct "Sold Out" message and that the count
    // isn't decremented further.
    public void testPurchaseSoda() {
        Drink soda = gui.getVendingMachine().getSoda();

        try {
            // Lower Boundary
            select("Soda");
            insertCoin("Dollar");
            purchase();
            assertEquals("Your deposit is not enough.", getInfoText());
            assertEquals(4, soda.getCount());

            // Exact change
            insertCoin("Dime");
            insertCoin("Nickel");
            purchase();
            assertEquals("Thank you for your business.", getInfoText());
            assertEquals(3, soda.getCount());

            // Upper boundary
            insertCoin("Dollar");
            insertCoin("Dollar");
            purchase();
            assertEquals("Your change is 85 cents. Thank you for your business.", getInfoText());
            assertEquals(2, soda.getCount());

            // Sold out
            for (int i = 0; i < 3; i++) {
                insertCoin("Dollar");
                insertCoin("Dollar");
                purchase();
            }

            assertEquals("Sorry, soda is sold out.", getInfoText());
            assertEquals(0, soda.getCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TESTS: ReturnCoins, InsertCoins
    // Inserts various different coins, clicks the ReturnCoins button, and tests that the correct change is
    // reflected in both the UI and in the VendingMachine.  Also tests to ensure that the correct message is
    // displayed.
    public void testReturnCoins() {
        try {
            insertCoin("Quarter");
            assertEquals("25 cents", getDepositText());
            assertEquals(25, gui.getVendingMachine().getDeposit());

            returnCoins();

            assertEquals("Coins are returned.", getInfoText());
            assertEquals("0 cents", getDepositText());
            assertEquals(0, gui.getVendingMachine().getDeposit());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}