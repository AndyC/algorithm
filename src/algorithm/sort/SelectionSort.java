package algorithm.sort;

import java.util.Arrays;

/**
 * @author AndyCui
 * @date 2018/9/24 下午8:34
 * @description 选择排序
 * 选择排序的思想是：首先，找到数组中的最小值，然后将它和第一个元素交换位置，然后从第二个元素开始找最小值，找到后将其与第二个元素交换位置
 * 直到将这个数组排序，即不断地选择剩余元素中的最小者。
 * 命题：对于长度为N的数组，大约需要N^2/2次比较和N次交换
 * 证明：外层循环次数为N，内层循环根据外层循环的i决定，为n-i，所以总共的次数为（N-1）+（N-2）+...+1=N(N-1)/2~ N^2/2
 * 交换的次数与外层循环次数一样 是N
 *
 * 特点：选择排序有两个鲜明的特点
 * （1）运行时间和输入无关，为了找到最小的元素而扫描一遍数组并没有为下一次扫描提供什么信息。所以就算一个数组已经有序，也和随机数组的执行时间一样长。
 * （2）每次交换都会改变两个数组的值，因此选择排序用了N次交换--交换次数和数组长度是线性关系，其他算法都不具备这个特点。
 *
 */
public class SelectionSort extends AbstractSort {
    @Override
    public void sort(Comparable[] c) {
        int n=c.length;
        //外层循环代表对数组的每个位置去寻找这个位置上面的元素
        for(int i=0;i<n;i++){
            //设置最小值为i 然后对后面的元素包括c[i]即数组序列c[i,c.length]查找最小值
            //min用于记录该次循环的最小值
            int min=i;
            for(int j=i+1;j<n;j++){
                if(!less(c[min],c[j])){
                    min=j;
                }
            }
            //交换c[i]和查找到的最小值
            exchange(c,i,min);
        }
        assert isSorted(c);
    }

    public static void main(String[] args) {
      Integer[] integers={3,2,8,12,7,0,6,-9,1};
      SelectionSort selectionSort=new SelectionSort();
      selectionSort.sort(integers);
      System.out.println(Arrays.toString(integers));
    }
}
