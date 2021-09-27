package com.jinjin.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 文进
 * @version 1.0
 * 创建文件
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    // new File(String pathname)
    @Test
    public void create01(){
        String pathName = "/Users/jinjin/code/LearnJava_hanshunping/code/chapter19/news1.txt";
        File file = new File(pathName);
        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // new File(File parent, String child);
    @Test
    public void create02(){
        File parentFile = new File("/Users/jinjin/code/LearnJava_hanshunping/code/chapter19");
        String child = "news2.txt";
        File file = new File(parentFile, child);
        try {
            file.createNewFile();
            System.out.println("文件创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // new File(String parent, String child);
    @Test
    public void create03() {
        String parent = "/Users/jinjin/code/LearnJava_hanshunping/code/chapter19";
        String child = "news3.txt";
        File file = new File(parent, child);
        try {
            file.createNewFile();
            System.out.println("文件创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
