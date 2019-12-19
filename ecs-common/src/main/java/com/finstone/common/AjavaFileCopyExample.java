package com.finstone.common;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class AjavaFileCopyExample {
    public static void main(String[] args) {
        // 源File对象
        File source = new File("/home/wangjian/Desktop/tmp/Redis实战书籍.pdf");

        // 备份的File对象
        File target = new File("/home/wangjian/Desktop/tmp/Redis实战书籍_new.pdf");

        //通过JVM读取java.io.tmpdir属性取得临时文件夹
        File targetDir = new File(System.getProperty("java.io.tmpdir") + "/upload");
        try {
            //在同一个文件夹复制文件
            System.out.println("复制 " + source + " 文件到 " + target);
            FileUtils.copyFile(source, target);

            // 根据指定的文件夹复制
            System.out.println("复制 " + source + " 文件到" + targetDir + "目录");
            FileUtils.copyFileToDirectory(source, targetDir);
        } catch (IOException e) {
            // Errors will be reported here if any error occures during copying
            // the file
            e.printStackTrace();
        }
    }
}