package com.janekey.pattern.abstractfactory.human;

/**
 * User: jackeyzheng
 * Date: 14-1-8
 * Time: 下午5:37
 */
public enum HumanEnum {
    YellowMaleHuman("com.janekey.pattern.abstractfactory.human.YellowMaleHuman"),
    YellowFemaleHuman("com.janekey.pattern.abstractfactory.human.YellowFemaleHuman"),
    WhiteMaleHuman("com.janekey.pattern.abstractfactory.human.WhiteMaleHuman"),
    WhiteFemaleHuman("com.janekey.pattern.abstractfactory.human.WhiteFemaleHuman"),
    BlackMaleHuman("com.janekey.pattern.abstractfactory.human.BlackMaleHuman"),
    BlackFemaleHuman("com.janekey.pattern.abstractfactory.human.BlackFemaleHuman");

    private String value;

    private HumanEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
