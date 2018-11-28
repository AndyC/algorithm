package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author AndyCui
 * @date 2018/9/24 下午11:33
 * @description
 */
public class SortCompare {
    private static long time(AbstractSort abstractSort, Comparable[] comparable){
        final long startTime = System.currentTimeMillis();
        abstractSort.sort(comparable);
        return System.currentTimeMillis()-startTime;
    }
    private static Double[] randomDoubleArray(int arrLen){
        Double[] d=new Double[arrLen];
        for(int i=0;i<arrLen;i++){
            d[i]= 1.0+new Random().nextDouble()*(10.0-1.0);
        }
        return d;
    }

    private static int[] randomIntArray(int arrLen){
        int[] d=new int[arrLen];
        for(int i=0;i<arrLen;i++){
            d[i]= 1+new Random().nextInt()*(10-1);
        }
        return d;
    }

    public static void main(String[] args) {
        //选择排序
        //System.out.println(time(new SelectionSort(),randomDoubleArray(100000)));
        //插入排序
        //System.out.println(time(new InsertSort(),randomDoubleArray(100000)));
        final Double[] doubles = randomDoubleArray(40000000);
        Double [] mergeDoubles= Arrays.copyOf(doubles,doubles.length);
        Double [] quickDoubles=Arrays.copyOf(doubles,doubles.length);
        Double [] dualPivotDoubles=Arrays.copyOf(doubles,doubles.length);
        //双轴快排
        System.out.println(time(new QuickSortDualPivot(),dualPivotDoubles));
        //快速排序
        System.out.println(time(new QuickSort(),quickDoubles));
        //自顶向下的归并排序
        System.out.println(time(new MergeSort(),mergeDoubles));
        //希尔排序
        //System.out.println(time(new ShellSort(),doubles));

    }
}
