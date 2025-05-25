import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

/**
 * The CashBoxFrame class represents a graphical user interface frame that displays the contents of a cash box.
 * It provides options to view the cash denominations and their quantities, and to add cash from the box.
 */
public class CashBoxFrame extends JFrame {

	//private JPanel contentPane;
	/**
	 * The text field for the quantity of 1000 bills.
	 */
	private JTextField txt1000;
	/**
	 * The text field for the quantity of 500 bills.
	 */
	private JTextField txt500;
	/**
	 * The text field for the quantity of 200 bills.
	 */
	private JTextField txt200;
	/**
	 * The text field for the quantity of 100 bills.
	 */
	private JTextField txt100;
	/**
	 * The text field for the quantity of 50 bills.
	 */
	private JTextField txt50;
	/**
	 * The text field for the quantity of 20 bills.
	 */
	private JTextField txt20;
	/**
	 * The text field for the quantity of 10 bills.
	 */
	private JTextField txt1;
	/**
	 * The text field for the quantity of 5 bills.
	 */
	private JTextField txt10;
	/**
	 * The text field for the quantity of 1 bills.
	 */
	private JTextField txt5;

	/**
	 * The button to add cash to the cash box.
	 */
	private JButton addBTN;
	/**
	 * The button to return to the main menu.
	 */
	private JButton returnBTN;

	//LABELS
	/**
	 * The label for the 1000, 500, 200, 100, 50, 20, 10, 5, and 1 bills.
	 */
	private JLabel lbl1000, lbl500, lbl200, lbl100, lbl50, lbl20, lbl10, lbl5, lbl1;

	/**
	 * The label for the total amount of 1000, 500, 200, 100, 50, 20, 10, 5, and 1 bills.
	 */
	private JLabel total1000, total500, total200, total100, total50, total20, total10, total5, total1, showTotalLBL_1;
	
	

	//BUTTONS
	/**
	 * Sets the action listener for the add button.
	 * @param actionListener
	*/
	public void setAddCashBoxActionListener(ActionListener actionListener) {
		
		this.addBTN.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the return button.
	 * @param actionListener
	*/
	public void setReturnActionListener(ActionListener actionListener) {
		
		this.returnBTN.addActionListener(actionListener);
	}

	//GETTERS FOR TEXT FIELDS
	/**
	 * Gets the text field for the quantity of 1000 bills.
	 * @return txt1000
	*/
	public JTextField getTxt1000() {
		return txt1000;
	}
	/**
	 * Gets the text field for the quantity of 500 bills.
	 * @return txt500
	*/
	public JTextField getTxt500() {
		return txt500;
	}
	/**
	 * Gets the text field for the quantity of 200 bills.
	 * @return txt200
	*/
	public JTextField getTxt200() {
		return txt200;
	}
	/**
	 * Gets the text field for the quantity of 100 bills.
	 * @return txt100
	*/
	public JTextField getTxt100() {
		return txt100;
	}
	/**
	 * Gets the text field for the quantity of 50 bills.
	 * @return txt50
	*/
	public JTextField getTxt50() {
		return txt50;
	}
	/**
	 * Gets the text field for the quantity of 20 bills.
	 * @return txt20
	*/
	public JTextField getTxt20() {
		return txt20;
	}
	/**
	 * Gets the text field for the quantity of 10 bills.
	 * @return txt10
	*/
	public JTextField getTxt10() {
		return txt10;
	}
	/**
	 * Gets the text field for the quantity of 5 bills.
	 * @return txt5
	*/
	public JTextField getTxt5() {
		return txt5;
	}
	/**
	 * Gets the text field for the quantity of 1 bills.
	 * @return txt1
	*/
	public JTextField getTxt1() {
		return txt1;
	}

	//getters for display
	/**
	 * Gets the label for the 1000 bills.
	 * @return lbl1000
	*/
	public void displaySummary(Integer[] total)
	{
		total1000.setText("1000: " + total[0]);
		total500.setText("500: " + total[1]);
		total200.setText("200: " + total[2]);
		total100.setText("100: " + total[3]);
		total50.setText("50: " + total[4]);
		total20.setText("20: " + total[5]);
		total10.setText("10: " + total[6]);
		total5.setText("5: " + total[7]);
		total1.setText("1: " + total[8]);
	}

	/**
	 * Gets the label for the total amount of 1000, 500, 200, 100, 50, 20, 10, 5, and 1 bills.
	 * @return showTotalLBL_1
	*/
	public void displayTotal(double total)
	{
		showTotalLBL_1.setText(Double.toString(total));
	}

	/**
	 * Resets text fields to 0.
	 */
	public void resetText()
	{
		txt1000.setText("0");
		txt500.setText("0");
		txt200.setText("0");
		txt100.setText("0");
		txt50.setText("0");
		txt20.setText("0");
		txt10.setText("0");
		txt5.setText("0");
		txt1.setText("0");
	}


	/**
	 * Opens the frame.
	 */
	public CashBoxFrame(){
		components();
	}
	
	
	/**
	 * Create the frame.
	 */
	public void components()
	{
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 650, 500);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 636, 463);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel walletLLBL = new JLabel("Cash Box");
		walletLLBL.setHorizontalAlignment(SwingConstants.CENTER);
		walletLLBL.setBounds(10, 5, 283, 45);
		walletLLBL.setFont(new Font("Harlow Solid Italic", Font.BOLD, 35));
		panel.add(walletLLBL);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 60, 616, 393);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel showTotalLBL = new JLabel("TOTAL CHANGE AMOUNT:");
		showTotalLBL.setFont(new Font("Rockwell", Font.BOLD, 15));
		showTotalLBL.setBounds(10, 369, 218, 13);
		panel_1.add(showTotalLBL);
		
		JPanel billsPanel = new JPanel();
		billsPanel.setBounds(0, 0, 220, 359);
		panel_1.add(billsPanel);
		billsPanel.setLayout(null);
		
		
		ArrayList<ImageIcon> resized = new ArrayList<ImageIcon>();
		ImageIcon originalIcon = null;
		Image resizedImage;
		int side = 85;
		
		for (int i=0; i<9; i++)
		{
			// Load the image as a resource using the ClassLoader
			switch(i)
			{
				case 0:
					originalIcon = new ImageIcon(this.getClass().getResource("/main/resources/1000php.jpg"));
					break;
				case 1:
					originalIcon = new ImageIcon(this.getClass().getResource("/main/resources/500php.jpg"));
					break;
				case 2:
					originalIcon = new ImageIcon(this.getClass().getResource("/main/resources/200php.png"));
					break;
				case 3:
					originalIcon = new ImageIcon(this.getClass().getResource("/main/resources/100php.jpg"));
					break;
				case 4:
					originalIcon = new ImageIcon(this.getClass().getResource("/main/resources/50php.jpg"));
					break;
				case 5:
					originalIcon = new ImageIcon(this.getClass().getResource("/main/resources/20php.jpg"));
					break;
				case 6:
					originalIcon = new ImageIcon(this.getClass().getResource("/main/resources/10php.jpg"));
					break;
				case 7:
					originalIcon = new ImageIcon(this.getClass().getResource("/main/resources/5php.jpg"));
					break;
				case 8:
					originalIcon = new ImageIcon(this.getClass().getResource("/main/resources/1php.jpg"));
					break;
			}
				
	        // Get the original image from the icon
	        Image originalImage = originalIcon.getImage();

	        // Resize the image to fit within the button
	        if(i>=0 && i<5)
	        	resizedImage = originalImage.getScaledInstance(215, 70, Image.SCALE_SMOOTH);
	        else
	        {
	        	resizedImage = originalImage.getScaledInstance(side, side, Image.SCALE_SMOOTH);
	        	side -= 5;
	        }
	        	

	        // Create a new ImageIcon from the resized image
	        ImageIcon resizedIcon = new ImageIcon(resizedImage);
	        
	        resized.add(resizedIcon);
		}
		
        

        // Create the button with the resized icon
		lbl1000 = new JLabel(resized.get(0));
		lbl1000.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl1000.setHorizontalAlignment(SwingConstants.LEADING);
		lbl1000.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lbl1000.setText("1000");
        lbl1000.setBackground(new Color(3, 102, 174));
    	lbl1000.setBounds(10, 0, 205, 61);
		
		
		lbl500 = new JLabel(resized.get(1));
		lbl500.setBackground(new Color(233, 163, 14));
		lbl500.setBounds(10, 73, 205, 61);
		
		
		lbl200 = new JLabel(resized.get(2));
		lbl200.setBackground(new Color(97, 174, 98));
		lbl200.setBounds(10, 144, 205, 61);
		
		lbl100 = new JLabel(resized.get(3));
		lbl100.setBackground(new Color(89, 80, 152));
		lbl100.setBounds(10, 215, 205, 61);
		
		lbl50 = new JLabel(resized.get(4));
		lbl50.setBackground(new Color(234, 72, 81));
		lbl50.setBounds(10, 288, 205, 61);
		
		
		JPanel coinsPanel = new JPanel();
		coinsPanel.setBounds(292, 0, 109, 359);
		panel_1.add(coinsPanel);
		coinsPanel.setLayout(null);
		
		lbl20 = new JLabel(resized.get(5));
		lbl20.setBounds(10, 0, 94, 89);
		
		
		lbl10 = new JLabel(resized.get(6));
		lbl10.setBounds(10, 92, 94, 89);
		
		
		lbl5 = new JLabel(resized.get(7));
		lbl5.setBounds(10, 180, 94, 89);
		
		
		lbl1 = new JLabel(resized.get(8));
		lbl1.setBounds(10, 270, 94, 89);
		
		
		JPanel counterPanel = new JPanel();
		counterPanel.setBounds(222, 0, 60, 359);
		panel_1.add(counterPanel);
		counterPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		txt1000 = new JTextField();
		txt1000.setHorizontalAlignment(SwingConstants.CENTER);
		txt1000.setText("0");
		txt1000.setFont(new Font("Rockwell", Font.PLAIN, 18));
		counterPanel.add(txt1000);
		txt1000.setColumns(10);
		
		txt500 = new JTextField();
		txt500.setText("0");
		txt500.setHorizontalAlignment(SwingConstants.CENTER);
		txt500.setFont(new Font("Rockwell", Font.PLAIN, 18));
		txt500.setColumns(10);
		counterPanel.add(txt500);
		
		txt200 = new JTextField();
		txt200.setText("0");
		txt200.setHorizontalAlignment(SwingConstants.CENTER);
		txt200.setFont(new Font("Rockwell", Font.PLAIN, 18));
		txt200.setColumns(10);
		counterPanel.add(txt200);
		
		txt100 = new JTextField();
		txt100.setText("0");
		txt100.setHorizontalAlignment(SwingConstants.CENTER);
		txt100.setFont(new Font("Rockwell", Font.PLAIN, 18));
		txt100.setColumns(10);
		counterPanel.add(txt100);
		
		txt50 = new JTextField();
		txt50.setText("0");
		txt50.setHorizontalAlignment(SwingConstants.CENTER);
		txt50.setFont(new Font("Rockwell", Font.PLAIN, 18));
		txt50.setColumns(10);
		counterPanel.add(txt50);
		
		JPanel counterPanel2 = new JPanel();
		counterPanel2.setBounds(403, 0, 60, 359);
		panel_1.add(counterPanel2);
		counterPanel2.setLayout(new GridLayout(0, 1, 0, 0));
		
		txt20 = new JTextField();
		txt20.setText("0");
		txt20.setHorizontalAlignment(SwingConstants.CENTER);
		txt20.setFont(new Font("Rockwell", Font.PLAIN, 18));
		txt20.setColumns(10);
		counterPanel2.add(txt20);
		
		txt10 = new JTextField();
		txt10.setText("0");
		txt10.setHorizontalAlignment(SwingConstants.CENTER);
		txt10.setFont(new Font("Rockwell", Font.PLAIN, 18));
		txt10.setColumns(10);
		counterPanel2.add(txt10);
		
		txt5 = new JTextField();
		txt5.setText("0");
		txt5.setHorizontalAlignment(SwingConstants.CENTER);
		txt5.setFont(new Font("Rockwell", Font.PLAIN, 18));
		txt5.setColumns(10);
		counterPanel2.add(txt5);
		
		txt1 = new JTextField();
		txt1.setText("0");
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setFont(new Font("Rockwell", Font.PLAIN, 18));
		txt1.setColumns(10);
		counterPanel2.add(txt1);
		
		addBTN = new JButton("ADD");
		addBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		addBTN.setBounds(346, 362, 125, 27);
		panel_1.add(addBTN);

		returnBTN = new JButton("Return");
		returnBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		returnBTN.setBounds(481, 362, 125, 27);
		panel_1.add(returnBTN);
		
		showTotalLBL_1 = new JLabel("0");
		showTotalLBL_1.setFont(new Font("Rockwell", Font.BOLD, 15));
		showTotalLBL_1.setBounds(222, 369, 115, 13);
		panel_1.add(showTotalLBL_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(481, 0, 125, 359);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblSummary = new JLabel("summary:");
		lblSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSummary.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel_2.add(lblSummary);
		
		total1000 = new JLabel("1000: ");
		total1000.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel_2.add(total1000);
		
		total500 = new JLabel("500:");
		total500.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel_2.add(total500);
		
		total200 = new JLabel("200: ");
		total200.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel_2.add(total200);
		
		total100 = new JLabel("100:");
		total100.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel_2.add(total100);
		
		total50 = new JLabel("50: ");
		total50.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel_2.add(total50);
		
		total20 = new JLabel("20:");
		total20.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel_2.add(total20);
		
		total10 = new JLabel("10: ");
		total10.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel_2.add(total10);
		
		total5 = new JLabel("5: ");
		total5.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel_2.add(total5);
		
		total1 = new JLabel("1: ");
		total1.setFont(new Font("Rockwell", Font.BOLD, 15));
		panel_2.add(total1);
		
		JLabel instruction = new JLabel("<html><center>Enter the quantity of bill/coin <br>you wish to add for each denomination.</center></html>");
		instruction.setHorizontalAlignment(SwingConstants.CENTER);
		instruction.setFont(new Font("Rockwell", Font.BOLD, 15));
		instruction.setBounds(266, 5, 349, 45);
		panel.add(instruction);
		//contentPane = new JPanel();
		
		
		
		lbl500.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl500.setHorizontalAlignment(SwingConstants.LEADING);
		lbl500.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lbl500.setText("500");

		
		lbl200.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl200.setHorizontalAlignment(SwingConstants.LEADING);
		lbl200.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lbl200.setText("200");

		
		lbl100.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl100.setHorizontalAlignment(SwingConstants.LEADING);
		lbl100.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lbl100.setText("100");

		
		lbl50.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl50.setHorizontalAlignment(SwingConstants.LEADING);
		lbl50.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lbl50.setText("50");


		lbl20.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl20.setHorizontalAlignment(SwingConstants.LEADING);
		lbl20.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lbl20.setText("20");


		lbl10.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl10.setHorizontalAlignment(SwingConstants.LEADING);
		lbl10.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lbl10.setText("10");


		lbl5.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl5.setHorizontalAlignment(SwingConstants.LEADING);
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lbl5.setText("5");


		lbl1.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl1.setHorizontalAlignment(SwingConstants.LEADING);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lbl1.setText("1");
		
		billsPanel.add(lbl1000);
		billsPanel.add(lbl500);
		billsPanel.add(lbl200);
		billsPanel.add(lbl100);
		billsPanel.add(lbl50);
		coinsPanel.add(lbl20);
		coinsPanel.add(lbl10);
		coinsPanel.add(lbl5);
		coinsPanel.add(lbl1);

	}
	
}
