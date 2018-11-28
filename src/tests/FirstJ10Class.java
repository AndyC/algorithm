package tests;


/**
 * @author AndyCui
 * @date 2018/9/18 下午5:25
 * @description
 */
public class FirstJ10Class implements Runnable {

    @Override
    public void run() {
        System.out.println("FirstJ10Class run");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        var firstJ10Class=new FirstJ10Class();
        firstJ10Class.run();
        Thread thread=new Thread(firstJ10Class);
        System.out.println("thread created is "+thread.getName());
        thread.run();
    }
}
