public class TestEnum {
    public static void main(String[] args) {
        Size size = Size.SMALL;
        System.out.println(size.toString());
        System.out.println(size.name());

        System.out.println(size == Size.SMALL);
        System.out.println(size.equals(Size.SMALL));
        System.out.println(size == Size.MEDIUM);
        System.out.println(size.ordinal());
        System.out.println(size.compareTo(Size.MEDIUM));
        System.out.println(Size.SMALL == Size.valueOf("SMALL"));
        for (Size size1 : Size.values()){
            System.out.println(size1);
        }
//        马俊昌. Java编程的逻辑 (Java核心技术系列) (Kindle位置2428). 北京华章图文信息有限公司. Kindle 版本.
//        马俊昌. Java编程的逻辑 (Java核心技术系列) (Kindle 位置 2411-2412). 北京华章图文信息有限公司. Kindle 版本.
    }
}
