package bank;

/**
 * bank.CheckingAccount is a sub-class of bank.BankAccount that supports banking behaviors. An
 * account balance of at least $100 is required at all times to avoid fees.
 */

public class CheckingAccount extends BankAccount {
  private boolean penaltyCharge;
  private static double threshold = 100.0;

  /**
   * Constructor that helps instantiate CheckingAccount objects.
   * If starter amount is below $100, a penalty fee will be charged
   * @param starterAmount double starter amount
   * @throws IllegalArgumentException if starter amount is less than 0.01
   */
  public CheckingAccount(double starterAmount) throws IllegalArgumentException {
    super(starterAmount);
    if (starterAmount < CheckingAccount.threshold) {
      penaltyCharge = true;
    }
  }

  /**
   * withdraw method allows customer to withdraw from checking account. If balance falls below $100
   * as a result of an withdrawal, a penalty fee would be charged during maintenance.
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
      if (accountBalance < CheckingAccount.threshold) {
        penaltyCharge = true;
      }
      return true;
    }
  }

  /**
   * performMonthlyMaintenance method assesses monthly fees and give a "clean slate". If the balance
   * falls below $100 at any time, a penalty fee of $5 is charged.
   */
  @Override
  public void performMonthlyMaintenance() {
    if (accountBalance < CheckingAccount.threshold) {
      penaltyCharge = true;
    }
    if (penaltyCharge) {
      accountBalance -= 5;
    }
    if (accountBalance >= CheckingAccount.threshold) {
      penaltyCharge = false;
    } else {
      penaltyCharge = true;
    }
  }

}
