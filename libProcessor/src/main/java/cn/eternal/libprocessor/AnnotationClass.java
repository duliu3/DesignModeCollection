package cn.eternal.libprocessor;

import javax.lang.model.element.TypeElement;

public class AnnotationClass {

    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = AnnotationClass.class.getSimpleName();

    String simpleName;

    String qualifiedName;

    TypeElement element;

    Class mClass;

    AnnotationClass(TypeElement element) {
        this.element = element;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public TypeElement getElement() {
        return element;
    }

    public Class getAnnotationClass() {
        return mClass;
    }
}
