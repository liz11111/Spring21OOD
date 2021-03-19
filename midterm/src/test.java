import java.util.Arrays;

public class test {
  public static void main(String[] args) {
    test test = new test();
    double[] initialGuess = {0, 0};
    System.out.println(Arrays.toString(test.solveNewton(initialGuess)));
  }

  public double[] solveNewton(double[] x0) {
    int iterations = 1000; // 1000 iterations

    for (int i = 0; i < iterations; i++) {
      double[] intermediate = matrixMulti(findInverse(findJacobian(x0)), findF(x0));
      x0[0] = x0[0] - intermediate[0];
      x0[1] = x0[1] - intermediate[1];
    }

    return x0;
  }

  public double[] findF(double[] input) {
    return new double[] {f0(input), f1(input)};
  }

  public double[][] findJacobian(double[] input) {
    double[][] result = {{J00(input), J01(input)}, {J10(input), J11(input)}};
    return result;
  }

  public double[][] findInverse(double[][] J) {
    double[][] adj = {{J[1][1], -J[0][1]}, {-J[1][0], J[0][0]}};
    double det = 1 / (J[0][0] * J[1][1] - J[0][1] * J[1][0]);
    return new double[][] {{det * adj[0][0], det * adj[0][1]}, {det * adj[1][0], det * adj[1][1]}};
  }

  public double[] matrixMulti(double[][] JInv, double[] F) {
    return new double[] {JInv[0][0] * F[0] + JInv[0][1] * F[1], JInv[1][0] * F[0] + JInv[1][1] * F[1]};
  }

  public double J00(double[] input) {
    return 1 + input[1] * Math.cos(input[0] * input[1]);
  }

  public double J01(double[] input) {
    return 1 + input[0] * Math.cos(input[0] * input[1]);
  }

  public double J10(double[] input) {
    return 2 * input[0] * Math.cos(input[0] * input[0] + input[1]);
  }

  public double J11(double[] input) {
    return Math.cos(input[0] * input[0] + input[1]);
  }

  public double f0(double[] input) {
    return input[0] + input[1] + Math.sin(input[0] * input[1]) - 0.2;
  }

  public double f1(double[] input) {
    return Math.sin(input[0] * input[0] + input[1]) - 0.3;
  }
}
