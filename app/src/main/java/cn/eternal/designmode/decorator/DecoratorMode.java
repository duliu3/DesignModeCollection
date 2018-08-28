package cn.eternal.designmode.decorator;

import cn.eternal.designmode.DesignMode;
import cn.eternal.libannotation.Design;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/28 18:30
 */
@Design
public class DecoratorMode extends DesignMode{

    @Override
    public void process() {
        DataofLove dataofLove = new DataofLove();
        GiveRingDecorate giveRingDecorate = new GiveRingDecorate(dataofLove);
        HoldhandDecorate holdhandDecorate = new HoldhandDecorate(giveRingDecorate);
        holdhandDecorate.walk();
        holdhandDecorate.kiss();
    }

    @Override
    public String getName() {
        return "装饰模式";
    }
}
