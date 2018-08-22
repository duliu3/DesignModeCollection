package cn.eternal.designmode.mediator;

import java.util.ArrayList;
import java.util.List;

public abstract class Mediator {

    protected HR mHR;
    protected Accountant mAccountant;
    protected Productor mProductor;
    protected List<StarStaff> starStaff = new ArrayList<>();

    public abstract void manage();

    public abstract void changed(StarStaff staff);

    public HR getHR() {
        return mHR;
    }

    public void setHR(HR hr) {
        mHR = hr;
        starStaff.add(hr);
    }

    public Accountant getAccountant() {
        return mAccountant;
    }

    public void setAccountant(Accountant accountant) {
        mAccountant = accountant;
        starStaff.add(accountant);
    }

    public Productor getProductor() {
        return mProductor;
    }

    public void setProductor(Productor productor) {
        mProductor = productor;
        starStaff.add(productor);
    }
}
