package cn.eternal.designmode.chain;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 20:31
 */
public class Father extends Relation {



    @Override
    public int getPropertyNumber() {
        return 3;
    }

    @Override
    public String getName() {
        return "父亲";
    }
}
