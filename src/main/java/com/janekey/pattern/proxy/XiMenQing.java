package com.janekey.pattern.proxy;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 下午4:07
 * 代理模式：我很忙，没空，你要找我就需要先找我的代理人。
 * 代理人总要知道被代理人的功能吧，即两人实现同一个接口。
 *
 * 西门庆要约潘金莲，需要王婆作为代理人与潘金莲接触
 */
public class XiMenQing {

    public static void main(String[] args) {
        //把王婆叫出来
        WangPo wangPo = new WangPo();

        //表面上是王婆在做，实际上爽的是潘金莲
        wangPo.makeEyesWithMan();
        wangPo.happyWithMan();
    }

}
