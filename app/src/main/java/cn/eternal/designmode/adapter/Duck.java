package cn.eternal.designmode.adapter;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/27 16:26
 */
public class Duck extends Animal implements Ifly {

    @Override
    public void fly() {
        System.out.println("鸭子飞了一米掉下来");
    }

    @Override
    public void eat() {
        System.out.println("吃水草");
    }
}
