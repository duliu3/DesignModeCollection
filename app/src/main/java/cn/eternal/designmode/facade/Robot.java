package cn.eternal.designmode.facade;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 14:55
 */
public class Robot {

    private IAction mActionSystem = new ActionSystem();
    private ITTS mTTS = new IflyTTS();

    public void sayHi() {
        mActionSystem.openEyes();
        mTTS.say("你好");
    }

    public void sleep() {
        mActionSystem.openEyes();
        mTTS.say("我睡觉去了");
        mActionSystem.closeEyes();
    }
}
