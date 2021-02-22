/**
 * Polynomial interface specifies the contract Polynomial(s) will adhere to.
 * It supports common polynomial algebraic operations, such as add a term, remove a term,
 * get degree, get coefficient, evaluate and add two polynomials together.
 */
public interface Polynomial {
  /**
   * addTerm takes a coefficient and a power and addes the resulting term to polynomial.
   *
   * @param coefficient int coefficient of the term
   * @param power int power of the term
   * @throws IllegalArgumentException if power is negative
   */
  public void addTerm(int coefficient, int power) throws IllegalArgumentException;

  /**
   * removeTerm takes a power and removes any and all terms in the polynomial with that power.
   *
   * @param power int power of the terms to remove
   */
  public void removeTerm(int power);

  /**
   * getDegree returns the degree of the polynomial.
   *
   * @return int degree of the polynomial
   */
  public int getDegree();

  /**
   * getCoefficient takes a power and returns the coefficient for the term with that power.
   *
   * @param power int power of the term
   * @return int coefficient of the term
   */
  public int getCoefficient(int power);

  /**
   * evaluate takes a double-precision number and returns double-precision result.
   *
   * @param x double decimal number
   * @return double result of evaluation
   */
  public double evaluate(double x);

  /**
   * add takes another polynomial object and add it to the existing polynomial.
   *
   * @param other Polynomial to be added
   * @return Polynomial result of addition
   */
  public Polynomial add(Polynomial other);

  /**
   * toString returns the string representation of the polynomial.
   *
   * @return String string representation of the polynomial
   */
  public String toString();
}
