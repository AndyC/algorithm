package algorithm.search;

/**
 * @author AndyCui
 * @date 2018/11/1 下午7:09
 * @description 二分查找
 */
public class BinarySearch {

    /**
     * 二分查找 循环实现
     */
    public int searchLoop(Comparable[] cs, Comparable c){
        int n=cs.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int middle=low+(high-low)/2;
            if(cs[middle].compareTo(c)==0){
                return middle;
            }else if(cs[middle].compareTo(c)<0){
                low=middle+1;
            }else {
                high=middle-1;
            }
        }
        return -1;
    }

    /**
     * 二分查找 递归实现
     */

    public int searchInternally(Comparable[] cs,Comparable c){
        return searchInternally(cs,c,0,cs.length-1);
    }

    public int searchInternally(Comparable[] cs, Comparable c, int low, int hi){
        if(hi<low){
            return -1;
        }
        //这样取中间值而不是 middle=(low+hi)/2 是为了防止数据溢出
        int middle=low+(hi-low)/2;
        if(cs[middle].compareTo(c)==0){
            return middle;
        }else if(cs[middle].compareTo(c)<0){
            return searchInternally(cs,c,middle+1,hi);
        }else {
            return searchInternally(cs,c,low,middle-1);
        }
    }

    public static void main(String[] args) {
        BinarySearch binarySearch=new BinarySearch();
        Integer[] integer=new Integer[]{1,3,4,8,9,25,44,76,77,88,102,9090,45000,45001};
        System.out.println(binarySearch.searchInternally(integer,8));
    }
}
