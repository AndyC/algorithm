package leetcode.array;

import java.util.*;

/**
 * @author AndyCui
 * @date 2018/10/10 下午8:21
 * @description leetcode 数组相关练习
 */
public class ArrayPractice {

    /**
     * 两数之和
     * @param numbers 数组
     * @param target 两数之和
     * 使用一遍hash的思路 时间复杂度O（n） 空间复杂度O（n）
     */
    public static int[] twoSum(int[] numbers,int target){
        int[] matchInts=new int[2];
        Map<Integer,Integer> map=new HashMap<>(numbers.length);
        for (int i=0;i<numbers.length;i++) {
            if(!map.containsKey(numbers[i])){
                map.put(target-numbers[i],i);
            }else {
                matchInts[0]=map.get(numbers[i]);
                matchInts[1]=i;
                break;
            }
        }
        return matchInts;
    }
    /**
     * 三数之和等于零的所有组合
     */
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length<3){
            return result;
        }
        //数组升序排列 Arrays.sort()方法使用的排序方法是双基准快排
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        //循环 注意只要循环到倒数第三个数就行 因为对每个元素找满足条件的元素组合都是从该元素后面的元素中开始
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0){
                //因为数组已经升序排列 循环到的元素大于零之后就不可能找到满足条件的组合
                break;
            }
            //去除重复元素 从第二个元素开始 如果该元素等于前面一个元素直接跳过
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int target=0-nums[i];
            System.out.println(target);
            //两个指针 一个指向下一个元素 一个指向数组最后一个元素
            int k=i+1,j=nums.length-1;
            while(k<j){
                if(nums[k]+nums[j]==target){
                    //两数相加整好等于目标值
                    List<Integer> goal=new ArrayList<>();
                    goal.add(nums[i]);
                    goal.add(nums[k]);
                    goal.add(nums[j]);
                    result.add(goal);
                    //去除重复元素
                    while(k<j && nums[k+1]==nums[k]){
                        k++;
                    }
                    while(k<j && nums[j-1]==nums[j]){
                        j--;
                    }
                    k++;
                    j--;
                }else if(nums[k]+nums[j]<target){
                    //小于目标值 将左边指针右移一位
                    k++;
                }else {
                    //大于目标值 将右边指针左移一位
                    j--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
