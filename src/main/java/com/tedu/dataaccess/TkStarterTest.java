package com.tedu.dataaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author chenjl
 * @date 2022/5/5
 * @desc TODO
 */
@SpringBootApplication
@MapperScan(value = "com.tedu.dataaccess.mapper")
public class TkStarterTest {

    public static void main(String[] args) {
        SpringApplication.run(TkStarterTest.class, args);
    }
}
