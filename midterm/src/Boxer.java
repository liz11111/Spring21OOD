import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Boxer {
  private String name;
  private double weight;
  private WEIGHT_CLASS weightClass;
  public enum WEIGHT_CLASS { FEATHER, MIDDLE, HEAVY };

  public Boxer(String name, double weight) {
    this.name = name;
    this.weight = weight;
    if (weight < 135.0) {
      this.weightClass = WEIGHT_CLASS.FEATHER;
    }
    else if (weight < 180.0 ) {
      this.weightClass = WEIGHT_CLASS.MIDDLE;
    }
    else {
      this.weightClass = WEIGHT_CLASS.HEAVY;
    }
  }
  public String getName() { return this.name; }
  public double getWeight() { return this.weight; }
  public WEIGHT_CLASS getWeightClass() { return this.weightClass;}

  @Override
  public String toString() { return getName(); }

  // Smoke test to verify our boxers
  public static void main(String [] args) {
    List<Boxer> boxers = new ArrayList<>();
    boxers.add(new Boxer("George Foreman", 283.3));
    boxers.add(new Boxer("Sugar Ray Leonard", 155.2));
    boxers.add(new Boxer("Muhammad Ali", 245.5));
    boxers.add(new Boxer("Rocky Marciano", 210.0));
    boxers.add(new Boxer("Manny Pacquiao", 134.2));
    boxers.add(new Boxer("Floyd Mayweather", 134.6));
    BoxerComparator byWeight = new BoxerComparator();

// *** YOU Write the BoxerComparator instantiated in the line above ***

    List<Boxer> sortedByWeight = boxers
            .stream()
            .sorted(byWeight) // YOUR Comparator is used here
            .collect(Collectors.toList());

    System.out.println(sortedByWeight);

    List<Boxer> heavyweights = sortedByWeight
            .stream()
            .filter(b -> b.getWeightClass() == WEIGHT_CLASS.HEAVY)
            .collect(Collectors.toList());
    System.out.println(heavyweights);
  }
}
