package algorithm.sort;

import java.util.Arrays;

/**
 * @author AndyCui
 * @date 2018/10/13 上午10:37
 * @description 冒泡排序
 * 冒泡排序的思想是每次比较相邻的两个数，将大数放在后面，小数放在前面，这样第一趟循环完最后一个数是最大值，第二趟的时候不用比较该值，
 * 第二趟对前面的n-1个数进行同样的操作，直到循环到第一个数
 */
public class BubbleSort extends AbstractSort {
    @Override
    public void sort(Comparable[] c) {
        int n=c.length;
        //外层控制遍历的趟数
        for(int i=0;i<n;i++){
            //内层控制每趟比较的次数
            for(int j=0;j<n-i-1;j++){
                if(less(c[j+1],c[j])){
                    //相邻两个数 大数放后面
                    exchange(c,j,j+1);
                }
            }
        }
        assert isSorted(c);
    }

    public static void main(String[] args) {
        Integer[] integers={2,1,0,3,6,4,-1,7,5,2,-9,4,6,1};
        BubbleSort bubbleSort=new BubbleSort();
        bubbleSort.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
