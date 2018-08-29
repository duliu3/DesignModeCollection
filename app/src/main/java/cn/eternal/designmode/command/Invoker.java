package cn.eternal.designmode.command;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 18:10
 */
public class Invoker {
    private Command mCommand;

    public Invoker(Command command) {
        this.mCommand = command;
    }

    public void setCommand(Command command) {
        this.mCommand = command;
    }

    public void invoke() {
     mCommand.excute();
    }
}
