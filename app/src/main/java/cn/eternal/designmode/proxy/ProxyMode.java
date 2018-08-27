package cn.eternal.designmode.proxy;

import java.lang.reflect.Proxy;

import cn.eternal.designmode.DesignMode;

public class ProxyMode extends DesignMode {

    @Override
    public void process() {
        dynamicProxy();
        staticProxy();
    }

    /**
     * 动态代理
     */
    private void dynamicProxy() {
        System.out.println("————执行动态代理————");
        ToysProduce producer = new RealProductor();
        DynamicProxy dynamicProxy = new DynamicProxy(producer);
        ClassLoader classLoader = producer.getClass().getClassLoader();
        ToysProduce o = (ToysProduce) Proxy.newProxyInstance(classLoader, new Class[]{ToysProduce.class}, dynamicProxy);
        o.produceToy();
        o.process();
    }

    /**
     * 静态代理
     */
    private void staticProxy() {
        System.out.println("————执行静态代理————");
        ToysProxyProductor toysProxyProductor = new ToysProxyProductor(new RealProductor());
        toysProxyProductor.produceToy();
    }

    @Override
    public String getName() {
        return "代理模式";
    }
}
