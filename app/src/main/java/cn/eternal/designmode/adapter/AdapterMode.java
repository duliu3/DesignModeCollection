package cn.eternal.designmode.adapter;

import cn.eternal.designmode.DesignMode;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/27 16:24
 */
public class AdapterMode extends DesignMode {
    @Override
    public void process() {
        System.out.println("————对象适配模式————");
        Duck duck = new Duck();
        duck.fly();
        DuckAdapter duckAdapter = new DuckAdapter(new Swan());
        duckAdapter.fly();

        System.out.println("————类适配模式————");
        duck.eat();
        Swan swan = new Swan();
        swan.eat();
    }

    @Override
    public String getName() {
        return "适配器模式";
    }
}
