package cn.eternal.designmode.mediator;

public class HR extends StarStaff {
    public HR(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("招聘了50个研发人才");
        mMediator.changed(this);
    }

    @Override
    public void report() {
        System.out.println("人员就位");
    }
}
