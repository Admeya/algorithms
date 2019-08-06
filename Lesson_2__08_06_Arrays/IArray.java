package arrays;

public interface IArray<T> {
  void add (T item);

  int size();

  T get(int index);

 // void add (T item, int index);
  // T remove(int index);

}
