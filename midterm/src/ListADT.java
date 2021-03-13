import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface ListADT<T> {

  void addToFront(T t);
  void addToBack(T t);

  int count();
  T get(int i);

  ListADT<T> filter(Predicate<T> p);

  <R> ListADT<R> map(Function<T,R> transformer);

  <R> R fold(BiFunction<T,R,R> combiner, R seed);

  //ListADT<T> mapSameType(Function<T,T> transformer);
}