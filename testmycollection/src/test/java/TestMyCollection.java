import java.util.Iterator;
import java.util.Random;

public class TestMyCollection {
    public static void main(String[] args) {
        MyCollection<Double> myCollection = new MyCollection<Double>();
        Random rnd = new Random();
        int size = 1 + rnd.nextInt(100);
        for (int i = 0; i < size; i++) {
            myCollection.add(Math.random());
        }

        for (int i = 0; i < size; i++) {
            System.out.println(i + ":" + myCollection.get(i));
        }

        System.out.println();
        MyCollection<Double> arr2 = new MyCollection<Double>();
        for (int i = 0; i < 10; i++) {
            arr2.add(Math.random());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + ":" + arr2.get(i));
        }
        System.out.println();

        Iterator<Double> iterator = arr2.iterator();
        int i=0;
        while(iterator.hasNext()){
            System.out.println(i+":"+iterator.next());
            i++;
        }
    }
}
