package arrays;

/**
 * Одиночный массив
 *
 * @param <T>
 */
public class SingleArray<T> implements IArray {

    private Object[] arr;

    public SingleArray() {
        this.arr = new Object[0];
    }

    @Override
    public void add(Object item) {
        resize();
        arr[size() - 1] = item;
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) arr[index];
    }

    void resize() {
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(arr, 0, newArray, 0, size());
        arr = newArray;
    }
}

