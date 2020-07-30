package com.laibin.demo1;

public class TestThread3 implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("studying"+i);
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        TestThread3 testThread3 = new TestThread3();

        //创建线程对象，通过线程对象开启我们的线程，代理
        Thread thread = new Thread(testThread3);

        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("敲代码"+i);
        }

    }
}
