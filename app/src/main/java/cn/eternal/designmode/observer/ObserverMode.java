package cn.eternal.designmode.observer;

import cn.eternal.designmode.DesignMode;
import cn.eternal.libannotation.Design;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/27 17:30
 */
@Design
public class ObserverMode extends DesignMode {

    @Override
    public void process() {
        Observer observer = new Observer();
        NetAccessLayer netAccessLayer = new NetAccessLayer();
        netAccessLayer.addObserver(observer);
        netAccessLayer.sendData(0, "列表数据100个");
    }

    @Override
    public String getName() {
        return "观察者模式";
    }
}
