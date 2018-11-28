package algorithm.sort;

import java.util.Arrays;

/**
 * @author AndyCui
 * @date 2018/9/25 下午1:28
 * @description 希尔排序
 * 对于大规模乱序数组插入排序很慢，因为它只会交换相邻的元素。希尔排序为了加快速度简单的改进了插入排序，交换不相邻的元素以对
 * 数组的局部进行排序，并最终用插入排序将局部有序的数组排序。
 * 希尔排序的思想是使数组中任意间隔为h的元素都是有序的。这样的数组称为h有序数组。
 * 结论：希尔排序的运行时间达不到平方级别。希尔排序比插入排序和选择排序要快得多，并且数组越大，优势越大
 */
public class ShellSort extends AbstractSort {
    @Override
    public void sort(Comparable[] c) {
        int n=c.length;
        //间隔
        int h=1;
        while(h<n/3){
            h=3*h+1;
        }
        //最外层循环是由间隔控制 直到间隔值为1
        while(h>=1){
            //将数组变为h有序
            for(int i=h;i<n;i++){
                int j=i;
                while(j>=h && less(c[j],c[j-h])){
                    //交换 与插入排序的思想一致 但是这里比较的不是相邻的 而是间隔为h的两个数
                    exchange(c,j,j-h);
                    j-=h;
                }
            }
            h=h/3;
        }
        assert isSorted(c);
    }

    public static void main(String[] args) {
        Integer[] integers={3,2,8,12,7,0,6,-9,1};
        ShellSort shellSort=new ShellSort();
        shellSort.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
