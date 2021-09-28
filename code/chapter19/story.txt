package com.jinjin.outputstream_;


import java.io.*;

/**
 * @author 文进
 * @version 1.0
 */
public class FileCopy {
    public static void main(String[] args) {
        String srcPath = "/Users/jinjin/code/LearnJava_hanshunping/notes/img-ch19/pika.png";
        String destPath = "/Users/jinjin/code/LearnJava_hanshunping/code/chapter19/pika.png";
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        byte[] buffer = new byte[1024];
        int bufLen = 0;
        try {
            inputStream = new FileInputStream(srcPath);
            outputStream = new FileOutputStream(destPath);
            while ((bufLen = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bufLen);
            }
            System.out.println("拷贝成功~");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
