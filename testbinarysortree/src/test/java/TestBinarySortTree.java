import java.util.Random;

public class TestBinarySortTree {
    public static void main(String[] args) {
        NodeOfTree rootNode = new NodeOfTree(10);
        BinarySortTree binarySortTree = new BinarySortTree(rootNode);
        Random r = new Random();
        int array[] = new int[20];

        for(int i=0;i<20;i++){
            int j=r.nextInt(20);
            array[i] =j;
        }

        for (int i : array) {
            System.out.print(i+ " ");
            binarySortTree.insert(new NodeOfTree(i));
        }

        System.out.println();

        System.out.println("前序");
        binarySortTree.outPutTree();

        System.out.println();

        System.out.println("中序");
        binarySortTree.outPutSortTree();



    }
}
