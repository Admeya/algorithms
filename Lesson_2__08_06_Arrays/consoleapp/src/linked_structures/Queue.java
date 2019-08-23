package linked_structures;

/**
 * Реализация очереди
 */
public class Queue<T> {
    /**
     * Указатель на начало
     */
    private Node<T> head;
    /**
     * Указатель на конец
     */
    private Node<T> tail;

    public Queue() {
        this.head = tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Добавление элемента
     * @param item элемент
     */
    public void enqueue(T item) {
        Node<T> node = new Node<T>(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            T item = head.getItem();
            head = head.getNext();
            return item;
        }

    }
}
