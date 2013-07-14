package com.janekey.pattern.factoryMethod;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 下午6:31
 */
public class NvWa {

    public static void main(String[] args) {
        Human whiteHumen = HumanFactory.createHuman(WhiteHuman.class);
        whiteHumen.laugh();
        whiteHumen.cry();
        whiteHumen.talk();

        Human yellowHumen = HumanFactory.createHuman(YelloHuman.class);
        yellowHumen.laugh();
        yellowHumen.cry();
        yellowHumen.talk();

        Human blackHumen = HumanFactory.createHuman(BlackHuman.class);
        blackHumen.laugh();
        blackHumen.cry();
        blackHumen.talk();
    }

}
