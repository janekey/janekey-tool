package com.janekey.pattern.factory;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 下午6:28
 */
public class HumanFactory {

    public static Human createHuman(Class c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();   //产生一个人类
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e ) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return human;
    }

}
