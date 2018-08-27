package cn.eternal.designmode.adapter;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/27 16:26
 */
public class Swan extends Animal {

    public void flyToSky() {
        System.out.println("白天鹅飞上了百米天空");
    }

    private void eatFish() {
        System.out.println("每天吃一条大鱼");
    }

    @Override
    public void eat() {
        eatFish();
    }
}
