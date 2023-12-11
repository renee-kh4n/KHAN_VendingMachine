

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

/**
 * The AddItemsFrame class represents a graphical user interface frame for adding items to a vending machine.
 * This frame allows the user to input information about a new product, such as name, calories, weight/volume,
 * description, price, quantity, and unit of measurement. It also provides options to mark the item as for sale,
 * as an ingredient, or a special item for a vending machine.
 */
public class AddItemsFrame extends JFrame {

	// Components
	//colors
	private Color blue = new Color(19, 156, 181);
	private Color WHITE = new Color(255, 255, 255);

	/**
	 * The content pane of the frame.
	 */
	private JPanel contentPane;

	/**
	 * The text field for the name of the product.
	 */
	private JTextField nameTXT;
	/**
	 * The text field for the volume of the product.
	 */
	private JTextField volTXT;
	/**
	 * The text field for the calories of the product.
	 */
	private JTextField calTXT;
	/**
	 * The text field for the description of the product.
	 */
	private JTextField descTXT;
	/**
	 * The text field for the price of the product.
	 */
	private JTextField priceTXT;
	/**
	 * The combo box for the unit of measurement of the product.
	 */
	private JComboBox<String> unitList;
	/**
	 * The combo box for the quantity of the product.
	 */
	private JComboBox<String> qtyList;
	/**
	 * The frame that opened this frame.
	 */
	private JFrame sourceFrame;
	/**
	 * The button for finishing the adding of items.
	 */

	private JButton finishBTN;
	/**
	 * The button for adding the item to the vending machine.
	 */
	private JButton addBTN;
	/**
	 * The check box for marking the item as for sale.
	 */
	private JCheckBox chckForSale;
	/**
	 * The check box for marking the item as an ingredient.
	 */
	private JCheckBox chckIngredient;
	/**
	 * The radio button for marking the item as a special item for a vending machine.
	 */
	private JRadioButton rdbtnSpecial, rdbtnRegular;
	/**
	 * The button group for the radio buttons.
	 */
	private ButtonGroup buttonGroup;
	/**
	 * The label for displaying the action.
	 */
	private JLabel displayAction;

	//BUTTONS
	/**
	 * Sets the action listener for the finish button.
	 * @param actionListener
	 */
	public void setFinishBtnListener(ActionListener actionListener) {
		this.finishBTN.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the add button.
	 * @param actionListener
	 */
	public void setAddBtnListener(ActionListener actionListener) {
		this.addBTN.addActionListener(actionListener);
	}
	


	//GETTERS for the strings
	/**
	 * Gets the name of the product.
	 * @return the name of the product
	 */
	public JTextField getNameTXT() {
		return nameTXT;
	}
	/**
	 * Gets the volume of the product.
	 * @return the volume of the product
	 */
	public JTextField getVolTXT() {
		return volTXT;
	}
	/**
	 * Gets the calories of the product.
	 * @return the calories of the product
	 */
	public JTextField getCalTXT() {
		return calTXT;
	}
	/**
	 * Gets the description of the product.
	 * @return the description of the product
	 */
	public JTextField getDescTXT() {
		return descTXT;
	}
	/**
	 * Gets the price of the product.
	 * @return the price of the product
	 */
	public JTextField getPriceTXT() {
		return priceTXT;
	}
	/**
	 * Gets the unit of measurement of the product.
	 * @return the unit of measurement of the product
	 */
	public JComboBox<String> getUnitList() {
		return unitList;
	}
	/**
	 * Gets the quantity of the product.
	 * @return the quantity of the product
	 */
	public JComboBox<String> getQtyList() {
		return qtyList;
	}
	/**
	 * Gets the frame that opened this frame.
	 * @return the frame that opened this frame
	 */
	public JFrame getSourceFrame() {
		return sourceFrame;
	}
	/**
	 * Gets the button for finishing the adding of items.
	 * @return the button for finishing the adding of items
	 */
	public JCheckBox getChckForSale() {
		return chckForSale;
	}
	/**
	 * Gets the button for adding the item to the vending machine.
	 * @return the button for adding the item to the vending machine
	 */
	public JCheckBox getChckIngredient() {
		return chckIngredient;
	}
	/**
	 * Gets the radio button for marking the item as a special item for a vending machine.
	 * @return the radio button for marking the item as a special item for a vending machine
	 */
	public JRadioButton getRdbtnSpecial() {
		return rdbtnSpecial;
	}
	/**
	 * Gets the radio button for marking the item as a regular item for a vending machine.
	 * @return the radio button for marking the item as a regular item for a vending machine
	 */
	public JRadioButton getRdbtnRegular() {
		return rdbtnRegular;
	}
	/**
	 * Gets the button group for the radio buttons.
	 * @return the button group for the radio buttons
	 */
	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}
	/**
	 * Gets the label for displaying the action.
	 * @return the label for displaying the action
	 */
	public void setDispenseAction(String action){
		this.displayAction.setText(action);
	}


	//CONSTRUCTORS
	/**
	 * Constructs a new AddItemsFrame.
	 */
	public AddItemsFrame() {
		contents();
	}
	/**
	 * Constructs a new AddItemsFrame with the specified source frame.
	 * @param sourceFrame the frame that opened this frame
	 */
	public void setSourceFrame(MaintainanceFeaturesFrame mFrame) {
		
		this.sourceFrame = mFrame;
	}
	
	/**
	 * Constructs a new AddItemsFrame with the specified source frame.
	 * @param sourceFrame the frame that opened this frame
	 */
	public void setSourceFrame(CreateFrame cFrame) {
		
		this.sourceFrame = cFrame;
	}
	

	/**
	 * Create the frame.
	 */
	
	public void contents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(blue);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel addLBL = new JLabel("Add Items");
		addLBL.setBounds(0, 10, 626, 45);
		addLBL.setFont(new Font("Harlow Solid Italic", Font.BOLD, 35));
		addLBL.setForeground(WHITE);
		addLBL.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(addLBL);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 65, 381, 308);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Product name: ");
		lblName.setBounds(0, 1, 197, 51);
		lblName.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel.add(lblName);
		
		JLabel lblCalories = new JLabel("Calories: ");
		lblCalories.setBounds(0, 52, 84, 51);
		lblCalories.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel.add(lblCalories);
		
		JLabel lblWeightvolume = new JLabel("Weight:");
		lblWeightvolume.setBounds(164, 52, 107, 51);
		lblWeightvolume.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel.add(lblWeightvolume);
		
		JLabel lblDescription = new JLabel("Description: (optional)");
		lblDescription.setBounds(0, 94, 197, 51);
		lblDescription.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel.add(lblDescription);
		
		JLabel lblPrice = new JLabel("Price per unit: ");
		lblPrice.setBounds(0, 205, 197, 51);
		lblPrice.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity: ");
		lblQuantity.setBounds(207, 205, 92, 51);
		lblQuantity.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel.add(lblQuantity);
		
		nameTXT = new JTextField();
		nameTXT.setFont(new Font("Rockwell", Font.PLAIN, 12));
		nameTXT.setBounds(117, 9, 254, 33);
		panel.add(nameTXT);
		nameTXT.setColumns(10);
		
		calTXT = new JTextField();
		calTXT.setFont(new Font("Rockwell", Font.PLAIN, 12));
		calTXT.setBounds(76, 62, 78, 33);
		panel.add(calTXT);
		calTXT.setColumns(10);
		
		volTXT = new JTextField();
		volTXT.setFont(new Font("Rockwell", Font.PLAIN, 12));
		volTXT.setBounds(237, 62, 62, 33);
		panel.add(volTXT);
		volTXT.setColumns(10);
		
		descTXT = new JTextField();
		descTXT.setFont(new Font("Rockwell", Font.PLAIN, 12));
		descTXT.setBounds(0, 137, 371, 63);
		panel.add(descTXT);
		descTXT.setColumns(10);
		
		priceTXT = new JTextField();
		priceTXT.setFont(new Font("Rockwell", Font.PLAIN, 12));
		priceTXT.setBounds(117, 216, 84, 33);
		panel.add(priceTXT);
		priceTXT.setColumns(10);
		
		qtyList = new JComboBox<String>();
		qtyList.setFont(new Font("Rockwell", Font.BOLD, 15));
		qtyList.setBounds(289, 215, 82, 34);
		panel.add(qtyList);
		for (int i = 1; i<=10; i++)
			qtyList.addItem(Integer.toString(i));
		
		JLabel lblnoCentsPlease = new JLabel("*no cents please");
		lblnoCentsPlease.setHorizontalAlignment(SwingConstants.CENTER);
		lblnoCentsPlease.setForeground(new Color(255, 0, 0));
		lblnoCentsPlease.setFont(new Font("Rockwell", Font.PLAIN, 12));
		lblnoCentsPlease.setBounds(0, 249, 197, 21);
		panel.add(lblnoCentsPlease);
		
		unitList = new JComboBox<String>();
		unitList.setFont(new Font("Rockwell", Font.BOLD, 15));
		unitList.setBounds(309, 63, 62, 33);
		panel.add(unitList);
		unitList.addItem("g");
		unitList.addItem("mL");
		
		
			
		finishBTN = new JButton("finish");
		finishBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		finishBTN.setBounds(532, 397, 94, 39);
		contentPane.add(finishBTN);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(401, 65, 225, 308);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(10, 10, 205, 218);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 128));
		panel_3.setBounds(10, 49, 185, 159);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		rdbtnRegular = new JRadioButton("regular item");
		rdbtnRegular.setBackground(new Color(128, 128, 128));
		rdbtnRegular.setForeground(new Color(255, 255, 255));
		rdbtnRegular.setBounds(0, 1, 185, 48);
		rdbtnRegular.setFont(new Font("Rockwell", Font.PLAIN, 15));
		panel_3.add(rdbtnRegular);
		
		rdbtnRegular.setSelected(true);
		
		rdbtnSpecial = new JRadioButton("special item");
		rdbtnSpecial.setBackground(new Color(128, 128, 128));
		rdbtnSpecial.setForeground(new Color(255, 255, 255));
		rdbtnSpecial.setBounds(0, 108, 185, 55);
		panel_3.add(rdbtnSpecial);
		rdbtnSpecial.setFont(new Font("Rockwell", Font.PLAIN, 15));
		
		buttonGroup = new ButtonGroup();
	    buttonGroup.add(rdbtnSpecial);
	    buttonGroup.add(rdbtnRegular);
		
		chckForSale = new JCheckBox("for sale");
		chckForSale.setForeground(Color.WHITE);
		chckForSale.setFont(new Font("Rockwell", Font.PLAIN, 12));
		chckForSale.setBackground(Color.GRAY);
		chckForSale.setBounds(46, 38, 92, 48);
		panel_3.add(chckForSale);
		
		chckForSale.setSelected(true);
		
		chckIngredient = new JCheckBox("ingredient");
		chckIngredient.setForeground(Color.WHITE);
		chckIngredient.setFont(new Font("Rockwell", Font.PLAIN, 12));
		chckIngredient.setBackground(Color.GRAY);
		chckIngredient.setBounds(46, 77, 92, 48);
		panel_3.add(chckIngredient);
		
		JLabel lblSpecial = new JLabel("<html><center>For Special<br>Vending Machine</center></html>");
		lblSpecial.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpecial.setForeground(Color.WHITE);
		lblSpecial.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblSpecial.setBounds(0, 0, 205, 55);
		panel_2.add(lblSpecial);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(128, 128, 128));
		panel_5.setBounds(10, 237, 205, 61);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		displayAction = new JLabel("<Action>");
		displayAction.setBounds(10, 10, 185, 38);
		displayAction.setHorizontalAlignment(SwingConstants.CENTER);
		displayAction.setForeground(Color.WHITE);
		displayAction.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 15));
		panel_5.add(displayAction);
		
		addBTN = new JButton("add");
		addBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		addBTN.setBounds(428, 397, 94, 39);
		contentPane.add(addBTN);

		
	}
}
