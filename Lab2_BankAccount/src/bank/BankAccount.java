package bank;

/**
 * bank.BankAccount class is an abstract class that provides a common foundation to specific type of
 * accounts. It provides attribute account balance and common implementations.
 */

public abstract class BankAccount implements IAccount {
  protected double accountBalance;

  /**
   * Constructor that helps instantiate bank.BankAccount object.
   * Customer must deposit at least 1 cent to instantiate a new account.
   *
   * @param starterAmount double starter amount to deposit
   * @throws IllegalArgumentException if starter amount is less than 1 cent
   */
  public BankAccount(double starterAmount) throws IllegalArgumentException {
    if (starterAmount < 0.01) {
      throw new IllegalArgumentException("You must deposit at least 1 cent.");
    }
    this.accountBalance = starterAmount;
  }

  @Override
  public void deposit(double amount) throws IllegalArgumentException {
    if (amount < 0.0) {
      throw new IllegalArgumentException("Amount to deposit cannot be negative.");
    }
    accountBalance += amount;
  }

  @Override
  public double getBalance() {
    return accountBalance;
  }

  /**
   * toString methods returns account balance in dollars/cents format.
   *
   * @return String representing account balance in dollars/cents format
   */
  @Override
  public String toString() {
    return String.format("$%.2f", accountBalance);
  }
}
