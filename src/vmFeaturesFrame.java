import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


/**
 * The vmFeaturesFrame class represents a JFrame for displaying the features of a vending machine.
 * It contains components such as buttons, text fields, and labels to interact with the vending machine.
 */
public class vmFeaturesFrame extends JFrame {

		//colors
		private Color blue = new Color(19, 156, 181);
		private Color pink = new Color(230, 110, 109);
		private Color yellow = new Color(243, 178, 26);
		private Color lightBlue = new Color(19, 156, 181, 200);
		private Color lightPink = new Color(238, 170, 170);

	private JPanel contentPane;
	private JPanel slotsPanel, slot;
	JPanel lowerPanel;

	/**
	 * Label for displaying the slot choice and current VM name
	 */
	private JLabel displaySlotChoice, vmNameLBL;

	//BUTTONS - components
	/**
	 * Buttons for the common vending machine controls.
	 */
	private JButton mainMenuBTN, returnBTN, payBTN, dispenseBTN, produceChangeBTN, printReceiptBTN, clearBTN, enterBTN, cancelTransactionBTN;
	/**
	 * Buttons for the number pad
	 */
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
	
	/**
	 * Button for adding a custom item to the vending machine.
	 */
	private JButton customItemBTN;

	/**
	 * Button for adding an ingredient to a special item in the vending machine.
	 */
	private JButton addIngredientBTN;

	// Text fields - components

	/**
	 * Label for displaying the selected slot choice.
	 */
	private JLabel slotLBL;

	/**
	 * Label for displaying the name of the selected item.
	 */
	private JLabel displayItemName;

	/**
	 * Label for displaying the weight of the selected item.
	 */
	private JLabel displayWeight;

	/**
	 * Label for displaying the calories of the selected item.
	 */
	private JLabel displayCalories;

	/**
	 * Label for displaying the description of the selected item.
	 */
	private JLabel displayDescription;

	/**
	 * Label for displaying the price of the selected item.
	 */
	private JLabel displayPrice;

	/**
	 * Label for displaying the stock quantity of the selected item.
	 */
	private JLabel displayStock;

	/**
	 * Label for displaying the current action being performed.
	 */
	private JLabel displayAction;

	/**
	 * Label for displaying the quantity of the selected item.
	 */
	private JLabel qtyTXT;

	/**
	 * Label for displaying the price of the selected item.
	 */
	private JLabel priceTXT;

	/**
	 * List of quantity labels for each slot.
	 */
	private ArrayList<JLabel> qtyTXTList = new ArrayList<JLabel>();

	/**
	 * List of price labels for each slot.
	 */
	private ArrayList<JLabel> priceTXTList = new ArrayList<JLabel>();

	private BuyerWalletFrame walletFrame = new BuyerWalletFrame();

	/**
	 * Label for displaying the ingredients of a special item.
	 */
	private JLabel IngredientsTXT;

	/**
	 * Label for displaying the price of a special item.
	 */
	private JLabel priceSpecialTXT;

	/**
	 * Label for displaying the calories of a special item.
	 */
	private JLabel calSpecialTXT;

	/**
	 * Label for displaying the name of a special item.
	 */
	private JLabel specialItemName;
	
	//BUTTONS
	/**
	 * Sets the action listener for the main menu button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setMainMenuActionListener(ActionListener actionListener)
	{
		mainMenuBTN.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the return button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setReturnActionListener(ActionListener actionListener)
	{
		returnBTN.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the pay button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setPayActionListener(ActionListener actionListener)
	{
		payBTN.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the dispense button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setDispenseActionListener(ActionListener actionListener)
	{
		dispenseBTN.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the produce change button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setProduceChangeActionListener(ActionListener actionListener)
	{
		produceChangeBTN.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the print receipt button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setPrintReceiptActionListener(ActionListener actionListener)
	{
		printReceiptBTN.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the clear button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setClearActionListener(ActionListener actionListener)
	{
		clearBTN.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the enter button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setEnterActionListener(ActionListener actionListener)
	{
		enterBTN.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the cancel transaction button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setCancelTransactionActionListener(ActionListener actionListener)
	{
		cancelTransactionBTN.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the custom item button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setCustomItemActionListener(ActionListener actionListener)
	{
		customItemBTN.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the add ingredient button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setAddIngredientActionListener(ActionListener actionListener)
	{
		addIngredientBTN.addActionListener(actionListener);
	}

	//Display on screen
	/**
	 * Sets the display on the screen with the provided item information.
	 *
	 * @param itemName The name of the item to be displayed.
	 * @param weight The weight of the item to be displayed.
	 * @param calories The calories of the item to be displayed.
	 * @param description The description of the item to be displayed.
	 * @param price The price of the item to be displayed.
	 * @param stock The stock quantity of the item to be displayed.
	 */
	public void setDisplayOnScreen(String itemName, String weight, 
									double calories, String description, double price, int stock)
	{
		
		displayItemName.setText("Item: " + itemName);
		displayWeight.setText("weight: " + weight);
		displayCalories.setText("cal: " + calories);
		displayDescription.setText(description);
		displayPrice.setText("price: " + price + "php");
		displayStock.setText("Stock left: " + stock);

	}

	//Display special item info
	/**
	 * Sets the display for a special item with the provided information.
	 *
	 * @param itemName The name of the special item to be displayed.
	 * @param ingredients The list of ingredients for the special item to be displayed.
	 * @param price The price of the special item to be displayed.
	 * @param calories The calories of the special item to be displayed.
	 */
	public void setSpecialItemInfo(String itemName, ArrayList<String> ingredients, double price, double calories)
{
    specialItemName.setText("Item: " + itemName);

    // Create a formatted HTML string for ingredients
    StringBuilder ingredientsHTML = new StringBuilder("<html><b>Ingredients:</b><br>");
    for (String ingredient : ingredients) {
        ingredientsHTML.append(ingredient).append("<br>");
    }
    ingredientsHTML.append("</html>");
    IngredientsTXT.setText(ingredientsHTML.toString());

    priceSpecialTXT.setText("Price: " + price + "php");
    calSpecialTXT.setText("Calories: " + calories);
}

public void resetSpecialItemInfo()
{
	specialItemName.setText("Item: ");
	IngredientsTXT.setText("<html><b>Ingredients:</b><br></html>");
	priceSpecialTXT.setText("Price: ");
	calSpecialTXT.setText("Calories: ");
}

	/**
	 * Gets the display action label.
	 *
	 * @return The display action label.
	 */
	public JLabel getDisplayAction()
	{
		return displayAction;
	}
	/**
	 * Gets the display slot choice label.
	 *
	 * @return The display slot choice label.
	 */
	public JLabel getDisplaySlotChoice()
	{
		return displaySlotChoice;
	}

	//ACTION LISTENERS FOR BUTTONS
	 /**
	 * Adds an ActionListener to the number buttons (0-9).
	 *
	 * @param actionListener The ActionListener to be added to the number buttons.
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
		 * Adds an ActionListener to the "clr" button.
		 *
		 * @param actionListener The ActionListener to be added to the "clr" button.
		 */
		public void ClearButtonListener(ActionListener actionListener){
			this.clearBTN.addActionListener(actionListener);
		}
	
		/**
		 * Adds an ActionListener to the "enter" button.
		 *
		 * @param actionListener The ActionListener to be added to the "enter" button.
		 */		
		public void EnterButtonListener(ActionListener actionListener){
			this.enterBTN.addActionListener(actionListener);
		}

		/**
		 * Gets the BuyerWalletFrame object associated with this vmFeaturesFrame.
		 *
		 * @return The BuyerWalletFrame object.
		 */
		public BuyerWalletFrame getBuyerWalletFrame() {
			
			return this.walletFrame;
			
		}

		/**
		 * Gets the price value from the displayPrice label.
		 *
		 * @return The price value as a double.
		 */
		public double getPrice() {
			
			return Double.parseDouble(displayPrice.getText());
		}

		/**
		 * Sets the quantity text for the given slot choice.
		 *
		 * @param slotChoice The slot number
		 */
		public void setQtyText(int slotChoice, int qty) {
			
			qtyTXTList.get(slotChoice-1).setText(qty + "x");
		}

		/**
		 * Resets the display on the screen by clearing the displayed item information.
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
	 * Creates slots based on the specified number of slots and populates them with the provided item information.
	 * 
	 * @param numSlots The total number of slots to create.
	 * @param itemName A list of item names to be displayed on the slots.
	 * @param qty A list of quantities to be displayed on the slots.
	 * @param price A list of prices to be displayed on the slots.
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

			}
			
			lowerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
				slot.add(lowerPanel, BorderLayout.SOUTH);
			JLabel slotNumTXT = new JLabel("#" + (i + 1));
				slotNumTXT.setFont(new Font("Rockwell", Font.BOLD, 12));
				lowerPanel.add(slotNumTXT);
		}
	
		slotsPanel.revalidate();
		slotsPanel.repaint();
	}
	

	/**
	 * Sets the number of slots and populates them with the provided item information.
	 * @param numSlots
	 * @param itemName
	 * @param qty
	 * @param price
	 */
	public void setNumSlots(int numSlots, ArrayList<String> itemName, ArrayList<Integer> qty, ArrayList<Double> price) {
		createSlots(numSlots, itemName, qty, price);
	}
	
	/**
	 * Sets the vending machine name based on current user
	 * @param vmName
	 */
	public void setVmName(String vmName)
	{
		vmNameLBL.setText(vmName);
	}

	/**
	 *  main entry point for the frame view
	 */
	public vmFeaturesFrame( ) {
		
		components();
		
	}

	
	/**
	 * Create the frame.
	 */
	private void components() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		vmControls.setBounds(639, 231, 267, 223);
		panel.add(vmControls);
		vmControls.setLayout(null);
		
		JPanel slotNumPanel = new JPanel();
		slotNumPanel.setBounds(45, 10, 191, 199);
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
		
		slotsPanel = new JPanel();
		slotsPanel.setBounds(10, 63, 405, 475);
		vendingMachine.add(slotsPanel);
		
		vmNameLBL = new JLabel("V.M. Name");
		vmNameLBL.setFont(new Font("Rockwell", Font.BOLD, 30));
		vmNameLBL.setHorizontalAlignment(SwingConstants.CENTER);
		vmNameLBL.setBounds(10, 10, 405, 43);
		vendingMachine.add(vmNameLBL);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(150, 5, 1, 1);
		vendingMachine.add(layeredPane);
		
		dispenseBTN = new JButton("DISPENSE ITEM");
		dispenseBTN.setBounds(10, 563, 141, 50);
		vendingMachine.add(dispenseBTN);
		dispenseBTN.setFont(new Font("Rockwell", Font.BOLD, 12));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(157, 563, 244, 50);
		vendingMachine.add(panel_1);
		
		JPanel maintainPanel = new JPanel();
		maintainPanel.setBounds(10, 10, 186, 623);
		panel.add(maintainPanel);
		maintainPanel.setLayout(null);
		
		returnBTN = new JButton("TEST FEATURES");
		returnBTN.setBounds(10, 531, 157, 36);
		returnBTN.setFont(new Font("Rockwell", Font.BOLD, 14));
		maintainPanel.add(returnBTN);
		
		mainMenuBTN = new JButton("\nMAIN MENU");
		mainMenuBTN.setBounds(10, 577, 157, 36);
		mainMenuBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		maintainPanel.add(mainMenuBTN);
		
		JLabel lblNewLabel = new JLabel("Vending");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel.setBounds(-9, 20, 166, 27);
		maintainPanel.add(lblNewLabel);
		
		JLabel lblReturn = new JLabel("Return");
		lblReturn.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturn.setFont(new Font("Harlow Solid Italic", Font.BOLD, 25));
		lblReturn.setBounds(10, 494, 157, 27);
		maintainPanel.add(lblReturn);
		
		
		JLabel lblMachine = new JLabel("Machine");
		lblMachine.setHorizontalAlignment(SwingConstants.CENTER);
		lblMachine.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblMachine.setBounds(26, 49, 166, 27);
		maintainPanel.add(lblMachine);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(10, 86, 166, 398);
		maintainPanel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel specialLBL = new JLabel("<html><center>For Special<br> Vending Machines</center></html>");
		specialLBL.setHorizontalAlignment(SwingConstants.CENTER);
		specialLBL.setBounds(0, 5, 166, 38);
		specialLBL.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 15));
		panel_5.add(specialLBL);
		
		customItemBTN = new JButton("<html><center>create <br> customized item</center></html>");
		customItemBTN.setFont(new Font("Rockwell", Font.BOLD, 12));
		customItemBTN.setBounds(10, 53, 146, 38);
		panel_5.add(customItemBTN);
		
		addIngredientBTN = new JButton("<html><center>add <br> ingredient</center></html>");
		addIngredientBTN.setFont(new Font("Rockwell", Font.BOLD, 12));
		addIngredientBTN.setBounds(10, 101, 146, 38);
		panel_5.add(addIngredientBTN);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 149, 146, 239);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		specialItemName = new JLabel("Item: ");
		specialItemName.setBounds(10, 5, 126, 15);
		specialItemName.setFont(new Font("Rockwell", Font.BOLD, 12));
		panel_6.add(specialItemName);
		
		IngredientsTXT = new JLabel("Ingredients: ");
		IngredientsTXT.setVerticalAlignment(SwingConstants.TOP);
		IngredientsTXT.setFont(new Font("Rockwell", Font.BOLD, 12));
		IngredientsTXT.setBounds(10, 30, 126, 148);
		panel_6.add(IngredientsTXT);
		
		priceSpecialTXT = new JLabel("Price: ");
		priceSpecialTXT.setFont(new Font("Rockwell", Font.BOLD, 12));
		priceSpecialTXT.setBounds(10, 188, 126, 15);
		panel_6.add(priceSpecialTXT);
		
		calSpecialTXT = new JLabel("Calories: ");
		calSpecialTXT.setFont(new Font("Rockwell", Font.BOLD, 12));
		calSpecialTXT.setBounds(10, 213, 126, 15);
		panel_6.add(calSpecialTXT);
		
		JPanel dislayPanel = new JPanel();
		
		dislayPanel.setBounds(639, 10, 267, 211);
		panel.add(dislayPanel);
		dislayPanel.setLayout(null);
		
		displaySlotChoice = new JLabel();
		displaySlotChoice.setFont(new Font("Rockwell", Font.PLAIN, 15));
		displaySlotChoice.setBounds(143, 10, 114, 43);
		dislayPanel.add(displaySlotChoice);

		
		displaySlotChoice.setForeground(new Color(0, 0, 64));
		
		slotLBL = new JLabel();
		slotLBL.setHorizontalAlignment(SwingConstants.TRAILING);
		slotLBL.setText("Slot #");
		slotLBL.setForeground(new Color(0, 0, 64));
		slotLBL.setFont(new Font("Rockwell", Font.PLAIN, 15));
		slotLBL.setBounds(10, 10, 123, 43);
		dislayPanel.add(slotLBL);
		
		displayItemName = new JLabel();
		displayItemName.setText("Item name");
		displayItemName.setHorizontalAlignment(SwingConstants.LEFT);
		displayItemName.setForeground(new Color(0, 0, 64));
		displayItemName.setFont(new Font("Rockwell", Font.PLAIN, 12));
		displayItemName.setBounds(10, 54, 123, 26);
		dislayPanel.add(displayItemName);
		
		displayWeight = new JLabel();
		displayWeight.setText("weight");
		displayWeight.setHorizontalAlignment(SwingConstants.LEFT);
		displayWeight.setForeground(new Color(0, 0, 64));
		displayWeight.setFont(new Font("Rockwell", Font.PLAIN, 12));
		displayWeight.setBounds(134, 54, 123, 26);
		dislayPanel.add(displayWeight);
		
		displayCalories = new JLabel();
		displayCalories.setText("cal");
		displayCalories.setHorizontalAlignment(SwingConstants.LEFT);
		displayCalories.setForeground(new Color(0, 0, 64));
		displayCalories.setFont(new Font("Rockwell", Font.PLAIN, 12));
		displayCalories.setBounds(10, 90, 57, 26);
		dislayPanel.add(displayCalories);
		
		displayDescription = new JLabel();
		displayDescription.setText("description");
		displayDescription.setHorizontalAlignment(SwingConstants.LEFT);
		displayDescription.setForeground(new Color(0, 0, 64));
		displayDescription.setFont(new Font("Rockwell", Font.PLAIN, 12));
		displayDescription.setBounds(134, 90, 123, 26);
		dislayPanel.add(displayDescription);
		
		displayPrice = new JLabel();
		displayPrice.setText("price");
		displayPrice.setHorizontalAlignment(SwingConstants.LEFT);
		displayPrice.setForeground(new Color(0, 0, 64));
		displayPrice.setFont(new Font("Rockwell", Font.PLAIN, 12));
		displayPrice.setBounds(10, 126, 123, 26);
		dislayPanel.add(displayPrice);
		
		displayStock = new JLabel();
		displayStock.setText("stock left: ");
		displayStock.setHorizontalAlignment(SwingConstants.LEFT);
		displayStock.setForeground(new Color(0, 0, 64));
		displayStock.setFont(new Font("Rockwell", Font.PLAIN, 12));
		displayStock.setBounds(134, 126, 123, 26);
		dislayPanel.add(displayStock);
		
		displayAction = new JLabel("");
		displayAction.setFont(new Font("Rockwell", Font.ITALIC, 15));
		displayAction.setHorizontalAlignment(SwingConstants.CENTER);
		displayAction.setBounds(10, 160, 247, 51);
		dislayPanel.add(displayAction);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(639, 464, 267, 55);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		payBTN = new JButton("Pay");
		payBTN.setBounds(10, 10, 97, 35);
		panel_2.add(payBTN);
		payBTN.setFont(new Font("Rockwell", Font.BOLD, 12));
		
		produceChangeBTN = new JButton("Produce Change");
		produceChangeBTN.setBounds(117, 10, 140, 35);
		panel_2.add(produceChangeBTN);
		produceChangeBTN.setFont(new Font("Rockwell", Font.BOLD, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(639, 529, 267, 47);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		cancelTransactionBTN = new JButton("Cancel transaction");
		cancelTransactionBTN.setBounds(57, 10, 153, 27);
		panel_3.add(cancelTransactionBTN);
		cancelTransactionBTN.setFont(new Font("Rockwell", Font.BOLD, 12));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(639, 586, 267, 47);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		printReceiptBTN = new JButton("Print Recept");
		printReceiptBTN.setBounds(62, 14, 146, 23);
		panel_4.add(printReceiptBTN);
		printReceiptBTN.setFont(new Font("Rockwell", Font.BOLD, 12));


		//panel colors
		panel.setBackground(lightBlue);
		dislayPanel.setBackground(Color.DARK_GRAY);
		//set all text in display panel to white
		displayAction.setForeground(Color.WHITE);
		displaySlotChoice.setForeground(Color.WHITE);
		displayItemName.setForeground(Color.WHITE);
		displayWeight.setForeground(Color.WHITE);
		displayCalories.setForeground(Color.WHITE);
		displayPrice.setForeground(Color.WHITE);
		displayStock.setForeground(Color.WHITE);

		slotNumPanel.setBackground(Color.DARK_GRAY);

		lblNewLabel.setForeground(Color.WHITE);
		lblMachine.setForeground(Color.WHITE);

		slotLBL.setForeground(Color.WHITE);
		displayDescription.setForeground(Color.WHITE);
		
		//set maintain panel color to blue
		maintainPanel.setBackground(blue);

		customItemBTN.setBackground(pink);
		customItemBTN.setForeground(Color.WHITE);
		addIngredientBTN.setBackground(pink);
		addIngredientBTN.setForeground(Color.WHITE);
		specialLBL.setForeground(Color.WHITE);

		panel_2.setBackground(blue);
		payBTN.setBackground(pink);
		payBTN.setForeground(Color.WHITE);
		produceChangeBTN.setBackground(pink);
		produceChangeBTN.setForeground(Color.WHITE);
		panel_3.setBackground(blue);
		cancelTransactionBTN.setBackground(pink);
		cancelTransactionBTN.setForeground(Color.WHITE);
		panel_4.setBackground(blue);
		printReceiptBTN.setBackground(pink);
		printReceiptBTN.setForeground(Color.WHITE);
	
		returnBTN.setBackground(yellow);
		mainMenuBTN.setBackground(yellow);

		//dispense button to darkgrey and font color to white
		dispenseBTN.setBackground(Color.DARK_GRAY);
		dispenseBTN.setForeground(Color.WHITE);
		//set vm controls color to blue
		vmControls.setBackground(blue);

		//set vending machine color to light pink
		vendingMachine.setBackground(lightPink);
		//set all slot panels to light pink
		slotsPanel.setBackground(lightPink);
	}
}
