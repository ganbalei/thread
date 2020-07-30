package com.laibin.demo1;

import static java.lang.Thread.sleep;

public class Thread4 implements Runnable {

    private int ticketNums = 10;


    public void run() {
        while (true){
            if (ticketNums<=0)
                break;
            try {
                sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ ticketNums-- +"张票");
        }
    }

    public static void main(String[] args) {
        Thread4 thread4 = new Thread4();

        new Thread(thread4, "xiaoming").start();
        new Thread(thread4, "xiaoming1").start();
        new Thread(thread4, "黄牛党").start();
    }
}
