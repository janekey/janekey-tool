package com.janekey.datastructure.test;

import com.janekey.datastructure.map.HashMap;
import org.junit.Test;

import java.util.Random;

/**
 * User: qi.zheng
 * Date: 13-6-17
 * Time: 下午4:03
 */
public class MapTest {

    @Test
    public void mapTest() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            hashMap.put(String.valueOf(r.nextInt(1000)), r.nextInt(100));
        }
        System.out.println(hashMap);
    }

}
