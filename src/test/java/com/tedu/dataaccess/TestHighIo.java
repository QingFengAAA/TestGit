package com.tedu.dataaccess;

import com.tedu.dataaccess.service.filehandler.MemoryHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author chenjl
 * @date 2022/5/7
 * @desc TODO
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestHighIo {

    @Autowired
    private MemoryHandler memoryHandler;

    /**
     * 通过内置的缓冲区读写
     * 耗时:197895
     * @throws IOException
     */
    @Test
    public void printInfo() throws IOException {
        memoryHandler.highEffientStream();
        System.out.println("aaa");
    }

    /**
     * 通过字节缓冲区进行读写
     * 耗时:276
     */
    @Test
    public void readWriteByByte() throws IOException {
        memoryHandler.highEffientByte();
        System.out.println("Success");
    }

    /**
     * 字节Buffer+字节缓冲区
     * 耗时:81s
     */
    @Test
    public void readWriteByBuffer() throws IOException {
        memoryHandler.highEffientBuffer();
        System.out.println("Success");
    }

    /**
     * PrintWriter(不支持字节的方式)
     * 耗时:1690
     */
    @Test
    public void readWriterPrintWriter() throws IOException {
        memoryHandler.hiEffientPrintWriter();
        System.out.println("Success");
    }

    /**
     * 纯buffer
     * 耗时:1820
     * @throws IOException
     */
    @Test
    public void singleBuffer() throws IOException {
        memoryHandler.sigleBuffer();
        System.out.println("Success");
    }
}
