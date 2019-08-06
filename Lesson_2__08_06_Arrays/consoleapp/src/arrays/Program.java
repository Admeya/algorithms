package arrays;

public class Program {
    public static void main(String[] args) {
        IArray<String> single = new SingleArray<>();
        addValues(single, 1000000);

        IArray<String> vector = new VectorArray<>();
        addValues(vector, 1000000);

        IArray<String> factor = new FactorArray<>();
        addValues(factor, 1000000);
    }

    static void addValues(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            array.add(i + "");
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + count + " " + duration + " ms");
    }
}
