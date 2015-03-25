package com.javaninja.genercis;


import java.util.LinkedList;
import java.util.List;

//http://www.javacodegeeks.com/2011/04/java-generics-quick-tutorial.html
public class SubtapingGenericsClass {

    interface Fruit {
    }

    class Apple implements Fruit {
    }

    class FujiApple extends Apple {
    }

    //subtyping relation between generic types is invariant.
    //below examples return compilation error incompatible types
    public static void main(String[] args) {
        List<Apple> apples = new LinkedList<Apple>();
        List<FujiApple> fujiApples = new LinkedList<FujiApple>();

        apples = fujiApples;


    }

}
