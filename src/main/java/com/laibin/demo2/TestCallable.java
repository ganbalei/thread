package com.laibin.demo2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//线程创建方式三：实现callable接口
public class TestCallable implements Callable {

    private String url;//图片地址
    private String name;//保存的文件名

    public TestCallable(String url, String name){
        this.url = url;
        this.name = name;
    }

    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable meitu1 = new TestCallable("https://n.sinaimg.cn/sinacn10106/460/w1080h1780/20200124/aa80-innckcf3439388.jpg", "meitu1.jpg");
        TestCallable meitu2 = new TestCallable("https://n.sinaimg.cn/sinacn10106/351/w1200h1551/20200124/bfcc-innckcf3439347.jpg", "meitu2.jpg");
        TestCallable meitu3 = new TestCallable("https://n.sinaimg.cn/sinacn10106/448/w853h1195/20200124/135c-innckcf3439413.jpg", "meitu3.jpg");

        //创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //提交执行
        Future <Boolean>r1 = executorService.submit(meitu1);
        Future <Boolean>r2 = executorService.submit(meitu2);
        Future <Boolean>r3 = executorService.submit(meitu3);

        //获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        //关闭服务
        executorService.shutdown();
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