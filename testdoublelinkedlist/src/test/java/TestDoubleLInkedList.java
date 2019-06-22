import java.util.ListIterator;
import java.util.Random;

public class TestDoubleLInkedList {
    public static void main(String[] args) {
        DoubleLinkedList<Double> myList = new DoubleLinkedList<Double>();
        Random rnd = new Random();
        int size = 1 + rnd.nextInt(100);

//        for (int i = 0; i < size; i++) {
//            myList.add(Math.random());
//        }

//        for (int i = 0; i < size; i++) {
//            System.out.println(i + ":" + myList.get(i));
//        }

        System.out.println();

//        ListIterator<Double> lit = myList.listIterator(0);
//        while (lit.hasNext()) {
//            System.out.println(lit.nextIndex() + ":" + lit.next());
//        }

        ListIterator<Double> lit2 = myList.listIterator(0);
        int int1 = lit2.nextIndex();
        while (int1<50) {
            lit2.add((double)int1);
            int1 = lit2.nextIndex();
        }


        System.out.println();
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(i + ":" + myList.get(i));
        }

    }
}
