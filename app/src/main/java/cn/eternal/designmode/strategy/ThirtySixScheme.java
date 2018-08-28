package cn.eternal.designmode.strategy;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/28 18:02
 */
public enum ThirtySixScheme {

    MANTIANGUOHAI {
        @Override
        public void use() {
            System.out.println("使用计策 瞒天过海");
        }
    },

    FUDICHOUXIN {
        @Override
        public void use() {
            System.out.println("使用计策 釜底抽薪");
        }
    };

    public abstract void use();

}
