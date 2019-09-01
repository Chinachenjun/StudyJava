import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {
   //@SuppressWarnings({" deprecation", " unused"})
    public static void main(String[] args) throws IllegalAccessException {
        List<String> obj = Arrays.asList(new String[]{" 老马", " 编程"});
        Class<?> cls = obj.getClass();
        for (Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(f.getName() + " - " + f.get(obj));
        }
            Date date = new Date(2017, 4, 12);
            int year = date.getYear();

    }
}
