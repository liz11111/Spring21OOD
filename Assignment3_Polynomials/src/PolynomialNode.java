/**
 * PolynomialNode interface represents all operations for a node in a list of Polynomial.
 */
public interface PolynomialNode {
  /**
   * addTerm adds a new node to the polynomial.
   *
   * @param coefficient int coefficient of the new term
   * @param power       int power of the new term
   */
  public PolynomialNode addTerm(int coefficient, int power);

  /**
   * removeTerm removes a node with given power.
   *
   * @param power int power of the node to remove
   */
  public PolynomialNode removeTerm(int power);

  /**
   * getDegree returns the degree of the polynomial.
   *
   * @return int degree of the polynomial
   */
  public int getDegree();

  /**
   * getCoefficient returns the coefficient of the term with given power.
   *
   * @param power int power of the term to get coefficient
   * @return int coefficient of the term
   */
  public int getCoefficient(int power);

  /**
   * evaluate takes in a double-precision number and returns the double-precision result.
   *
   * @return double result of evaluation
   */
  public double evaluate(double x);

  /**
   * toString returns the string representation of the polynomial.
   *
   * @return String string representation of the polynomial
   */
  public String toString();
}
