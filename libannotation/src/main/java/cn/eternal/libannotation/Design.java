package cn.eternal.libannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/27 20:20
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Design {
}
