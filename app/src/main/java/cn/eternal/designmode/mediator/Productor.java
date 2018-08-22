package cn.eternal.designmode.mediator;

public class Productor extends StarStaff {

    public Productor(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        design();
        confirm();
        mMediator.changed(this);
    }

    @Override
    public void report() {
        System.out.println("设计完毕");
    }

    private void design() {
        System.out.println("设计出八种手机方案");
    }

    private void confirm() {
        System.out.println("选择了香蕉X作为本次产品");
    }
}
