package cn.eternal.designmode.command;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 18:12
 */
public class TestCommand extends Command {

    public TestCommand(IReceive receive) {
        super(receive);
    }

    @Override
    public void excute() {
        System.out.println("测试应用");
        mIReceive.receive();
    }
}
