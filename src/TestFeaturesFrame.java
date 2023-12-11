
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;

/**
 * The TestFeaturesFrame class represents a frame for testing the features of the vending machine.
 * It allows the user to test maintenance features and vending machine features by providing the vending machine ID.
 */
public class TestFeaturesFrame extends JFrame {

	//colors
	private Color blue = new Color(19, 156, 181);
	private Color pink = new Color(230, 110, 109);
	private Color yellow = new Color(243, 178, 26);


	/**
	 * The content pane of the frame.
	 */
	private JPanel contentPane;
	/**
	 * The text field for entering the vending machine ID.
	 */
	private JTextField vmID;
	/**
	 * The vending machine ID entered by the user.
	 */
	private String vmIdNum;
	/**
	 * The MainMenuFrame instance associated with this TestFeaturesFrame.
	 */
	private MainMenuFrame mainMenu;
	/**
	 * The MaintainanceFeaturesFrame instance associated with this TestFeaturesFrame.
	 */
	private MaintainanceFeaturesFrame maintainFrame = new MaintainanceFeaturesFrame();
	/**
	 * The vmFeaturesFrame instance associated with this TestFeaturesFrame.
	 */
	private vmFeaturesFrame vmFrame = new vmFeaturesFrame();
	/**
	 * The "Maintenance Features" button.
	 */
	private JButton testMaintainBTN;
	/**
	 * The "Vending Machine Features" button.
	 */
	private JButton testVmBTN;
	/**
	 * The "MAIN MENU" button.
	 */
	private JButton mainMenuBTN;
	/**
	 * The "enter" button.
	 */
	private JButton btnEnter;
	
	//buttons
	/**
	 * Set the ActionListener for the "Maintenance Features" button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setTestMaintainanceBtnListener(ActionListener actionListener) {
		
		this.testMaintainBTN.addActionListener(actionListener);
	}
	
	/**
	 * Set the ActionListener for the "Vending Machine Features" button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setTestVmBtnListener(ActionListener actionListener) {
		
		this.testVmBTN.addActionListener(actionListener);
	}
	/**
	 * Set the ActionListener for the "MAIN MENU" button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setMainMenuActionListener(ActionListener actionListener) {
		
		this.mainMenuBTN.addActionListener(actionListener);
	}
	/**
	 * Set the ActionListener for the "enter" button.
	 *
	 * @param actionListener The ActionListener to be set.
	 */
	public void setEnterActionListener(ActionListener actionListener) {
		
		this.btnEnter.addActionListener(actionListener);
	}
	
	/**
	 * Get the MainMenuFrame instance associated with this TestFeaturesFrame.
	 *
	 * @return The MainMenuFrame instance.
	 */
	public MainMenuFrame getMainMenuFrame() {
		return this.mainMenu;
	}

	/**
	 * Get the MaintainanceFeaturesFrame instance associated with this TestFeaturesFrame.
	 *
	 * @return The MaintainanceFeaturesFrame instance.
	 */
	public MaintainanceFeaturesFrame getMaintainanceFrame() {
		return this.maintainFrame;
	}

	/**
	 * Get the vmFeaturesFrame instance associated with this TestFeaturesFrame.
	 *
	 * @return The vmFeaturesFrame instance.
	 */
	public vmFeaturesFrame getVmFrame() {
		return this.vmFrame;
	}

	/**
	 * Get the Vending Machine ID entered by the user.
	 *
	 * @return The Vending Machine ID.
	 */
	public String getVmIdNum() {
		this.vmIdNum = this.vmID.getText();

		return this.vmIdNum;
	}



	/**
	 * Create the TestFeaturesFrame.
	 *
	 * @param mMenuFrame The MainMenuFrame instance associated with this TestFeaturesFrame.
	 */
	public TestFeaturesFrame(MainMenuFrame mMenuFrame) {
		this.mainMenu = mMenuFrame;
		
		components();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void components() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 616, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel testFeaturesLBL = new JLabel("Test Features");
		testFeaturesLBL.setBounds(0, 1, 616, 75);
		testFeaturesLBL.setFont(new Font("Harlow Solid Italic", Font.BOLD, 40));
		testFeaturesLBL.setHorizontalAlignment(SwingConstants.CENTER);
		testFeaturesLBL.setForeground(Color.WHITE);
		panel.add(testFeaturesLBL);
		
		//provide VM ID
			JLabel inputIdLBL = new JLabel("Vending Machine ID: ");
			inputIdLBL.setFont(new Font("Rockwell", Font.BOLD, 20));
			inputIdLBL.setBounds(87, 94, 325, 24);
			panel.add(inputIdLBL);
			
			vmID = new JTextField();
			vmID.setBounds(313, 95, 131, 24);
			panel.add(vmID);
			vmID.setColumns(10);
				
		//BUTTONS
			testMaintainBTN = new JButton("Maintainance Features");
			testMaintainBTN.setFont(new Font("Rockwell", Font.BOLD, 20));
			testMaintainBTN.setBounds(114, 272, 380, 86);
			panel.add(testMaintainBTN);
			
			testVmBTN = new JButton("Vending Machine Features");
			testVmBTN.setFont(new Font("Rockwell", Font.BOLD, 20));
			testVmBTN.setBounds(114, 156, 380, 86);
			panel.add(testVmBTN);
			
			mainMenuBTN = new JButton("MAIN MENU");
			mainMenuBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
			mainMenuBTN.setBounds(456, 397, 150, 36);
			panel.add(mainMenuBTN);
			
			btnEnter = new JButton("enter");
			btnEnter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnEnter.setFont(new Font("Rockwell", Font.BOLD, 15));
			btnEnter.setBounds(451, 91, 85, 33);
			panel.add(btnEnter);
			

			//set all panel colors to blue
			panel.setBackground(blue);
			contentPane.setBackground(blue);

			//set all buttons to pink and text white
			testMaintainBTN.setBackground(pink);
			testMaintainBTN.setForeground(Color.WHITE);
			testVmBTN.setBackground(pink);
			testVmBTN.setForeground(Color.WHITE);
			mainMenuBTN.setBackground(yellow);

			btnEnter.setBackground(yellow);
		
	}
}
