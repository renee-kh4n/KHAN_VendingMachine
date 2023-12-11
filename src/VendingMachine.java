// KHAN, Renee Althea F. - 12275905

import java.util.*;

/**
 * The VendingMachine class represents a vending machine with item slots and a cash register.
 * It contains methods for getting the item slots, name, ID, type, number of slots, and cash register of the vending machine.
 */
public class VendingMachine {
	
	/**
	 * The list of item slots in the vending machine.
	 */
	protected ArrayList<ItemSlot> itemSlots;

	/**
	 * The name of the vending machine.
	 */
	protected String name;

	/**
	 * The ID of the vending machine.
	 */
	protected int vmID;

	/**
	 * The type of the vending machine.
	 */
	protected String type;

	/**
	 * The number of slots in the vending machine.
	 */
	protected int slots;

	/**
	 * The cash register of the vending machine.
	 */
	protected CashRegister cashReg;

	/**
	 * Create a new VendingMachine instance with the given parameters.
	 *
	 * @param name The name of the vending machine.
	 * @param vmID The ID of the vending machine.
	 * @param type The type of the vending machine.
	 * @param slots The number of slots in the vending machine.
	 */	
	VendingMachine(String name, int vmID, String type, int slots)
	{
		this.name = name;
		this.vmID = vmID;
		this.type = type;
		this.slots = slots;
		

		this.itemSlots = new ArrayList<ItemSlot>();
		//create slots
		for(int i=0; i<slots; i++)
		{
			System.out.println("Slot created " + i);
			System.out.println("Slots total:" + slots);
			ItemSlot slot = new ItemSlot();
			itemSlots.add(slot);
		}
		
		cashReg = new CashRegister();
	}

	/**
	 * Get the list of item slots in the vending machine.
	 *
	 * @return The list of item slots.
	 */
	public ArrayList<ItemSlot> getItemSlots() {
		return itemSlots;
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
	 * @return The number of slots.
	 */
	public int getSlots() {
		return slots;
	}

	/**
	 * Get the cash register of the vending machine.
	 *
	 * @return The cash register.
	 */
	public CashRegister getCashReg() {
		return cashReg;
	}
	

	
}