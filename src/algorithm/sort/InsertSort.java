package algorithm.sort;

import java.util.Arrays;

/**
 * @author AndyCui
 * @date 2018/9/24 下午9:57
 * @description 插入排序
 * 插入排序的思想是将每个元素插入到前面已经有序的序列当中。插入排序所需的时间与输入中元素的初始状态是有关系的。
 * 对已经有序的数组进行排序的时间要比随机的数组或者逆序的数组快得多。
 * 最坏情况：N^2/2次比较和N^2/2次交换
 * 平均情况：N^2/4次交换和N^2/4次比较
 * 最好情况（有序）：N-1次比较 0次交换
 * 插入排序需要的交换操作次数和数组中的倒置数量相同，需要的比较操作大于等于倒置的数量，小于等于倒置的数量加上数组的大小再减1。
 * 插入排序对于部分有序的数组十分高效，也很适合小规模数组。
 * 要大幅度提高插入排序的速度， 只需要在内循环中将较大的元素都向右移动而不总是交换两个元素，这样能将访问的次数减半。
 *
 * 对于随机排序的无重复主键的数组，插入排序和选择排序的运行时间是平方级别的，两者之比应该是一个较小的常数。
 */
public class InsertSort extends AbstractSort {
    @Override
    public void sort(Comparable[] c) {
        int n=c.length;
        for(int i=0;i<n-1;i++){
            //循环里面 j表示要插入的元素索引
            int j=i+1;
            //从要插入的索引开始 向前比较 只要小于 就交换位置
            while (j>0 && less(c[j],c[j-1])){
                exchange(c,j,j-1);
                j--;
            }
        }
        assert isSorted(c);
    }

    public void sort(Comparable[] c,int lo,int hi){
        if(hi<=lo){
            return;
        }
        for(int i=lo;i<hi;i++){
            int j=i+1;
            while (j>lo && less(c[j],c[j-1])){
                exchange(c,j,j-1);
                j--;
            }
        }
    }
    /**
     * 不使用交换的插入排序
     * 在内循环中让大的元素右移而不是交换 这样就能减少访问数组的次数
     */
    public void sortWithoutExchange(Comparable[] c){
        int n=c.length;
        for(int i=0;i<n-1;i++){
            int j=i+1;
            //记录需要插入的数据 因为使用的是元素移动而不是交换 所以下面的while循环里面不能与使用交换的插入排序一样
            // 使用c[j]和前面比较 而应该使用保存的临时变量
            Comparable comparable=c[j];
            while(j>0 && less(comparable,c[j-1])){
                c[j]=c[j-1];
                j--;
            }
            c[j]=comparable;
        }
        assert isSorted(c);
    }

    /**
     * 去掉边界校验的插入排序
     * 在排序之前找到数组的最小值并将其放在数组的最左侧 这样在内循环中就可以省掉j>0的判断
     * 因为最小值在最左边 所以不会有元素比最左边的值还小 不会循环到最左边
     */
    public void sortWithoutIndexCheck(Comparable[] c){
        int n=c.length;
        //从数组末尾开始遍历 如果当前位置值小于前一个元素的值 交换
        // （记住这个将最小值放在数组最左侧的方式） 然后想一想将最大值放在数组最右边的方式
        for(int i=n-1;i>0;i--){
            if(less(c[i],c[i-1])){
                exchange(c,i,i-1);
            }
        }
        for(int i=0;i<n-1;i++){
            int j=i+1;
            while(less(c[j],c[j-1])){
                exchange(c,j,j-1);
                j--;
            }
        }
        assert isSorted(c);

    }

    public static void main(String[] args) {
        Integer[] integers={3,2,8,12,7,0,6,-9,1};
        InsertSort insertSort=new InsertSort();
        insertSort.sort(integers,0 ,integers.length-1);
        System.out.println(Arrays.toString(integers));
    }
}
