package algorithm.sort;

import java.util.Random;

/**
 * @author AndyCui
 * @date 2018/9/27 下午3:32
 * @description 快速排序
 * 快速排序是一种分治的排序算法。它将一个数组分成两个数组，将两部分独立的排序，快速排序和归并排序是互补的：
 * 归并排序将数组分成两个小数组分别排序，并将两个有序的小数组归并以将整个数组排序；而快速排序将数组排序的方式
 * 则是当两个子数组都有序时整个数组也就自然有序了。
 *
 * 命题K：将长度为N的无重复数组排序，快速排序平均需要~2NlgN次比较。
 * 命题L：快速排序最多需要N^2/2次比较，但是随机打乱数组能够预防这种情况。
 */
public class QuickSort extends AbstractSort {
    @Override
    public void sort(Comparable[] c) {
        sort(c,0,c.length-1);
        assert isSorted(c);
    }

    /**
     * 递归 快速排序
     */
    private void sort(Comparable[] c,int lo,int hi){
        if(hi<=lo){
            return;
        }
        int index=partition(c,lo,hi);
        //大数组排序完成后index位置的元素会到正确的位置上 所以下面排序的左右两个子序列都不需要对该元素进行排序
        sort(c,lo,index-1);
        sort(c,index+1,hi);

    }

    /**
     * 对小数组使用插入排序的快排实现 当要排序的数组的元素数量小于20时 对该数组使用插入排序
     * @param insertLimitCount 使用插入排序的最大数组长度
     */
    private void sortWithInsert(Comparable[] c,int lo,int hi,int insertLimitCount){
        if(hi<=lo+insertLimitCount){
            new InsertSort().sort(c,lo,hi);
        }else {
            int index=partition(c,lo,hi);
            //大数组排序完成后index位置的元素会到正确的位置上 所以下面排序的左右两个子序列都不需要对该元素进行排序
            sortWithInsert(c,lo,index-1,insertLimitCount);
            sortWithInsert(c,index+1,hi,insertLimitCount);
        }
    }

    /**
     * 插入排序的切分 找到每次切分的位置 每次切分以数组第一个元素为基准
     * 切分完成之后以原数组第一个元素为界限 左边元素都小于该界限 右边数组都大于该界限
     */
    private int partition(Comparable[] c,int lo,int hi){
        int i=lo;
        int j=hi+1;
        Comparable v=c[lo];
        while(true){
            while(less(c[++i],v)) {
                //左边循环每次结束的条件是找到第一个小于最左边值的元素
                if (i==hi) {
                    //注意判断是否到最右侧
                    break;
                }
            }
            while(less(v,c[--j])){
                //右边循环结束的条件是找到第一个大于最左边值的元素
                if(j==lo){
                    //注意判断是否到最左侧
                    break;
                }
            }
            if(i>=j){
                //大循环结束的条件时左右两个指针相遇或者越过 3 4 2 6 5 1     3 1 2 6 5 4     2 1 3 6 5 4
                break;
            }
            //交换找到的左侧子序列大于最左值的元素与右侧子序列小于最左值的元素
            exchange(c,i,j);
        }
        //大循环结束后 表示整个序列已经分为两部分 左边都小于当前最左值 右边都大于当前最左值 将最小值放在合适的位置上面
        exchange(c,lo,j);
        return j;
    }

    public static void main(String[] args) {
        /*
        * 49 38 65 97 76 13 27 49`
        * 49 38 49` 97 76 13 27 65
        * 48 38 49` 27 76 13 97 65
        * 48 38 49` 27 13 76 97 65
        * 13 38 49` 27 49 76 97 65
        * */
        int count=10000000;
        Double[] d=new Double[count];
        for(int i=0;i<count;i++){
            d[i]= 1.0+new Random().nextDouble()*(10.0-1.0);
        }
        QuickSort quickSort=new QuickSort();
        final long start = System.currentTimeMillis();
        quickSort.sortWithInsert(d,0,d.length-1,20);
        System.out.println("sortWithInsert: "+(System.currentTimeMillis()-start));
        Double[] d1=new Double[count];
        for(int i=0;i<count;i++){
            d1[i]= 1.0+new Random().nextDouble()*(10.0-1.0);
        }
        final long start1=System.currentTimeMillis();
        quickSort.sort(d1);
        System.out.println("sort: "+(System.currentTimeMillis()-start1));
    }
}
