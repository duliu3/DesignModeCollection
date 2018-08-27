package cn.eternal.designmode.MementoMode;

import cn.eternal.designmode.DesignMode;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/27 19:06
 */
@Design
public class MementoMode extends DesignMode {
    @Override
    public void process() {
        SaveManager saveManager = new SaveManager();

        Role role = new Role(1 , "龙傲天");
        role.hunt();
        saveManager.addSave("龙傲天",role.createSave());
        role.hunt();
        role.hunt();
        Role role2 = new Role(1 , "凤舞九天");
        role2.loadSave(saveManager.getSave("龙傲天"));
    }

    @Override
    public String getName() {
        return "备忘录模式";
    }
}
