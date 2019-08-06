package arrays;

/**
 * Реализация динамического массива с увеличением массива на константную величину
 * при исчерпании свободного места в массиве
 */
public class VectorArray<T> implements IArray<T> {

    /**
     * Внутренний массив элементов
     */
    private Object[] arr;
    /**
     * Количество элементов, которое будет зарезервировано для вставки будущих элементов
     */
    private int vector;
    /**
     * Фактическое число элементов в массиве
     */
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
        System.arraycopy(arr, 0, newArray, 0, size());
        arr = newArray;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        return (T) arr[index];
    }
}
