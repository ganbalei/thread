package com.laibin.gaoji;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
public static void main(String[] args) {
        BuyTeckit buyTeckit = new BuyTeckit();
        new Thread(buyTeckit, "苦逼的我").start();
        new Thread(buyTeckit, "牛逼的你们").start();
        new Thread(buyTeckit, "可恶的黄牛党").start();
    }
}

class BuyTeckit implements Runnable{

    private int ticketNums = 10;
    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();
    boolean flag = true;

    @Override
    public void run() {
        while (flag){
            try {
                lock.lock();//加锁
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();//解锁
            }
        }
    }

    public void buy() throws InterruptedException {
        if (ticketNums <=0){
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"拿到了"+ ticketNums--);
    }
}
