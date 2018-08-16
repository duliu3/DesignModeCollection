package cn.eternal.designmode.visitor;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/15 21:19
 */
public class Engineer extends Staff {
    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = Engineer.class.getSimpleName();


    public String salary;

    public String skill;

    @Override
    public void accept(IVisit visitor) {
        visitor.visit(this);
    }


    // ===========================================================
    // Methods
    // ===========================================================


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
