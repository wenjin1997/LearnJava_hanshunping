package com.jinjin.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author 文进
 * @version 1.0
 */
public class FileOutputStream01 {
    public static void main(String[] args) {

    }
    /**
     * 使用FileOutputStream将数据写到文件中
     * 如果该文件不存在，则创建该文件
     */
    @Test
    public void writeFile(){
        String filePath = "/Users/jinjin/code/LearnJava_hanshunping/code/chapter19/a.txt";
        FileOutputStream fileOutputStream = null;
        try {
//            fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream = new FileOutputStream(filePath, true);
            // 方式一
            // fileOutputStream.write('a');

            // 方式二
            String content = "hello, world!";
//            fileOutputStream.write(content.getBytes());

            // 方式三
            fileOutputStream.write(content.getBytes(),0,3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
