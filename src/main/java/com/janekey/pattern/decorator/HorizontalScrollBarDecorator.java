package com.janekey.pattern.decorator;

/**
 * User: p_qizheng
 * Date: 2015/3/12
 * Time: 18:38
 */
public class HorizontalScrollBarDecorator extends WindowDecorator {
    public HorizontalScrollBarDecorator(Window decoratedWindow) {
        super(decoratedWindow);
    }

    @Override
    public void draw() {
        this.decoratedWindow.draw();
    }

    @Override
    public String getDescription() {
        return this.decoratedWindow.getDescription() + " , including horizontal scrollbars";
    }
}
