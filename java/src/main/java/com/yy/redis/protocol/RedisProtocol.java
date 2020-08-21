package com.yy.redis.protocol;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description: redis协议
 * @author: yy
 * @date: 2020/8/20 18:16
 */
public class RedisProtocol {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost",6379);
        // 获取写入流
        OutputStream outputStream = socket.getOutputStream();
        // 指令 set simpleKey simpleValue
        outputStream.write("*3\r\n$3\r\nSET\r\n$9\r\nsimpleKey\r\n$11\r\nsimpleValue\r\n".getBytes());
        outputStream.flush();
        // 解析返回结果
        InputStream is = socket.getInputStream();
        byte[] result = new byte[1024];
        is.read(result);
        System.out.println(new String(result));
        is.close();
        outputStream.close();
        socket.close();

    }

}
