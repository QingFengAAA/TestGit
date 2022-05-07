IO:：Java对数据的操作是通过流的方式，IO流用来处理设备之间的数据传输，上传文件和下载文件，Java用于操作流的对象都在IO包中。

IO流的主要分类
1.IO
(1).字节流
    1.InputSream字节输入流
        1).FileInputStream
        2).BufferInputStream
    2.OutputStream字节输出流
        1).FileOutputStream
        2).BufferOutputStream
(2).字符流
    1.Reader字符输入流
        1).InputStreamReader转换流 -- FileReader
        2).BufferedReader
    2.Writer字符输出流
        1).OutputStream Writer转换流 -- FileWriter
        2).BufferedWriter
