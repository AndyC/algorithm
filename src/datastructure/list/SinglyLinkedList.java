package datastructure.list;

/**
 * @author AndyCui
 * @date 2018/10/16 上午11:44
 * @description 单链表 添加、删除、插入
 */
public class SinglyLinkedList<T> {
    /**
     * 头节点
     */
    private Node head = null;
    /**
     * 结点数量
     */
    private int size;

    public int size() {
        return size;
    }

    /**
     * 在链表末尾添加 单链表的添加需要从头节点开始找 找到尾结点 再进行添加
     */
    public boolean add(T element) {
        Node last = new Node(element, null);
        if (head == null) {
            //如果链表为空 直接设置为头节点
            head = last;
        } else {
            //链表不为空 找尾结点
            Node currentLast=head;
            while(currentLast.next!=null){
                currentLast=currentLast.next;
            }
            //当前尾结点的next指向新节点
            currentLast.next=last;
        }
        size++;
        return true;
    }

    /**
     * 在指定位置添加（元素插入）
     */
    public boolean add(int index, T element) {
        //检查索引位置 插入的位置不能大于链表的长度
        checkPositionIndex(index);
        Node newNode=new Node(element,null);
        if(head==null){
            //链表为空 直接将新节点设为头节点即可
            head=newNode;
        }else if(index==0) {
            //在第一个位置插入
            newNode.next=head;
            head=newNode;
        }else {
            //找index前一个的元素
            Node before=head;
            for(int i=0;i<index-1;i++){
                before=before.next;
            }
            if(before.next==null){
                before.next=newNode;
            }else {
                newNode.next=before.next;
                before.next=newNode;
            }
        }
        size++;
        return true;
    }

    private void checkPositionIndex(int index){
        if(!isPositionIndex(index)){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index){
        return "index："+index+", size:"+size;
    }

    private boolean isPositionIndex(int index){
        return index>=0 && index<=size;
    }

    /**
     * 删除末尾元素
     */
    private void remove() {
        if(size==0){
            return;
        }
        if(size==1){
            //只有一个结点 直接将头节点设为null即可
            head.data=null;
            head=null;
        }else {
            Node node=head;
            Node nodeBefore=null;
            while(node.next!=null){
                nodeBefore=node;
                node=node.next;
            }
            nodeBefore.next=null;
            //help gc
            node.data=null;
        }
        size--;

    }

    /**
     * 删除指定位置元素
     */
    public void remove(int index) {
        //被删除的元素索引范围 0~size-1
        checkElementIndex(index);
        if(size==1){
            //只有一个元素
            head=null;
        }else if(index==0) {
            //删除的是第一个元素
            head.data=null;
            head=head.next;
        }else {
            Node before=head;
            for(int i=0;i<index-1;i++){
                before=before.next;
            }
            before.next=before.next.next;
        }
        size--;
    }

    private void checkElementIndex(int index){
        if(!isElementIndex(index)){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isElementIndex(int index){
        return index>=0 && index<size;
    }

    public void printAll(){
        Node start=head;
        while(start!=null){
            System.out.print(start.data+" ");
            start=start.next;
        }
    }

    private class Node {
        /**
         * 数据
         */
        private T data;
        /**
         * 指向下一节点
         */
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 反转
     */
    public void reverse(){
        //链表为空或者只有一个结点 不需要反转
        if(head==null || head.next==null){
            return;
        }
        head=reverseImpl(head);
    }

    /**
     * 反转 递归实现 注意在递归过程中记录头节点的位置
     */
    public Node reverseImpl(Node node){
        if(node==null || node.next==null){
            return node;
        }
        final Node reHead = reverseImpl(node.next);
        node.next.next=node;
        node.next=null;
        return reHead;
    }

    /**
     * 反转 遍历实现
     */
    public void traverse(){
        //链表为空或者只有一个节点 不需要反转
        if(head==null || head.next==null){
            return;
        }
        Node currentHead=head.next;
        Node last=head;
        while(currentHead!=null){
            Node temp=currentHead.next;
            currentHead.next=head;
            head=currentHead;
            currentHead=temp;
        }
        last.next=null;
    }

    public static void main(String[] args) {
    }
}
