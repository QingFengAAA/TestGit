package com.tedu.dataaccess.service.filehandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author chenjl
 * @date 2022/5/6
 * @desc TODO
 */
public interface MemoryHandler {

    /**
     * 字节流,自带的缓冲区
     */
    void highEffientStream() throws IOException;

    /**
     * 字节流,字节数组缓冲区
     */
    void highEffientByte() throws IOException;

    /**
     * Buffer 缓冲区字节流
     */
    void highEffientBuffer() throws IOException;

    /**
     * PringWriter
     */
    void hiEffientPrintWriter() throws IOException;

    /**
     * 纯buffer
     */
    void sigleBuffer() throws FileNotFoundException, UnsupportedEncodingException;
}
