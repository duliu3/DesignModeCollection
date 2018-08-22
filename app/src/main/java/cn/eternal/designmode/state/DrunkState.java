package cn.eternal.designmode.state;

public class DrunkState implements IBodyState {

    @Override
    public void xiangLong() {
        System.out.println("使出亢龙有悔，打下了天上的飞机");
    }

    @Override
    public void daGou() {
        System.out.println("使出打狗棍法，打趴下三十六条大狼狗");
    }
}
