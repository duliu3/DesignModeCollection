package cn.eternal.designmode.command;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 18:31
 */
class AutoTestReceiver implements IReceive {
    @Override
    public void receive() {
        System.out.println("开始自动化测试");
    }
}
