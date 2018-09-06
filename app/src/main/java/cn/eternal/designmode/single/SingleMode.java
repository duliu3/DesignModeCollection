package cn.eternal.designmode.single;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
    public void process() throws Exception {
        //最佳单例模式之双重锁，高效，相对安全
        LoginController login = mSingleTon.get();
        login.login();
        System.out.println(login.hashCode() + "-" + login.toString());
        LoginController loginController = serializableCopyContoller(login);
        loginController.login();
        System.out.println(loginController.hashCode() + "-" + loginController.toString());


        //最佳单例模式之枚举，绝对安全，适应反序列化，效率低
        LoginManager.INS.login();
        System.out.println(LoginManager.INS.hashCode() + "-" + LoginManager.INS.toString());
        LoginManager loginManager = serializableCopyManager(LoginManager.INS);
        loginManager.login();
        System.out.println(loginManager.hashCode() + "-" + loginManager.toString());
    }

    @Override
    public String getName() {
        return "单例模式";
    }

    SingleTon<LoginController> mSingleTon = new SingleTon<LoginController>() {
        @Override
        protected LoginController create() {
            return new LoginController();
        }
    };

    /**
     * 序列化克隆
     *
     * @return
     * @throws Exception
     */
    public LoginController serializableCopyContoller(LoginController login) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(login);

        InputStream is = new ByteArrayInputStream(os.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(is);
        LoginController test = (LoginController) ois.readObject();
        return test;
    }

    public LoginManager serializableCopyManager(LoginManager login) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(login);

        InputStream is = new ByteArrayInputStream(os.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(is);
        LoginManager test = (LoginManager) ois.readObject();
        return test;
    }

}
