package cn.eternal.libprocessor;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

import cn.eternal.libannotation.Design;

/**
 * @author Administrator
 * @since 2017/2/23 11:21
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes("*")
public class DesignProcessor extends AbstractProcessor {

    private Filer mFilter;

    private Elements mElementUtils;

    private Types mTypeUtils;

    private Messager mMessage;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        mFilter = processingEnv.getFiler();

        mElementUtils = processingEnv.getElementUtils();
        mTypeUtils = processingEnv.getTypeUtils();
        mMessage = processingEnv.getMessager();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        TypeSpec builderInit = TypeSpec.classBuilder("AnnotationProvider")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(buildDesignMethod(roundEnv))
                .build();

        try {
            JavaFile.builder("cn.eternal.libannotation", builderInit)
                    .build()
                    .writeTo(mFilter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    private MethodSpec buildDesignMethod(RoundEnvironment roundEnv) {
        MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("getDesigns")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(TypeName.VOID)
                .addParameter(HashSet.class, "DesignSet");

        methodBuilder.addStatement("System.out.println(\"start\")");
        Set<? extends Element> DesignElements = roundEnv.getElementsAnnotatedWith(Design.class);
        debug("DesignElements size " + DesignElements.size());
//        methodBuilder.addStatement("System.out.println(Design size $N)",  DesignElements);
        try {
            for (Element element : DesignElements) {
                if (element.getKind() != ElementKind.CLASS) {
                    throw new ProcessingException(element, "", "Only classes can be annotated with @%s",
                            Design.class.getSimpleName());
                }

                TypeElement typeElement = (TypeElement)element;
                AnnotationClass annotationClass = new DesignAnnotationClass(typeElement);
                checkValidClass(annotationClass);
//                methodBuilder.addStatement("System.out.println($S)", ((TypeElement) element).getSimpleName().toString());
                ClassName className = ClassName.get((TypeElement) element);
                methodBuilder.addStatement("DesignSet.add(new $T())", className);
            }
        } catch (ProcessingException e) {
            e.printStackTrace();
            error(e.getElement(), e.getMessage());
        }
        return methodBuilder.build();
    }


    private void checkValidClass(AnnotationClass annotation) throws ProcessingException {
        TypeElement element = annotation.getElement();
        if (!element.getModifiers().contains(Modifier.PUBLIC)) {
            throw new ProcessingException(element, "The class %s is not public.", annotation.getQualifiedName());
        }

        if (element.getModifiers().contains(Modifier.ABSTRACT)) {
            throw new ProcessingException(element, "The class %s is abstract. You can't annotate abstract classes with @%",
                    annotation.getQualifiedName(), annotation.getAnnotationClass().getSimpleName());
        }

        TypeElement typeElement = mElementUtils.getTypeElement(annotation.getQualifiedName());
        if (typeElement != null) {
            if (typeElement.getKind() == ElementKind.INTERFACE) {
                List<? extends TypeMirror> interfaces = typeElement.getInterfaces();
                if (!interfaces.contains(typeElement.getQualifiedName())) {
                    throw new ProcessingException(element, "The class %s annotated with @%s must implement the interface %s",
                            typeElement.getQualifiedName().toString(), annotation.getAnnotationClass().getSimpleName(),
                            annotation.getQualifiedName());
                }
            } else {
                TypeElement currentElement = element;
                while (true) {
                    TypeMirror superclass = currentElement.getSuperclass();
                    if (superclass.getKind() == TypeKind.NONE) {
                        throw new ProcessingException(element,
                                "The class %s annotated with @%s must inherit from %s",
                                element.getQualifiedName().toString(), annotation.getAnnotationClass().getSimpleName(),
                                annotation.getQualifiedName());
                    }

                    if (superclass.toString().equals(annotation.getQualifiedName())) {
                        break;
                    }

                    currentElement = (TypeElement) mTypeUtils.asElement(superclass);
                }
            }

            for (Element enclosed: element.getEnclosedElements()) {
                if (enclosed.getKind() == ElementKind.CONSTRUCTOR) {
                    ExecutableElement executeElement = (ExecutableElement) enclosed;
                    if (executeElement.getParameters().size() == 0 && executeElement.getModifiers().contains(Modifier.PUBLIC)) {
                        return;
                    }
                }
            }

            throw new ProcessingException(element,
                    "The class %s must provide an public empty default constructor",
                    element.getQualifiedName().toString());
        }

    }

    /**
     * Prints an error message
     *
     * @param e The element which has caused the error. Can be null
     * @param msg The error message
     */
    public void error(Element e, String msg) {
        mMessage.printMessage(Diagnostic.Kind.ERROR, msg, e);
    }

    private void debug(String msg) {
        mMessage.printMessage(Diagnostic.Kind.NOTE, msg);
    }
}
