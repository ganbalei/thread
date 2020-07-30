package com.laibin.gaoji;

//生产者消费者模型--》利用缓冲区解决：管程法

//生产者，消费者，产品，缓冲区
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();

        new Productor(synContainer).start();
        new Consumer(synContainer).start();
    }
}

//生产者
class Productor extends Thread{

    SynContainer synContainer;

    public Productor(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    //生产

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}

//消费者
class Consumer extends Thread{

    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    //消费
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("消费了-->"+synContainer.pop()+"只鸡");
        }
    }
}

//产品
class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer{

    //容器大小
    Chicken[] chickens = new Chicken[10];
    //容器计数器
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken){
        if (count == chickens.length){
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满，我们就需要丢入产品
        chickens[count] = chicken;
        count++;
        //可以通知消费者了
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized int pop(){
        //判断是否能消费
        if (count == 0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Chicken chicken = chickens[count];
        //吃完了，通知生产者生产
        this.notifyAll();

        return chicken.id;
    }
}