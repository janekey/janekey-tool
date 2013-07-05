package com.janekey.base.innerclass;

/**
 * User: qi.zheng
 * Date: 13-7-4
 * Time: 下午12:09
 */
public class A {

    InnerA getInnterA() {
        return new InnerA();
    }

    C getInnerB() {
        return new C() {
            private int i = 0;
        };
    }

    class InnerA {

    }

    public static void main(String[] args) {
        A a = new A();
        InnerA innerA = a.getInnterA();
    }
}
