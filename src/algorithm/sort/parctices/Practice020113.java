package algorithm.sort.parctices;

import algorithm.sort.AbstractSort;

import java.util.Arrays;

/**
 * @author AndyCui
 * @date 2018/9/25 下午4:25
 * @description 纸牌排序 首先比较最上面的两张牌 如果第二张大于第一张 交换 然后将交换后的第二章移到最底下
 * 否则直接将第二张移到最底下 依次直到所有的牌都和位置一上的牌比较过 这样最上面的牌就是最小的
 * 然后从第二张开始比较第二张和下面一张 依次下去 就能确定各个位置的牌
 */
public class Practice020113 extends AbstractSort {
    public static void main(String[] args) {
        Integer [] pokerArr=new Integer[52];
        int length=52;
        for(int i=0;i<length;i++){
            pokerArr[i]=i%4+1;
        }
        Practice020113 practice020113 =new Practice020113();
        practice020113.sort(pokerArr);
        System.out.println(Arrays.toString(pokerArr));
    }

    @Override
    public void sort(Comparable[] c) {
        int length=c.length;
        //外层循环 每次循环表示寻找该位置的值
        for(int i=0;i<length-1;i++){
            //每个外层循环对应的内层循环表示每次
            for(int j=0;j<length-i-1;j++){
                //如果当前索引位置的值大于后面位置的值 交换
                if(less(c[i+1],c[i])){
                    exchange(c,i,i+1);
                }
                //交换后将后面位置的元素移到数组末尾 用while
                int k=i+1;
                while(k<length-1){
                  exchange(c,k,k+1);
                  k++;
                }
            }
        }
    }
}
