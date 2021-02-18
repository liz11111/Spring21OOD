/**
 * PayCheck class helps calculate employee's paycheck. PayCheck class has attributes employee's
 * name, pay rate and hours.
 */
public class PayCheck {
  private String firstName;
  private String lastName;
  private double payRate;
  private double hours;
  private double totalPay;

  /**
   * Constructor instantiates a paycheck object with employee's name, pay rate and hours
   * worked.
   *
   * @param firstName String employee's first name
   * @param lastName  String employee's last name
   * @param payRate   double employee's pay rate per hour
   * @param hours     double employee's hours worked
   */
  public PayCheck(String firstName, String lastName, double payRate, double hours) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.payRate = payRate;
    this.hours = hours;

    if (hours <= 40.0) {
      this.totalPay = hours * payRate;
    } else {
      this.totalPay = 40.0 * payRate + (hours - 40.0) * (payRate * 1.5);
    }

  }

  /**
   * getFirstName is the getter method for private field firstName.
   *
   * @return firstName String employee's first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * getLastName is the getter method for private field lastName.
   *
   * @return lastName String employee's last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * getPayRate is the getter method for private field payRate.
   *
   * @return payRate double employee's pay rate
   */
  public double getPayRate() {
    return payRate;
  }

  /**
   * getHours is the getter method for private field hours.
   *
   * @return hours double of hours worked
   */
  public double getHours() {
    return hours;
  }


  /**
   * getTotalPay returns total pay of the week.
   *
   * @return double of total pay of the week
   */
  public double getTotalPay() {
    return this.totalPay;
  }

  /**
   * toString returns a string representation of PayCheck object in proper dollars $xxx.yy format.
   *
   * @return String of total pay in $xxx.yy
   */
  public String toString() {
    return "$" + String.format("%.2f", this.totalPay);
  }
}
