package com.janekey.algorithms.question;

import java.util.Arrays;
import java.util.HashSet;

/**
 * User: qi.zheng
 * Date: 13-7-2
 * Time: 下午4:28
 */
public class StringTester {
    //字符串的所有排列组合
    static HashSet<String> list = new HashSet<String>();
    static void permutation(char[] str, int i) {
        if (i >= str.length) return;

        if (i == (str.length - 1)) {
            list.add(String.valueOf(str));
        } else {
            for (int j = i; j < str.length; j++) {
                char tmp = str[i];
                str[i] = str[j];
                str[j] = tmp;

                permutation(str, i + 1);

                tmp = str[i];
                str[i] = str[j];
                str[j] = tmp;
            }
        }
    }

    // 字符串反转
    static String reverse(String str) {
        if (str == null || str.length() == 0)
            return "";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = tmp;
        }
        return String.valueOf(chars);
    }

    static void testPermutation() {
        String a = "sssd";
        permutation(a.toCharArray(), 0);
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));
    }

    static void testStrReverse() {
        String a = "asldkjfslkj";
        System.out.println(a);
        System.out.println(reverse(a));
    }

    //九九乘法表
    static void ninenineMulti() {
        for (int i = 1, j = 1; j <= 9; i++) {
            System.out.print(i + "*" + j + "=" + i * j + " ");
            if (i == j) {
                j++;
                i = 0;
                System.out.println();
            }
        }
    }

    //查找字符串中第一个只出现一次的字符
    static char findSingle(String str) {
        if (str == null) return '\0';
        char[] cs = str.toCharArray();
        int[] count = new int[256];
        for (char c : cs) {
            count[c]++;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i] == 1) {
                return (char)i;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
//        testPermutation();
//        testStrReverse();
//        ninenineMulti();
        System.out.println(findSingle("abaccdeff"));
    }

}
