import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

class EmptyNode<T> implements GenericList<T> {

  @Override
  public GenericList<T> addToBack(T t) {
    return new ElementNode<>(t, this);
  }

  @Override
  public int count() {
    return 0;
  }

  @Override
  public GenericList<T> filter(Predicate<T> p) {
    return this;
  }

  @Override
  public <R> GenericList<R> map(Function<T, R> transformer) {
    return new EmptyNode<R>();
  }

  @Override
  public T get(int i) {
    throw new IndexOutOfBoundsException("No such element");
  }

  @Override
  public <R> R fold(BiFunction<T, R, R> combiner, R seed) {
    return seed;
  }
}
