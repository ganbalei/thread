package com.laibin.demo2;

public class TestLambda {

    //3.静态内部类
    static class Like2 implements ILike{
        public void lambda() {
            System.out.println("I Like Lambda2");
        }
    }

    public static void main(String[] args) {
        Like like = new Like();
        like.lambda();

        Like2 like2 = new Like2();
        like2.lambda();

        //4.局部内部类
        class Like3 implements ILike{
            public void lambda() {
                System.out.println("I Like Lambda3");
            }
        }

        Like3 like3 = new Like3();
        like3.lambda();

        //5.匿名内部类，没有类名，必须借助接口或者父类
        ILike like4 = new ILike() {
            public void lambda() {
                System.out.println("I Like Lambda4");
            }
        };
        like4.lambda();

        //6.用lambda简化
//        like = ()->System.out.println("I Like Lambda5");

    }
}

//1.定义一个函数式接口，只有一个方法
interface ILike{
    void lambda();
}

//2.实现类
class Like implements ILike{

    public void lambda() {
        System.out.println(" I Like Lambda");
    }
}