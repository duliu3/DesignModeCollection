package cn.eternal.designmode.chain;

import cn.eternal.designmode.DesignMode;
import cn.eternal.libannotation.Design;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 20:20
 */
@Design
public class ChainMode extends DesignMode {

    @Override
    public void process() {
        Grandson grandson = new Grandson();
        Father father = new Father();
        Son son = new Son();
        GrandFather grandFather = new GrandFather();

        grandFather.setNextRelation(father);
        father.setNextRelation(son);
        son.setNextRelation(grandson);

        grandFather.inheriteProperty(new Property(1));
        System.out.println("------------");
        grandson.setNextRelation(grandFather);
        grandson.inheriteProperty(new Property(3));
    }

    @Override
    public String getName() {
        return "责任链模式";
    }
}
