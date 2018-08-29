package cn.eternal.designmode.facade;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 14:54
 */
class IflyTTS implements ITTS {
    @Override
    public void say(String string) {
        System.out.println(string);
    }
}
