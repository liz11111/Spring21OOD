package cs5004.marblesolitaire.model;

public enum State {
  Marble {
    public String toString() {
      return "O";
    }
  },
  Empty {
    public String toString() {
      return "_";
    }
  },
  Invalid {
    public String toString() {
      return " ";
    }
  };
}
