package cn.eternal.libprocessor;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;

public class DesignAnnotationClass extends AnnotationClass {

    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = DesignAnnotationClass.class.getSimpleName();

    DesignAnnotationClass(TypeElement element) {
        super(element);
        mClass = Design.class;
        Design annotation = element.getAnnotation(Design.class);
        try {
            Class<? extends Design> aClass = annotation.getClass();
            qualifiedName = aClass.getCanonicalName();
            simpleName = aClass.getSimpleName();
        } catch (MirroredTypeException e) {
            DeclaredType typeMirror = (DeclaredType) e.getTypeMirror();
            TypeElement typeElement = (TypeElement) typeMirror.asElement();
            qualifiedName = typeElement.getQualifiedName().toString();
            simpleName = typeElement.getSimpleName().toString();
        }
    }

}
