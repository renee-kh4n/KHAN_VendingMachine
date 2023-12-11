import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;

/**
 * Controller class that handles the interaction between the user and the model
 * 
 */
public class Controller {

	/**
	 * The view
	 */
	private MainMenuFrame view = new MainMenuFrame();
	/**
	 * The info frame
	 */
	private InfoFrame infoFrame = new InfoFrame();
	/**
	 * The add items frame
	 */
	private AddItemsFrame addItemsFrame = new AddItemsFrame();
	/**
	 * The model
	 */
	private Model model = new Model();
	/**
	 * The number of slots set by the user for the V. Machine
	 */
	private int slots; 
	/**
	 * The slot number where the item will be placed; resets to zero when a new V. Machine is created
	 */
	private int slotNum, addToSlotNum = 0; 
	/**
	 * The counter for the dispense button
	 */
	private int count = 0; 

	/**
	 * The special item
	 */
	private Item specialItem = new Item("special", "", 0, 0, "0", true, false, "*");

	/**
	 * Constructor
	 * @param v - the view
	 * @param m - the model
	 */
	Controller(MainMenuFrame v, Model m){
		
		view = v;
		model = m;
		
		view.setVisible(true);
		

		//MAIN MENU BUTTONS
		{
		view.setCreateFrameBtnListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCreateFrame().setVisible(true);

				int vmIdNew = model.fetchVmIdTotal();
				view.getCreateFrame().setVmIdNum(vmIdNew);
				view.getCreateFrame().displayId();
				
				view.setVisible(false);
			}
		});
		
		view.setTestFrameBtnListener(new ActionListener (){
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setVisible(false);
				view.getTestFrame().setVisible(true);
			
			}
		});
		
		view.setExitBtnListener(new ActionListener (){
			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
			
			}
		});
	}
		
		//CREATE FRAME BUTTONS
		{
		view.getCreateFrame().setAddBtnListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent e) {

				
				if(view.getCreateFrame().getSlots()<40)
				{
					view.getCreateFrame().setSlots(view.getCreateFrame().getSlots()+1);
					view.getCreateFrame().displaySlots();
				}
				else
				{
					infoFrame.maxSlot();
					infoFrame.setVisible(true);
				}
					
			}
		});

		view.getCreateFrame().setMinusBtnListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				if (view.getCreateFrame().getSlots()>8)
				{
					view.getCreateFrame().setSlots(view.getCreateFrame().getSlots()-1);
					view.getCreateFrame().displaySlots();
				}
				else
				{
					infoFrame.minSlot();
					infoFrame.setVisible(true);
				}
					
			}
		});

		view.getCreateFrame().setRegularBtnListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				view.getCreateFrame().setVmType("regular");
			}
		});

		view.getCreateFrame().setSpecialBtnListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				view.getCreateFrame().setVmType("special");
			}
		});

		

		view.getCreateFrame().setInfoBtnListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				infoFrame.vmTypeInfo();
				infoFrame.setVisible(true);
			}
		});

		view.getCreateFrame().setCancelBtnListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				view.getCreateFrame().clearNameTXTfield();
				view.getCreateFrame().setVmType(null);
				infoFrame.cancelCreate();
				view.getCreateFrame().dispose();
				infoFrame.setVisible(true);
				view.setVisible(true);

			}
		});

		view.getCreateFrame().setCreateBtnListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				

				String vmName = view.getCreateFrame().getNameTXT().getText();
				String type = view.getCreateFrame().getVmType();
				slots = view.getCreateFrame().getSlots();
				int vmID = view.getCreateFrame().getVmIdNum();
			    
			    if (type == null || vmName.isEmpty()) {
					infoFrame.nullTypeName(type, vmName);
					infoFrame.setVisible(true);
			    } else {
			    	infoFrame.confirmCreate(type, slots);
			        infoFrame.setVisible(true);

					if(vmID>1)
						model.loadVmListFromFile();
			        
					model.createVM(vmName, vmID, type, slots); //
					model.setVendingMachine(vmID);
					
					model.writeVmTotal(vmID);
					
			        model.writeBuyerInfo(vmName, vmID, type, slots);

					model.loadVmListFromFile();
					model.setVendingMachine(vmID);

					view.getCreateFrame().setAddItemsBtnListener(new ActionListener(){ ////////////// ADD ITEMS BUTTON CREATE FRAME
					
					@Override
					public void actionPerformed(ActionEvent e){
						addItemsFrame.setSourceFrame(view.getCreateFrame());
						addItemsFrame.setVisible(true);

						if(model.getVm().getType().equalsIgnoreCase("regular"))
						{
							addItemsFrame.getChckIngredient().setEnabled(false);
							addItemsFrame.getChckForSale().setEnabled(false);
							addItemsFrame.getRdbtnSpecial().setEnabled(false);	
							addItemsFrame.getRdbtnRegular().setEnabled(false);
						}
						else
						{
							addItemsFrame.getRdbtnSpecial().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// Disable the check boxes if "Special" is selected
								addItemsFrame.getChckIngredient().setEnabled(false);
								addItemsFrame.getChckForSale().setEnabled(false);
								addItemsFrame.getQtyList().setEnabled(false);

							}
						});

							addItemsFrame.getRdbtnRegular().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// enable the check boxes if "Regular" is selected
								addItemsFrame.getChckIngredient().setEnabled(true);
								addItemsFrame.getChckForSale().setEnabled(true);
								addItemsFrame.getQtyList().setEnabled(true);

							}
						});
						}
						
						

					}

					});
				}
				
			}
			
		}); 

		view.getCreateFrame().setMainMenuActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getCreateFrame().dispose();
				infoFrame.dispose();
				view.setVisible(true);
			}

		});
	}		
			
		//TEST FEATURES FRAME BUTTONS
		{
		view.getTestFrame().setEnterActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = view.getTestFrame().getVmIdNum();
				model.loadVmListFromFile();

				if (model.searchVM(id))
				{
					infoFrame.idExists();
					infoFrame.setVisible(true);

					model.setVendingMachine(Integer.parseInt(id)); 
					
					view.getTestFrame().getVmFrame().setVmName(model.getVm().getName());
					view.getTestFrame().getMaintainanceFrame().setVmName(model.getVm().getName());

					HashMap<Item, Integer> itemList = model.fetchItemsFromFile(Integer.parseInt(id), model.getVm().getName() );

					//store all item names in one arrayList
					ArrayList<String> itemNames = new ArrayList<String>();
					ArrayList<Integer> itemsQty = new ArrayList<Integer>();
					ArrayList<Double> itemPrices = new ArrayList<Double>();
					for (int i=0; i<itemList.size(); i++)
					{
						//get the item names from the hashmap
						itemNames.add(itemList.keySet().toArray(new Item[itemList.size()])[i].getItemName());
						itemsQty.add(itemList.get(itemList.keySet().toArray()[i]));
						itemPrices.add(itemList.keySet().toArray(new Item[itemList.size()])[i].getPrice());
					}

					//load current vm
					int j=0;
					for (Item item : itemList.keySet()) {
						
						model.addItems(j, item, itemList.get(item));
						
						model.recordInitialInventory(item.getItemName(), itemList.get(item));
						j++;
					}

								
					view.getTestFrame().getMaintainanceFrame().setNumSlots(model.getVm().getSlots(), itemNames, itemsQty, itemPrices);
					
					view.getTestFrame().getVmFrame().setNumSlots(model.getVm().getSlots(), itemNames, itemsQty, itemPrices);

					view.getTestFrame().setTestMaintainanceBtnListener(new ActionListener() {
			
						@Override
						public void actionPerformed(ActionEvent e) {
							view.getTestFrame().setVisible(false);
							view.getTestFrame().getMaintainanceFrame().setVisible(true);
							view.getTestFrame().getMaintainanceFrame().resetDisplayOnScreen();
						}

					});

					view.getTestFrame().setTestVmBtnListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							
							view.getTestFrame().setVisible(false);
							view.getTestFrame().getVmFrame().setVisible(true);
							view.getTestFrame().getVmFrame().resetDisplayOnScreen();
						}

					});
				}
				else
				{
					infoFrame.idNotExist();
					infoFrame.setVisible(true);
				}
			}
		});


		view.getTestFrame().setMainMenuActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getTestFrame().dispose();
				infoFrame.dispose();
				view.setVisible(true);
			}

		});
	}
	
		//ADD ITEMS FRAME BUTTONS
		{
		addItemsFrame.setFinishBtnListener(new ActionListener() {
							
					@Override
					public void actionPerformed(ActionEvent e) {
						
					
					addItemsFrame.dispose();
					addItemsFrame.getSourceFrame().setVisible(true);
					}
		});

			addItemsFrame.setAddBtnListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
					String name = addItemsFrame.getNameTXT().getText();
					double price = Double.parseDouble(addItemsFrame.getPriceTXT().getText());
					String weight = addItemsFrame.getVolTXT().getText() + addItemsFrame.getUnitList().getSelectedItem().toString();
					double cal = Double.parseDouble(addItemsFrame.getCalTXT().getText());
					String desc = "*" + addItemsFrame.getDescTXT().getText();
					String type = "regular"; //by deafaul if vm is regular
					boolean isSold = true, isIngredient = false; //by default if vm is regular
					int qty = 1;

					if(!addItemsFrame.getChckForSale().isSelected())
					{
						desc = "*Not for Sale! ";
						isSold = false;
					}

					if(addItemsFrame.getChckIngredient().isSelected())
						isIngredient = true;

					if(addItemsFrame.getRdbtnSpecial().isSelected())
						isIngredient = false;

					if(addItemsFrame.getRdbtnSpecial().isSelected())
						type = "special";
						

					if (addItemsFrame.getQtyList().isEnabled())
						qty = Integer.parseInt(addItemsFrame.getQtyList().getSelectedItem().toString());

					addItemsFrame.setDispenseAction("Adding " + name + " ...");

					Item item = new Item(type, name, price, cal, weight, isSold, isIngredient, desc);

					
					if (addToSlotNum <= slots)
					{
						System.out.println("addToSlotNum: " + addToSlotNum);
						System.out.println("slots Total: " + slots);
						model.addItems(addToSlotNum, item, qty);
						model.addItemsToFile(model.getVm().getVmID(), model.getVm().getName(), addToSlotNum, type, name, 
						price, cal, weight, qty, isSold, isIngredient, desc) ;
						addToSlotNum++;
					}
					else
					{
						addItemsFrame.setAddBtnListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e)
							{
													
								infoFrame.slotsAreFull();
								infoFrame.setVisible(true);
							}
						});
					}
				}
						
		});
	}

		//VM FEATURES FRAME BUTTONS
		{
		view.getTestFrame().getVmFrame().setMainMenuActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getTestFrame().getVmFrame().dispose();
				view.getTestFrame().dispose();
				infoFrame.dispose();
				view.setVisible(true);
			}

		});
		
		view.getTestFrame().getVmFrame().setReturnActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.getTestFrame().getVmFrame().dispose();
				view.getTestFrame().setVisible(true);

			}
		});
		
		
			view.getTestFrame().getVmFrame().setPayActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if (model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getIsSold()==true)
					{
						view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter1000("0");
						view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter500("0");
						view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter200("0");
						view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter100("0");
						view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter50("0");
						view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter20("0");
						view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter10("0");
						view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter5("0");
						view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter1("0");
						view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCashOut("");
						model.getVm().getCashReg().initializeBuyerPayment();
						model.getVm().getCashReg().setPayment(0.0);
						view.getTestFrame().getVmFrame().getBuyerWalletFrame().setVisible(true);
					}
					else
						view.getTestFrame().getVmFrame().getDisplayAction().setText("<html><center>Item is an ingredient.<br>Not for sale.</center></html>");

					
				}
			});


		//BUYER WALLET FUNCTIONS
		view.getTestFrame().getVmFrame().getBuyerWalletFrame().setPayBtnListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (model.getVm().getCashReg().getPayment()>= model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getPrice())
				{
					
					view.getTestFrame().getVmFrame().getBuyerWalletFrame().dispose();
					view.getTestFrame().getVmFrame().getDisplayAction().setText("Receiving payment: Php" + model.getVm().getCashReg().getPayment());
					count = 0;

					view.getTestFrame().getVmFrame().setProduceChangeActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {

						if(model.getVm().getCashReg().computeChange(model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getPrice()) == true)
						{
							view.getTestFrame().getVmFrame().getDisplayAction().setText("Change produced: Php" + model.getVm().getCashReg().getChange());

					//SPECIAL VENDING MACHINE BUTTONS
						if (model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getType().equalsIgnoreCase("Special"))
						{
							view.getTestFrame().getVmFrame().setCustomItemActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e)
								{
									if (model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getType().equalsIgnoreCase("Special"))
									{
										view.getTestFrame().getVmFrame().getDisplayAction().setText("Choose ingredients for " + model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getItemName() );
										
										specialItem = model.getVm().getItemSlots().get(slotNum-1).getItems().get(0);
										
										if(!specialItem.getItemName().isBlank())
										view.getTestFrame().getVmFrame().EnterButtonListener(new ActionListener() {
								
										@Override
										public void actionPerformed(ActionEvent e)
										{
											try {
											// Set the slotNum based on the entered numbers
											slotNum = Integer.parseInt(view.getTestFrame().getVmFrame().getDisplaySlotChoice().getText());
											// Display the slotNum (optional)
											view.getTestFrame().getVmFrame().getDisplaySlotChoice().setText(Integer.toString (slotNum));
											Item item = model.getVm().getItemSlots().get(slotNum-1).getItems().get(0);

										//(String itemName, String weight, double calories, String description, double price, int stock)

										view.getTestFrame().getVmFrame().setDisplayOnScreen(item.getItemName(), item.getWeight(), item.getCalories(), item.getDescription(), item.getPrice(), model.getVm().getItemSlots().get(slotNum-1).getItems().size());
										if (item.getIsIngredient()==true)
											view.getTestFrame().getVmFrame().getDisplayAction().setText("<html><center>Click ADD INGREDIENT<br>if you like to add this item.</center></html>" );
										else
											view.getTestFrame().getVmFrame().getDisplayAction().setText("<html><center>Item is not an ingredient.<br>Cannot add ingredient.</center></html>" );

											
										} catch (NumberFormatException ex) {
											// Handle invalid input (optional)
											System.err.println("Invalid input. Please enter a valid integer.");
										}
											
										
										}
									});

										
									view.getTestFrame().getVmFrame().setAddIngredientActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e)
										{
											Item item =  model.getSpecialVM().getItemSlots().get(slotNum-1).getItems().get(0);

											if (model.getSpecialVM().getItemSlots().get(slotNum-1).getItems().size() > 0 && item.getIsIngredient()==true)
											{
												model.getSpecialVM().setBaseIngredients(item);
												model.dispenseItem(slotNum);

												view.getTestFrame().getVmFrame().setQtyText(slotNum, model.getVm().getItemSlots().get(slotNum-1).getItems().size());
																	
												view.getTestFrame().getVmFrame().setDisplayOnScreen(item.getItemName(), item.getWeight(), item.getCalories(), item.getDescription(), item.getPrice(), model.getVm().getItemSlots().get(slotNum-1).getItems().size());

												view.getTestFrame().getVmFrame().getDisplayAction().setText( item.getItemName() + "added. Preparing . . .");

												view.getTestFrame().getVmFrame().setSpecialItemInfo(specialItem.getItemName(), model.getSpecialVM().getBaseIngredients(), specialItem.getPrice(),  model.getSpecialVM().getCalSpecialItem());
																
											}
											else if (item.getIsIngredient()==false)
												view.getTestFrame().getVmFrame().getDisplayAction().setText("Item is not an ingredient");
											else
												view.getTestFrame().getVmFrame().getDisplayAction().setText("No item to add");

										}
									
									});


									}
									else
										view.getTestFrame().getVmFrame().getDisplayAction().setText("<html><center>Item is not special.<br>Cannot add ingredients.</center></html>");
									

								}
							
							});

						}
							





							//dispense only when there's enough change
							view.getTestFrame().getVmFrame().setDispenseActionListener(new ActionListener() {
					
							@Override
							public void actionPerformed(ActionEvent e) {
								
								count++;
								
								if (model.getSpecialVM().getBaseIngredients().size() < 0 &&  model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getType().equalsIgnoreCase("Special"))
								{
									view.getTestFrame().getVmFrame().getDisplayAction().setText("<html><center>Please create special item.<br>and add ingredients</center></html>");
								}
								else if (model.getSpecialVM().getBaseIngredients().size()==0 && model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getType().equalsIgnoreCase("Regular") && count == 1)
								{
									
									Item item = model.getVm().getItemSlots().get(slotNum-1).getItems().get(0);

									model.dispenseItem(slotNum);
									view.getTestFrame().getVmFrame().setQtyText(slotNum, model.getVm().getItemSlots().get(slotNum-1).getItems().size());
									

									view.getTestFrame().getVmFrame().setDisplayOnScreen(item.getItemName(), item.getWeight(), item.getCalories(), item.getDescription(), item.getPrice(), model.getVm().getItemSlots().get(slotNum-1).getItems().size());
									view.getTestFrame().getVmFrame().getDisplayAction().setText("Dispensing " + item.getItemName() + "...");
								}
								//else if specialItem has ingredients
								else if (model.getSpecialVM().getBaseIngredients().size()>0)
								{
									view.getTestFrame().getVmFrame().getDisplayAction().setText("Dispensing " + specialItem.getItemName() + "...");
									view.getTestFrame().getVmFrame().resetSpecialItemInfo();
									model.getSpecialVM().emptyIngredients();
									specialItem = new Item("special", "", 0, 0, "0", true, false, "*");
								}
									
								
								for(int i=0; i<model.getVm().getItemSlots().size(); i++)
									model.recordRecentInventory(model.getVm().getItemSlots().get(i).getItems().get(0).getItemName(), model.getVm().getItemSlots().get(i).getItems().size());
								
							}
						});

							
						}
						else
						{
							view.getTestFrame().getVmFrame().getDisplayAction().setText("<html>Sorry, there's no enough change.<br>Returning payment. . .</html>");
							model.getVm().getCashReg().initializeBuyerPayment();
						}
						
						
					}
				});

				}
				else
				view.getTestFrame().getVmFrame().getDisplayAction().setText("<html><center>Insufficient amount.<br>Returning payment. . .</center></html>");
				

			}
		});
		
		view.getTestFrame().getVmFrame().getBuyerWalletFrame().setBillsBtnListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String buttonText = ((JButton) e.getSource()).getText();
				// Append the clicked number to the displayAction label
				model.receivePayment(Double.parseDouble(buttonText), 1);
				view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter1000(model.getVm().getCashReg().getReceivedPayment().get(1000.0).toString());
				view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter500(model.getVm().getCashReg().getReceivedPayment().get(500.0).toString());
				view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter200(model.getVm().getCashReg().getReceivedPayment().get(200.0).toString());
				view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter100(model.getVm().getCashReg().getReceivedPayment().get(100.0).toString());
				view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter50(model.getVm().getCashReg().getReceivedPayment().get(50.0).toString());
				view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter20(model.getVm().getCashReg().getReceivedPayment().get(20.0).toString());
				view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter10(model.getVm().getCashReg().getReceivedPayment().get(10.0).toString());
				view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter5(model.getVm().getCashReg().getReceivedPayment().get(5.0).toString());
				view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCounter1(model.getVm().getCashReg().getReceivedPayment().get(1.0).toString());
				view.getTestFrame().getVmFrame().getBuyerWalletFrame().setCashOut(Double.toString(model.getVm().getCashReg().getPayment()));
				
			
			}
		});

		

	
	
		// ActionListener implementation for number buttons
		view.getTestFrame().getVmFrame().NumberButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String buttonText = ((JButton) e.getSource()).getText();
				// Append the clicked number to the displayAction label
				view.getTestFrame().getVmFrame().getDisplaySlotChoice().setText(view.getTestFrame().getVmFrame().getDisplaySlotChoice().getText() + buttonText);
			}
		});
	
		// ActionListener implementation for the "clr" button
		view.getTestFrame().getVmFrame().ClearButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Clear the displayAction label
				view.getTestFrame().getVmFrame().getDisplaySlotChoice().setText("");
				view.getTestFrame().getVmFrame().resetDisplayOnScreen();
			}
		});
	
		// ActionListener implementation for the "enter" button
		view.getTestFrame().getVmFrame().EnterButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Set the slotNum based on the entered numbers
					slotNum = Integer.parseInt(view.getTestFrame().getVmFrame().getDisplaySlotChoice().getText());
					// Display the slotNum (optional)
					view.getTestFrame().getVmFrame().getDisplaySlotChoice().setText(Integer.toString (slotNum));
					Item item = model.getVm().getItemSlots().get(slotNum-1).getItems().get(0);

				//(String itemName, String weight, double calories, String description, double price, int stock)

				view.getTestFrame().getVmFrame().setDisplayOnScreen(item.getItemName(), item.getWeight(), item.getCalories(), item.getDescription(), item.getPrice(), model.getVm().getItemSlots().get(slotNum-1).getItems().size());
				

					
				} catch (NumberFormatException ex) {
					// Handle invalid input (optional)
					System.err.println("Invalid input. Please enter a valid integer.");
				}
			}
		});

		view.getTestFrame().getVmFrame().setCancelTransactionActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				model.getVm().getCashReg().cancelTransaction();

				view.getTestFrame().getVmFrame().getDisplayAction().setText("Transaction cancelled...");
				
				model.getVm().getCashReg().initializeBuyerPayment();
			}
		});

		}

		//MAINTAINANCE FRAME BUTTONS
		{
		// ActionListener implementation for number buttons
		view.getTestFrame().getMaintainanceFrame().NumberButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String buttonText = ((JButton) e.getSource()).getText();
				// Append the clicked number to the displayAction label
				view.getTestFrame().getMaintainanceFrame().getDisplaySlotChoice().setText(view.getTestFrame().getMaintainanceFrame().getDisplaySlotChoice().getText() + buttonText);
			}
		});
	
		// ActionListener implementation for the "clr" button
		view.getTestFrame().getMaintainanceFrame().ClearButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Clear the displayAction label
				view.getTestFrame().getMaintainanceFrame().getDisplaySlotChoice().setText("");
				view.getTestFrame().getMaintainanceFrame().resetDisplayOnScreen();
			}
		});
	
		// ActionListener implementation for the "enter" button
		view.getTestFrame().getMaintainanceFrame().EnterButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Set the slotNum based on the entered numbers
					slotNum = Integer.parseInt(view.getTestFrame().getMaintainanceFrame().getDisplaySlotChoice().getText());
					view.getTestFrame().getMaintainanceFrame().setDisplayOnScreen(model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getItemName(),
					model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getWeight(),
					model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getCalories(),
					model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getPrice(),
					model.getVm().getItemSlots().get(slotNum-1).getItems().size());

					// Display the slotNum 
					view.getTestFrame().getMaintainanceFrame().getDisplaySlotChoice().setText(Integer.toString (slotNum));
				} catch (NumberFormatException ex) {
					// Handle invalid input 
					view.getTestFrame().getMaintainanceFrame().getDisplayAction().setText("Invalid input.");
					System.err.println("Invalid input. Please enter a valid integer.");
				}
			}
		});


		view.getTestFrame().getMaintainanceFrame().setMainMenuActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getTestFrame().getMaintainanceFrame().dispose();
				view.getTestFrame().dispose();
				infoFrame.dispose();
				view.setVisible(true);
			}

		});
		
		view.getTestFrame().getMaintainanceFrame().setReturnActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.getTestFrame().getMaintainanceFrame().dispose();
				view.getTestFrame().setVisible(true);

			}
		});

		view.getTestFrame().getMaintainanceFrame().setReplenishChangeActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Integer qty[] = new Integer[9];
				//reset qty
				for (int i=0; i<qty.length; i++)
				{
					qty[i] = 0 + model.getVm().getCashReg().getCashBoxChange().get(model.getVm().getCashReg().getDenomination()[i]);
				}
				
				view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().displaySummary(qty);
				view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().setVisible(true);

			}
		});

		view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().setAddCashBoxActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			
				int qty1000 = Integer.parseInt(view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().getTxt1000().getText());
				int qty500 = Integer.parseInt(view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().getTxt500().getText());
				int qty200 = Integer.parseInt(view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().getTxt200().getText());
				int qty100 = Integer.parseInt(view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().getTxt100().getText());
				int qty50 = Integer.parseInt(view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().getTxt50().getText());

				int qty20 = Integer.parseInt(view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().getTxt20().getText());
				int qty10 = Integer.parseInt(view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().getTxt10().getText());
				int qty5 = Integer.parseInt(view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().getTxt5().getText());
				int qty1 = Integer.parseInt(view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().getTxt1().getText());

				
				
				model.replenishChange(qty1000, qty500, qty200, qty100, qty50, qty20, qty10, qty5, qty1);

				Integer qty[] = new Integer[9];
				qty[0] = model.getVm().getCashReg().getCashBoxChange().get(1000.0);
				qty[1] = model.getVm().getCashReg().getCashBoxChange().get(500.0);
				qty[2] = model.getVm().getCashReg().getCashBoxChange().get(200.0);
				qty[3] = model.getVm().getCashReg().getCashBoxChange().get(100.0);
				qty[4] = model.getVm().getCashReg().getCashBoxChange().get(50.0);
				qty[5] = model.getVm().getCashReg().getCashBoxChange().get(20.0);
				qty[6] = model.getVm().getCashReg().getCashBoxChange().get(10.0);
				qty[7] = model.getVm().getCashReg().getCashBoxChange().get(5.0);
				qty[8] = model.getVm().getCashReg().getCashBoxChange().get(1.0);

				view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().displaySummary(qty);

				view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().resetText();

				view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().displayTotal(model.getVm().getCashReg().computeCashBoxChange());
				

			}
		});

		view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().setReturnActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.getTestFrame().getMaintainanceFrame().getCashBoxFrame().dispose();

			}
		});


		view.getTestFrame().getMaintainanceFrame().setPriceButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				view.getTestFrame().getMaintainanceFrame().getDisplayAction().setText("Set price...");

				view.getTestFrame().getMaintainanceFrame().setCurrPrice(model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getPrice());
				
				view.getTestFrame().getMaintainanceFrame().displaySetPrice();

				view.getTestFrame().getMaintainanceFrame().saveActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
					model.setItemPrice(slotNum, Double.parseDouble(view.getTestFrame().getMaintainanceFrame().getNewPriceTXT().getText()));

					view.getTestFrame().getMaintainanceFrame().getDisplayAction().setText("Price updated.");

					view.getTestFrame().getMaintainanceFrame().setPriceText(slotNum);

					view.getTestFrame().getMaintainanceFrame().setDisplayOnScreen(model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getItemName(),
					model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getWeight(),
					model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getCalories(),
					model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getPrice(),
					model.getVm().getItemSlots().get(slotNum-1).getItems().size());


					}
				});

				view.getTestFrame().getMaintainanceFrame().cancelActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e) {
					view.getTestFrame().getMaintainanceFrame().getNewPriceTXT().setText("");
					
					}

				});

			}
		});

		view.getTestFrame().getMaintainanceFrame().restockButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				

				if(model.getVm().getItemSlots().get(slotNum-1).getItems().size() < 10)
				{
					view.getTestFrame().getMaintainanceFrame().getDisplayAction().setText("Restocking...");

					view.getTestFrame().getMaintainanceFrame().setQtyText(view.getTestFrame().getMaintainanceFrame().getSlotChoice(),model.getVm().getItemSlots().get(slotNum-1).getItems().size() + 1);

					Item item = model.getVm().getItemSlots().get(slotNum-1).getItems().get(0);

					model.stockItem(item, slotNum-1);

					view.getTestFrame().getMaintainanceFrame().setDisplayOnScreen(model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getItemName(),
					model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getWeight(),
					model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getCalories(),
					model.getVm().getItemSlots().get(slotNum-1).getItems().get(0).getPrice(),
					model.getVm().getItemSlots().get(slotNum-1).getItems().size());

				}
				else
				{
					view.getTestFrame().getMaintainanceFrame().getDisplayAction().setText("Slot is full.");
				}
			}
		});
		

		view.getTestFrame().getMaintainanceFrame().setCollectPaymentActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){

				view.getTestFrame().getMaintainanceFrame().getDisplayAction().setText("Collecting " + model.collectPayment() + "php...");

			}
		});

		view.getTestFrame().getMaintainanceFrame().setAddItemsBtnListener(new ActionListener(){ ////////////// ADD ITEMS BUTTON MAINTAINANCE FRAME

					
					
					@Override
					public void actionPerformed(ActionEvent e){
						

						view.getTestFrame().getMaintainanceFrame().getDisplayAction().setText("Adding items...");
						addItemsFrame.setSourceFrame(view.getTestFrame().getMaintainanceFrame());
						addItemsFrame.setVisible(true);

						if(model.getVm().getType().equalsIgnoreCase("regular"))
						{
							addItemsFrame.getChckIngredient().setEnabled(false);
							addItemsFrame.getChckForSale().setEnabled(false);
							addItemsFrame.getRdbtnSpecial().setEnabled(false);	
							addItemsFrame.getRdbtnRegular().setEnabled(false);
						}
						else
						{
								addItemsFrame.getRdbtnSpecial().addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									// Disable the check boxes if "Special" is selected
									addItemsFrame.getChckIngredient().setEnabled(false);
									addItemsFrame.getChckForSale().setEnabled(false);
									addItemsFrame.getQtyList().setEnabled(false);

								}
							});

								addItemsFrame.getRdbtnRegular().addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									// enable the check boxes if "Regular" is selected
									addItemsFrame.getChckIngredient().setEnabled(true);
									addItemsFrame.getChckForSale().setEnabled(true);
									addItemsFrame.getQtyList().setEnabled(true);

								}
							});
						}
						
						

					}

					});
				
			
		

		view.getTestFrame().getMaintainanceFrame().setPrintSummaryActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){

				view.getTestFrame().getMaintainanceFrame().getDisplayAction().setText("Printing summary...");

				infoFrame.TransactionSummary(model.getInitialInventory(), model.getRecentInventory(), model.getVm().getCashReg().collectPayment());
				infoFrame.setVisible(true);
				model.printSummary();

			}
		});

	}
		
	}

	/**
	 * Displays the project information
	 */
	public void displayProjectInfo() {
		
		System.out.println("Renee Althea F. Khan - 12275905");
		System.out.println("MCO2 - Vending Machine");
		System.out.println("08/02/2023");
	}
}
