package datastructure.base;

/**
 * @author AndyCui
 * @date 2018/9/30 上午11:02
 * @description 求最大子序列 为方便起见，如果所有整数均为负数，则最大子序列和为0
 */
public class MaxSubSum {


    /**
     * 找出所有的子序列，判断大小
     */
    private static int maxSubSum1(int[] a){
        int maxSum=0;
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                int thisSum=0;
                for(int k=i;k<=j;k++){
                    thisSum+=a[k];
                }
                if(thisSum>maxSum){
                    maxSum=thisSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 简化maxSubSum1
     */
    private static int maxSubSum2(int[] a){
        int maxSum=0;
        for(int i=0;i<a.length;i++){
            int thisSum=0;
            for(int j=i;j<a.length;j++){
                thisSum+=a[j];
                if(thisSum>maxSum){
                    maxSum=thisSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 动态规划
     */
    private static int maxSubSum4(int[] a){
        int maxSum=0;
        int thisSum=0;
        for (int i : a) {
            thisSum+=i;
            if(thisSum>maxSum){
                maxSum=thisSum;
            }else if(thisSum<0){
                thisSum=0;
            }
        }
        return maxSum;
    }



    public static void main(String[] args) {
        int [] ints={-2,11,-4,13,-5,-2};
        System.out.println(maxSubSum1(ints));
        System.out.println(maxSubSum2(ints));
        System.out.println(maxSubSum4(ints));
    }
}
