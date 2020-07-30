package com.laibin.demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 extends Thread{

    private String url;//图片地址
    private String name;//保存的文件名

    public TestThread2(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为"+name);
    }

    public static void main(String[] args) {
        TestThread2 meitu1 = new TestThread2("https://n.sinaimg.cn/sinacn10106/460/w1080h1780/20200124/aa80-innckcf3439388.jpg", "meitu1.jpg");
        TestThread2 meitu2 = new TestThread2("https://n.sinaimg.cn/sinacn10106/351/w1200h1551/20200124/bfcc-innckcf3439347.jpg", "meitu2.jpg");
        TestThread2 meitu3 = new TestThread2("https://n.sinaimg.cn/sinacn10106/448/w853h1195/20200124/135c-innckcf3439413.jpg", "meitu3.jpg");

        meitu1.start();
        meitu2.start();
        meitu3.start();
    }

}

//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }
}

