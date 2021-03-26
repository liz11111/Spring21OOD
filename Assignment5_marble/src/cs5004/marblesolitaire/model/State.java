package cs5004.marblesolitaire.model;

/**
 * Enum class that contains possible states of the game.
 */
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
