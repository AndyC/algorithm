package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author AndyCui
 * @date 2018/10/25 上午11:04
 * @description 所有的排序算法实现
 */
public class AllSort extends AbstractSort {
    @Override
    public void sort(Comparable[] c) {

    }

    /**
     * 选择排序 重点： 第一趟循环只循环到数组的倒数第二个数 每趟选择 使用了一个指针 min 指向该趟最小值用于和i交换
     */
    public void selectionSort(Comparable[] c) {
        int n = c.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(c[j], c[min])) {
                    min = j;
                }
            }
            exchange(c, i, min);
        }
        assert isSorted(c);
    }

    /**
     * 插入排序 重点：第一趟循环从数组的第二个元素开始 次循环用while而不是for 次循环中使用的是元素交换
     */
    public void insertSort(Comparable[] c) {
        int n = c.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && less(c[j], c[j - 1])) {
                exchange(c, j, j - 1);
                j--;
            }
        }
        assert isSorted(c);
    }

    /**
     * 不使用元素交换的插入排序 在内循环中 循环开始之前需要记录下要交换的元素  内循环中使用指针移动来实现元素右移
     */
    public void insertSortWithOutExchange(Comparable[] c) {
        int n = c.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            Comparable current = c[i];
            while (j >= 0 && less(current, c[j])) {
                c[j + 1] = c[j];
                j--;
            }
            c[++j] = current;
        }
        assert isSorted(c);
    }

    /**
     * 没有边界检查的插入排序 思想：在开始排序之前 将数组中最小值放在第一个
     */
    public void insertSortWithOutBoundCheck(Comparable[] c) {
        int n = c.length;
        int min = 0;
        for (int i = 1; i < n; i++) {
            if (less(c[i], c[min])) {
                min = i;
            }
        }
        exchange(c, min, 0);
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            Comparable current = c[i];
            while (less(current, c[j])) {
                c[j + 1] = c[j];
                j--;
            }
            c[++j] = current;
        }
        assert isSorted(c);
    }

    /**
     * 希尔排序 希尔排序是基于插入排序的 对第h个及其后面的元素 使用插入排序 注意插入排序的间隔为h而不是1
     */
    public void shellSort(Comparable[] c) {
        int n = c.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int j = i;
                while (j >= h && less(c[j], c[j - h])) {
                    exchange(c, j, j - h);
                    j -= h;
                }
            }
            h = h / 3;
        }
        assert isSorted(c);
    }

    /**
     * 归并排序 注意归并排序使用了一个临时数组
     */
    public void mergeSort(Comparable[] c) {
        Comparable[] temp=new Comparable[c.length];
        mergeSort(c, 0, c.length - 1,temp);
        assert isSorted(c);
    }

    /**
     * 归并排序 递归fun
     */
    private void mergeSort(Comparable[] c, int low, int hi,Comparable[] temp) {
        if (hi <= low) {
            return;
        }
        int middle = low+(hi-low)/2;
        mergeSort(c, low, middle,temp);
        mergeSort(c, middle + 1, hi,temp);
        merge(c,low,middle,hi,temp);
    }

    /**
     * 归并 数组c可以分为两个有序数组 low-middle有序 (middle+1)-hi有序 这里用到了双指针法
     * 左右两个数组都有值 比较大小取小值 左边无值 取右边所有 右边无值 取左边所有
     */
    private void merge(Comparable[] c, int low, int middle, int hi,Comparable[] temp) {
        int length = hi - low + 1;
        if(length>=0){
            System.arraycopy(c, low, temp, low, length);
        }
        int i = low;
        int j = middle + 1;
        int index=low;
        while (i <= middle || j <= hi) {
            if (i<=middle && j<=hi) {
                if(less(temp[i],temp[j])){
                    c[index++]=temp[i++];
                }else {
                    c[index++]=temp[j++];
                }
            }else if(i>middle){
                while(j<=hi){
                    c[index++]=temp[j++];
                }
            }else {
                while(i<=middle){
                    c[index++]=temp[i++];
                }
            }
        }
    }

    /**
     * 快速排序
     */
    public void quickSort(Comparable[] c) {
        quickSort(c,0,c.length-1);
        assert isSorted(c);
        System.out.println(Arrays.toString(c));
    }

    public void quickSort(Comparable[] c,int low,int hi){
        if(low>=hi){
            return;
        }
        final int middle = partition(c, low, hi);
        quickSort(c,low,middle-1);
        quickSort(c,middle+1,hi);
    }

    public int partition(Comparable[] c,int low,int hi){
        int i=low+1;
        int j=hi;
        while(true){
            while(less(c[i],c[low])){
                if(i==hi){
                    break;
                }
                i++;
            }
            while(less(c[low],c[j])){
                if(j==low){
                    break;
                }
                j--;
            }
            if(i>=j){
                break;
            }else {
                exchange(c,i,j);
                i++;
                j--;
            }
        }
        exchange(c,j,low);
        return j;
    }

    /**
     * 双轴快排
     */
    public void dualPivotQuickSort() {

    }

    private Integer[] randomCreator(int length) {
        Integer[] result = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result[i] = random.nextInt(10000);
        }
        return result;
    }

    public static void main(String[] args) {
        AllSort allSort = new AllSort();
        final Integer[] integers = allSort.randomCreator(100000);
        allSort.quickSort(integers);
    }


}
