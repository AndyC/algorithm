package datastructure.tree;

/**
 * @author AndyCui
 * @date 2018/12/2 1:28 PM
 * @description 红黑树
 * 红黑树的定义： 红黑树是含有红黑链接并满足下列条件的一颗树：
 * （1）红连接均为左链接
 * （2）没有任何一个结点同时和两条红链接相连
 * （3）该数是完美黑色平衡的，即任意空连接到根节点的路径上的黑色连接树相同
 *  红黑树既是二叉查找树也是2-3树，因此可以将二叉查找树的高效查找算法和2-3树的平衡插入算法结合起来
 */
public class RedBlackBSTree<T extends Comparable> {
    private static final boolean RED=true;
    private static final boolean BLACK=false;
    private class Node<T>{
        /**
         * 数据
         */
        private T element;
        /**
         * 左子树
         */
        private Node<T> leftChild;
        /**
         * 右子树
         */
        private Node<T> rightChild;
        /**
         * 由其父节点指向它的连接的颜色
         */
        private boolean color;

    }
}
