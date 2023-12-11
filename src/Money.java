/**
 * The Money class represents a monetary amount.
 * It is used to store and retrieve the amount of money.
 */
public class Money {

	/**
	 * The amount of money.
	 */
	private double amount;

	/**
	 * Constructs a new Money object with the specified amount.
	 *
	 * @param amount The amount of money.
	 */
	Money(double amount) {
		this.amount = amount;
	}

	/**
	 * Get the amount of money.
	 *
	 * @return The amount of money.
	 */
	public double getAmount() {
		return amount;
	}
}
