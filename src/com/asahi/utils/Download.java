package com.asahi.utils;

import com.asahi.common.PrintLog;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class Download {
    public static void checkPath(String savePath) throws Exception {
        File file = new File(savePath);
        new PrintLog("判断目录是否存在>>",1000);
        if (!file.exists()){
            new PrintLog("目录不存在，正在创建目录......",1000);
            file.mkdirs();
            new PrintLog("创建成功！执行下一步操作>>",1000);
        }else{
            new PrintLog("目录存在，执行下一步操作>>",1000);
        }
    }
    public static void download(String urlPath,String savePath) throws Exception {
        // 构造URL
        URL url = new URL(urlPath);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5*1000);
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf=new File(savePath);
        int randomNo=(int)(Math.random()*1000000);
        String filename=urlPath.substring(urlPath.lastIndexOf("/")+1,urlPath.length());//获取服务器上图片的名称
        new PrintLog("正在下载->"+filename,0);
        filename=new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date())+randomNo+filename;//时间+随机数防止重复
        OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);
        long oldTime = System.currentTimeMillis();
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
        long m = System.currentTimeMillis()-oldTime;
        new PrintLog(filename+"下载完成！用时"+(double)m/1000+"秒",0);
    }
    public static File getDesktop(){
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File path=fsv.getHomeDirectory();
        return path;
    }
}
