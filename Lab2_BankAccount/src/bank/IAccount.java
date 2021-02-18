package bank;

/**
 * This interface represents a bank account. It is the super-type for any other type of traditional
 * financial account a bank might offer
 */

public interface IAccount {
  /**
   * deposit method takes a double amount and deposit into the account.
   *
   * @param amount double the amount to be deposited
   */
  void deposit(double amount);

  /**
   * withdraw method reduces the account balance by the amount specified.
   *
   * @param amount double the amount to be withdrawn
   * @return boolean indicating state of transaction
   */
  boolean withdraw(double amount);

  /**
   * getBalance method returns the account balance.
   *
   * @return double the account balance
   */
  double getBalance();

  /**
   * performMonthlyMaintenance charge fees and reset transaction counter to zero if applicable.
   */
  void performMonthlyMaintenance();
}
