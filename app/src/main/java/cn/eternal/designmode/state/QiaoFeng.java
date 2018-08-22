package cn.eternal.designmode.state;

public class QiaoFeng {

    private IBodyState state;

    public void setState(IBodyState state) {
        this.state = state;
    }

    public IBodyState getState() {
        return state;
    }

    public void daGou() {
        state.daGou();
    }

    public void xiangLong() {
        state.xiangLong();
    }
}
