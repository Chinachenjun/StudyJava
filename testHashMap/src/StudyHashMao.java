import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StudyHashMao {

    public static void main(String[] args) {
        Random rnd = new Random();
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>(16,7);
        for (int i = 0; i < 1000; i++) {
            int num = rnd.nextInt(4);
            Integer count = countMap.get(num);
            if (count == null) {
                countMap.put(num, 1);
            } else {
                countMap.put(num, count + 1);
            }
        }
        for (Map.Entry<Integer, Integer> kv : countMap.entrySet()) {
            System.out.println(kv.getKey() + "," + kv.getValue());
        }

        //马俊昌. Java编程的逻辑 (Java核心技术系列) (Kindle 位置 4820-4824). 北京华章图文信息有限公司. Kindle 版本.
    }

}
