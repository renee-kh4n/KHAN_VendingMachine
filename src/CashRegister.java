import java.util.HashMap;

public class CashRegister {


	/**
 * The cashBoxChange HashMap stores the quantity of each cash denomination available in the cash box.
 * The key represents the amount (denomination) of cash, and the value represents the quantity of that denomination.
 */
private HashMap<Double, Integer> cashBoxChange = new HashMap<Double, Integer>();

/**
 * The receivedPayment HashMap stores the quantity of each cash denomination received as payment from a buyer.
 * The key represents the amount (denomination) of cash received, and the value represents the quantity of that denomination received.
 */
private HashMap<Double, Integer> receivedPayment = new HashMap<Double, Integer>();

/**
 * The returnChange HashMap stores the quantity of each cash denomination to be returned as change to a buyer.
 * The key represents the amount (denomination) of cash to be returned, and the value represents the quantity of that denomination to be returned.
 */
private HashMap<Double, Integer> returnChange = new HashMap<Double, Integer>();

/**
 * The denomination array stores the different cash denominations available.
 * These denominations are used to calculate the change and manage the cash box.
 */
private Double[] denomination = {1000.0, 500.0, 200.0, 100.0, 50.0, 20.0, 10.0, 5.0, 1.0};

/**
 * The totalIncome variable stores the total income earned from successful transactions.
 * It represents the total amount of money collected from buyers for the items purchased.
 */
private double totalIncome = 0;

/**
 * The payment variable stores the total payment received from a buyer for the current transaction.
 * It represents the total amount of money paid by the buyer for the items purchased.
 */
private double payment = 0;

/**
 * The change variable stores the total change to be returned to the buyer after a transaction.
 * It represents the total amount of money that needs to be returned to the buyer.
 */
private double change = 0;


	/**
	 * Constructor that automatically initializes contents of the cash register.
	 */
	CashRegister(){
		initializeBuyerPayment();
		initializeCashBoxChange();
		initializeReturnChange();

	}
	/**
	 * Initializes the cashBoxChange HashMap with the denomination as keys and 0 as values.
	 */
	public void initializeCashBoxChange(){
		cashBoxChange.put(1000.0, 0);
		cashBoxChange.put(500.0, 0);
		cashBoxChange.put(200.0, 0);
		cashBoxChange.put(100.0, 0);
		cashBoxChange.put(50.0, 0);
		cashBoxChange.put(20.0, 0);
		cashBoxChange.put(10.0, 0);
		cashBoxChange.put(5.0, 0);
		cashBoxChange.put(1.0, 0);
	}
	/**
	 * Initializes the receivedPayment HashMap with the denomination as keys and 0 as values.
	 */
	public void initializeBuyerPayment(){
		receivedPayment.put(1000.0, 0);
		receivedPayment.put(500.0, 0);
		receivedPayment.put(200.0, 0);	
		receivedPayment.put(100.0, 0);
		receivedPayment.put(50.0, 0);
		receivedPayment.put(20.0, 0);
		receivedPayment.put(10.0, 0);
		receivedPayment.put(5.0, 0);
		receivedPayment.put(1.0, 0);
	}

	/**
	 * Initializes the returnChange HashMap with the denomination as keys and 0 as values.
	 */
	public void initializeReturnChange(){
		returnChange.put(1000.0, 0);
		returnChange.put(500.0, 0);
		returnChange.put(200.0, 0);	
		returnChange.put(100.0, 0);
		returnChange.put(50.0, 0);
		returnChange.put(20.0, 0);
		returnChange.put(10.0, 0);
		returnChange.put(5.0, 0);
		returnChange.put(1.0, 0);
	}
	
	/**
	 * 
	 * @param key - denomination
	 * @param n - quantity of denomination
	 */
	public void receivePayment(double key, int n)
	{

		receivedPayment.put(key, receivedPayment.get(key) + n);

		computePayment();
	}
	
	 /**
     * Calculates the payment amount based on the received payments from the buyer.
     * The calculated payment amount is stored in the "payment" instance variable.
     */
	public void computePayment()
	{
		payment = 0;
		
		for (Double key : receivedPayment.keySet()) {
			payment += key*receivedPayment.get(key);

		}
		
	}

	/**
	 * 
	 * @param itemPrice - price of the item
	 * @return true if the change can be computed, false otherwise
	 */
	public boolean computeChange(double itemPrice) {

		change = payment - itemPrice;
		double changeTemp = change;

		for (int i = 0; i < denomination.length; i++) {
			if (cashBoxChange.get(denomination[i])!=0)
			{
				int n = (int) (changeTemp / denomination[i]);
				if (n > cashBoxChange.get(denomination[i])) {
					n = cashBoxChange.get(denomination[i]);
				}
				returnChange.put(denomination[i], n);
				cashBoxChange.put(denomination[i], cashBoxChange.get(denomination[i]) - n);	
				changeTemp -= n * denomination[i];
			}
		}

		if (changeTemp != 0) 
			return false;
	
		totalIncome += itemPrice;
		return true;
		
		
	}

	/**
	 * Received payment is returned as change
	 * @return the change amount
	 */
	public double cancelTransaction(){
		change = 0;
		returnChange = new HashMap<Double, Integer>(receivedPayment);

		for (Double key : returnChange.keySet()) {
			change = key*returnChange.get(key);
		}

		return change;

	}

	/**
	 * Replenish change in the cash register by taking user input for each denomination
	 * @param qty1000 - quantity of 1000 denomination
	 * @param qty500 - quantity of 500 denomination
	 * @param qty200 - quantity of 200 denomination
	 * @param qty100 - quantity of 100 denomination
	 * @param qty50 - quantity of 50 denomination
	 * @param qty20 - quantity of 20 denomination
	 * @param qty10 - quantity of 10 denomination
	 * @param qty5 - quantity of 5 denomination
	 * @param qty1 - quantity of 1 denomination
	 */
	public void replenishChange(int qty1000, int qty500, int qty200, int qty100, int qty50, int qty20, int qty10, int qty5, int qty1) {

		cashBoxChange.put(1000.0, cashBoxChange.get(1000.0) + qty1000);
		cashBoxChange.put(500.0, cashBoxChange.get(500.0) + qty500);
		cashBoxChange.put(200.0, cashBoxChange.get(200.0) + qty200);
		cashBoxChange.put(100.0, cashBoxChange.get(100.0) + qty100);
		cashBoxChange.put(50.0, cashBoxChange.get(50.0) + qty50);
		cashBoxChange.put(20.0, cashBoxChange.get(20.0) + qty20);
		cashBoxChange.put(10.0, cashBoxChange.get(10.0) + qty10);
		cashBoxChange.put(5.0, cashBoxChange.get(5.0) + qty5);
		cashBoxChange.put(1.0, cashBoxChange.get(1.0) + qty1);
		
	}

	/**
	 * Computes the total change the Cash register has
	 * @return the total amount of change in the cash register
	 */
	public double computeCashBoxChange()
	{
		double totalChange= 0;
		
		for (Double key : cashBoxChange.keySet()) {
			totalChange += key*cashBoxChange.get(key);

		}

		return totalChange;
		
	}

	/**
	 * Computes the total income the Cash register has
	 * @return the total amount of income in the cash register
	 */
	public double collectPayment() {
		
		return totalIncome;

	}

	/**
	 * 
	 * @return the total amount of change the Cash register has
	 */
	public double getChange() {
		return change;
	}

	/**
	 * 
	 * @return the total amount of payment the Cash register has
	 */
	public double getPayment() {
		return payment;
	}

	/**
	 * 
	 * @return the total amount of income the Cash register has
	 */
	public void setPayment(double payment) {
		this.payment = payment;
	}

	/**
	 * 
	 * @return the total amount of income the Cash register has
	 */
	public HashMap<Double, Integer> getReceivedPayment() {
		return receivedPayment;
	}

	/**
	 * 
	 * @return the total amount of income the Cash register has
	 */
	public HashMap<Double, Integer> getReturnChange() {
		return returnChange;
	}

	/**
	 * 
	 * @return the total amount of income the Cash register has
	 */
	public HashMap<Double, Integer> getCashBoxChange() {
		return cashBoxChange;
	}

	/**
	 * 
	 * @return the total amount of income the Cash register has
	 */
	public Double[] getDenomination() {
		return denomination;
	}

	
}
