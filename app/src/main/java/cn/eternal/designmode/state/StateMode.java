package cn.eternal.designmode.state;

import cn.eternal.designmode.DesignMode;
@Design
public class StateMode extends DesignMode {
    @Override
    public void process() {
        QiaoFeng qiaoFeng = new QiaoFeng();
        qiaoFeng.setState(new NormalState());
        System.out.println("---乔峰进入普通状态---");
        qiaoFeng.daGou();
        qiaoFeng.xiangLong();

        qiaoFeng.setState(new DrunkState());
        System.out.println("---乔峰进入醉酒状态---");
        qiaoFeng.daGou();
        qiaoFeng.xiangLong();
    }

    @Override
    public String getName() {
        return "状态模式";
    }
}
