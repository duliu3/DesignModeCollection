package cn.eternal.designmode.proxy;

public class ToysProxyProductor implements ToysProduce {

    public ToysProduce mToysProduce;

    public ToysProxyProductor(ToysProduce toysProduce) {
        mToysProduce = toysProduce;
    }

    @Override
    public void produceToy() {
        System.out.println("准备星星纸");
        mToysProduce.produceToy();
        System.out.println("用星星纸包装玩具");
    }

    @Override
    public void process() {

    }
}
