package cn.eternal.designmode.observer;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/27 17:32
 */
public class Observer implements IObserver {
    @Override
    public void receiveResponse(int code, String response) {
        System.out.println("observer receive" + code + "-" + response);
    }
}
