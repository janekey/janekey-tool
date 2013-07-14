package com.janekey.pattern.proxy;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 下午4:05
 */
public class WangPo implements Women {

    private Women women;

    public WangPo() {
        this.women = new PanJinLian();
    }

    //她可以是任何一个女人的代理
    public WangPo(Women women) {
        this.women = women;
    }

    @Override
    public void makeEyesWithMan() {
        this.women.makeEyesWithMan();
    }

    @Override
    public void happyWithMan() {
        this.women.happyWithMan();
    }
}
