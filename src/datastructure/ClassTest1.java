package datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author AndyCui
 * @date 2018/9/28 下午2:31
 * @description
 */
public class ClassTest1 {

    public static void printLots(List<Integer> l,List<Integer> p){
        final Iterator<Integer> li = l.iterator();
        final Iterator<Integer> pi = p.iterator();
        int itemP;
        int itemL;
        int start=0;
        while(li.hasNext() && pi.hasNext()){
            itemL = li.next();
            while(start<=itemL && pi.hasNext()){
                start++;
                itemP=pi.next();
                if(start==itemL+1){
                    System.out.println(itemP);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> li=new ArrayList<>();
        li.add(1);
        li.add(2);
        li.add(4);
        li.add(7);
        li.add(10);
        li.add(17);
        li.add(19);
        List<Integer> pi=new ArrayList<>();
        pi.add(1);
        pi.add(2);
        pi.add(3);
        pi.add(5);
        pi.add(9);
        pi.add(98);
        printLots(li,pi);
    }
}
