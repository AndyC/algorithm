package algorithm.sort;

/**
 * @author AndyCui
 * @date 2018/9/24 下午6:45
 * @description 排序模板 包括排序、比较、交换两个元素的位置等方法
 * 各种排序方法时间复杂度总结：
 * O(n^2): 冒泡排序、选择排序、插入排序、希尔排序
 * O（nlogn）:归并排序 快速排序、堆排序
 * O(n):计数排序、基数排序、桶排序
 *
 * 原地排序：指空间复杂度为O（1）的排序算法。 冒泡排序、选择排序、插入排序、快速排序都是原地排序。归并排序不是原地排序。
 *
 * 稳定排序：排序之后原来值相等的两个元素还能保持之前的顺序，选择排序
 */
public abstract class AbstractSort {
    /**
     * 排序
     * @param c 要排序的数组
     */
    public abstract void sort(Comparable[] c);
    /**
     * 比较大小
     */
    public boolean less(Comparable comparable, Comparable comparable1){
        return comparable.compareTo(comparable1)<0;
    }
    /**
     * 交换两个元素的位置
     */
    public void exchange(Comparable[] comparable,int i,int j){
        Comparable t=comparable[i];
        comparable[i]=comparable[j];
        comparable[j]=t;
    }
    /**
     * 判断是否排序
     */
    public boolean isSorted(Comparable[] c){
        for(int i=1;i<c.length;i++){
            if(less(c[i],c[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
