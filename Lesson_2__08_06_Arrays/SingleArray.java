package arrays;

public class SingleArray<T> implements IArray {

  private Object[] arr;

  public SingleArray() {
    this.arr = new Object[0];
  }

  @Override public void add(Object item) {
    resize();
    arr[size()-1] = item;

  }

  @Override public int size() {
    return arr.length;
  }

  @Override
  @SuppressWarnings("unchecked")
  public Object get(int index) {
    return (T) arr[index];
  }

  void resize() {
    Object[] newArray = new Object[size() + 1];
//    for (int i = 0; i < size() ; i++) {
//      newArray[i] = arr[i];
//
//    }
    System.arraycopy(arr, 0, newArray, 0, size());
    arr = newArray;
  }
}
