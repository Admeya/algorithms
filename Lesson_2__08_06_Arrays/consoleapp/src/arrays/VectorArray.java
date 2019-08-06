package arrays;

public class VectorArray<T> implements IArray<T> {

    private Object[] arr;
    private int vector;
    private int size;

    public VectorArray(int vector) {
        this.vector = vector;
        arr = new Object[0];
        size = 0;
    }

    public VectorArray() {

        this(100);
    }

    @Override
    public void add(Object item) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = item;
    }

    void resize() {
        Object[] newArray = new Object[size() + vector];
        //    for (int i = 0; i < size() ; i++) {
        //      newArray[i] = arr[i];
        //
        //    }
        System.arraycopy(arr, 0, newArray, 0, size());
        arr = newArray;
    }

    @Override public int size() {
        return size;
    }

    @Override public T get(int index) {
        return null;
    }
}
