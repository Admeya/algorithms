package arrays;

/**
 * Интерфейс динамического массива
 * @param <T> параметр
 */
public interface IArray<T> {

    /**
     * Добавление элемента
     * @param item элемент
     */
    void add (T item);

    /**
     * Размер динамического массива
     */
    int size();

    /**
     * Получение элемента по индексу
     * @param index индекс элемента массива
     * @return элемент
     */
    T get(int index);

    // void add (T item, int index);
    // T remove(int index);

}
