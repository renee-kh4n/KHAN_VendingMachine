import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileReaderWriter {

	/**
	 * The vmList File represents the file containing the list of vending machines.
	 * It points to the "resources/vmList.txt" file in the filesystem.
	 */
	private File vmList = new File("resources/vmList.txt");

	/**
	 * The itemList File represents the file for storing the list of items in a vending machine.
	 * The specific file location will be set later during runtime based on the vending machine ID.
	 */
	private File itemList;

	/**
	 * The writer BufferedWriter is used for writing data to a file.
	 * It is used to write data to the specified files, vmList and itemList.
	 */
	BufferedWriter writer;
	
	/**
	 * Used for reading the total IDs from a file.
	 * @param vmIdNum
	 */
	public void writeVmTotal(int vmIdNum) {
        try (RandomAccessFile raf = new RandomAccessFile(vmList, "rw")) {
            // Seek to the beginning of the file
            raf.seek(0);
            // Write the updated vmIdNum as a string to the first line
            raf.writeBytes(Integer.toString(vmIdNum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/**
	 * Reads the total number of existing vending machines from the vmList file and returns the next available vending machine ID.
	 *
	 * If the vmList file does not exist, a new file is created, and the vmID is initialized to 1. Subsequently, the method
	 * returns 1 as the next available vending machine ID.
	 *
	 * If the vmList file exists, the current value of the vmID is read from the file, and the method returns the next available
	 * vending machine ID by incrementing the current value by 1.
	 *
	 * @return The next available vending machine ID as an integer.
	 */
	public int readVmIdTotal() {
	    int vmIdNum = 0;

	    try {
	        if (!vmList.exists()) {
	            // If the file doesn't exist, create a new file and initialize vmID to 1
	            vmList.createNewFile();
	            vmIdNum = 1;

	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(vmList))) {
	                writer.write(Integer.toString(vmIdNum));
					//add new line
					writer.newLine();
	            } catch (IOException e) {
	                // Handle file writing errors here
	                e.printStackTrace();
	            }
	        } else {
	            // If the file exists, read the current value of vmID and increment it
	            try (Scanner scanner = new Scanner(vmList)) {
	                int n = scanner.nextInt(); // Get the number of records
	                vmIdNum = n + 1;
	            } catch (IOException e) {
	                // Handle file reading errors here
	                e.printStackTrace();
	            }
	        }
	    } catch (IOException e) {
	        // Handle file creation errors here
	        e.printStackTrace();
	    }

	    return vmIdNum;
	}

	/**
	 * Writes the buyer information to the vmList file in append mode.
	 *
	 * The method takes the buyer's name, ID, type, and the number of slots as input parameters and writes this information as a new
	 * line in the vmList file, separated by underscores (_). The file is opened in append mode to add the new buyer information at
	 * the end of the file.
	 *
	 * @param name The buyer's name to be written to the file.
	 * @param id The buyer's ID to be written to the file.
	 * @param type The buyer's type (regular or special) to be written to the file.
	 * @param slots The number of slots purchased by the buyer to be written to the file.
	 */
	public void writeBuyerInfo(String name, int id, String type, int slots) {
	    try {
	        // Open the file in append mode
	        writer = new BufferedWriter(new FileWriter(vmList, true));
	        
	        // Write the new line with the buyer information
	        writer.write(id + "_" + name + "_" + type + "_" + slots);
	        writer.newLine(); // Add a new line after the information
	        
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * Searches for a vending machine ID in the vmList file.
	 *
	 * The method takes a vending machine ID as a string input and searches for it in the vmList file. It uses a Scanner to read
	 * each line of the file and extract the ID from each line. If the provided vending machine ID is found in the file, the method
	 * returns true. Otherwise, it returns false.
	 *
	 * @param vmID The vending machine ID to be searched for in the vmList file.
	 * @return true if the vending machine ID is found in the file, false otherwise.
	 */
	public boolean searchVmId(String vmID){

		Scanner lineScanner = null;
		String id = "0";

		    try (Scanner scanner = new Scanner(vmList)) {

					//scan until the first space for every line
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine();
						lineScanner = new Scanner(line);
						lineScanner.useDelimiter("_");
						id = lineScanner.next();

						if (id.equals(vmID)) {
							return true;
	            		} 

					}

					lineScanner.close();
					scanner.close();
			}catch (IOException e) {
	                // Handle file reading errors here
	                e.printStackTrace();
	        }
				
			return false;
	}

	/**
	 * Adds items to the itemList file associated with the given vending machine.
	 *
	 * The method takes various parameters representing item information and adds them as a new line in the itemList file
	 * associated with the provided vending machine ID and name. The itemList file is created if it does not exist. The method uses
	 * a BufferedWriter to open the file in append mode and write the new item information to it.
	 *
	 * @param vmID The ID of the vending machine to which the item belongs.
	 * @param vmName The name of the vending machine to which the item belongs.
	 * @param slotNum The slot number of the vending machine where the item will be stored.
	 * @param type The type of the item (e.g., regular or special).
	 * @param itemName The name of the item.
	 * @param price The price of the item.
	 * @param calories The calorie content of the item.
	 * @param weight The weight of the item.
	 * @param qty The quantity of the item available in the vending machine.
	 * @param isSold A boolean indicating if the item is for sale or not.
	 * @param isIngredient A boolean indicating if the item is an ingredient or not.
	 * @param desc The description of the item.
	 */
	public void addItems(int vmID, String vmName, int slotNum, String type, String itemName, 
						double price, double calories, String weight, int qty, boolean isSold, boolean isIngredient, String desc) 
	{ 


		itemList = new File("resources/" + Integer.toString(vmID) + "-" + vmName + ".txt");

		 try {
	        if (!itemList.exists()) {
	            // If the file doesn't exist, create a new file and initialize vmID to 1
	            itemList.createNewFile();
	            
				try {
				// Open the file in append mode
				writer = new BufferedWriter(new FileWriter(itemList, true));
				
				// Write the new line with the buyer information
				writer.write(type + "_" + itemName+ "_" + price+ "_" + calories+ "_" + weight+ "_" + qty + "_" + isSold + "_" + isIngredient+ "_" + desc);
				writer.newLine(); // Add a new line after the information
				
				writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	           
	        } else {
	            
				
				try {
				// Open the file in append mode
				writer = new BufferedWriter(new FileWriter(itemList, true));
				
				// Write the new line with the buyer information
				writer.write(type + "_" + itemName+ "_" + price+ "_" + calories+ "_" + weight+ "_" + qty + "_" + isSold + "_" + isIngredient+ "_" + desc);
				writer.newLine(); // Add a new line after the information
				
				writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	    } catch (IOException e) {
	        // Handle file creation errors here
	        e.printStackTrace();
	    }


	}

	//load an array of vending machines from file vmList.txt
	/**
	 * Loads vending machine data from the vmList file and populates an ArrayList of VendingMachine objects.
	 *
	 * The method reads vending machine data from the vmList file and converts each line of data into VendingMachine objects
	 * or SpecialVendingMachine objects based on the type of the vending machine (regular or special). It populates an ArrayList of
	 * VendingMachine objects and returns it. If any parsing or file reading errors occur, appropriate exception handling is done.
	 *
	 * @param vmListArray An ArrayList of VendingMachine objects to be populated with data from the vmList file.
	 * @return An updated ArrayList of VendingMachine objects containing the loaded vending machine data.
	 */
	public ArrayList<VendingMachine> loadVmArray(ArrayList<VendingMachine> vmListArray){
		
		int id = 0;
		String name = null;
		String type = null;
		int slots = 0;

		    try (Scanner scanner = new Scanner(vmList)) {
				scanner.nextInt(); 
				//go to the next line
				scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try (Scanner lineScanner = new Scanner(line)) {
                    lineScanner.useDelimiter("_");
                    id = Integer.parseInt(lineScanner.next());
                    name = lineScanner.next();
                    type = lineScanner.next();
                    slots = Integer.parseInt(lineScanner.next());

                    if (type.equalsIgnoreCase("Regular"))
                        vmListArray.add(new VendingMachine(name, id, type, slots));
                    else
                        vmListArray.add(new SpecialVendingMachine(name, id, type, slots));
                } catch (Exception e) {
                    // Handle line parsing errors here
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            // Handle file not found errors here
            e.printStackTrace();
        }
		

		return vmListArray;

	}


	/**
	 * Loads item data from the specified vending machine file and populates a HashMap of items and quantities.
	 *
	 * The method reads item data from the specified vending machine file and converts each line of data into Item objects.
	 * It then populates a HashMap with the Item objects as keys and the corresponding quantities as values. The method takes
	 * the vending machine ID and name as input to locate the appropriate vending machine file. If any parsing or file reading
	 * errors occur, appropriate exception handling is done.
	 *
	 * @param vmID The ID of the vending machine from which to load items.
	 * @param vmName The name of the vending machine from which to load items.
	 * @return A HashMap containing the loaded items as keys and their corresponding quantities as values.
	 */
	public HashMap<Item, Integer> loadItemsToVendingMachine(int vmID, String vmName) {
    File itemList = new File("resources/" + Integer.toString(vmID) + "-" + vmName + ".txt");
    HashMap<Item, Integer> itemListMap = new HashMap<>();

    try (Scanner scanner = new Scanner(itemList)) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            try (Scanner lineScanner = new Scanner(line)) {
                lineScanner.useDelimiter("_");
                
                String type = lineScanner.next(); 
                String itemName = lineScanner.next();
				double price = Double.parseDouble(lineScanner.next());
				double calories = Double.parseDouble(lineScanner.next());
				String weight = lineScanner.next();
                int qty = Integer.parseInt(lineScanner.next());
				boolean isSold = lineScanner.nextBoolean();
				boolean isIngredient = lineScanner.nextBoolean();
				String desc = lineScanner.next();

                Item item = new Item(type, itemName, price, calories, weight, isSold, isIngredient, desc);
                itemListMap.put(item, qty);
            } catch (Exception e) {
                // Handle line parsing errors here
                e.printStackTrace();
            }
        }
    } catch (FileNotFoundException e) {
        // Handle file not found errors here
        e.printStackTrace();
    }

    return itemListMap;
}


}
