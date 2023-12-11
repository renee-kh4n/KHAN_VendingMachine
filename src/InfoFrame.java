

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.SwingConstants;
import java.awt.Font;

public class InfoFrame extends JFrame {

	/**
	 * Private JPanel and JLabel attributes for InfoFrame.
	 * The InfoFrame class is a JFrame that displays information messages to the user.
	 * It contains a JPanel for layout and a JLabel to display the information message.
	 * The 'message' JLabel is used to display various information messages to the user,
	 * and the 'info' JLabel is currently not used in the class.
	 */

	private JPanel contentPane, panel;
	JLabel message, info = new JLabel();

	/**
	 * Private method to remove any additional info from the contentPane.
	 * This method checks if the 'info' JLabel is not empty and removes the 'panel' from the 'contentPane'
	 * and adjusts the position and alignment of the 'message' JLabel.
	 */
	private void removeAdditionalInfo()
	{

		if(!info.getText().isEmpty())
		{
			contentPane.remove(panel);
			message.setBounds(5, 5, 276, 158);
			message.setVerticalAlignment(SwingConstants.CENTER);
		}
			
	}
	
	//CREATE FRAME
	/**
	 * Public method to display confirmation message for creating a vending machine.
	 * This method displays the type and number of slots for the newly created vending machine.
	 * It also calls the 'removeAdditionalInfo()' method to remove any additional info from the 'contentPane'.
	 */
	public void confirmCreate(String type, int slotsNum)
	{
		removeAdditionalInfo();
		
		JLabel info = new JLabel("Type: " + type );
		info.setFont(new Font("Rockwell", Font.BOLD, 12));
		info.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel info2 = new JLabel("Slots:" + slotsNum);
		info2.setFont(new Font("Rockwell", Font.BOLD, 12));
		info2.setVerticalAlignment(SwingConstants.CENTER);
		
		panel = new JPanel();
		panel.setBounds(10, 29, 271, 129);
		JPanel spacer = new JPanel();
		contentPane.add(panel);
		
		panel.add(info);
		panel.add(spacer);
		panel.add(info2);
		
		
		
		message.setText("<html><bold>Vending Machine Created!</bold></html>");

		
	}
	
	/**
	 * Public method to display cancellation message for creating a vending machine.
	 * This method calls the 'removeAdditionalInfo()' method to remove any additional info from the 'contentPane'.
	 */
	public void cancelCreate()
	{
		removeAdditionalInfo();

		message.setText("<html><center><bold>C A N C E L L E D</bold><br>creation of vending machine</center></html>");
	}

	/**
	 * Public method to display a message that the minimum number of slots is 8.
	 * This method calls the 'removeAdditionalInfo()' method to remove any additional info from the 'contentPane'.
	 */
	public void minSlot()
	{
		removeAdditionalInfo();

		message.setText("<html><center><bold>MINIMUM # OF SLOTS: 8</bold><br>you cannot have less than 8 slots</center></html>");
	}
	/**
	 * Public method to display a message that the maximum number of slots is 40.
	 * This method calls the 'removeAdditionalInfo()' method to remove any additional info from the 'contentPane'.
	 */
	public void maxSlot()
	{
		removeAdditionalInfo();

		message.setText("<html><center><bold>MAXIMUM # OF SLOTS: 40</bold><br>you cannot have more than 40 slots</center></html>");
	}
	/**
	 * Public method to display a message for null or empty type and name input when creating a vending machine.
	 * This method checks if either the 'type' or 'name' is null or empty and displays the appropriate message to the user.
	 * It calls the 'removeAdditionalInfo()' method to remove any additional info from the 'contentPane'.
	 */
	public void nullTypeName(String type, String name) 
	{

		removeAdditionalInfo();

		
		
	    if (type == null && name.isEmpty()) {
	        message.setText("<html><center><bold>Please input all<br>necessary information</bold></center></html>");
	    } else {
	        if (type == null) {
	            message.setText("<html><center><bold>Please choose a type!</bold></center></html>");
	        }
	        if (name.isEmpty()) {
	            message.setText("<html><center><bold>Please enter a name!</bold></center></html>");
	        }
	    }
	}
	
	/**
	 * Public method to display information about the different types of vending machines.
	 * This method displays information about regular and special vending machines using JLabels in a GridLayout.
	 * It calls the 'removeAdditionalInfo()' method to remove any additional info from the 'contentPane'.
	 */
	public void vmTypeInfo() {

		JLabel info = new JLabel("<html>REGULAR:<br>Items are sold and dispensed individually.</html>");
		info.setFont(new Font("Rockwell", Font.BOLD, 12));
		info.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel info2 = new JLabel("<html>SPECIAL:<br>Items are either sold individually or <br>used as ingredients to make a new product.</html>");
		info2.setFont(new Font("Rockwell", Font.BOLD, 12));
		info2.setVerticalAlignment(SwingConstants.CENTER);
		
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		message.setVerticalAlignment(SwingConstants.TOP);
		message.setText("(i) vending machine types");
		panel.add(info);
		panel.add(info2);
		
	}

	/**
	 * Public method to display a message that the slots are full and no more items can be added.
	 * This method calls the 'removeAdditionalInfo()' method to remove any additional info from the 'contentPane'.
	 */
	public void slotsAreFull() {
		removeAdditionalInfo();

		message.setText("<html><center><bold>Slots are full!</bold><br>Cannot add more items.</center></html>");
	}

	/**
	 * Public method to display a message that a vending machine with the given ID exists.
	 * This method calls the 'removeAdditionalInfo()' method to remove any additional info from the 'contentPane'.
	 */
	public void idExists() {
		removeAdditionalInfo();

		message.setText("<html><center><bold>ID Found!</bold><br>You may now test your machine.</center></html>");
	}

	/**
	 * Public method to display a message that a vending machine with the given ID does not exist.
	 * This method calls the 'removeAdditionalInfo()' method to remove any additional info from the 'contentPane'.
	 */
	public void idNotExist() {
		removeAdditionalInfo();

		message.setText("<html><center><bold>ID NOT Found!</bold></center></html>");
	}

	
	//PRINT SUMMARY
	/**
	 * Public method to create a Transaction Summary JFrame.
	 * This method creates a Transaction Summary JFrame that displays the initial and recent inventory of items
	 * and the total income. It takes the initialInventory, recentInventory, and income as parameters.
	 * The Transaction Summary JFrame has a GridLayout and JLabels for displaying inventory information and total income.
	 */
	   public void TransactionSummary(HashMap<String, Integer> initialInventory, HashMap<String, Integer> recentInventory, double income) {
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 98, 466, 455);
        contentPane.add(panel);
        panel.setLayout(new GridLayout(0, 3, 0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("Initial:");
        lblNewLabel.setBounds(43, 5, 68, 24);
        lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        panel_1.add(lblNewLabel);

        int initialRow = 30; // Initial vertical position for initialInventory items

        for (String item : initialInventory.keySet()) {
            JLabel itemLabel = new JLabel(item + ": " + initialInventory.get(item));
            itemLabel.setFont(new Font("Rockwell", Font.PLAIN, 10));
            itemLabel.setBounds(10, initialRow, 135, 24);
            panel_1.add(itemLabel);
            initialRow += 30;
        }

        JPanel panel_2 = new JPanel();
        panel.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblRecent = new JLabel("Recent:");
        lblRecent.setBounds(40, 5, 75, 24);
        lblRecent.setFont(new Font("Rockwell", Font.BOLD, 20));
        panel_2.add(lblRecent);

        int recentRow = 30; // Initial vertical position for recentInventory items

        for (String item : recentInventory.keySet()) {
            JLabel itemLabel = new JLabel(item + ": " + recentInventory.get(item));
            itemLabel.setFont(new Font("Rockwell", Font.PLAIN, 10));
            itemLabel.setBounds(10, recentRow, 135, 24);
            panel_2.add(itemLabel);
            recentRow += 30;
        }

        JPanel panel_3 = new JPanel();
        panel.add(panel_3);
        panel_3.setLayout(null);

        JLabel lblItemsSold = new JLabel("Items Sold:");
        lblItemsSold.setBounds(22, 5, 110, 24);
        lblItemsSold.setFont(new Font("Rockwell", Font.BOLD, 20));
        panel_3.add(lblItemsSold);

        int itemsSoldRow = 30; // Initial vertical position for items sold

        for (String item : recentInventory.keySet()) {
            int initialQty = initialInventory.getOrDefault(item, 0);
            int recentQty = recentInventory.getOrDefault(item, 0);
            int itemsSold = initialQty - recentQty;
            JLabel itemLabel = new JLabel(item + ": " + itemsSold);
            itemLabel.setFont(new Font("Rockwell", Font.PLAIN, 10));
            itemLabel.setBounds(10, itemsSoldRow, 135, 24);
            panel_3.add(itemLabel);
            itemsSoldRow += 30;
        }

        JLabel lblInventory = new JLabel("Inventory");
        lblInventory.setHorizontalAlignment(SwingConstants.CENTER);
        lblInventory.setFont(new Font("Harlow Solid Italic", Font.BOLD, 35));
        lblInventory.setBounds(10, 10, 466, 63);
        contentPane.add(lblInventory);
        
        JLabel lblTotalIncome = new JLabel("Total Income: " + income);
        lblTotalIncome.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 15));
        lblTotalIncome.setBounds(10, 70, 466, 24);
        contentPane.add(lblTotalIncome);
        
	}
	
	/**
	 * Create the frame.
	 */
	public InfoFrame() {
		components();
		
	}
	
	/**
	 * Initializes and sets up the components of the InfoFrame class.
	 * Configures the frame's default close operation, size, and position.
	 * Creates the 'contentPane' JPanel with a border and a null layout.
	 * Adds the 'message' JLabel for displaying information messages.
	 * Creates the 'panel' JPanel, which is not initialized further in this method.
	 * This method is called in the constructor of InfoFrame.
	 */
	private void components() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		message = new JLabel("");
		message.setBounds(5, 5, 276, 158);
		message.setFont(new Font("Rockwell", Font.BOLD, 15));
		message.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(message);
		
		panel = new JPanel();
		panel.setBounds(10, 29, 271, 129);
		contentPane.add(panel);
		
		
		
		
	}
}
