package cn.eternal.designmode.observer;

import java.util.HashSet;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/27 17:26
 */
public class NetAccessLayer {

    public HashSet<IObserver> observers = new HashSet<>();

    public void addObserver(IObserver iObserver) {
        observers.add(iObserver);
    }

    public void removeObserver(IObserver iObserver) {
        observers.remove(iObserver);
    }

    public void receiveResponse(int code, String data) {
        for (IObserver observer : observers) {
            try {
                observer.receiveResponse(code , data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 模拟服务器发送数据
     * @param code
     * @param data
     */
    public void sendData(int code, String data) {
       receiveResponse(code, "返回 " + data);
    }
}
