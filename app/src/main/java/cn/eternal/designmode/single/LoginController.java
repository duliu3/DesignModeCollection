package cn.eternal.designmode.single;

import java.io.Serializable;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/29 16:13
 */
public class LoginController implements Serializable {
    public void login(){
        System.out.println("双重锁 登陆成功");
    }
}
