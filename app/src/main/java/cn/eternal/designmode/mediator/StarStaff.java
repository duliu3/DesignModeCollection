package cn.eternal.designmode.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/15 21:19
 */
public abstract class StarStaff {
    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = StarStaff.class.getSimpleName();

    public Mediator mMediator;

    public List<StarStaff> starStaff = new ArrayList<>();

    public StarStaff(Mediator mediator) {
        this.mMediator = mediator;
    }

    public String name;

    public abstract void action();

    public abstract void report();

}
