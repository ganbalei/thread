package com.laibin.syn;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestJUC {
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                copyOnWriteArrayList.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(copyOnWriteArrayList.size());
    }
}
