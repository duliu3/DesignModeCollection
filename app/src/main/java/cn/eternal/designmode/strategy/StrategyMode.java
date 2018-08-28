package cn.eternal.designmode.strategy;

import cn.eternal.designmode.DesignMode;
import cn.eternal.libannotation.Design;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/28 18:00
 */
@Design
public class StrategyMode extends DesignMode {
    @Override
    public void process() {
        ThirtySixScheme.FUDICHOUXIN.use();
        ThirtySixScheme.MANTIANGUOHAI.use();
    }

    @Override
    public String getName() {
        return "策略模式";
    }
}
