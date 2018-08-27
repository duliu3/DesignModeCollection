package cn.eternal.designmode.MementoMode;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/27 19:19
 */
public class Role  {

    public int level;

    public String name;

    public Role(int level, String name) {
        this.level = level;
        this.name = name;
        System.out.println("创建角色 " + name);
    }

    public void hunt() {
        level++;
        System.out.println("打猎后等级提升为 " + level);
    }

    public ISave createSave() {
        System.out.println("存档");
        return new Save(level , name);
    }

    public void loadSave(ISave save) {
        System.out.println("读档");
        this.level = ((Save)save).level;
        this.name = ((Save)save).name;
        System.out.println("姓名："+ name +" 等级：" + level);
    }

    /**
     * 存档不开放 为私有类禁止访问
     */
    private class Save implements ISave {

        private int level;

        private String name;

        public Save(int level, String name) {
            this.level = level;
            this.name = name;
        }

    }
}
