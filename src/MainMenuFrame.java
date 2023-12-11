import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

/**
 * The MainMenuFrame class represents the main menu frame of the vending machine application.
 * It extends the JFrame class.
 * It contains buttons for creating a vending machine, testing features, and exiting the application.
 * The class provides methods to set action listeners for the create, test, and exit buttons.
 * The 'createFrame' and 'testFrame' instances are used to create and test vending machines respectively.
 * The class initializes and sets up the components of the main menu frame, including labels and buttons.
 * The constructor calls the 'components' method to set up the frame's layout and components.
 * This class is responsible for displaying the main menu of the application.
 */
public class MainMenuFrame extends JFrame {

	//colors
	private Color blue = new Color(19, 156, 181);
	private Color pink = new Color(230, 110, 109);
	private Color yellow = new Color(243, 178, 26);

	private JPanel contentPane;
	CreateFrame createFrame = new CreateFrame(this);
	TestFeaturesFrame testFrame = new TestFeaturesFrame(this);
	private JButton exitBTN;
	private JButton testBTN;
	private JButton createBTN;;

	/**
	 * Returns the instance of CreateFrame.
	 *
	 * @return The CreateFrame instance.
	 */
	public CreateFrame getCreateFrame() {
		return createFrame;
	}

	/**
	 * Returns the instance of TestFeaturesFrame.
	 *
	 * @return The TestFeaturesFrame instance.
	 */
	public TestFeaturesFrame getTestFrame() {
		return testFrame;
	}

	/**
	 * Sets the action listener for the 'Create Vending Machine' button.
	 *
	 * @param actionListener The ActionListener to be set for the button.
	 */
	public void setCreateFrameBtnListener(ActionListener actionListener)
	{
		this.createBTN.addActionListener(actionListener);
		
	}
	
	/**
	 * Sets the action listener for the 'Test Features' button.
	 *
	 * @param actionListener The ActionListener to be set for the button.
	 */
	public void setTestFrameBtnListener(ActionListener actionListener)
	{	
		this.testBTN.addActionListener(actionListener);
	}
	

	/**
	 * Sets the action listener for the 'Exit' button.
	 *
	 * @param actionListener The ActionListener to be set for the button.
	 */
	public void setExitBtnListener(ActionListener actionListener)
	{
		this.exitBTN.addActionListener(actionListener); //adding this.dispose will not open the frame // dispose() must be in the controller
	}

	/**
	 * Create the frame.
	 */
	public MainMenuFrame() {
		//this.setVisible(true);
		components();
	}
	
	/**
	 * Initializes and sets up the components of the main menu frame.
	 * Configures the frame's default close operation, size, and position.
	 * Creates the 'contentPane' JPanel with a border and a null layout.
	 * Creates labels and buttons for the main menu options (create, test, exit).
	 */
	private void components()
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel panel = new JPanel();
		panel.setBackground(blue); 
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel welcomeLBL = new JLabel("Renee's Vending Machine Factory");
		welcomeLBL.setForeground(new Color(255, 255, 255));
		welcomeLBL.setBounds(0, 1, 636, 115);
		welcomeLBL.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 40));
		welcomeLBL.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(welcomeLBL);
		
		JPanel createPNL = new JPanel();
		createPNL.setBackground(yellow);
		createPNL.setBounds(164, 126, 318, 97);
		panel.add(createPNL);
		createPNL.setLayout(null);
		
		
		createBTN = new JButton("Create Vending Machine");
		createBTN.setForeground(new Color(255, 255, 255));
		createBTN.setBackground(pink);
		createBTN.setBounds(10, 10, 298, 77);
		createPNL.add(createBTN);
		createBTN.setBorderPainted(false);
		createBTN.setFont(new Font("Rockwell", Font.BOLD, 20));
		
		JPanel testPNL = new JPanel();
		testPNL.setBounds(164, 257, 318, 97);
		testPNL.setBackground(yellow);
		panel.add(testPNL);
		testPNL.setLayout(null);
		
			
		testBTN = new JButton("Test Features");
		testBTN.setForeground(new Color(255, 255, 255));
		testBTN.setBounds(10, 10, 298, 77);
		testBTN.setBackground(pink);
		testPNL.add(testBTN);
		testBTN.setBorderPainted(false);
		testBTN.setFont(new Font("Rockwell", Font.BOLD, 20));
			
		JPanel exitPNL = new JPanel();
		exitPNL.setBounds(164, 385, 318, 53);
		panel.add(exitPNL);
		exitPNL.setLayout(null);
			
			
		exitBTN = new JButton("Exit");
		exitBTN.setForeground(new Color(255, 255, 255));
		exitBTN.setBounds(10, 10, 298, 33);
		exitPNL.add(exitBTN);
		exitBTN.setBackground(pink);
		exitPNL.setBackground(yellow);
		exitBTN.setBorderPainted(false);
		exitBTN.setFont(new Font("Rockwell", Font.BOLD, 20));
	}
}

	

