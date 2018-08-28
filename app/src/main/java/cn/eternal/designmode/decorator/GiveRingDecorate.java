package cn.eternal.designmode.decorator;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/28 18:37
 */
public class GiveRingDecorate extends Decorator {

    public GiveRingDecorate(DataofLove dataofLove) {
        super(dataofLove);
    }

    public void giveRing() {
        System.out.println("送女神一个一百克拉戒指");
    }

    @Override
    public void kiss() {
        giveRing();
        super.kiss();
    }
}
