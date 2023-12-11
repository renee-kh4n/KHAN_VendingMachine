
/**
 * The Item class represents an item with various attributes such as name,
 * price, calories, weight, and damage status.
 */
public class Item {
    /**
     * The name of the item.
     */
    private String itemName;

    /**
     * The price of the item.
     */
    private double price;

    /**
     * The number of calories in the item.
     */
    private double calories;

    /**
     * The weight of the item and its unit in g or mL.
     */
    private String weight;

    /**
     * The description of the item.
     */
    private String desc;

    /**
     * The type of the item.
     */
    private String type;

    /**
     * Checks if the item is for sale.
     */
    private boolean isSold;

    /**
     * Checks if the item is an ingredient.
     */
    private boolean isIngredient;

    /**
     * Constructs an Item object with the specified attributes.
     *
     * @param itemName  the name of the item
     * @param price     the price of the item
     * @param calories  the number of calories in the item
     * @param weight    the weight of the item
     * @param isSold    checks if the item is for sale
     * @param isIngredient checks if the item is an ingredient
     * @param desc      the description of the item
     */
    public Item(String type, String itemName, double price, double calories, String weight, boolean isSold, boolean isIngredient, String desc) {
        this.itemName = itemName;
        this.price = price;
        this.calories = calories;
        this.weight = weight;
        this.desc = desc;
        this.type = type;
        this.isSold = isSold;
        this.isIngredient = isIngredient;

    }


    /**
     * Returns the name of the item.
     *
     * @return the name of the item
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Returns the price of the item.
     *
     * @return the price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the number of calories in the item.
     *
     * @return the number of calories in the item
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Returns the weight of the item.
     *
     * @return the weight of the item
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Returns the description of the item.
     *
     * @return the description of the item
     */
    public String getDescription() {
        return desc;
    }

    /**
     * Sets the price of the item.
     *
     * @param price the new price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }


    /**
     * Returns the type of the item.
     *
     * @return the type of the item
     */
    public String getType() {
        return type;
    }

    /**
     * Returns true if the item is for sale.
     *
     * @return true if the item is for sale
     */
    public boolean getIsSold() {
        return isSold;
    }

    /**
     * Returns true if the item is an ingredient.
     *
     * @return true if the item is an ingredient
     */
    public boolean getIsIngredient() {
        return isIngredient;
    }

}