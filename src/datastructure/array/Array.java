package datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AndyCui
 * @date 2018/10/8 上午10:58
 * @description 实现的数组类型 数组元素类型为int
 * 注意：数组是不能动态扩展的，ArrayList可以动态是因为每次扩容重新生成新的数组
 */
public class Array {
    /**
     * 包含的数组
     */
    private int[] data;
    /**
     * 数组长度
     */
    private int n;
    /**
     * 数组被赋值元素的个数
     */
    private int count;

    public Array(int capacity){
        data=new int[capacity];
        n=capacity;
        count=0;
    }


    /**
     * 随机访问 数组的随机访问时间复杂度为O（N）
     */
    public int find(int index){
        //防止数组越界
        if(index<0 || index>=count){
            return -1;
        }
        return data[index];
    }

    /**
     * 在指定位置插入 插入的时间复杂度为O（N）
     * 注意由于数组在构造方法中进行了初始化，所以数组的每个元素都是进行了初始化的（0），
     * 而由于数组不能动态扩容，所以插入操作需要保证被赋值的元素的数量不能超过数组的长度
     */
    public boolean insert(int index,int value){
        //防止数组越界
        if(index<0 || index>=count){
            return false;
        }
        //数组已满
        if(count==n){
            return false;
        }
        for(int i=count-1;i>=index;i++){
            data[i+1]=data[i];
        }
        count++;
        data[index]=value;
        return true;
    }

    public static void main(String[] args) {
        List<String> strings=new ArrayList<>();
        strings.add(2,"andy");
        System.out.println(strings);
    }
}
