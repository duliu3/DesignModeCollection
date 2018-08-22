package cn.eternal.designmode.mediator;

public class StarManager extends Mediator {

    @Override
    public void manage() {
        //        mHR.action();
        //        mProductor.action();
        //        mAccountant.action();
        for (int i = 0; i < starStaff.size(); i++) {
            StarStaff starStaff = this.starStaff.get(i);
            starStaff.action();
        }
    }


    @Override
    public void changed(StarStaff staff) {
        staff.report();
    }
}
