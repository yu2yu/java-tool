package com.yy.common.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: hashMap探析
 * @author: yy
 * @date: 2020/7/21 13:23
 */
public class HashMapTest {

    public static String intToBinary32(int i, int bitNum) {
        String binaryStr = Integer.toBinaryString(i);
        while (binaryStr.length() < bitNum) {
            binaryStr = "0" + binaryStr;
        }
        return binaryStr;
    }

    /**
     * hash算法测试
     */
    public static void hashAlg(){
        // 0000 0000 0000 0001 1001 0011 0110 1000
        String s = "hhh";
        System.out.println(intToBinary32(s.hashCode(),32));
        //0000 0000 0000 0000 0000 0000 0000 0001
        System.out.println(intToBinary32(s.hashCode() >>> 16,32));
        //0000 0000 0000 0001 1001 0011 0110 1001
        System.out.println(intToBinary32(s.hashCode() ^ (s.hashCode() >>> 16),32));
        //0000 0000 0000 0001 1001 0011 0110 1000
        System.out.println(intToBinary32(s.hashCode() ^ (s.hashCode() >>> 16) & 16,32));
        //
        System.out.println(intToBinary32(17,32));
        System.out.println(intToBinary32(s.hashCode() ^ (s.hashCode() >>> 16) & 17,32));


    }

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        for(int i=0;i<78;i++) {
            map.put(i+"", i+"");
        }
        hashAlg();

    }

}
