import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListADTImpl<T> implements ListADT<T> {
  private GenericList<T> head;

  public ListADTImpl() {
    head = new EmptyNode<>();
  }

  private ListADTImpl(GenericList<T> head) {
    this.head = head;
  }

  @Override
  public void addToFront(T t) {
    head = new ElementNode<>(t, head);
  }

  @Override
  public void addToBack(T t) {
    head = head.addToBack(t);
  }

  @Override
  public int count() {
    return head.count();
  }

  @Override
  public T get(int i) {
    return head.get(i);
  }

  @Override
  public ListADT<T> filter(Predicate<T> p) {
    return new ListADTImpl<>(head.filter(p));
  }

  @Override
  public <R> ListADT<R> map(Function<T, R> transformer) {
    return new ListADTImpl<R>(head.map(transformer));
  }

  @Override
  public <R> R fold(BiFunction<T, R, R> combiner, R seed) {
    return head.fold(combiner, seed);
  }
}