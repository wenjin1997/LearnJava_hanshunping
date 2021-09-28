package com.jinjin.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author 文进
 * @version 1.0
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 单个字节的读取
     */
    @Test
    public void readFile01(){
        String filePath = "/Users/jinjin/code/LearnJava_hanshunping/code/chapter19/hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 按照read(byte[] b)读取
     */
    @Test
    public void readFile02(){
        String filePath = "/Users/jinjin/code/LearnJava_hanshunping/code/chapter19/hello.txt";
        byte[] buffer = new byte[8];
        int bufferLen = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            while ((bufferLen = fileInputStream.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0 ,bufferLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
