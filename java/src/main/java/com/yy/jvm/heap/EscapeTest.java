package com.yy.jvm.heap;

/**
 * @description: 逃逸测试栈上分配
 * @author: yy
 * @date: 2020/7/31 15:09
 */
public class EscapeTest {

    public static void testEscape(){
        Byte[] b = new Byte[2];
        b[0] = 2;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            testEscape();
        }
        // -XX:+DoEscapeAnalysis 9
        // -XX:-DoEscapeAnalysis 31
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
