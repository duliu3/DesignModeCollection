package cn.eternal.designmode.proxy;

public class ToysProxyProductor implements ToysProduce {

    public ToysProduce mToysProduce;

    public ToysProxyProductor(ToysProduce toysProduce) {
        mToysProduce = toysProduce;
    }

    @Override
    public void produceToy() {
        System.out.println("打上星星牌玩具标签");
        mToysProduce.produceToy();
        System.out.println("用星星纸包装玩具");
    }

    @Override
    public void process() {

    }
}
