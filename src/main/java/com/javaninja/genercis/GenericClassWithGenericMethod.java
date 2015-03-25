package com.javaninja.genercis;

import java.util.LinkedList;
import java.util.List;

public class GenericClassWithGenericMethod<T> {

    List<T> objects = new LinkedList<T>();

    //In this case <T> Hides class <T> that's why we can't add element to the list
    public <T> T testMethod(T element){
        objects.add(element);
        return element;
    }

    //here everything is correct we are using class <T> and not method defined <T> that's why we can add element
    //to the List
    public T secondTestMethod(T element){
        objects.add(element);
        return element;
    }
}
