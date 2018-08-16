package cn.eternal.designmode.visitor;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/15 21:19
 */
public class Manager extends Staff {
    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = Manager.class.getSimpleName();


    public String progress;

    public String demand;

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
