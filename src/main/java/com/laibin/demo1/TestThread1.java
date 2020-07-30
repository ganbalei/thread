package com.laibin.demo1;

public class TestThread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("studying..."+i);
        }
    }

    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1();

        //调用start()方法开启线程
        testThread1.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("敲代码ing"+i);
        }
    }
}
