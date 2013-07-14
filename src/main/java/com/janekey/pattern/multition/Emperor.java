package com.janekey.pattern.multition;

import java.util.ArrayList;
import java.util.Random;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 下午5:47
 * 多例模式
 * 当一个朝代有两个皇帝的时候（明朝）
 */
public class Emperor {
    private static int maxNumOfEmperor = 2; //最多只有能两个皇帝
    private static ArrayList<Emperor> emperorList = new ArrayList<Emperor>(maxNumOfEmperor);
    private String name;

    static {
        for (int i = 0; i < maxNumOfEmperor; i++) {
            emperorList.add(new Emperor("皇帝" + i));
        }
    }

    private Emperor(String name) {
        this.name = name;
    }

    public static Emperor getInstance() {
        Random random = new Random();
        return emperorList.get(random.nextInt(maxNumOfEmperor));
    }

    public void emperorInfo() {
        System.out.println("我是 " + name);
    }

}
