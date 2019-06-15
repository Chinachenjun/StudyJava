import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {
//        Map<String, String> map = new TreeMap<String, String>();
        Map<String, String> map = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);

//        Map<String, String> map = new TreeMap<String, String>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        Map<String, String> map = new TreeMap<String, String>(Collections.<String>reverseOrder());
        map.put(" a", "abstract");
        map.put(" c", "call");
        map.put(" b", "basic");
        map.put(" T", "tree");
        map.put(" t", "tree1");
        for (Map.Entry<String, String> kv : map.entrySet()) {
            System.out.print(kv.getKey() + "=" + kv.getValue() + " ");
        }

        //马俊昌. Java编程的逻辑 (Java核心技术系列) (Kindle 位置 5163-5166). 北京华章图文信息有限公司. Kindle 版本.


        Map<String, Integer> map1 = new TreeMap<String, Integer>(new Comparator<String>() {
            SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd");

            @Override
            public int compare(String o1, String o2) {
                try {
                    return sdf.parse(o1).compareTo(sdf.parse(o2));
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        });
        map1.put(" 2016-7-3", 100);
        map1.put(" 2016-7-10", 120);
        map1.put(" 2016-8-1", 90);

        for (Map.Entry<String, Integer> kv : map1.entrySet()) {
            System.out.print(kv.getKey() + "=" + kv.getValue() + " ");
        }

//        马俊昌.Java编程的逻辑(Java核心技术系列) (Kindle 位置 5191 - 5192).北京华章图文信息有限公司.Kindle 版本.
    }
}
