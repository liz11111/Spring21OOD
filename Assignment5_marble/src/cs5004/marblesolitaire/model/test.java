package cs5004.marblesolitaire.model;

public class test {
  public static void main(String[] args) {
    MarbleSolitaireModelImpl m = new MarbleSolitaireModelImpl(4, 0, 5);
    String s = m.getGameState();
    System.out.println(m);
  }
}
