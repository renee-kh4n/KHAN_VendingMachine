import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.SwingConstants;

public class CreateFrame extends JFrame {

//colors
private Color blue = new Color(19, 156, 181);
private Color pink = new Color(230, 110, 109);
private Color yellow = new Color(243, 178, 26);


/**
 * The contentPane JPanel is the main content pane of the frame.
 */
private JPanel contentPane;

/**
 * The nameTXT JTextField is used to input the name of the vending machine.
 */
private JTextField nameTXT;

/**
 * The vmID JTextField is used to input the ID number of the vending machine.
 */
private JTextField vmID;

/**
 * The sourceFrame MainMenuFrame is the frame that opened this current frame.
 */
private MainMenuFrame sourceFrame;

/**
 * The infoFrame InfoFrame is an instance of the InfoFrame class used for displaying information.
 */
private InfoFrame infoFrame = new InfoFrame();

/**
 * The vmName String stores the name of the vending machine.
 */
private String vmName;

/**
 * The vmIdNum int stores the ID number of the vending machine.
 */
private int vmIdNum;

/**
 * The accessFile FileReaderWriter provides methods for reading and writing files.
 */
private FileReaderWriter accessFile;

/**
 * The type String stores the type of the vending machine.
 */
private String type = null;

/**
 * The slots int represents the number of available slots in the vending machine.
 */
private int slots = 8;

/**
 * The slotNumCounter JLabel displays the current number of slots selected.
 */
private JLabel slotNumCounter;

/**
 * The panel JPanel is used for layout and organization of components.
 */
private JPanel panel;

/**
 * The lblNewLabel JLabel displays a label for some content.
 */
private JLabel lblNewLabel;

/**
 * The panel_1 JPanel is used for layout and organization of components.
 */
private JPanel panel_1;

/**
 * The slotsNumLBL JLabel displays the number of slots available for the vending machine.
 */
private JLabel slotsNumLBL;

/**
 * The addBTN JButton is used to add items to the vending machine.
 */
private JButton addBTN;

/**
 * The minusBTN JButton is used to decrease the number of slots for the vending machine.
 */
private JButton minusBTN;

/**
 * The regularPanel JPanel is used for layout and organization of components for regular items.
 */
private JPanel regularPanel;

/**
 * The regularBTN JButton is used to select regular items for the vending machine.
 */
private JButton regularBTN;

/**
 * The specialPanel JPanel is used for layout and organization of components for special items.
 */
private JPanel specialPanel;

/**
 * The specialBTN JButton is used to select special items for the vending machine.
 */
private JButton specialBTN;

/**
 * The lblType JLabel displays a label for the type of vending machine (regular or special).
 */
private JLabel lblType;

/**
 * The exitOptPanel JPanel is used for layout and organization of exit option buttons.
 */
private JPanel exitOptPanel;

/**
 * The mainMenuBTN JButton is used to return to the main menu.
 */
private JButton mainMenuBTN;

/**
 * The cancelBTN JButton is used to cancel the current action.
 */
private JButton cancelBTN;

/**
 * The createBTN JButton is used to create the vending machine.
 */
private JButton createBTN;

/**
 * The infoBTN JButton is used to display information about the vending machine.
 */
private JButton infoBTN;

/**
 * The addItemsBTN JButton is used to add items to the vending machine.
 */
private JButton addItemsBTN;

/**
 * The lblVendingMachineId JLabel displays a label for the ID of the vending machine.
 */
private JLabel lblVendingMachineId;

	
	
	

	//Buttons

/**
 * Sets an ActionListener for the mainMenuBTN JButton.
 *
 * @param actionListener The ActionListener to be set for the mainMenuBTN JButton.
 */
public void setMainMenuActionListener(ActionListener actionListener) {
    this.mainMenuBTN.addActionListener(actionListener);
}

/**
 * Sets an ActionListener for the createBTN JButton.
 *
 * @param actionListener The ActionListener to be set for the createBTN JButton.
 */
public void setCreateBtnListener(ActionListener actionListener) {
    this.createBTN.addActionListener(actionListener);
}

/**
 * Displays the number of available slots by updating the slotNumCounter JLabel.
 */
public void displaySlots() {
    slotNumCounter.setText(Integer.toString(slots));
}

/**
 * Sets an ActionListener for the addBTN JButton.
 *
 * @param actionListener The ActionListener to be set for the addBTN JButton.
 */
public void setAddBtnListener(ActionListener actionListener) {
    this.addBTN.addActionListener(actionListener);
}

/**
 * Sets an ActionListener for the minusBTN JButton.
 *
 * @param actionListener The ActionListener to be set for the minusBTN JButton.
 */
public void setMinusBtnListener(ActionListener actionListener) {
    this.minusBTN.addActionListener(actionListener);
}

/**
 * Sets an ActionListener for the regularBTN JButton.
 *
 * @param actionListener The ActionListener to be set for the regularBTN JButton.
 */
public void setRegularBtnListener(ActionListener actionListener) {
    this.regularBTN.addActionListener(actionListener);
}

/**
 * Sets an ActionListener for the specialBTN JButton.
 *
 * @param actionListener The ActionListener to be set for the specialBTN JButton.
 */
public void setSpecialBtnListener(ActionListener actionListener) {
    this.specialBTN.addActionListener(actionListener);
}

/**
 * Sets an ActionListener for the infoBTN JButton.
 *
 * @param actionListener The ActionListener to be set for the infoBTN JButton.
 */
public void setInfoBtnListener(ActionListener actionListener) {
    this.infoBTN.addActionListener(actionListener);
}

/**
 * Sets an ActionListener for the addItemsBTN JButton.
 *
 * @param actionListener The ActionListener to be set for the addItemsBTN JButton.
 */
public void setAddItemsBtnListener(ActionListener actionListener) {
    this.addItemsBTN.addActionListener(actionListener);
}

/**
 * Sets an ActionListener for the cancelBTN JButton.
 *
 * @param actionListener The ActionListener to be set for the cancelBTN JButton.
 */
public void setCancelBtnListener(ActionListener actionListener) {
    this.cancelBTN.addActionListener(actionListener);
}


/**
 * Gets the contentPane JPanel of the frame.
 *
 * @return The contentPane JPanel representing the main content pane of the frame.
 */
public JPanel getContentPane() {
    return contentPane;
}

/**
 * Gets the nameTXT JTextField used to input the name of the vending machine.
 *
 * @return The nameTXT JTextField representing the input field for the vending machine name.
 */
public JTextField getNameTXT() {
    return nameTXT;
}

/**
 * Clears the nameTXT JTextField by setting its text to an empty string.
 */
public void clearNameTXTfield() {
    nameTXT.setText("");
}

/**
 * Gets the vmID JTextField used to input the ID number of the vending machine.
 *
 * @return The vmID JTextField representing the input field for the vending machine ID.
 */
public JTextField getVmID() {
    return vmID;
}

/**
 * Sets the text of vmID JTextField to the current value of vmIdNum as a string.
 */
public void setVmID() {
    this.vmID.setText(Integer.toString(vmIdNum));
}

/**
 * Gets the sourceFrame MainMenuFrame representing the frame that opened the current frame.
 *
 * @return The sourceFrame MainMenuFrame representing the parent frame.
 */
public MainMenuFrame getSourceFrame() {
    return sourceFrame;
}

/**
 * Gets the infoFrame InfoFrame representing an instance of the InfoFrame class used for displaying information.
 *
 * @return The infoFrame InfoFrame representing the frame used for displaying information.
 */
public InfoFrame getInfoFrame() {
    return infoFrame;
}

/**
 * Gets the name of the vending machine.
 *
 * @return The vmName String representing the name of the vending machine.
 */
public String getVmName() {
    return vmName;
}

/**
 * Gets the ID number of the vending machine.
 *
 * @return The vmIdNum int representing the ID number of the vending machine.
 */
public int getVmIdNum() {
    return vmIdNum;
}

/**
 * Sets the ID number of the vending machine to the given value.
 *
 * @param vmIdNum The int value representing the ID number of the vending machine to be set.
 */
public void setVmIdNum(int vmIdNum) {
    this.vmIdNum = vmIdNum;
}

/**
 * Gets the FileReaderWriter object used for reading and writing files.
 *
 * @return The accessFile FileReaderWriter object used for file access.
 */
public FileReaderWriter getAccessFile() {
    return accessFile;
}

/**
 * Gets the type of the vending machine (regular or special).
 *
 * @return The type String representing the type of the vending machine.
 */
public String getVmType() {
    return type;
}

/**
 * Sets the type of the vending machine (regular or special) to the given value.
 *
 * @param type The String value representing the type of the vending machine to be set.
 */
public void setVmType(String type) {
    this.type = type;
}

/**
 * Gets the number of available slots in the vending machine.
 *
 * @return The slots int representing the number of available slots in the vending machine.
 */
public int getSlots() {
    return slots;
}

/**
 * Sets the number of available slots in the vending machine to the given value.
 *
 * @param slots The int value representing the number of available slots to be set.
 * @return The updated number of available slots in the vending machine.
 */
public int setSlots(int slots) {
    return this.slots = slots;
}

/**
 * Gets the slotNumCounter JLabel displaying the current number of slots selected.
 *
 * @return The slotNumCounter JLabel representing the display for the number of slots.
 */
public JLabel getSlotNumCounter() {
    return slotNumCounter;
}

/**
 * Displays the vending machine ID by setting the text of vmID JTextField to the current value of vmIdNum as a string.
 */
public void displayId() {
    vmID.setText(Integer.toString(vmIdNum));
}

	/**
	 * Create the frame.
	 */
	public CreateFrame(MainMenuFrame mMenuFrame) {
		this.sourceFrame = mMenuFrame;
		components();
		
	}
	
	/**
	 * Create the frame.
	 */
	private void components()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(blue);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 10, 616, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Create Vending Machine");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 10, 596, 45);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 65, 616, 82);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		slotsNumLBL = new JLabel("Number of Slots: ");
		slotsNumLBL.setFont(new Font("Rockwell", Font.BOLD, 15));
		slotsNumLBL.setBounds(280, 42, 148, 27);
		panel_1.add(slotsNumLBL);
		
		nameTXT = new JTextField("");
		nameTXT.setBounds(218, 13, 388, 19);
		panel_1.add(nameTXT);
		nameTXT.setColumns(10);
		
		addBTN = new JButton("+");
		addBTN.setFont(new Font("Rockwell", Font.BOLD, 25));
		addBTN.setBounds(531, 43, 54, 27);
		panel_1.add(addBTN);
		
		minusBTN = new JButton("-");
		minusBTN.setFont(new Font("Rockwell", Font.BOLD, 25));
		minusBTN.setBounds(419, 42, 54, 28);
		panel_1.add(minusBTN);
		
		lblVendingMachineId = new JLabel("Vending Machine ID: ");
		lblVendingMachineId.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblVendingMachineId.setBounds(10, 42, 166, 27);
		panel_1.add(lblVendingMachineId);
		
		vmID = new JTextField();
		vmID.setBounds(174, 42, 96, 27);
		panel_1.add(vmID);
		vmID.setColumns(10);
		
		JLabel nameLBL = new JLabel("Business/Customer Name: ");
		nameLBL.setFont(new Font("Rockwell", Font.BOLD, 15));
		nameLBL.setBounds(10, 8, 304, 24);
		panel_1.add(nameLBL);
		
		slotNumCounter = new JLabel("8");
		slotNumCounter.setHorizontalAlignment(SwingConstants.CENTER);
		slotNumCounter.setFont(new Font("Rockwell", Font.BOLD, 20));
		slotNumCounter.setBounds(419, 41, 164, 27);
		panel_1.add(slotNumCounter);
		
		regularPanel = new JPanel();
		regularPanel.setBounds(0, 207, 308, 181);
		panel.add(regularPanel);
		
		regularBTN = new JButton("REGULAR");
		regularBTN.setFont(new Font("Rockwell", Font.BOLD, 20));
		regularPanel.add(regularBTN);
		
		specialPanel = new JPanel();
		specialPanel.setBounds(306, 207, 310, 181);
		panel.add(specialPanel);
		
		specialBTN = new JButton("SPECIAL");
		specialBTN.setFont(new Font("Rockwell", Font.BOLD, 20));
		specialPanel.add(specialBTN);
		
		lblType = new JLabel("choose a type:");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 35));
		lblType.setBounds(10, 157, 596, 45);
		panel.add(lblType);
		
		exitOptPanel = new JPanel();
		exitOptPanel.setBounds(0, 387, 616, 56);
		panel.add(exitOptPanel);
		exitOptPanel.setLayout(null);
		
		mainMenuBTN = new JButton("MAIN MENU");
		mainMenuBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		mainMenuBTN.setBounds(440, 10, 166, 41);
		exitOptPanel.add(mainMenuBTN);
		
		cancelBTN = new JButton("cancel");
		cancelBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		cancelBTN.setBounds(93, 17, 90, 27);
		exitOptPanel.add(cancelBTN);
		
		createBTN = new JButton("create");
		createBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		createBTN.setBounds(193, 17, 90, 27);
		exitOptPanel.add(createBTN);
		
		infoBTN = new JButton("( i )");
		infoBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		infoBTN.setBounds(10, 17, 66, 27);
		exitOptPanel.add(infoBTN);
		
		addItemsBTN = new JButton("Add Items");
		addItemsBTN.setFont(new Font("Rockwell", Font.BOLD, 15));
		addItemsBTN.setBounds(311, 10, 119, 41);
		exitOptPanel.add(addItemsBTN);

		//set all panel to blue
		panel.setBackground(blue);
		panel_1.setBackground(blue);
		regularPanel.setBackground(blue);
		specialPanel.setBackground(blue);
		exitOptPanel.setBackground(blue);

		//set all label to white
		lblType.setForeground(Color.WHITE);
		slotsNumLBL.setForeground(Color.WHITE);
		nameLBL.setForeground(Color.WHITE);
		lblNewLabel.setForeground(Color.WHITE);
		lblVendingMachineId.setForeground(Color.WHITE);
		slotNumCounter.setForeground(Color.WHITE);

		//set all buttons to pink + labels are white
		mainMenuBTN.setBackground(pink);
		mainMenuBTN.setForeground(Color.WHITE);
		cancelBTN.setBackground(pink);	
		cancelBTN.setForeground(Color.WHITE);
		createBTN.setBackground(pink);
		createBTN.setForeground(Color.WHITE);
		infoBTN.setBackground(pink);
		infoBTN.setForeground(Color.WHITE);
		addItemsBTN.setBackground(pink);
		addItemsBTN.setForeground(Color.WHITE);
		addBTN.setBackground(pink);
		addBTN.setForeground(Color.WHITE);
		minusBTN.setBackground(pink);
		minusBTN.setForeground(Color.WHITE);

		//set type buttons to yellow
		regularBTN.setBackground(yellow);
		specialBTN.setBackground(yellow);

	}
}
