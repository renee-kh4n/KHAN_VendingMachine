
import java.util.ArrayList;

/**
 * The ItemSlot class represents a slot that holds a list of items.
 */
public class ItemSlot {
    /**
     * The list of items in the slot.
     */
    private ArrayList<Item> items;
    
    /**
     * Constructs an ItemSlot object with the specified initial items and size.
     *
     * @param items the initial list of items
     * @param size the size of the slot
     */
    public ItemSlot(){
        items = new ArrayList<Item>();
    }

    /**
     * Returns the list of items in the slot.
     *
     * @return the list of items
     */
    public ArrayList<Item> getItems() {
        return items;
    }
    
    /**
     * Adds an item to the specified index in the slot.
     *
     * @param index the index at which to add the item
     * @param item the item to add
     */
    public void addItemToSlot(Item item) {
        items.add(item);
    }
    
    /**
     * Removes the specified item from the slot.
     *
     * @param item the item to remove
     */
    public void removeItemFromList(Item item) {
        items.remove(item);
    }
}