package com.janekey.pattern.abstractfactory.human;

/**
 * User: jackeyzheng
 * Date: 14-1-8
 * Time: 下午5:28
 */
public class YellowFemaleHuman extends AbstractYellowHuman {
    @Override
    public void sex() {
        System.out.println("性别女的黄种人");
    }
}
