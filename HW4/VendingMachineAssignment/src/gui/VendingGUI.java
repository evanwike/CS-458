package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import vending.Coin;
import vending.VendingMachine;

public class VendingGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JRadioButton nickelButton, dimeButton, quarterButton, dollarButton;
	private JRadioButton coffeeButton, juiceButton, sodaButton;
	private JButton insertCoinButton, returnCoinsButton, purchaseButton;
	private JTextField depositTextField, infoTextField;

	private VendingMachine vendingMachine;
	
	public VendingGUI(VendingMachine vendingMachine){
		this.vendingMachine = vendingMachine;
		createContentPane();
		setComponentNames();
	}

	public VendingMachine getVendingMachine() {
		return vendingMachine;
	}
	
	private void setComponentNames() {
		nickelButton.setName("NickelButton");
		dimeButton.setName("DimeButton");
		quarterButton.setName("QuarterButton");
		dollarButton.setName("DollarButton");
		
		coffeeButton.setName("CoffeeButton");
		juiceButton.setName("JuiceButton");
		sodaButton.setName("SodaButton");
		
		insertCoinButton.setName("InsertCoinButton");
		returnCoinsButton.setName("ReturnCoinsButton");
		purchaseButton.setName("PurchaseButton");
		depositTextField.setName("DepositTextField");
		infoTextField.setName("InfoTextField");
	}

	
	private void createContentPane() { 
		JPanel mainPanel = new JPanel();
		mainPanel.add(createInfoPanel());
		mainPanel.setLayout(new GridLayout(4,1));
		mainPanel.add(createCoinPanel());
		mainPanel.add(createDepositAmountPanel());
		mainPanel.add(createPurchasePanel());
		setContentPane(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private JPanel createCoinPanel(){	
		insertCoinButton = new JButton("Insert Coin");
		insertCoinButton.addActionListener(this);
		JPanel panel = new JPanel();
		panel.add(insertCoinButton);
		panel.add(createCoinRadioGroup());
		return panel;
	}
	
	private JPanel createCoinRadioGroup(){
		nickelButton = new JRadioButton(Coin.NICKEL.name());
		nickelButton.setSelected(false);
		dimeButton = new JRadioButton(Coin.DIME.name());
		dimeButton.setSelected(false);
		quarterButton = new JRadioButton(Coin.QUARTER.name());
		quarterButton.setSelected(true);
		dollarButton = new JRadioButton(Coin.DOLLAR.name());
		dollarButton.setSelected(false);
		
		ButtonGroup coinRadioGroup = new ButtonGroup();
		coinRadioGroup.add(nickelButton);
		coinRadioGroup.add(dimeButton);
		coinRadioGroup.add(quarterButton);
		coinRadioGroup.add(dollarButton);

		JPanel coinRadioPanel = new JPanel(); 
		coinRadioPanel.add(nickelButton);
		coinRadioPanel.add(dimeButton);
		coinRadioPanel.add(quarterButton);
		coinRadioPanel.add(dollarButton);
		
		return coinRadioPanel;
	}
	
	private JPanel createDepositAmountPanel(){
		JLabel depositLabel = new JLabel("Deposit");
		depositTextField = new JTextField(6);
		depositTextField.setEditable(false);
		depositTextField.setText("0 cents");
		
		JPanel depositPanel = new JPanel(); 
		depositPanel.add(depositLabel);
		depositPanel.add(depositTextField);
		depositPanel.add(createReturnCoinsPanel());
		return depositPanel;
	}

	private JPanel createReturnCoinsPanel(){
		returnCoinsButton = new JButton("Return Coins");
		returnCoinsButton.addActionListener(this);
		JPanel panel = new JPanel();
		panel.add(returnCoinsButton);
		return panel;
	}

	private JPanel createPurchasePanel(){	
		purchaseButton = new JButton("Purchase");
		purchaseButton.addActionListener(this);
		JPanel panel = new JPanel();
		panel.add(purchaseButton);
		panel.add(createDrinkRadioGroup());
		return panel;
	}
		
	private JPanel createDrinkRadioGroup(){
		coffeeButton = new JRadioButton(vendingMachine.getCoffee().toString());
		coffeeButton.setSelected(true);
		juiceButton = new JRadioButton(vendingMachine.getJuice().toString());
		juiceButton.setSelected(false);
		sodaButton = new JRadioButton(vendingMachine.getSoda().toString());
		sodaButton.setSelected(false);
		
		ButtonGroup drinkRadioGroup = new ButtonGroup();
		drinkRadioGroup.add(coffeeButton);
		drinkRadioGroup.add(juiceButton);
		drinkRadioGroup.add(sodaButton);

		JPanel drinkRadioPanel = new JPanel(); 
		drinkRadioPanel.add(coffeeButton);
		drinkRadioPanel.add(juiceButton);
		drinkRadioPanel.add(sodaButton);
		
		return drinkRadioPanel;
	}

	private JPanel createInfoPanel(){
		infoTextField = new JTextField(30);
		infoTextField.setText("Welcome! ");
		infoTextField.setEditable(false);
		JPanel infoPanel = new JPanel(); 
		infoPanel.add(infoTextField);
		return infoPanel;
	}

	private void updateDepositTextField(int amount){
		depositTextField.setText(amount+" cents");
	}
	
	private void updateInformation(String info){
		infoTextField.setText(info);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insertCoinButton) {
			if (nickelButton.isSelected())
				vendingMachine.insertCoin(Coin.NICKEL);
			else
			if (dimeButton.isSelected())
				vendingMachine.insertCoin(Coin.DIME);
			else
			if (quarterButton.isSelected())
				vendingMachine.insertCoin(Coin.QUARTER);
			else
			if (dollarButton.isSelected())
				vendingMachine.insertCoin(Coin.DOLLAR);
			updateDepositTextField(vendingMachine.getDeposit());
			updateInformation("Welcome!");
		} else
		if (e.getSource() == purchaseButton) {
			boolean isPurchaseSuccessful = false; 
			if (coffeeButton.isSelected()) {
				isPurchaseSuccessful = vendingMachine.purchase(VendingMachine.COFFEE);
				if (isPurchaseSuccessful)
					coffeeButton.setText(vendingMachine.getCoffee().toString());
				else {
					if (vendingMachine.getCoffee().getCount()==0)
						updateInformation("Sorry, coffee is sold out.");
					else
						updateInformation("Your deposit is not enough.");
				}
			}
			else
			if (juiceButton.isSelected()) {
				isPurchaseSuccessful = vendingMachine.purchase(VendingMachine.JUICE);
				if (isPurchaseSuccessful)
					juiceButton.setText(vendingMachine.getJuice().toString());
				else {
					if (vendingMachine.getJuice().getCount()==0)
						updateInformation("Sorry, juice is sold out.");
					else
						updateInformation("Your deposit is not enough.");
				}
			}
			else
			if (sodaButton.isSelected()){
				isPurchaseSuccessful = vendingMachine.purchase(VendingMachine.SODA);
				if (isPurchaseSuccessful)
					sodaButton.setText(vendingMachine.getSoda().toString());
				else {
					if (vendingMachine.getSoda().getCount()==0)
						updateInformation("Sorry, soda is sold out.");
					else
						updateInformation("Your deposit is not enough.");
				}
			}
			
			if (isPurchaseSuccessful) {
				updateDepositTextField(vendingMachine.getDeposit());
				if (vendingMachine.getChange()>0)
					updateInformation("Your change is "+vendingMachine.getChange()+ " cents. Thank you for your business.");
				else
					updateInformation("Thank you for your business.");					
			}				
		} else
		if (e.getSource() == returnCoinsButton) {
			if (vendingMachine.getDeposit()>0) {
				vendingMachine.returnCoins();
				updateDepositTextField(vendingMachine.getDeposit());
				updateInformation("Coins are returned.");
			}
		}  
	}
}
