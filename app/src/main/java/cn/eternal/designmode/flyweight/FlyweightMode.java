package cn.eternal.designmode.flyweight;

import cn.eternal.designmode.DesignMode;
import cn.eternal.libannotation.Design;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 15:32
 */
@Design
public class FlyweightMode extends DesignMode {

    @Override
    public void process() {
        short code = 101;
        for (int i = 0; i < 20; i++) {
            TcpMessage msg = TcpMessage.obtain(code);
            TcpMessage.recycle(msg);
        }

        short code2 = 103;
        for (int i = 0; i < 10; i++) {
            TcpMessage msg = TcpMessage.obtain(code2);
            TcpMessage.recycle(msg);
        }
    }

    @Override
    public String getName() {
        return "享元模式";
    }
}
