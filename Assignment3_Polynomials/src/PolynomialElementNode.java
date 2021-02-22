/**
 * PolynomialElementNode represents a non-trivial term in the polynomial.
 */
public class PolynomialElementNode implements PolynomialNode {
  private int coefficient;
  private int power;
  private PolynomialNode rest;

  /**
   * Constructor for an element node in the polynomial.
   *
   * @param coefficient int coefficient of a term
   * @param power int power of a term
   * @param rest PolynomialNode object the rest of list object
   */
  public PolynomialElementNode(int coefficient, int power, PolynomialNode rest) {
    this.coefficient = coefficient;
    this.power = power;
    this.rest = rest;
  }

  @Override
  public PolynomialNode addTerm(int coefficient, int power) {
    if (power > this.power) {
      return new PolynomialElementNode(coefficient, power, this);
    } else if (power == this.power) {
      this.coefficient += coefficient;
      if (this.coefficient == 0) {
        return this.rest;
      } else {
        return this;
      }
    } else {
      this.rest = this.rest.addTerm(coefficient, power);
      return this;
    }
  }

  @Override
  public PolynomialNode removeTerm(int power) {
    if (power > this.power) {
      return this;
    } else if (power == this.power) {
      return this.rest;
    } else {
      this.rest = this.rest.removeTerm(power);
      return this;
    }
  }

  @Override
  public int getDegree() {
    return this.power;
  }

  @Override
  public int getCoefficient(int power) {
    if (power > this.power) {
      return 0;
    } else if (power == this.power) {
      return this.coefficient;
    } else {
      return this.rest.getCoefficient(power);
    }
  }

  @Override
  public double evaluate(double x) {
    return this.coefficient * Math.pow(x, this.power) + this.rest.evaluate(x);
  }

  @Override
  public String toString() {
    String result = " ";
    if (this.power == 0) {
      return result + (this.coefficient >= 0 ? "+" : "") + this.coefficient + this.rest.toString();
    } else {
      return result + (this.coefficient >= 0 ? "+" : "") + this.coefficient
              + "x^" + this.power + this.rest.toString();
    }
  }
}
