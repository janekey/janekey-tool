package com.janekey.pattern.decorator;

/**
 * User: p_qizheng
 * Date: 2015/3/12
 * Time: 18:37
 */
public class VerticalScrollBarDecorator extends WindowDecorator {
    public VerticalScrollBarDecorator(Window decoratedWindow) {
        super(decoratedWindow);
    }

    @Override
    public void draw() {
        this.decoratedWindow.draw();
    }

    @Override
    public String getDescription() {
        return this.decoratedWindow.getDescription() + " , including vertical scrollbars";
    }
}
