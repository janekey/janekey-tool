package com.janekey.pattern.decorator;

/**
 * User: p_qizheng
 * Date: 2015/3/12
 * Time: 18:39
 */
public class DecoratedWindowTest {
    public static void main(String[] args) {
        Window decoratorWindow = new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(new SimpleWindow()));
        System.out.println(decoratorWindow.getDescription());
    }
}
