package arrays;

/**
 * Массив массивов для реализации динамического массива
 */
public class MatrixArray<T> implements IArray<T> {
    private IArray<IArray<T>> arr;
    private int vector;
    private int size;

    public MatrixArray(int vector) {
        this.vector = vector;
        arr = new SingleArray<>();
        size = 0;

    }

    @Override
    public void add(T item) {
        if (size == arr.size() * vector) {
            arr.add(new VectorArray<>(vector));
        }
        arr.get(size/vector).add(item);
    }

    @Override public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return null;
    }
}
