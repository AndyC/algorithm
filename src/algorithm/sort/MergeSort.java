package algorithm.sort;

import java.util.Arrays;

/**
 * @author AndyCui
 * @date 2018/9/26 上午10:44
 * @description 归并排序
 * 要将一个数组排序，可以先递归的将它分为两半分别排序，然后将结果归并起来使得整个数组有序。
 * 命题F：对于长度为N的任意数组，自顶向下的归并排序需要1/2(NlgN)到NlgN次比较
 * 命题G：对于长度为N的任意数组，自顶向下的归并排序最多需要访问数组6NlgN次。
 * 命题F和命题G意思是归并排序所需的时间和NlgN成正比，它表明我们只需要比遍历整个数组多个对数因子的时间就能将
 * 一个庞大的数组排序。归并排序的缺点是辅助数组所需要的额外空间和N的大小成正比。
 * 命题H：对于长度为N的任意数组，自底向上的归并排序需要1/2(NlgN)到NlgN次比较，最多访问数组6NlgN次。
 * 自底向上的归并排序比较适合用链表组织的数据。
 *
 * 排序算法的复杂度：
 * 命题I：没有任何基于比较的算法能够保证使用少于lg(N!)~NlgN次比较能够将长度为N的数组排序。
 * 命题J：归并排序是一种渐进最优的基于比较排序的算法。
 *
 * 3个改进：（1）加快小数组的排序速度 （2）检测数组是否已经有序 （3）通过在递归中交换参数来避免数组复制
 *
 */


public class MergeSort extends AbstractSort {


    @Override
    public void sort(Comparable[] c) {
        Comparable[] temp=new Comparable[c.length];
        sort(c,temp, 0,c.length-1);
        assert isSorted(c);
    }

    /**
     * 自顶向下的归并排序 基于原地归并的抽象实现的递归归并
     * 如果一个算法能够将两个子数组排序，它就能通过归并两个子数组来将整个数组排序
     */
    public void sort(Comparable[] c,Comparable[] temp, int lo,int hi){
        if(hi<=lo){
            return;
        }
        int mid=lo+(hi-lo)/2;
        //将左右两个数组分别排序 即递归调用自身
        sort(c,temp,lo,mid);
        sort(c,temp,mid+1,hi);
        //将两个有序子数组归并使得整个数组有序
        merge(c,temp,lo,mid,hi);
    }

    /**
     * 自底向上的归并排序
     */
    public void sortBU(Comparable[] c){

    }

    /**
     * 原地归并的抽象方法
     * 将两个有序子数组a[lo,mid]和a[mid+1,hi]归并成一个有序的数组并将结果存放在a[lo,hi]中。
     */
    private void merge(Comparable[] c,Comparable[] temp, int lo, int mid, int hi){
        int i=lo;
        int j=mid+1;
        //将需要排序的数组复制到另外一个数组中
        if (hi + 1 - lo >= 0) {
            System.arraycopy(c, lo, temp, lo, hi + 1 - lo);
        }
        //左半边用尽（取右半边的元素） 右半边用尽（取左半边的元素）
        //右半边的当前元素小于左半边的当前元素（取右半边的元素） 右半边的当前元素大于左半边的当前元素（取左半边的元素）
        for(int k=lo;k<=hi;k++){
            if(i>mid){
                c[k]=temp[j++];
            }else if(j>hi){
                c[k]=temp[i++];
            }else if(less(temp[j],temp[i])){
                c[k]=temp[j++];
            }else {
                c[k]=temp[i++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers={3,2,8,12,7,0,6,-9,1};
        MergeSort mergeSort=new MergeSort();
        mergeSort.sort(integers);
        System.out.println(Arrays.toString(integers));
    }


}
