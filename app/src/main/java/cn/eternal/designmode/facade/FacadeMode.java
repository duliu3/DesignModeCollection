package cn.eternal.designmode.facade;

import cn.eternal.designmode.DesignMode;
import cn.eternal.libannotation.Design;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 14:52
 */
@Design
public class FacadeMode extends DesignMode {
    @Override
    public void process() {
        Robot robot = new Robot();
        robot.sayHi();
        robot.sleep();
    }

    @Override
    public String getName() {
        return "外观模式";
    }
}
