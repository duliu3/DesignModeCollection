package cn.eternal.designmode.single;

import cn.eternal.designmode.DesignMode;
import cn.eternal.libannotation.Design;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 16:08
 */
@Design
public class SingleMode extends DesignMode {

    @Override
    public void process() {
        //最佳单例模式之双重锁，高效，相对安全
        Login login = mSingleTon.get();
        login.login();
        System.out.println(login.hashCode() + "-" + login.toString());
        mSingleTon.get().login();
        System.out.println(login.hashCode() + "-" + login.toString());

        //最佳单例模式之枚举，绝对安全，适应反序列化，效率低
        LoginManager.INS.login();
        System.out.println(login.hashCode() + "-" + login.toString());
        LoginManager.INS.login();
        System.out.println(login.hashCode() + "-" + login.toString());
    }

    @Override
    public String getName() {
        return "单例模式";
    }

    SingleTon<Login> mSingleTon = new SingleTon<Login>() {
        @Override
        protected Login create() {
            return new Login();
        }
    };
}
