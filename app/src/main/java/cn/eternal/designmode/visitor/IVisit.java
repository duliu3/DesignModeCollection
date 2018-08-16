package cn.eternal.designmode.visitor;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/15 22:01
 */
public interface IVisit {
    // ===========================================================
    // Constants
    // ===========================================================

    String TAG = IVisit.class.getSimpleName();

    // ===========================================================
    // Methods
    // ===========================================================

    void visit(Engineer engineer);

    void visit(Manager engineer);

}
