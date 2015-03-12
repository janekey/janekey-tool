package com.janekey.pattern.decorator;

/**
 * User: p_qizheng
 * Date: 2015/3/12
 * Time: 18:35
 */
public abstract class WindowDecorator implements Window {
    protected Window decoratedWindow;

    public WindowDecorator(Window decoratedWindow) {
        this.decoratedWindow = decoratedWindow;
    }
}
