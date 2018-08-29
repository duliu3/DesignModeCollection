package cn.eternal.designmode.command;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 18:12
 */
public class InstalCommand extends Command {

    public InstalCommand(IReceive receive) {
        super(receive);
    }

    @Override
    public void excute() {
        System.out.println("安装应用");
        mIReceive.receive();
    }

}
