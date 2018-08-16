package cn.eternal.designmode.visitor;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/15 21:19
 */
public class CTO  implements IVisit {
    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = CTO.class.getSimpleName();

    @Override
    public void visit(Engineer engineer) {
        System.out.println(engineer.name + "：" + engineer.skill);
    }

    @Override
    public void visit(Manager engineer) {
        System.out.println(engineer.name + "："+ engineer.demand);
    }


    // ===========================================================
    // Methods
    // ===========================================================


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
