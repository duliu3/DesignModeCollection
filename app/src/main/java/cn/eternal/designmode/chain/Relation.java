package cn.eternal.designmode.chain;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 20:22
 */
public abstract class Relation {

    protected Relation nextRelation;


    public void setNextRelation(Relation nextRelation) {
        this.nextRelation = nextRelation;
    }

    public Relation inheriteProperty(Property property) {
        System.out.println(" 当前序号 " + getPropertyNumber() + " 继承人序号 " + property.inheritNumber);
        if (property.inheritNumber == getPropertyNumber()) {
            System.out.println(getName() + " 继承了一亿财产");
        } else {
            if (nextRelation != null) {
                System.out.println(getName() + " 没有继承财产权传给下一位");
                this.nextRelation.inheriteProperty(property);
            } else {
                System.out.println("巨额财产无人继承");
            }
        }
        return this;
    }

    public abstract int getPropertyNumber();

    public abstract String getName();

}
