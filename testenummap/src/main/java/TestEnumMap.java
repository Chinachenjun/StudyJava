import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class TestEnumMap {
    public static void main(String[] args) {
        Clothes[] C1 = new Clothes[]{
                new Clothes("1",Size.LARGE),
                new Clothes("2",Size.LARGE),
                new Clothes("3",Size.LARGE),
                new Clothes("4",Size.SMALL),
                new Clothes("5",Size.MEDIUM),
                new Clothes("6",Size.LARGE),
        };
        List<Clothes> l1 = Arrays.asList(C1);
        for(Clothes c : l1){
            System.out.println(c);
        }

//        int[] ints= countBySize(l1);
//
//        for (int i = 0;i<ints.length;i++){
//            System.out.println(Size.values()[i] + ": "+ints[i]);
//        }
        System.out.println(countBySize2(l1));




    }
    public static int[] countBySize(List<Clothes> clothes){
        int [] ints = new int[Size.values().length];
        for(Clothes c : clothes){
            ints[c.size.ordinal()]++;
        }
        return ints;
    }
    public static Map<Size,Integer> countBySize2(List<Clothes> clothes){
        Map<Size, Integer> maps = new EnumMap<Size,Integer>(Size.class);

        for(Clothes c : clothes){
            if(maps.get(c.size)!=null){
                maps.put(c.size,maps.get(c.size) + 1);
            }else maps.put(c.size,1);
        }
        return maps;
    }
}
