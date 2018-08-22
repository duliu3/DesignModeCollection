package cn.eternal.designmode.mediator;

public class Accountant extends StarStaff {

    public Accountant(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("花了500万");
        mMediator.changed(this);
    }

    @Override
    public void report() {
        System.out.println("资金就位");
    }
}
