package com.janekey.pattern.abstractfactory;

import com.janekey.pattern.abstractfactory.human.Human;
import com.janekey.pattern.abstractfactory.human.HumanEnum;

/**
 * User: jackeyzheng
 * Date: 14-1-8
 * Time: 下午5:46
 */
public class MaleHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YellowMaleHuman);
    }

    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteMaleHuman);
    }

    @Override
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackMaleHuman);
    }
}
