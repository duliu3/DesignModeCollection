package cn.eternal.designmode.decorator;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/28 18:38
 */
public class Decorator extends DataofLove {

    private DataofLove mDataofLove;

    public Decorator(DataofLove
                      dataofLove) {
        mDataofLove = dataofLove;
    }

    @Override
    public void walk() {
        mDataofLove.walk();
    }

    @Override
    public void kiss() {
        mDataofLove.kiss();
    }
}
