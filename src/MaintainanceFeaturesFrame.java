

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

/**
 * The MaintenanceFrame class represents a frame for maintaining a vending machine.
 * It allows the user to perform various maintenance actions on the vending machine.
 * 
 */
public class MaintainanceFeaturesFrame extends JFrame {

	//colors
	private Color blue = new Color(19, 156, 181);
	private Color pink = new Color(230, 110, 109);
	private Color yellow = new Color(243, 178, 26);
	private Color lightBlue = new Color(19, 156, 181, 200);
	private Color lightPink = new Color(238, 170, 170);


	private JPanel contentPane;
	
	private JPanel slotsPanel, displayPanel;

	/**
	 * Buttons for the number pad of the vending machine.
	 */
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, clearBTN, enterBTN;
	/**
	 * Buttons for the main menu of the application.
	 */
	private JButton mainMenuBTN, returnBTN, saveBTN, cancelBTN, addItemsBTN;
	/**
	 * Buttons for the maintenance features of the vending machine.
	 */
	private JButton replenishBTN, stockBTN, setPriceBTN, collectBTN, printSummaryBTN;

	
	/**
	 * The CashBoxFrame instance for the vending machine.
	 */
	private CashBoxFrame cashBoxFrame = new CashBoxFrame();
	/**
	 * The Text field to place the new price.
	 */
	private JTextField newPriceTXT;
	/**
	 * The JLabels for the display panel of the vending machine.
	 */
	private JLabel vmNameLBL, displayAction, displaySlotChoice, lblCurrPrice, lblNewPrice, displayItemName;
	/**
	 * The JLabels for the item info on the display panel of the vending machine.
	 */
	private JLabel displayWeight, displayCalories, displayPrice, displayStock;
	/**
	 * The JPanel representing the slots of the vending machine.
	 */
	private JPanel slot;
	/**
	 * The JLabels for the quantity and price on the slots of the vending machine.
	 */
	private JLabel qtyTXT, priceTXT;
	/**
	 * The ArrayLists for the quantity on the slots of the vending machine.
	 */
	ArrayList<JLabel> qtyTXTList = new ArrayList<JLabel>();
	/**
	 * The ArrayLists for the price on the slots of the vending machine.
	 */
	ArrayList<JLabel> priceTXTList = new ArrayList<JLabel>();
	
	//BUTTONS
	/**
	 * Sets the action listener for the 'Main Menu' button.
	 * @param actionListener
	 */
	public void setMainMenuActionListener(ActionListener actionListener)
	{
		mainMenuBTN.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the 'Return' button.
	 * @param actionListener
	 */
	public void setReturnActionListener(ActionListener actionListener)
	{
		returnBTN.addActionListener(actionListener);

	}
	/**
	 * Sets the action listener for the 'Replenish Change' button.
	 * @param actionListener
	 */
	public void setReplenishChangeActionListener(ActionListener actionListener)
	{
		replenishBTN.addActionListener(actionListener);
	}

	/**
	 * Sets the action listener for the 'Stock' button.
	 * @param actionListener
	 */
	public void setCollectPaymentActionListener(ActionListener actionListener)
	{
		collectBTN.addActionListener(actionListener);
	}

	/**
	 * Sets the action listener for the 'Stock' button.
	 * @param actionListener
	 */
	public void setPrintSummaryActionListener(ActionListener actionListener)
	{
		printSummaryBTN.addActionListener(actionListener);
	}
	
	/**
	 * Sets the action listener for the 'Stock' button.
	 * @param actionListener
	 */
	public CashBoxFrame getCashBoxFrame() {
		return this.cashBoxFrame;
	}

	//ACTION LISTENERS FOR BUTTONS
	/**
	 * Action listener implementation for number buttons
	 * @param actionListener
	 */
		public void NumberButtonListener (ActionListener actionListener){
	
			this.btn0.addActionListener(actionListener);
			this.btn1.addActionListener(actionListener);
			this.btn2.addActionListener(actionListener);
			this.btn3.addActionListener(actionListener);
			this.btn4.addActionListener(actionListener);
			this.btn5.addActionListener(actionListener);
			this.btn6.addActionListener(actionListener);
			this.btn7.addActionListener(actionListener);
			this.btn8.addActionListener(actionListener);
			this.btn9.addActionListener(actionListener);
		}

		/**
		 * Getter for the displayAction
		 * @return
		 */
		public JLabel getDisplayAction()
		{
			return displayAction;
		}

		/**
		 * Getter for the displaySlotChoice
		 * @return
		 */
		public JLabel getDisplaySlotChoice()
		{
			return displaySlotChoice;
		}
	
		/**
		 * Action listener implementation for the "clear" button
		 * @param actionListener
		 */
		public void ClearButtonListener(ActionListener actionListener){
			this.clearBTN.addActionListener(actionListener);
		}
	
		/**
		 * Action listener implementation for the "enter" button
		 * @param actionListener
		 */
		public void EnterButtonListener(ActionListener actionListener){
			this.enterBTN.addActionListener(actionListener);
		}

	
		/**
		 * Action listener implementation for the "set price" button
		 * @param actionListener
		 */
		public void setPriceButtonListener(ActionListener actionListener){
			this.setPriceBTN.addActionListener(actionListener);
		}

		/**
		 * displays the set price panel containing text fields for the new price
		 */
		public void displaySetPrice() {

			saveBTN = new JButton("save");
			saveBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
			saveBTN.setBounds(172, 302, 85, 21);
			displayPanel.add(saveBTN);
			
			cancelBTN = new JButton("cancel");
			cancelBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
			cancelBTN.setBounds(10, 302, 85, 21);
			displayPanel.add(cancelBTN);
			
			lblNewPrice.setText("New Price: ");
			
			newPriceTXT = new JTextField();
			newPriceTXT.setBounds(104, 253, 153, 26);
			displayPanel.add(newPriceTXT);
			newPriceTXT.setColumns(10);


		}


		/**
		 * Action listener implementation for the "save" button
		 * @param actionListener
		 */
		public void saveActionListener(ActionListener actionListener) {
			saveBTN.addActionListener(actionListener);
		}

		/**
		 * Action listener implementation for the "cancel" button
		 * @param actionListener
		 */
		public void cancelActionListener(ActionListener actionListener) {
			cancelBTN.addActionListener(actionListener);
		}
		
		/**
		 * gets the text field for the new price
		 */
		public JTextField getNewPriceTXT()
		{
			return newPriceTXT;
		}

		/**
		 * Gets the slot choice from the display panel
		 * @return
		 */
		public int getSlotChoice()
		{
			return Integer.parseInt(displaySlotChoice.getText());
		}

		/**
		 * Gets the new price from the text field
		 * @return
		 */
		public Double getNewPrice()
		{
			return Double.parseDouble( newPriceTXT.getText());
		}

		/**
		 * sets current price
		 * @param price
		 */
		public void setCurrPrice(double price)
		{
			lblCurrPrice.setText("Current Price: " + price + "php");
		}

	

	//Display Item info
	/**
	 * displays info of the chosen item
	 * @param itemName
	 * @param weight
	 * @param calories
	 * @param price
	 * @param stock
	 */
	public void setDisplayOnScreen(String itemName, String weight, 
									double calories,double price, int stock)
	{
		
		displayItemName.setText("Item: " + itemName);
		displayWeight.setText("weight: " + weight);
		displayCalories.setText("cal: " + calories );
		displayPrice.setText("price: " + price + "php");
		displayStock.setText("stock left: " + stock);

	}

	/**
	 * Resets the display on the screen.
	 */
	public void resetDisplayOnScreen()
	{
		displayItemName.setText("Item: ");
		displayWeight.setText("weight: ");
		displayCalories.setText("cal: ");
		displayPrice.setText("price: ");
		displayStock.setText("stock left: ");
		displayAction.setText("");
	}

		
		/**
		 * Action listener implementation for the "stock" button
		 * @param actionListener
		 */
		public void restockButtonListener(ActionListener actionListener){
			this.stockBTN.addActionListener(actionListener);
		}
		
		/**
		 * sets the text of the quantity of the item in the slot
		 * @param slotChoice
		 * @param qty
		 */
		public void setQtyText(int slotChoice, int qty) {
			
			qtyTXTList.get(slotChoice-1).setText(qty + "x");
		}

		/**
		 * sets the text of the price of the item in the slot
		 * @param slotChoice
		 */
		public void setPriceText(int slotChoice) {
			
			
			priceTXTList.get(slotChoice-1).setText(getNewPrice() + "php");
		}



	
	/**
	 * createSlots method creates the slots of the vending machine.
	 * @param numSlots
	 * @param itemName
	 * @param qty
	 * @param price
	 */
	private void createSlots(int numSlots, ArrayList<String> itemName, ArrayList<Integer> qty, ArrayList<Double> price) {
		slotsPanel.removeAll(); // Remove any existing panels
		
		int rows = (int) Math.ceil((double) numSlots / 4);
		slotsPanel.setLayout(new GridLayout(rows, 4, 10, 10)); // Use GridLayout to arrange the panels in a 4-column grid
	
		for (int i = 0; i < numSlots; i++) {
			slot = new JPanel();
			slot.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			slot.setLayout(new BorderLayout()); // Use BorderLayout for each slot panel
			slotsPanel.add(slot);
	
			if (i < itemName.size()) {
				JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				slot.add(upperPanel, BorderLayout.NORTH);
	
				JLabel itemNameTXT = new JLabel(itemName.get(i));
				itemNameTXT.setFont(new Font("Rockwell", Font.BOLD, 12)); // Increase the font size for better visibility
				upperPanel.add(itemNameTXT);
	
				qtyTXT = new JLabel(qty.get(i) + "x");
				qtyTXT.setFont(new Font("Rockwell", Font.PLAIN, 10));
				upperPanel.add(qtyTXT);
				qtyTXTList.add(qtyTXT);
	
				JPanel midPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				slot.add(midPanel, BorderLayout.CENTER);
	
				priceTXT = new JLabel("Price:");
				priceTXT.setFont(new Font("Rockwell", Font.PLAIN, 10));
				midPanel.add(priceTXT);
	
				JLabel priceValTXT = new JLabel(price.get(i) + "php");
				priceValTXT.setFont(new Font("Rockwell", Font.BOLD, 12));
				midPanel.add(priceValTXT);
				priceTXTList.add(priceValTXT);
	
				JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
				slot.add(lowerPanel, BorderLayout.SOUTH);
	
				JLabel slotNumTXT = new JLabel("#" + (i + 1));
				slotNumTXT.setFont(new Font("Rockwell", Font.BOLD, 12));
				lowerPanel.add(slotNumTXT);
			}
		}
	
		slotsPanel.revalidate();
		slotsPanel.repaint();
	}
	

	/**
	 * Sets the number of slots of the vending machine.
	 * @param numSlots
	 * @param itemName
	 * @param qty
	 * @param price
	 */
	public void setNumSlots(int numSlots, ArrayList<String> itemName, ArrayList<Integer> qty, ArrayList<Double> price) {
		createSlots(numSlots, itemName, qty, price);
	}

	/**
	 * Sets the action listener for the 'Add Items' button.
	 * @param actionListener
	 */
	public void setAddItemsBtnListener(ActionListener actionListener) {
		addItemsBTN.addActionListener(actionListener);	
	}
	
	/**
	 * Sets the action listener for the 'Add Items' button.
	 * @param actionListener
	 */
	public void setVmName(String vmName)
	{
		vmNameLBL.setText(vmName);
	}


	//CONSTRUCTOR	
	public MaintainanceFeaturesFrame(){
		
		components();
	}

	
	/**
	 * Create the frame.
	 */
	private void components() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 500, 950, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 202, 58));
		panel.setBounds(10, 10, 916, 643);
		contentPane.add(panel);
		panel.setLayout(null);

		
		
		JPanel vmControls = new JPanel();
		vmControls.setBounds(641, 353, 265, 280);
		panel.add(vmControls);
		vmControls.setLayout(null);
		
		JPanel slotNumPanel = new JPanel();
		slotNumPanel.setBounds(38, 31, 191, 199);
		vmControls.add(slotNumPanel);
		slotNumPanel.setLayout(null);
		
		// Slot buttons
		btn1 = new JButton("1");
		btn1.setBounds(24, 5, 43, 33);
		btn1.setFont(new Font("Rockwell", Font.BOLD, 15));
		slotNumPanel.add(btn1);

		btn2 = new JButton("2");
		btn2.setBounds(72, 5, 48, 33);
		btn2.setFont(new Font("Rockwell", Font.BOLD, 15));
		slotNumPanel.add(btn2);

		btn3 = new JButton("3");
		btn3.setBounds(125, 5, 43, 33);
		btn3.setFont(new Font("Rockwell", Font.BOLD, 15));
		slotNumPanel.add(btn3);

		btn4 = new JButton("4");
		btn4.setBounds(24, 43, 43, 33);
		btn4.setFont(new Font("Rockwell", Font.BOLD, 15));
		slotNumPanel.add(btn4);

		btn5 = new JButton("5");
		btn5.setBounds(72, 43, 48, 33);
		btn5.setFont(new Font("Rockwell", Font.BOLD, 15));
		slotNumPanel.add(btn5);

		btn6 = new JButton("6");
		btn6.setBounds(125, 43, 43, 33);
		btn6.setFont(new Font("Rockwell", Font.BOLD, 15));
		slotNumPanel.add(btn6);

		btn7 = new JButton("7");
		btn7.setBounds(24, 81, 43, 33);
		btn7.setFont(new Font("Rockwell", Font.BOLD, 15));
		slotNumPanel.add(btn7);

		btn8 = new JButton("8");
		btn8.setBounds(72, 81, 48, 33);
		btn8.setFont(new Font("Rockwell", Font.BOLD, 15));
		slotNumPanel.add(btn8);

		btn9 = new JButton("9");
		btn9.setBounds(125, 81, 43, 33);
		btn9.setFont(new Font("Rockwell", Font.BOLD, 15));
		slotNumPanel.add(btn9);

		btn0 = new JButton("0");
		btn0.setBounds(24, 119, 43, 33);
		btn0.setFont(new Font("Rockwell", Font.BOLD, 15));
		slotNumPanel.add(btn0);

		clearBTN = new JButton("clr");
		clearBTN.setBounds(72, 119, 96, 33);
		clearBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		slotNumPanel.add(clearBTN);
		
		enterBTN = new JButton("enter");
		enterBTN.setBounds(46, 157, 99, 35);
		enterBTN.setFont(new Font("Rockwell", Font.BOLD, 20));
		slotNumPanel.add(enterBTN);
		
		JPanel vendingMachine = new JPanel();
		vendingMachine.setBounds(206, 10, 425, 623);
		panel.add(vendingMachine);
		vendingMachine.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(150, 5, 1, 1);
		vendingMachine.add(layeredPane);
		
		slotsPanel = new JPanel();
		slotsPanel.setBounds(10, 63, 405, 475);
		vendingMachine.add(slotsPanel);
		
		vmNameLBL = new JLabel("V.M. Name");
		vmNameLBL.setFont(new Font("Rockwell", Font.BOLD, 30));
		vmNameLBL.setHorizontalAlignment(SwingConstants.CENTER);
		vmNameLBL.setBounds(10, 10, 405, 43);
		vendingMachine.add(vmNameLBL);
		
		addItemsBTN = new JButton("Add Items");
		addItemsBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		addItemsBTN.setBounds(146, 557, 166, 43);
		vendingMachine.add(addItemsBTN);
		
		JPanel maintainPanel = new JPanel();
		maintainPanel.setBounds(10, 10, 186, 623);
		panel.add(maintainPanel);
		maintainPanel.setLayout(null);
		
		stockBTN = new JButton("Restock ");
		stockBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		stockBTN.setBounds(10, 57, 106, 50);
		maintainPanel.add(stockBTN);
		
		setPriceBTN = new JButton("Set Price");
		setPriceBTN.setBounds(10, 117, 166, 50);
		setPriceBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		maintainPanel.add(setPriceBTN);
		
		collectBTN = new JButton("Collect Payment");
		collectBTN.setBounds(10, 177, 166, 50);
		collectBTN.setFont(new Font("Rockwell", Font.BOLD, 12));
		maintainPanel.add(collectBTN);
		
		replenishBTN = new JButton("Replenish Change");
		replenishBTN.setBounds(10, 237, 166, 50);
		replenishBTN.setFont(new Font("Rockwell", Font.BOLD, 12));
		maintainPanel.add(replenishBTN);
		
		printSummaryBTN = new JButton("<html><center>Print Transaction<br>Summary</center></html>");		
		printSummaryBTN.setBounds(10, 297, 166, 50);
		printSummaryBTN.setFont(new Font("Rockwell", Font.BOLD, 12));
		maintainPanel.add(printSummaryBTN);
		
		returnBTN = new JButton("TEST FEATURES");
		returnBTN.setBounds(10, 531, 157, 36);
		returnBTN.setFont(new Font("Rockwell", Font.BOLD, 14));
		maintainPanel.add(returnBTN);
		
		mainMenuBTN = new JButton("\nMAIN MENU");
		mainMenuBTN.setBounds(10, 577, 157, 36);
		mainMenuBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		maintainPanel.add(mainMenuBTN);
		
		JLabel lblNewLabel = new JLabel("Maintainance");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel.setBounds(-9, 20, 201, 27);
		maintainPanel.add(lblNewLabel);
		
		JLabel lblReturn = new JLabel("Return");
		lblReturn.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturn.setFont(new Font("Harlow Solid Italic", Font.BOLD, 25));
		lblReturn.setBounds(10, 494, 157, 27);
		maintainPanel.add(lblReturn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(114, 57, 62, 50);
		maintainPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("+1");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 62, 50);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 25));
		panel_1.add(lblNewLabel_1);
		
		displayPanel = new JPanel();
		
		displayPanel.setBounds(639, 10, 267, 333);
		panel.add(displayPanel);
		displayPanel.setLayout(null);

		lblCurrPrice = new JLabel("");
			lblCurrPrice.setFont(new Font("Rockwell", Font.PLAIN, 15));
			lblCurrPrice.setBounds(10, 208, 247, 45);
			displayPanel.add(lblCurrPrice);
			
			lblNewPrice = new JLabel("");
			lblNewPrice.setFont(new Font("Rockwell", Font.PLAIN, 15));
			lblNewPrice.setBounds(10, 245, 119, 45);
			displayPanel.add(lblNewPrice);
		
		JLabel lblNewLabel_3 = new JLabel("Slot #");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 10, 119, 45);
		displayPanel.add(lblNewLabel_3);
		
		displaySlotChoice = new JLabel("");
		displaySlotChoice.setFont(new Font("Rockwell", Font.PLAIN, 15));
		displaySlotChoice.setBounds(138, 10, 119, 45);
		displayPanel.add(displaySlotChoice);
		
		displayItemName = new JLabel("Item:");
		displayItemName.setFont(new Font("Rockwell", Font.PLAIN, 15));
		displayItemName.setBounds(10, 54, 247, 45);
		displayPanel.add(displayItemName);
		slotsPanel.setLayout(null);
	
		displayWeight = new JLabel();
		displayWeight.setText("weight:");
		displayWeight.setHorizontalAlignment(SwingConstants.LEFT);
		displayWeight.setForeground(new Color(0, 0, 64));
		displayWeight.setFont(new Font("Rockwell", Font.PLAIN, 12));
		displayWeight.setBounds(134, 103, 82, 26);
		displayPanel.add(displayWeight);
		
		displayCalories = new JLabel();
		displayCalories.setText("cal:");
		displayCalories.setHorizontalAlignment(SwingConstants.LEFT);
		displayCalories.setForeground(new Color(0, 0, 64));
		displayCalories.setFont(new Font("Rockwell", Font.PLAIN, 12));
		displayCalories.setBounds(10, 100, 57, 26);
		displayPanel.add(displayCalories);
		
		displayPrice = new JLabel();
		displayPrice.setText("price:");
		displayPrice.setHorizontalAlignment(SwingConstants.LEFT);
		displayPrice.setForeground(new Color(0, 0, 64));
		displayPrice.setFont(new Font("Rockwell", Font.PLAIN, 12));
		displayPrice.setBounds(10, 126, 123, 26);
		displayPanel.add(displayPrice);
		
		displayStock = new JLabel();
		displayStock.setText("stock left: ");
		displayStock.setHorizontalAlignment(SwingConstants.LEFT);
		displayStock.setForeground(new Color(0, 0, 64));
		displayStock.setFont(new Font("Rockwell", Font.PLAIN, 12));
		displayStock.setBounds(134, 126, 123, 26);
		displayPanel.add(displayStock);
		
		displayAction = new JLabel("");
		displayAction.setFont(new Font("Rockwell", Font.ITALIC, 15));
		displayAction.setHorizontalAlignment(SwingConstants.CENTER);
		displayAction.setBounds(10, 160, 247, 51);
		displayPanel.add(displayAction);

		
		panel.setBackground(lightBlue);
		displayPanel.setBackground(Color.DARK_GRAY);
		//set all text in display panel to white
		displayAction.setForeground(Color.WHITE);
		displaySlotChoice.setForeground(Color.WHITE);
		displayItemName.setForeground(Color.WHITE);
		displayWeight.setForeground(Color.WHITE);
		displayCalories.setForeground(Color.WHITE);
		displayPrice.setForeground(Color.WHITE);
		displayStock.setForeground(Color.WHITE);
		lblCurrPrice.setForeground(Color.WHITE);
		lblNewPrice.setForeground(Color.WHITE);
		lblNewLabel_3.setForeground(Color.WHITE);	

		slotNumPanel.setBackground(Color.DARK_GRAY);

		lblNewLabel_1.setForeground(blue);
		lblNewLabel.setForeground(Color.WHITE);
		
		//set maintain panel color to blue
		maintainPanel.setBackground(blue);
		//all buttons to pink + label to white
		stockBTN.setBackground(pink);
		stockBTN.setForeground(Color.WHITE);
		setPriceBTN.setBackground(pink);
		setPriceBTN.setForeground(Color.WHITE);
		collectBTN.setBackground(pink);
		collectBTN.setForeground(Color.WHITE);
		replenishBTN.setBackground(pink);
		replenishBTN.setForeground(Color.WHITE);
		printSummaryBTN.setBackground(pink);	
		printSummaryBTN.setForeground(Color.WHITE);
		returnBTN.setBackground(yellow);
		mainMenuBTN.setBackground(yellow);
		addItemsBTN.setBackground(Color.DARK_GRAY);
		addItemsBTN.setForeground(Color.WHITE);

		//set vm controls color to blue
		vmControls.setBackground(blue);

		//set vending machine color to light pink
		vendingMachine.setBackground(lightPink);
		//set all slot panels to light pink
		slotsPanel.setBackground(lightPink);




	}
}
