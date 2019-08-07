package arrays;

import linked_structures.LinkedArray;
import linked_structures.Queue;
import linked_structures.Stack;

/**
 * Тестовый класс
 */
public class Program {

    public static void main(String[] args) {
        queueTest();
        stackTest();

        IArray<String> single = new SingleArray<>();
        addValues(single, 10000);
        getValues(single, 10000);

        IArray<String> vector = new VectorArray<>();
        addValues(vector, 1000000);
        getValues(vector, 1000000);

        IArray<String> factor = new FactorArray<>();
        addValues(factor, 1000000);
        getValues(factor, 1000000);

        IArray<String> matrix = new MatrixArray<>(100);
        addValues(matrix, 100000);
        getValues(matrix, 100000);

        IArray<String> linkedArray = new LinkedArray<>();
        addValues(linkedArray, 10000);
        getValues(linkedArray, 10000);
    }

    private static void stackTest() {
        Stack<String> stack = new Stack<>();
        stack.push("John");
        stack.push("Alex");
        stack.push("Irina");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void queueTest() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("John");
        queue.enqueue("Alex");
        queue.enqueue("Irina");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }

    static void addValues(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            array.add(i + "");
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("Add " + array + " " + count + " " + duration + " ms");
    }

    static void getValues(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            array.get(i);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("Get " + array + " " + count + " " + duration + " ms");
    }
}
