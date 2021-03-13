import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

class ElementNode<T> implements GenericList<T> {
  private T t;
  private GenericList<T> rest;

  ElementNode(T t, GenericList<T> rest) {
    this.t = t;
    this.rest = rest;
  }

  @Override
  public GenericList<T> addToBack(T t) {
    return new ElementNode<T>(this.t, rest.addToBack(t));
  }

  @Override
  public int count() {
    return 1 + rest.count();
  }

  @Override
  public GenericList<T> filter(Predicate<T> p) {
    return null;
  }

  @Override
  public <R> GenericList<R> map(Function<T, R> transformer) {
    return new ElementNode<R>(transformer.apply(t), rest.map(transformer));
  }

  @Override
  public T get(int i) {
    if (i == 0) {
      return t;
    } else {
      return rest.get(i - 1);
    }
  }

  @Override
  public <R> R fold(BiFunction<T, R, R> combiner, R seed) {
    //return combiner.apply(this.t, rest.fold(combiner, seed));
    return rest.fold(combiner, combiner.apply(this.t, seed));
  }
}