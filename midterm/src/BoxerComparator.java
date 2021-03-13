import java.util.Comparator;

public class BoxerComparator implements Comparator<Boxer> {
  @Override
  public int compare(Boxer o1, Boxer o2) {
    if (o1.getWeight() == o2.getWeight()) {
      return 0;
    }
    return o1.getWeight() < o2.getWeight() ? -1 : 1;
  }
}
