package com.asahi.common;

/**
 * 写这个类目的是想输出一下当前的状态，然后就是设置一下睡眠时间
 */
public class PrintLog {
    private static String pre = "";

    public PrintLog() {
    }

    public PrintLog(String title,Integer millis) throws InterruptedException {
        System.out.println(pre+title);
        Thread.sleep(millis);
    }
    //想写个多线程来着，然后设置一下线程名
//    public void setPre(String title){
//        this.pre = title;
//    }
}
