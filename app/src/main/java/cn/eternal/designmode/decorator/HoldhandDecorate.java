package cn.eternal.designmode.decorator;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/28 18:37
 */
public class HoldhandDecorate extends Decorator {

    public HoldhandDecorate(DataofLove dataofLove) {
        super(dataofLove);
    }

    public void holdHand() {
        System.out.println("牵手");
    }

    @Override
    public void walk() {
        holdHand();
        super.walk();
    }
}
