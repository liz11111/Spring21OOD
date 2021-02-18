/**
 * Employee class represents a hourly paid employee. Employee class has attributes employee name,
 * hours worked per week and a pay rate.
 */


public class Employee {
  private String firstName;
  private String lastName;
  private double hours;
  private double payRate;

  /**
   * Constructor for employee instances initializes employee's name and pay rate according to
   * parameters. It also initializes hours worked to 0;
   *
   * @param firstName String employee's first name
   * @param lastName  String employee's last name
   * @param payRate   double employee's pay rate per hour
   */
  public Employee(String firstName, String lastName, double payRate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.payRate = payRate;
    this.hours = 0.0;
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
   * getHours is the getter method for private field hours.
   *
   * @return hours double of hours worked
   */
  public double getHours() {
    return hours;
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
   * addHoursWorked takes a double and add that to hours worked.
   *
   * @param addHours double additional hours worked
   */
  public void addHoursWorked(double addHours) {
    this.hours += addHours;
  }

  /**
   * resetHoursWorked resets hours worked to 0.
   */

  public void resetHoursWorked() {
    this.hours = 0.0;
  }

  /**
   * getWeeklyCheck returns a new PayCheck object with employee's name, pay rate and hours worked.
   *
   * @return PayCheck obj of employee's information
   */
  public PayCheck getWeeklyCheck() {
    return new PayCheck(firstName, lastName, payRate, hours);
  }

  /**
   * toString method allows Employee object to be represented by employee's name in string format.
   *
   * @return String representing Employee object
   */
  public String toString() {
    return "" + this.firstName + " " + this.lastName;
  }
}
