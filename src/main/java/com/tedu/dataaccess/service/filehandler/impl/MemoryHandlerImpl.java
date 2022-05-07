package com.tedu.dataaccess.service.filehandler.impl;

import com.tedu.dataaccess.service.filehandler.MemoryHandler;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author chenjl
 * @date 2022/5/6
 * @desc TODO
 */
@Service
public class MemoryHandlerImpl implements MemoryHandler {

    /**
     * 利用FileOutStream,FileInputStream内置的缓冲区读写文件
     * 耗时:197895
     */
    @Override
    public void highEffientStream() throws IOException {
        LocalDateTime start = null;
        LocalDateTime end=null;
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            //操作文件路径
            String filePath = "F:\\io_test_file";
            inputStream = new FileInputStream(filePath+"\\Spring常用注解详解.docx");
            outputStream = new FileOutputStream("F:\\io_test_file\\highEffientStream.docx");

            int len;
            //开始时间
            start = LocalDateTime.now();
            //一次读取一个字节
            while ((len = inputStream.read()) != -1) {
                outputStream.write(len);
            }
            end = LocalDateTime.now();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                inputStream.close();
                outputStream.close();
            }
        }

        //耗时
        System.out.println("用时:" + Duration.between(start, end).toMillis());
    }

    /**
     * 借助字节数组作为缓冲区读写
     * 耗时:276
     */
    @Override
    public void highEffientByte() throws IOException {
        String inPath = "F:\\io_test_file\\Spring常用注解详解.docx";
        String outPath = "F:\\io_test_file\\highEffientByte.docx";

        FileInputStream inputStream = new FileInputStream(inPath);
        FileOutputStream outputStream = new FileOutputStream(outPath);
        
        int len=0;
        byte[] buffer = new byte[1024];
        LocalDateTime startTime = LocalDateTime.now();
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer,0,len);
        }

        System.out.println("耗时:"+Duration.between(startTime, LocalDateTime.now()).toMillis());
        inputStream.close();
        outputStream.close();
    }

    /**
     * 缓冲区字节流
     * 耗时:185
     */
    @Override
    public void highEffientBuffer() throws IOException {
        String inPath = "F:\\io_test_file\\Spring常用注解详解.docx";
        String outPath = "F:\\io_test_file\\highEffientBuffer.docx";
        FileInputStream inputStream = new FileInputStream(inPath);
        FileOutputStream outputStream = new FileOutputStream(outPath);
        BufferedInputStream bufferedReader = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedWriter = new BufferedOutputStream(outputStream);
        
        int len=0;
        //字节缓冲区
        byte[] buffer = new byte[1024];
        //开始时间
        LocalDateTime startTime = LocalDateTime.now();

        while ((len = bufferedReader.read(buffer)) != -1) {
            bufferedWriter.write(buffer,0,len);
        }

        System.out.println("耗时:" + Duration.between(startTime, LocalDateTime.now()).toMillis());
        
        bufferedReader.close();
        bufferedWriter.close();
        inputStream.close();
        outputStream.close();
    }

    /**
     * 
     */
    public void sigleBuffer() throws FileNotFoundException, UnsupportedEncodingException {
        String inPath = "F:\\io_test_file\\Spring常用注解详解.docx";
        String outPath = "F:\\io_test_file\\sigleBuffer.docx";
//        StringBuilder str = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inPath), "utf-8"));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPath)));
            String line = null;
            LocalDateTime starTime = LocalDateTime.now();
            while ((line = bufferedReader.readLine()) != null) {
//                str.append(line);
                bufferedWriter.write(line);
            }
            System.out.println("耗时:"+Duration.between(starTime,LocalDateTime.now()).toMillis());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过字节数组
     * PrintWriter
     * 1.可以自动换行：println()
     * 2.不能输出字节，但可以输出其他的任意类型
     * 3.通过某些配置可以自动刷新（只有在println,print,format才可以使用）
     * 4.是包装流，不具备读写功能
     * 5.可以把字节转换成字符输出 
     */
    @Override
    public void hiEffientPrintWriter() throws IOException {
        String inPath = "F:\\io_test_file\\Spring常用注解详解.docx";
        String outPath = "F:\\io_test_file\\hiEffientPrintWriter.docx";
//        PrintStream printStream=new PrintStream()
        FileReader fileReader = new FileReader(inPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //创建一个新的对象,此对对象具有自动刷新的功能，即在释放资源之前就写入数据
        FileWriter fileWriter = new FileWriter(outPath);
        PrintWriter outWriter = new PrintWriter(fileWriter, true);
//        PrintWriter out2 = new PrintWriter(new FileOutputStream(outPath));
        int len=0;
        char[] buffer=new char[1024];

        LocalDateTime startTime = LocalDateTime.now();
        while ((len = fileReader.read(buffer))!=-1) {
            outWriter.write(buffer,0,len);
        }
        System.out.println("耗时:"+Duration.between(startTime,LocalDateTime.now()).toMillis());
        bufferedReader.close();
        outWriter.close();
        fileReader.close();
        fileWriter.close();
        
    }
}
