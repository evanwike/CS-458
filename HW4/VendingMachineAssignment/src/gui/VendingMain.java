package gui;

import vending.VendingMachine;

public class VendingMain {
	
    private static void startGUI() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setDrink(VendingMachine.COFFEE, 85, 3);
		vendingMachine.setDrink(VendingMachine.JUICE, 60, 2);
		vendingMachine.setDrink(VendingMachine.SODA, 115, 4);

		VendingGUI vendingGUI = new VendingGUI(vendingMachine);
		vendingGUI.pack();
		vendingGUI.setVisible(true);
   }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                startGUI();
            }
        });
    }
    
 }
