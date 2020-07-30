package com.laibin.syn;

public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTeckit buyTeckit = new BuyTeckit();
        new Thread(buyTeckit, "苦逼的我").start();
        new Thread(buyTeckit, "牛逼的你们").start();
        new Thread(buyTeckit, "可恶的黄牛党").start();
    }
}

class BuyTeckit implements Runnable{

    private int ticketNums = 10;
    boolean flag = true;

    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized  void buy() throws InterruptedException {
        if (ticketNums <=0){
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"拿到了"+ ticketNums--);
    }
}