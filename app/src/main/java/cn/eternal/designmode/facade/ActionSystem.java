package cn.eternal.designmode.facade;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 14:54
 */
class ActionSystem implements IAction {

    @Override
    public void openEyes() {
        System.out.println("机器人睁开眼睛");
    }

    @Override
    public void closeEyes() {
        System.out.println("机器人闭上眼睛");
    }

}
