package com.janekey.pattern.abstractfactory;

import com.janekey.pattern.abstractfactory.human.Human;
import com.janekey.pattern.abstractfactory.human.HumanEnum;

/**
 * User: jackeyzheng
 * Date: 14-1-8
 * Time: 下午5:41
 */
public abstract class AbstractHumanFactory implements HumanFactory {
    protected Human createHuman(HumanEnum humanEnum) {
        Human human = null;
        try {
            human = (Human) Class.forName(humanEnum.value()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return human;
    }
}
