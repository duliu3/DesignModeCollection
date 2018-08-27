package cn.eternal.designmode.adapter;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/27 16:25
 */
public class DuckAdapter implements Ifly {

    private final Swan swan;

    public DuckAdapter(Swan swan) {
        this.swan = swan;
    }

    @Override
    public void fly() {
        swan.flyToSky();
    }
}
