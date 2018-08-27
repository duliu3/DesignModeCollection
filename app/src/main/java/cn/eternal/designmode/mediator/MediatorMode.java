package cn.eternal.designmode.mediator;

import cn.eternal.designmode.DesignMode;

public class MediatorMode extends DesignMode {

    @Override
    public void process() {
        Mediator manager = new StarManager();
        manager.setAccountant(new Accountant(manager));
        manager.setHR(new HR(manager));
        manager.setProductor(new Productor(manager));
        manager.manage();
    }

    @Override
    public String getName() {
        return "中介者模式";
    }
}
