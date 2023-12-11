

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;

/**
 * The BuyerWalletFrame class represents a graphical user interface frame that displays the wallet balance of a buyer.
 * This frame shows the current balance and provides an option to add funds to the wallet.
 */
public class BuyerWalletFrame extends JFrame {

	//private JPanel contentPane;
	/**
	 * The text field that displays the total cash out.
	 */
	private JTextField cashOut;
	/**
	 * The button that adds the total cash out to the wallet balance.
	 */
	private JButton pay;

	//buttons
	/**
	 * The buttons that adds 1000, 500, 200, 100, 50, 20, 10, 5, and 1 to the total cash out.
	 */
	private JButton btn1000, btn500, btn200, btn100, btn50, btn20, btn10, btn5, btn1;

	//labels
	/**
	 * The labels that display the number of 1000, 500, 200, 100, 50, 20, 10, 5, and 1 bills.
	 */
	private JLabel counter1000, counter500, counter200, counter100, counter50, counter20, counter10, counter5, counter1;
   
	/**
	 * Sets the action listener for the pay button.
	 * @param actionListener the action listener for the pay button
	 */
	public void setPayBtnListener(ActionListener actionListener) {
		this.pay.addActionListener(actionListener);
	}
	/**
	 * Sets the action listener for the bills buttons.
	 * @param actionListener the action listener for the bills buttons
	 */
	public void setBillsBtnListener(ActionListener actionListener) {
		
		this.btn1000.addActionListener(actionListener);
		this.btn500.addActionListener(actionListener);
		this.btn200.addActionListener(actionListener);
		this.btn100.addActionListener(actionListener);
		this.btn50.addActionListener(actionListener);
		this.btn20.addActionListener(actionListener);
		this.btn10.addActionListener(actionListener);
		this.btn5.addActionListener(actionListener);
		this.btn1.addActionListener(actionListener);

	}
	/**
	 * Sets the text of the labels that display the number of 1000 bills
	 * @param counter1000
	 */
	public void setCounter1000(String counter1000) {
		this.counter1000.setText(counter1000);
	}
	/**
	 * Sets the text of the labels that display the number of 500 bills
	 * @param counter500
	 */
	public void setCounter500(String counter500) {
		this.counter500.setText(counter500);
	}
	/**
	 * Sets the text of the labels that display the number of 200 bills
	 * @param counter200
	 */
	public void setCounter200(String counter200) {
		this.counter200.setText(counter200);
	}
	/**
	 * Sets the text of the labels that display the number of 100 bills
	 * @param counter100
	 */
	public void setCounter100(String counter100) {
		this.counter100.setText(counter100);
	}
	/**
	 * Sets the text of the labels that display the number of 50 bills
	 * @param counter50
	 */
	public void setCounter50(String counter50) {
		this.counter50.setText(counter50);
	}
	/**
	 * Sets the text of the labels that display the number of 20 bills
	 * @param counter20
	 */
	public void setCounter20(String counter20) {
		this.counter20.setText(counter20);
	}
	/**
	 * Sets the text of the labels that display the number of 10 bills
	 * @param counter10
	 */
	public void setCounter10(String counter10) {
		this.counter10.setText(counter10);
	}
	/**
	 * Sets the text of the labels that display the number of 5 bills
	 * @param counter5
	 */
	public void setCounter5(String counter5) {
		this.counter5.setText(counter5);
	}
	/**
	 * Sets the text of the labels that display the number of 1 bills
	 * @param counter1
	 */
	public void setCounter1(String counter1) {
		this.counter1.setText(counter1);
	}
	/**
	 * Sets the text of the text field that displays the total cash out
	 * @param cashOut
	 */
	public void setCashOut(String cashOut) { //total cash out
		this.cashOut.setText(cashOut);
	}
	/**
	 * Gets the text of the text field that displays the total cash out
	 * @return the text of the text field that displays the total cash out
	 */
	public BuyerWalletFrame() {
		
		components();
	}



	/**
	 * Create the frame.
	 */
	private void components() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 650, 500);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 636, 463);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel walletLLBL = new JLabel("Wallet");
		walletLLBL.setBounds(264, 5, 108, 45);
		walletLLBL.setFont(new Font("Harlow Solid Italic", Font.BOLD, 35));
		panel.add(walletLLBL);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 48, 616, 405);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel payTotalLBL = new JLabel("TOTAL CASH OUT:");
		payTotalLBL.setFont(new Font("Rockwell", Font.BOLD, 15));
		payTotalLBL.setBounds(10, 382, 187, 13);
		panel_1.add(payTotalLBL);
		
		cashOut = new JTextField();
		cashOut.setFont(new Font("Rockwell", Font.PLAIN, 15));
		cashOut.setColumns(10);
		cashOut.setBounds(158, 379, 95, 19);
		panel_1.add(cashOut);
		
		JPanel billsPanel = new JPanel();
		billsPanel.setBounds(0, 0, 253, 359);
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
					originalIcon = new ImageIcon(this.getClass().getResource("/1000php.jpg"));
					break;
				case 1:
					originalIcon = new ImageIcon(this.getClass().getResource("/500php.jpg"));
					break;
				case 2:
					originalIcon = new ImageIcon(this.getClass().getResource("/200php.png"));
					break;
				case 3:
					originalIcon = new ImageIcon(this.getClass().getResource("/100php.jpg"));
					break;
				case 4:
					originalIcon = new ImageIcon(this.getClass().getResource("/50php.jpg"));
					break;
				case 5:
					originalIcon = new ImageIcon(this.getClass().getResource("/20php.jpg"));
					break;
				case 6:
					originalIcon = new ImageIcon(this.getClass().getResource("/10php.jpg"));
					break;
				case 7:
					originalIcon = new ImageIcon(this.getClass().getResource("/5php.jpg"));
					break;
				case 8:
					originalIcon = new ImageIcon(this.getClass().getResource("/1php.jpg"));
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
        btn1000 = new JButton(resized.get(0));
        btn1000.setBackground(new Color(3, 102, 174));
        btn1000.setBorderPainted(false);
    	btn1000.setBounds(21, 2, 205, 61);
		billsPanel.add(btn1000);
		
		btn500 = new JButton(resized.get(1));
		btn500.setBackground(new Color(233, 163, 14));
		btn500.setBounds(21, 73, 205, 61);
		btn500.setBorderPainted(false);
		billsPanel.add(btn500);
		
		btn200 = new JButton(resized.get(2));
		btn200.setBackground(new Color(97, 174, 98));
		btn200.setBounds(21, 144, 205, 61);
		btn200.setBorderPainted(false);
		billsPanel.add(btn200);
		
		btn100 = new JButton(resized.get(3));
		btn100.setBackground(new Color(89, 80, 152));
		btn100.setBounds(21, 215, 205, 61);
		btn100.setBorderPainted(false);
		billsPanel.add(btn100);
		
		btn50 = new JButton(resized.get(4));
		btn50.setBackground(new Color(234, 72, 81));
		btn50.setBounds(21, 286, 205, 61);
		btn50.setBorderPainted(false);
		billsPanel.add(btn50);
		
		JPanel coinsPanel = new JPanel();
		coinsPanel.setBounds(361, 0, 150, 359);
		panel_1.add(coinsPanel);
		coinsPanel.setLayout(null);
		
		btn20 = new JButton(resized.get(5));
		btn20.setBounds(29, 1, 94, 89);
		btn20.setBorderPainted(false);
		coinsPanel.add(btn20);
		
		btn10 = new JButton(resized.get(6));
		btn10.setBounds(29, 90, 94, 89);
		btn10.setBorderPainted(false);
		coinsPanel.add(btn10);
		
		btn5 = new JButton(resized.get(7));
		btn5.setBounds(29, 179, 94, 89);
		btn5.setBorderPainted(false);
		coinsPanel.add(btn5);
		
		btn1 = new JButton(resized.get(8));
		btn1.setBounds(29, 268, 94, 89);
		btn1.setBorderPainted(false);
		coinsPanel.add(btn1);
		
		JPanel counterPanel = new JPanel();
		counterPanel.setBounds(263, 0, 88, 359);
		panel_1.add(counterPanel);
		counterPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		counter1000 = new JLabel("0");
		counter1000.setHorizontalAlignment(SwingConstants.CENTER);
		counter1000.setFont(new Font("Rockwell", Font.BOLD, 25));
		counterPanel.add(counter1000);
		
		counter500 = new JLabel("0");
		counter500.setHorizontalAlignment(SwingConstants.CENTER);
		counter500.setFont(new Font("Rockwell", Font.BOLD, 25));
		counterPanel.add(counter500);
		
		counter200 = new JLabel("0");
		counter200.setHorizontalAlignment(SwingConstants.CENTER);
		counter200.setFont(new Font("Rockwell", Font.BOLD, 25));
		counterPanel.add(counter200);
		
		counter100 = new JLabel("0");
		counter100.setHorizontalAlignment(SwingConstants.CENTER);
		counter100.setFont(new Font("Rockwell", Font.BOLD, 25));
		counterPanel.add(counter100);
		
		counter50 = new JLabel("0");
		counter50.setHorizontalAlignment(SwingConstants.CENTER);
		counter50.setFont(new Font("Rockwell", Font.BOLD, 25));
		counterPanel.add(counter50);
		
		JPanel counterPanel2 = new JPanel();
		counterPanel2.setBounds(520, 0, 95, 359);
		panel_1.add(counterPanel2);
		counterPanel2.setLayout(new GridLayout(0, 1, 0, 0));
		
		counter20 = new JLabel("0");
		counter20.setHorizontalAlignment(SwingConstants.CENTER);
		counter20.setFont(new Font("Rockwell", Font.BOLD, 25));
		counterPanel2.add(counter20);
		
		counter10 = new JLabel("0");
		counter10.setHorizontalAlignment(SwingConstants.CENTER);
		counter10.setFont(new Font("Rockwell", Font.BOLD, 25));
		counterPanel2.add(counter10);
		
		counter5 = new JLabel("0");
		counter5.setHorizontalAlignment(SwingConstants.CENTER);
		counter5.setFont(new Font("Rockwell", Font.BOLD, 25));
		counterPanel2.add(counter5);
		
		counter1 = new JLabel("0");
		counter1.setHorizontalAlignment(SwingConstants.CENTER);
		counter1.setFont(new Font("Rockwell", Font.BOLD, 25));
		counterPanel2.add(counter1);
		
		pay = new JButton("PAY");
		pay.setFont(new Font("Rockwell", Font.BOLD, 15));
		pay.setBounds(436, 369, 180, 32);
		panel_1.add(pay);
		//contentPane = new JPanel();

		btn1000.setVerticalAlignment(SwingConstants.BOTTOM);
		btn1000.setHorizontalAlignment(SwingConstants.LEADING);
		btn1000.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btn1000.setText("1000");
		
		btn500.setVerticalAlignment(SwingConstants.BOTTOM);	
		btn500.setHorizontalAlignment(SwingConstants.LEADING);
		btn500.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btn500.setText("500");

		btn200.setVerticalAlignment(SwingConstants.BOTTOM);
		btn200.setHorizontalAlignment(SwingConstants.LEADING);
		btn200.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btn200.setText("200");

		btn100.setVerticalAlignment(SwingConstants.BOTTOM);
		btn100.setHorizontalAlignment(SwingConstants.LEADING);
		btn100.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btn100.setText("100");

		btn50.setVerticalAlignment(SwingConstants.BOTTOM);
		btn50.setHorizontalAlignment(SwingConstants.LEADING);
		btn50.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btn50.setText("50");

		btn20.setVerticalAlignment(SwingConstants.BOTTOM);
		btn20.setHorizontalAlignment(SwingConstants.LEADING);
		btn20.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btn20.setText("20");

		btn10.setVerticalAlignment(SwingConstants.BOTTOM);
		btn10.setHorizontalAlignment(SwingConstants.LEADING);
		btn10.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btn10.setText("10");

		btn5.setVerticalAlignment(SwingConstants.BOTTOM);
		btn5.setHorizontalAlignment(SwingConstants.LEADING);
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btn5.setText("5");

		btn1.setVerticalAlignment(SwingConstants.BOTTOM);
		btn1.setHorizontalAlignment(SwingConstants.LEADING);
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btn1.setText("1");
		
		billsPanel.add(btn1000);
		billsPanel.add(btn500);
		billsPanel.add(btn200);
		billsPanel.add(btn100);
		billsPanel.add(btn50);
		coinsPanel.add(btn20);
		coinsPanel.add(btn10);
		coinsPanel.add(btn5);
		coinsPanel.add(btn1);
	}
}
