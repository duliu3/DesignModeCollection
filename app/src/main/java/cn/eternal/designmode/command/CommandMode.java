package cn.eternal.designmode.command;

import cn.eternal.designmode.DesignMode;
import cn.eternal.libannotation.Design;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 18:09
 */
@Design
public class CommandMode extends DesignMode {
    @Override
    public void process() {
        Invoker invoker = new Invoker(new InstalCommand(new InstallManagerReceiver()));
        invoker.invoke();

        Invoker invoker2 = new Invoker(new TestCommand(new AutoTestReceiver()));
        invoker2.invoke();
    }

    @Override
    public String getName() {
        return "命令模式";
    }
}
