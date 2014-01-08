package com.janekey.pattern.abstractfactory;

import com.janekey.pattern.abstractfactory.human.Human;

/**
 * User: jackeyzheng
 * Date: 14-1-8
 * Time: 下午5:34
 */
public interface HumanFactory {

    public Human createYellowHuman();

    public Human createWhiteHuman();

    public Human createBlackHuman();
}
