package com.example.demo.annotation;

import java.lang.annotation.Annotation;

/**
 * InheritableSon 类只是继承于 InheritableFather，
 */
public class InheritableSon extends InheritableFather {
    public InheritableSon() {
//        super();    // 调用父类的构造函数
        // InheritableSon类是否具有 Inheritable Annotation
        System.out.println("InheritableSon:" + InheritableSon.class.isAnnotationPresent(Inheritable.class));
    }

    public static void main(String[] args) {
        InheritableSon is = new InheritableSon();
        Inheritable annotation = InheritableSon.class.getAnnotation(Inheritable.class);
        System.out.println(annotation.name());
    }
}
