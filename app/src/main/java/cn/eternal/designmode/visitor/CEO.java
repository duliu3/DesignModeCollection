package cn.eternal.designmode.visitor;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/15 21:19
 */
public class CEO implements IVisit {
    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = CEO.class.getSimpleName();


    @Override
    public void visit(Engineer engineer) {
        System.out.println(engineer.name + "："+ engineer.salary);
    }

    @Override
    public void visit(Manager engineer) {
        System.out.println(engineer.name + "：" + engineer.progress);
    }


    // ===========================================================
    // Methods
    // ===========================================================


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
