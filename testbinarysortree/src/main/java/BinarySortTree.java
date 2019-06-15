    /**
     * 排序的二叉树
     * 1、如果左子树不为空，那么左子树所有节点的值均小于它的根节点的值
     * 2、如果右子树不为空，那么右子树所有节点的值均大于它的根节点的值
     * 3、左、右子树也分别是二叉排序树。
     * @author chenjun
     */
    public class BinarySortTree {
        public NodeOfTree rootNode;//根节点
        public BinarySortTree leftTree; //左子树
        public BinarySortTree rightTree; //右子树

        public BinarySortTree(NodeOfTree rootNode ){ //构造一个只有根节点的树
            this.rootNode = rootNode;
        }

        public void setleftTree(NodeOfTree node){
            leftTree = new BinarySortTree(node);
            rootNode.leftSonNode = leftTree.rootNode;
        }

        public void setrightTree(NodeOfTree node){
            rightTree = new BinarySortTree(node);
            rootNode.rightSonNode = rightTree.rootNode;
        }

        //插入一个节点
        public void insert(NodeOfTree node){
            /**
             * 核心思想：新增节点的值和root中的值比较，比root大插入右边,比root小插入左边，利用递归
             */
                if(node.nodeValue > rootNode.nodeValue){
                    /**
                     * 让右子树去添加节点，如果右子树为空，则新构建一个，并且当前对象的根节点指向右子树的根节点
                     */
                    if(null == rightTree){
                        setrightTree(node);
                    }else {
                        rightTree.insert(node);
                    };
                } else if (node.nodeValue < rootNode.nodeValue) {
                    /**
                     * 让左子树去添加节点，如果左子树为空，则新构建一个，并且当前对象的根节点指向左子树的根节点
                     */
                    if (null == leftTree) {
                        setleftTree(node);
                    } else {
                        leftTree.insert(node);
                    }
                }
        }

        //前序递归遍历二叉树
        public void outPutTree(){
            System.out.print(rootNode.nodeValue +" ");
            if(null != leftTree){
                this.leftTree.outPutTree();
            }
            if(null != rightTree){
                this.rightTree.outPutTree();
            }
        }

        //中序递归遍历二叉树
        public void outPutSortTree(){
            if(null != leftTree){
                this.leftTree.outPutSortTree();
            }
            System.out.print(rootNode.nodeValue +" ");
            if(null != rightTree){
                this.rightTree.outPutSortTree();
            }
        }
    }

