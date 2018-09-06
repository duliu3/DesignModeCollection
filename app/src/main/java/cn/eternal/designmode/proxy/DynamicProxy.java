package cn.eternal.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    private final Object mObj;

    public DynamicProxy(Object obj) {
        mObj = obj;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if ("produceToy".equals(method.getName())) {
            System.out.println("随便找个箱子");
        }
        Object invoke = method.invoke(mObj, objects);
        if ("process".equals(method.getName())) {
            System.out.println("随意包装玩具");
        }
        return invoke;
    }
}
