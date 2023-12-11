import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Model class represents the data model for the vending machine application.
 * It manages the vending machines, their items, cash registers, and inventory records.
 */
public class Model {
	
	/**
	 * The list of vending machines.
	 */
	private ArrayList<VendingMachine> vmList = new ArrayList<VendingMachine>();
	/**
	 * The name and type of the vending machine.
	 */
	private String name = null, type = null;
	/**
	 * The ID of the vending machine.
	 */
	private int vmID = 0;
	/**
	 * The number of slots in the vending machine.
	 */
	private int slots = 0;
	/**
	 * The current vending machine instance.
	 */
	private VendingMachine vm = new VendingMachine(name, vmID, type, slots);
	/**
	 * The current special vending machine instance.
	 */
	private SpecialVendingMachine specialVM = new SpecialVendingMachine(name, vmID, type, slots);
	/**
	 * The initial inventory record.
	 */
	private HashMap<String, Integer> initialInventory = new HashMap<String, Integer>();
	/**
	 * The recent inventory record.
	 */
	private HashMap<String, Integer> recentInventory = new HashMap<String, Integer>();

/**
 * The Model class represents the data model for the vending machine application.
 * It manages the vending machines, their items, cash registers, and inventory records.
 */
	private FileReaderWriter accessFile = new FileReaderWriter();
	
		//create vending machine
		/**
		 * Create a vending machine given the name, id, type, and number of slots
		 * @param name
		 * @param vmID
		 * @param type
		 * @param slots
		 */
		public void createVM(String name, int vmID, String type, int slots) {
				
			if (type.equalsIgnoreCase("Regular"))
				this.vmList.add(new VendingMachine(name, vmID, type, slots)) ;
			else
				this.vmList.add(new SpecialVendingMachine(name, vmID, type, slots));
		}
		
		//FILE METHODS
		/**
		 * Load the vending machines from the file
		 */
		public void loadVmListFromFile() {
			vmList = accessFile.loadVmArray(vmList);
		}

		/**
		 * Search for the vending machine given the id
		 * @param vmID
		 * @return
		 */
		public boolean searchVM(String vmID) {
			
			return accessFile.searchVmId(vmID);
		}


		/**
		 * Set the vending machine given the id
		 * @param vmID
		 */
		public void setVendingMachine(int vmID)
		{
			
			for (int i=0; i<vmList.size(); i++)
			{
				if ( vmID==vmList.get(i).getVmID() )
				{
					this.vm = vmList.get(i);

					if(vm.getType().equalsIgnoreCase("Special"))
						this.specialVM = new SpecialVendingMachine(vm.getName(), vm.getVmID(), vm.getType(), vm.getSlots());
				}
					

			}
				
		}

		/**
		 * Fetch the total number of vending machines
		 * @return total number of vending machines
		 */
		public int fetchVmIdTotal(){
			return accessFile.readVmIdTotal();
		}

		/**
		 * Write the vmID to the file
		 * @param vmID
		 */
		public void writeVmTotal(int vmID) {
			accessFile.writeVmTotal(vmID);
		}
		
		/**
		 * Write the buyer information to the file
		 * @param vmName
		 * @param vmID
		 * @param type
		 * @param slots
		 */
		public void writeBuyerInfo(String vmName, int vmID, String type, int slots) {
			accessFile.writeBuyerInfo(vmName, vmID, type, slots);
		}

		/**
		 * Add items to the file
		 * @param vmID
		 * @param vmName
		 * @param slotNum
		 * @param type
		 * @param itemName
		 * @param price
		 * @param calories
		 * @param weight
		 * @param qty
		 * @param isSold
		 * @param isIngredient
		 * @param desc
		 */
		public void addItemsToFile(int vmID, String vmName, int slotNum, String type, String itemName, 
									double price, double calories, String weight, int qty, boolean isSold, boolean isIngredient, String desc)  
		{
			accessFile.addItems(vmID, vmName, slotNum, type, itemName, 
			price, calories, weight, qty, isSold, isIngredient, desc) ;
		}

		/**
		 * Fetch items from the file
		 * @param vmID
		 * @param vmName
		 * @return HashMap<Item, Integer> the items in the vending machine
		 */
		public HashMap<Item, Integer>fetchItemsFromFile(int vmID, String vmName) {
			return accessFile.loadItemsToVendingMachine(vmID, vmName);
		}

		//ADD ITEMS to the vending machine
		/**
		 * Add items to the vending machine
		 * @param slotNum
		 * @param item
		 * @param qty
		 */
		public void addItems(int slotNum, Item item, int qty){ 
			
			for(int i=0; i<qty; i++)
			{
				System.out.println(slotNum);
				vm.getItemSlots().get(slotNum).addItemToSlot(item);

				if(vm.getType().equalsIgnoreCase("Special"))
					specialVM.getItemSlots().get(slotNum).addItemToSlot(item);
			}
						
		}
		
		
		//VENDING FEATURES	
		/**
		 * receives payment from the user
		 * @param payment
		 * @param n
		 */
		public void receivePayment(double payment, int n)
		{
				
			vm.getCashReg().receivePayment(payment, n); 
			
		}
		
		/**
		 * Dispense item on the slot num given
		 * @param slotNum
		 */
		public void dispenseItem(int slotNum)
		{
			
			vm.getItemSlots().get(slotNum-1).getItems().set(0, null); //destroy the instance of an item
			
			vm.getItemSlots().get(slotNum-1).removeItemFromList(vm.getItemSlots().get(slotNum-1).getItems().get(0));// remove from arrayList

			if(vm.getType().equalsIgnoreCase("Special"))
			{
				specialVM.getItemSlots().get(slotNum-1).getItems().set(0, null); //destroy the instance of an item
				
				specialVM.getItemSlots().get(slotNum-1).removeItemFromList(specialVM.getItemSlots().get(slotNum-1).getItems().get(0));// remove from arrayList
			}
			
		}
		
		/**
		 * 
		 * @return the change amount
		 */
		public double produceChange()
		{
			return vm.getCashReg().getChange();
		}
		
		//MAINTAINANCE FEATURES
		
		/**
		 * Checks if the stock is full
		 * @param slotNum
		 * @return true if the stock is full, false otherwise
		 */
		public boolean isStockFull(int slotNum) {
			if (vm.getItemSlots().get(slotNum).getItems().size()< 10)	
			{
				return false;
			}
			
			 return true; // if true, trigger the error: cannot add more
			
		}
		
		/**
		 * stocks item to the vending machine
		 * @param Item
		 * @param slotNum
		 */
		public void stockItem(Item Item, int slotNum) 
		{
			
			vm.getItemSlots().get(slotNum).addItemToSlot(Item);
			
		}
		
		/**
		 * Sets new price for all items in the slot
		 * @param slotNum
		 * @param amount
		 */
		public void setItemPrice(int slotNum, double amount)
		{
			
			for(int i=0; i<vm.getItemSlots().get(slotNum-1).getItems().size(); i++)
				vm.getItemSlots().get(slotNum-1).getItems().get(i).setPrice(amount);
			
		}
		
		/**
		 * 
		 * @return the total amount of income in the cash register
		 */
		public double collectPayment() 
		{
			return vm.getCashReg().collectPayment();
			
		}
		/**
		 * Replenish change in the cash register by taking user input for each denomination
		 * @param qty1000
		 * @param qty500
		 * @param qty200
		 * @param qty100
		 * @param qty50
		 * @param qty20
		 * @param qty10
		 * @param qty5
		 * @param qty1
		 */
		public void replenishChange(int qty1000, int qty500, int qty200, int qty100, int qty50, int qty20, int qty10, int qty5, int qty1) {

			
			vm.getCashReg().replenishChange(qty1000, qty500, qty200, qty100, qty50, qty20, qty10, qty5, qty1);
			
		}
		
		//Print summary methods
		/**
		 * Record the initial inventory of the vending machine.
		 * @param itemName
		 * @param qty
		 */
		public void recordInitialInventory(String itemName, int qty) {
			//hashmap of items and quantity
			
			initialInventory.put(itemName, qty);
			recentInventory = new HashMap<>(initialInventory);
		}
		
		/**
		 * Record the recent inventory of the vending machine.
		 * @param itemName
		 * @param newQty
		 */
		public void recordRecentInventory(String itemName, int newQty) {
			//hashmap of items and quantity
				
			recentInventory.put(itemName, newQty);
			
			
		}

		/**
		 * Print the transaction summary of the vending machine on the terminal
		 */
		public void printSummary() {
			
			System.out.println("Vending Machine Initial Inventory: ");
			for (String key : initialInventory.keySet()) {
				System.out.println(key + ", " + initialInventory.get(key));
			}

			System.out.println("Vending Machine Recent Inventory: ");
			for (String key : recentInventory.keySet()) {
				System.out.println(key + ", " + recentInventory.get(key));
			}
			
			System.out.println("Vending Machine Items Sold: ");
			for (String key : recentInventory.keySet()) {
				System.out.println(key + ", " + (initialInventory.get(key) - recentInventory.get(key)));
			}
			
		}

	/**
	 * Get the list of vending machines.
	 * 
	 * @return The list of vending machines.
	 */
		public ArrayList<VendingMachine> getVmList() {
			return vmList;
		}
	/**
	 * Get the name of the vending machine.
	 * 
	 * @return The name of the vending machine.
	 */
		public String getName() {
			return name;
		}
	/**
	 * Get the ID of the vending machine.
	 * 
	 * @return The ID of the vending machine.
	 */
		public int getVmID() {
			return vmID;
		}
	/**
	 * Get the type of the vending machine.
	 * 
	 * @return The type of the vending machine.
	 */
		public String getType() {
			return type;
		}
	/**
	 * Get the number of slots in the vending machine.
	 * 
	 * @return The number of slots in the vending machine.
	 */
		public int getSlots() {
			return slots;
		}

	/**
	 * Get the current vending machine instance.
	 * 
	 * @return The current vending machine instance.
	 */
		public VendingMachine getVm() {
			return vm;
		}
	/**
	 * Get the current special vending machine instance.
	 * 
	 * @return The current special vending machine instance.
	 */
		public SpecialVendingMachine getSpecialVM() {
			return specialVM;
		}

	/**
	 * Get the initial inventory record.
	 * 
	 * @return The initial inventory record as a HashMap.
	 */
		public HashMap<String, Integer> getInitialInventory() {
			return initialInventory;
		}

	/**
	 * Get the recent inventory record.
	 * 
	 * @return The recent inventory record as a HashMap.
	 */
		public HashMap<String, Integer> getRecentInventory() {
			return recentInventory;
		}




	}
