package cn.eternal.designmode.visitor;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/15 21:19
 */
public abstract class Staff {
    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = Staff.class.getSimpleName();

    public String name;

    // ===========================================================
    // Methods
    // ===========================================================

    public abstract void accept(IVisit visitor);

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
