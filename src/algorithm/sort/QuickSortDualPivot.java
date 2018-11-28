package algorithm.sort;

import java.util.Arrays;

/**
 * @author AndyCui
 * @date 2018/10/11 下午4:16
 * @description Dual-Pivot quickSort （双轴快排）
 */
public class QuickSortDualPivot extends AbstractSort{

    @Override
    public void sort(Comparable[] c) {
        sort(c,0,c.length-1);
        assert isSorted(c);
    }

    private void sort(Comparable[] c,int lowIndex,int hiIndex){
        if(hiIndex<=lowIndex){
            return;
        }
        //取头元素和尾元素作为两个轴 要保证pivot1<pivot2 如果不是 交换这两个元素
        if(less(c[hiIndex],c[lowIndex])){
            exchange(c,lowIndex,hiIndex);
        }
        Comparable pivot1=c[lowIndex];
        Comparable pivot2=c[hiIndex];
        int i=lowIndex;
        int j=hiIndex;
        int k=lowIndex+1;
        out_break:while(k<j){
            if(less(c[k],pivot1)){
                //当前位置的元素小于小基准轴 交换该元素和位置为i+1元素
                exchange(c,k++,++i);
            }else if(c[k].compareTo(pivot2)<=0){
                //当前位置的元素大于等于小基准轴 小于等于大基准轴 直接将k加1
                k++;
            }else {
                //当前位置的元素大于大基准轴 从j位置的元素开始 找到第一个小于等于大基准轴的元素
                while(less(pivot2,c[--j])) {
                    if (j <= k) {
                        //直接跳出整个循环
                        break out_break;
                    }
                }
                    if(less(c[j],pivot1)){
                        //如果j当前位置的元素小于小基准轴 需要交换三个元素
                        exchange(c,k,j);
                        exchange(c,++i,k);
                    }else {
                        //j当前位置的元素不小于小基准轴 直接将k和j位置的元素交换
                        exchange(c,k,j);
                    }
                    k++;
                }
            }
        //循环完之后i指向小基准轴元素应该在的位置 j指向大基准轴应该在的位置 调整位置
        exchange(c,i,lowIndex);
        exchange(c,j,hiIndex);
        //递归排列三个子数组 i j位置不用排序
        sort(c,lowIndex,i-1);
        sort(c,i+1,j-1);
        sort(c,j+1,hiIndex);
    }

    public static void main(String[] args) {
        Integer[] integers={2,1,0,1,0,2,2,2,1,1,2,0,0,1,0,2};
        QuickSortDualPivot dualPivot=new QuickSortDualPivot();
        dualPivot.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
