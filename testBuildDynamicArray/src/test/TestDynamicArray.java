import java.util.Random;

public class TestDynamicArray {
    public static void main(String[] args) {
        DynamicArray<Double> arr = new DynamicArray<Double>();
        Random rnd = new Random();
        int size = 1 + rnd.nextInt(100);
        for (int i = 0; i < size; i++) {
            arr.add(Math.random());
        }

        for (int i = 0; i < size; i++) {
            System.out.println(i+":"+arr.get(i));
        }

        System.out.println();
        DynamicArray<Double> arr2 = new DynamicArray<Double>();
        for (int i = 0; i < 10; i++) {
            arr2.add(Math.random());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i+":"+arr2.get(i));
        }
        System.out.println();
//        arr2.remove(0);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i+":"+arr2.get(i));
//        }
        DynamicArrayIterator dynamicArrayIterator = new DynamicArrayIterator(arr2);

        for (int i = 0; i < 10; i++) {
            dynamicArrayIterator.hasNext();
            dynamicArrayIterator.next();
            if(i>5) {
                dynamicArrayIterator.remove();
            }
        }

        dynamicArrayIterator = new DynamicArrayIterator(arr2);
        while (dynamicArrayIterator.hasNext()) {
            System.out.println(dynamicArrayIterator.next());
        }

    }
}
