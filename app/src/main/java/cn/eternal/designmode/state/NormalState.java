package cn.eternal.designmode.state;

public class NormalState implements IBodyState {

    @Override
    public void xiangLong() {
        System.out.println("使出飞龙在天，撞破了邻居三堵墙壁");
    }

    @Override
    public void daGou() {
        System.out.println("使出打狗棍法，把泰迪打倒在地");
    }
}
