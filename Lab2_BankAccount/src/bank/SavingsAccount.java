package bank;

/**
 * bank.SavingsAccount class is a sub-class of bank.BankAccount that supports banking behaviors.
 * Number of withdrawals must be less than or equal to 6 to avoid charges.
 */

public class SavingsAccount extends BankAccount {
  private int withdrawal;

  public SavingsAccount(double starterAmount) throws IllegalArgumentException {
    super(starterAmount);
  }

  /**
   * withdraw method allows customer to withdraw from savings account.
   *
   * @param amount double the amount to be withdrawn
   * @return whether the operation is successful
   */
  @Override
  public boolean withdraw(double amount) {
    if (amount > accountBalance || amount <= 0.0) {
      return false;
    } else {
      accountBalance -= amount;
      withdrawal += 1;
      return true;
    }
  }

  /**
   * performMonthlyMaintenance method assesses monthly fees and give a "clean slate". If number of
   * withdrawals is greater than 6, a penalty fee of $14 will be charged.
   */
  @Override
  public void performMonthlyMaintenance() {
    if (withdrawal > 6) {
      accountBalance -= 14;
    }
    withdrawal = 0;
  }

}
