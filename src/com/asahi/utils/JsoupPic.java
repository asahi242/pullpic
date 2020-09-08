package com.asahi.utils;

import com.asahi.common.PrintLog;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * 获取图片资源
 * kind为要获取哪个分类下的图片
 */
public class JsoupPic {
    public static void getPic(String kind) throws Exception {

        Document root_doc = Jsoup.connect("http://www.netbian.com/" + kind + "/").get();
        Elements els = root_doc.select("#main .page a");
        Integer page = Integer.parseInt(els.eq(els.size() - 2).text());
        for (int i = 1; i < page; i++) {
            Document document ;
            if (i == 1) {
                document = Jsoup.connect("http://www.netbian.com/" + kind + "/index.htm").get();
            } else {
                document = Jsoup.connect("http://www.netbian.com/" + kind + "/index_" + i + ".htm").get();
            }
            File desktop = Download.getDesktop();
            Download.checkPath(desktop.getPath() + "\\images\\" + kind);
            //获取每个分页链接里面a标签的链接，进入链接页面获取当前图拼的大尺寸图片
            Elements elements = document.select("#main .list ul li a");
            for (Element element : elements) {
                String href = element.attr("href");
                if (href.startsWith("/")) {
                    String picUrl = "http://www.netbian.com" + href;
                    Document document1 = Jsoup.connect(picUrl).get();
                    Elements elements1 = document1.select(".endpage .pic p a img");
                    Download.download(elements1.attr("src"), desktop.getPath() + "\\images\\" + kind);
                }
            }
        }
        new PrintLog("分类下全部图片下载完成！", 1000);
    }
}
