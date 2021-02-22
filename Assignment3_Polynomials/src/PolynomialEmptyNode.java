/**
 * PolynomialEmptyNode represents a trivial special ending term in a polynomial.
 */
public class PolynomialEmptyNode implements PolynomialNode {
  @Override
  public PolynomialNode addTerm(int coefficient, int power) {
    return new PolynomialElementNode(coefficient, power, this);
  }

  @Override
  public PolynomialNode removeTerm(int power) {
    return this;
  }

  @Override
  public int getDegree() {
    return -1;
  }

  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  @Override
  public double evaluate(double x) {
    return 0;
  }

  @Override
  public String toString() {
    return "";
  }
}
