package com.asahi.mainapp;

import com.asahi.common.Kind;
import com.asahi.common.PrintLog;
import com.asahi.utils.JsoupPic;

import java.util.Scanner;

/**
 * 运行的主方法
 */
public class PullPic {
    public static void main(String[] args) throws Exception {
        new PullPic().downloadPic();
    }

    public void downloadPic() throws Exception {
        new PrintLog("启动程序>>\n请输入所爬取的分类：", 1000);
        Scanner scanner = new Scanner(System.in);
        String kind = scanner.next();
        while (!Kind.contains(kind)) {
            new PrintLog("分类不存在，请重新输入：", 1000);
            kind = scanner.next();
        }
        new PrintLog("分类输入正确！", 1000);
        new PrintLog("正在获取图片资源......", 1000);
        new PrintLog("获取资源成功！！", 1000);
        new PrintLog("开始下载>>", 1000);
        JsoupPic.getPic(kind);
    }
}
