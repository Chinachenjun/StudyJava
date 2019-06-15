/**
 * 二叉树的节点
 * @author chenjun
 */

public class NodeOfTree {
    public Integer nodeValue;//每一个节点的值
    public NodeOfTree leftSonNode;//左子节点
    public NodeOfTree rightSonNode;//右子节点

    public NodeOfTree(Integer nodeValue){ //根据指定的值构建节点
        this.nodeValue = nodeValue;
    }

    @Override
    public String toString() {
        return nodeValue.toString();
    }
}
