import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{8, 5, 3, 6, 2, 19, 21});
        System.out.println(list.subList(1, 5));

        Collections.rotate(list.subList(1, 5), 2);
        System.out.println(list);
    }
}
