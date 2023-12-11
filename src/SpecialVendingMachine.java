import java.util.ArrayList;

/**
 * The SpecialVendingMachine class represents a special type of vending machine that can create new items based on its ingredients.
 * It extends the VendingMachine class and adds functionality to handle base ingredients and customer choices for creating new items.
 */
public class SpecialVendingMachine extends VendingMachine {

	/**
	 * The list of base ingredients
	 */
	private ArrayList<Item> baseIngredients = new ArrayList<Item>();
	
	/**
	 * Constructs a new SpecialVendingMachine object with the specified name, vending machine ID, type, and slots.
	 *
	 * @param name  The name of the vending machine.
	 * @param vmID  The ID of the vending machine.
	 * @param type  The type of the vending machine.
	 * @param slots The number of slots in the vending machine.
	 */
	SpecialVendingMachine(String name, int vmID, String type, int slots)
	{
		super(name, vmID, type, slots);
	}

	/**
	 * Get the total calories of the special item created from base ingredients.
	 *
	 * @return The total calories of the special item.
	 */
	public double getCalSpecialItem()
	{
		double calories = 0;
		for(Item i : baseIngredients)
		{
			calories += i.getCalories();
		}

		return calories;
	}
	
	/**
	 * Set a base ingredient for creating new items.
	 *
	 * @param i The base ingredient item to add.
	 */
	public void setBaseIngredients(Item i)
	{
		this.baseIngredients.add(i);
	}

	public void emptyIngredients()
	{
		this.baseIngredients.clear();

	}
	

	/**
	 * Get the names of the base ingredients and store them in an array.
	 *
	 * @return An ArrayList containing the names of the base ingredients.
	 */
	public ArrayList<String> getBaseIngredients()
	{
		ArrayList<String> baseIngredientsName = new ArrayList<String>();
		for(Item i : baseIngredients)
		{
			baseIngredientsName.add(i.getItemName());
		}
		return baseIngredientsName;
	}


}
