package cn.eternal.designmode.proxy;

public class RealProductor implements ToysProduce {

    @Override
    public void produceToy() {
        System.out.println("生产玩具");
    }

    @Override
    public void process() {
        System.out.println("加工处理");
    }
}
