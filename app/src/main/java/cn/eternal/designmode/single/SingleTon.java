package cn.eternal.designmode.single;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 16:09
 */
public abstract class SingleTon<T> {

    /**
     *
     * new操作非原子操作，分为3步：
     * 1.为mInstance分配分配内存
     * 2.调用mInstance 的构造函数初始化成员变量
     * 3.将mInstance 指向分配的内存空间（执行完此步骤mInstance对象就非null了）
     * 若不加volatile关键字，2、3两步执行顺序不确定。按照1-3-2的顺序执行则可能会return未初始化的对象
     */
    private volatile T mInstance;

    protected abstract T create();

    /**
     * 获取唯一单例，由子类实现
     * @return
     */
    public final T get() {
        if (mInstance == null) {
            synchronized (this) {
                if (mInstance == null) {
                    mInstance = create();
                }
            }
        }
        return mInstance;
    }
}
