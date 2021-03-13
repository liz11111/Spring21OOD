import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

interface GenericList<T> {
  GenericList<T> addToBack(T t);
  int count();

  GenericList<T> filter(Predicate<T> p);

  <R> GenericList<R> map(Function<T, R> transformer);

  T get(int i);

  <R> R fold(BiFunction<T, R, R> combiner, R seed);
}