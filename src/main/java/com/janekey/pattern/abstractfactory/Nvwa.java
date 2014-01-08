package com.janekey.pattern.abstractfactory;

/**
 * User: jackeyzheng
 * Date: 14-1-8
 * Time: 下午5:49
 */
public class Nvwa {

    public static void main(String[] args) {
        HumanFactory maleHumanFactory = new MaleHumanFactory();
        HumanFactory femaleHumanFactory = new FemaleHumanFactory();

        maleHumanFactory.createYellowHuman();
        maleHumanFactory.createWhiteHuman();
        maleHumanFactory.createBlackHuman();

        femaleHumanFactory.createYellowHuman();
        femaleHumanFactory.createWhiteHuman();
        femaleHumanFactory.createBlackHuman();
    }
}
