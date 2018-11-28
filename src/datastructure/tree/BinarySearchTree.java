package datastructure.tree;

/**
 * @author AndyCui
 * @date 2018/11/9 上午11:59
 * @description 二叉查找树
 * 二叉树：二叉树是一棵树 其中每个结点都不能有多于两个的儿子。二叉树的一个性质是一棵平均二叉树的深度要比结点个数N小得多，
 * 平均深度为O（根号N） 二叉查找树的平均深度为O（logN）
 * 二叉查找树：对于一个二叉树中的任意结点X，如果X的左子树的每个项的值都小于X的值并且右子树的所有项的值都大于X的值，这样的二叉树叫做二叉查找树。
 * 二叉查找树是一种将链表插入的灵活性和有序数组查找的高效性结合起来的符号表实现。
 * 二叉查找树的重要应用是在查找中的使用（为什么会有树？链表的插入和删除操作很快，但是对于大量的输入数据，线性的查找时间O（N）很慢）。
 * 二叉查找树和二分查找一样，插入和查找的时间复杂度都为lgN,但是在最坏情况下仍然会有N的时间复杂度。原因是插入和删除元素的时候，树没有保持平衡。
 *
 *
 * 2-3查找树的定义： 一棵2-3查找树要么是一棵空树要么由以下结点组成:
 * (1)2-结点： 含有一个键（及其对应的值）和两条链接，左链接指向的2-3树中的键都小于该结点，右链接指向的2-3树中的键都大于该结点。
 *（2）3-结点：含有两个键（及其对应的值）和三条链接，左链接指向的2-3树中的键都小于该结点，中链接指向的2-3树中的键都位于该结点的两个键之间，
 * 右链接指向的2-3树中的键都大于该结点。
 */
public class BinarySearchTree<T extends Comparable> {
    /**
     * 根结点
     */
    private BinarySearchTreeNode<T> root;
    public BinarySearchTree(){
        this(null);
    }
    public BinarySearchTree(BinarySearchTreeNode<T> root){
        this.root=root;
    }

    public boolean contains(T t){
        return contains(t,this.root);
    }
    /**
     * 判断树中是否包含某个元素 递归 递归中如果当前节点小于要查找的值 则从右子树中查找
     * 大于要找的值 从左子树查找 等于要找的值 就是当前节点
     */
    private boolean contains(T t,BinarySearchTreeNode node){
        if(node==null){
            /*  1  2 3 4  6   8 */
            return false;
        }
        if(t.compareTo(node.element)==0){
            return true;
        }else if(t.compareTo(node.element)<0){
            return contains(t,node.rightChild);
        }else {
            return contains(t,node.leftChild);
        }
    }

    public BinarySearchTreeNode<T> getMin(){
        return getMin(root);
    }

    /**
     * 递归获取最小结点
     */
    private BinarySearchTreeNode<T> getMin(BinarySearchTreeNode<T> node){
        if(node==null){
            return null;
        }
        if(node.leftChild==null){
            return node;
        }
        return getMin(node.leftChild);
    }

    public BinarySearchTreeNode getMax(){
        return getMax(root);
    }
    /**
     * while循环获取最大结点
     */
    private BinarySearchTreeNode getMax(BinarySearchTreeNode node){
        if(node!=null){
            while(node.rightChild!=null){
                node=node.rightChild;
            }
        }
        return node;
    }

    /**
     * 向二叉搜索树中插入一个结点
     */
    public BinarySearchTreeNode<T> insert(T t){
        //如果当前二叉树没有根结点 直接将要插入的结点作为根结点即可
        if(this.root==null){
            BinarySearchTreeNode root=new BinarySearchTreeNode(t,null,null);
            this.root=root;
            return root;
        }
        //有根结点 调用递归插入方法
        return insert(t,this.root);
    }

    private BinarySearchTreeNode<T> insert(T t,BinarySearchTreeNode<T> node){
        //最终的终结条件 如果要插入的位置没有结点 直接将其插入即可
        if(node==null){
            return new BinarySearchTreeNode(t,null,null);
        }
        final int compareResult = t.compareTo(node.element);
        if(compareResult>0){
            node.rightChild=insert(t,node.rightChild);
        }else if(compareResult<0){
            node.leftChild=insert(t,node.leftChild);
        }else {
            //存在该结点 不做任何操作
        }
        return node;
    }

    /**
     * 删除某个结点
     */
    public BinarySearchTreeNode<T> remove(T t){
        return remove(t,this.root);
    }

    private BinarySearchTreeNode<T> remove(T t,BinarySearchTreeNode<T> node){
        //没有该结点 直接忽略
        if(node==null){
            return null;
        }
        final int compareResult = t.compareTo(node.element);
        if(compareResult<0){
            node.leftChild=remove(t,node.leftChild);
        }else if(compareResult>0){
            node.rightChild=remove(t,node.rightChild);
        }else if(node.leftChild!=null && node.rightChild!=null){
            //要删除的结点有两个子节点  用其右子树的最小的数据代替该节点的数据并递归的删除那个节点
            node.element=getMin(node.rightChild).element;
            node.rightChild=remove(node.element,node.rightChild);
        }else {
            //要删除的结点是叶子结点 直接删除
            // 不是叶子结点但是只有一个子节点（子树）直接改变要删除节点的指向即可 只有左子树指向左子树 只有右子树指向右子树即可
            node=(node.leftChild==null)?node.rightChild:node.leftChild;
        }
        return node;
    }


    /**
     * 前序遍历 对于一棵树 先遍历根、再遍历左子树 最后遍历右子树
     */
    private void preOrderTraversal(){
        if(this.root==null){
            System.out.println("this binarySearchTree is null");
            return;
        }
        preOrderTraversal(this.root);
    }

    private void preOrderTraversal(BinarySearchTreeNode<T> node){
        if(node==null){
            return;
        }
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 中序遍历 对于一棵树 先左子树 再根 再右子树 中序遍历会得到排好序的序列
     */
    private void inOrderTraversal(){
        if(this.root==null){
            System.out.println("this binarySearchTree is null");
            return;
        }
        inOrderTraversal(this.root);
    }

    private void inOrderTraversal(BinarySearchTreeNode<T> node){
        if(node==null){
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.element+" ");
        inOrderTraversal(node.rightChild);
    }

    /**
     * 后续遍历 对于一棵树 先左子树 再右子树 最后根
     */
    private void postOrderTraversal(){
        if(this.root==null){
            System.out.println("this binarySearchTree is null");
            return;
        }
        postOrderTraversal(this.root);
    }

    private void postOrderTraversal(BinarySearchTreeNode<T> node){
        if(node==null){
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.element+" ");
    }

    /**
     * 删除最小值
     */
    public void deleteMin(){
        if(root==null){
            return;
        }
        deleteMin(root);
    }

    private BinarySearchTreeNode<T> deleteMin(BinarySearchTreeNode<T> node){
        if(node.leftChild==null){
            return node.rightChild;
        }
        node.leftChild=deleteMin(node.leftChild);
        return node;
    }

    /**
     * 删除最大值
     */
    public void deleteMax(){
        if(root==null){
            return;
        }
        deleteMax(root);
    }

    private BinarySearchTreeNode<T> deleteMax(BinarySearchTreeNode<T> node){
        if(node.rightChild==null){
            return node.leftChild;
        }
        node.rightChild=deleteMax(node.rightChild);
        return node;
    }


    private static class BinarySearchTreeNode<T> {
        /**
         * 结点元素
         */
        T element;
        /**
         * 指向左子树的引用（实际上是左子节点的引用）
         */
        BinarySearchTreeNode<T> leftChild;
        /**
         * 指向右子树的引用（实际上是右子节点的引用）
         */
        BinarySearchTreeNode<T> rightChild;

        BinarySearchTreeNode(T element) {
            this(element, null, null);
        }

        BinarySearchTreeNode(T element, BinarySearchTreeNode leftChild, BinarySearchTreeNode rightChild) {
            this.element = element;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree=new BinarySearchTree(new BinarySearchTreeNode(11,null,null));
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(0);
        binarySearchTree.insert(17);
        binarySearchTree.insert(14);
        binarySearchTree.insert(12);
        binarySearchTree.insert(15);
        binarySearchTree.insert(31);
        binarySearchTree.insert(16);
        binarySearchTree.insert(42);
        binarySearchTree.inOrderTraversal();
        binarySearchTree.remove(0);
        binarySearchTree.inOrderTraversal();
        binarySearchTree.remove(14);
        binarySearchTree.inOrderTraversal();
        binarySearchTree.insert(22);
        binarySearchTree.inOrderTraversal();
        binarySearchTree.remove(17);
        binarySearchTree.inOrderTraversal();
    }
}
