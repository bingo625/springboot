package com.example.demo.annotation;

@Inheritable(name="xxx")
public class InheritableFather {
    public InheritableFather() {
        // InheritableBase是否具有 Inheritable Annotation
        System.out.println("InheritableFather:" + InheritableFather.class.isAnnotationPresent(Inheritable.class));
    }
}