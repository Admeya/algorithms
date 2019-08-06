package arrays;

public class FactorArray<T> implements IArray<T> {

    private Object[] arr;
    private int factor;
    private int size;

    public FactorArray() {
        factor = 100;
        arr = new Object[10];
        size = 0;
    }

    @Override public void add(T item) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = item;
    }

    @Override public int size() {
        return 0;
    }

    @Override public T get(int index) {
        return (T)arr[index];
    }

    void resize() {
        Object[] newArray = new Object[arr.length + factor/ 100];
        System.arraycopy(arr, 0, newArray, 0, arr.length);
        arr = newArray;
    }
}
