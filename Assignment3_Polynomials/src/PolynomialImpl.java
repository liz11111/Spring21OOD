/**
 * PolynomialImpl provides implementation to specific contracts defined by polynomial interface.
 */
public class PolynomialImpl implements Polynomial {
  private PolynomialNode head;

  /**
   * Constructor to create an empty polynomial 0.
   */
  public PolynomialImpl() {
    head = new PolynomialElementNode(0, 0, new PolynomialEmptyNode());
  }

  /**
   * Constructor that takes in a string and parse it to a polynomial.
   *
   * @param in String representation of polynomial
   * @throws IllegalArgumentException if trying to initialize a term with negative power
   */
  public PolynomialImpl(String in) throws IllegalArgumentException {
    this();

    String[] array = in.split(" ");
    for (int i = 0; i < array.length; i++) {
      String term = array[i];
      int xPos = term.indexOf('x');
      if (xPos < 0) {
        addTerm(Integer.parseInt(term), 0);
      } else {
        int coefficient = Integer.parseInt(term.substring(0, xPos));
        int power = Integer.parseInt(term.substring(xPos + 2));
        addTerm(coefficient, power);
      }
    }
  }

  /**
   * addTerm takes a coefficient and a power and addes the resulting term to polynomial.
   *
   * @param coefficient int coefficient of the term
   * @param power       int power of the term
   * @throws IllegalArgumentException if power is negative
   */
  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be negative.");
    }

    if (coefficient == 0) {
      return;
    }

    head = head.addTerm(coefficient, power);

    if (getDegree() != -1 && getCoefficient(0) == 0) {
      removeTerm(0);
    }
    reinitialize();
  }

  @Override
  public void removeTerm(int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be negative.");
    }

    head = head.removeTerm(power);
    reinitialize();
  }

  @Override
  public int getDegree() {
    return head.getDegree();
  }

  @Override
  public int getCoefficient(int power) {
    return head.getCoefficient(power);
  }

  @Override
  public double evaluate(double x) {
    return head.evaluate(x);
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException("Cannot add a polynomial of a different type.");
    }

    String p1 = this.toString();
    String p2 = other.toString();
    String combined = p1 + (p2.charAt(0) == '-' ? " " : " +") + p2;
    return new PolynomialImpl(combined);
  }

  @Override
  public String toString() {
    String result = head.toString();
    if (result.charAt(1) == '+') {
      return result.substring(2);
    } else {
      return result.substring(1);
    }
  }

  /**
   * reinitialize the polynomial when the last elementNode has been removed.
   */
  private void reinitialize() {
    if (getDegree() == -1) {
      head = new PolynomialElementNode(0, 0, new PolynomialEmptyNode());
    }
  }
}
