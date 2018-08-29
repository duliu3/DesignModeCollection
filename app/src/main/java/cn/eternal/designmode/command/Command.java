package cn.eternal.designmode.command;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 18:09
 */
public abstract class Command {

    protected IReceive mIReceive;

    public Command(IReceive receive){
        mIReceive = receive;
    }

    public abstract void excute();
}
