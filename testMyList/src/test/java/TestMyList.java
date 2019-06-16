import java.util.Iterator;
import java.util.Random;

public class TestMyList {
    public static void main(String[] args) {
        MyList<Double> myList = new MyList<Double>();
        Random rnd = new Random();
        int size = 1 + rnd.nextInt(100);
        for (int i = 0; i < size; i++) {
            myList.add(Math.random());
        }

        for (int i = 0; i < size; i++) {
            System.out.println(i + ":" + myList.get(i));
        }

        System.out.println();
        MyList<Double> arr2 = new MyList<Double>();
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
