package com.javaninja.genercis;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class WildCards {


    interface Fruit {
    }

    static class Apple implements Fruit {
    }

    static class FujiApple extends Apple {
    }


    //Covariance examples
    public void covariance {

        FujiApple fujiApple = new FujiApple();
        Apple apple = new Apple();

        //Narrowing a reference (covariance)
        List<FujiApple> fujiAppleList = new LinkedList<FujiApple>();
        List<Fruit> fruitsList;
        List<? extends Apple> covariance = fujiAppleList;
        covariance = fruitsList; // doesn't compile because we narrowing a reference
        // we can't add
        covariance.add(fujiApple);
        covariance.add(new Apple());

        //The reason why we can't add is pretty simple, if we think about it: the ? extends T wildcard tells the compiler that we’re dealing with a subtype of the type T,
        // but we cannot know which one. Since there’s no way to tell, and we need to guarantee type safety, you won’t be allowed to put anything inside such a structure.
        // On the other hand, since we know that whichever type it might be, it will be a subtype of T, we can get data out of the structure with the guarantee that it will be a T instance:

        Apple fujiApple1 = covariance.get(0);
    }

    public void contravariance(){
        List<Fruit> fruits = new ArrayList<Fruit>();
        List<? super Apple> superList = fruits;

        //we cannot know which supertype it is, but we know that Apple and any of its subtypes will be assignment compatible with it
        //that's why we can add any og the subtypes
        superList.add(new Apple());
        superList.add(new FujiApple());

        //we can't add any of the super type - we don't know nothing about super types
        superList.add(new Fruit()); // here compiler complains

        // we can't get any object from such a list.
        //It turns out that you the only thing you can get out of it will be Object
        //since we cannot know which supertype it is, the compiler can only guarantee that it will be a reference to an Object, since Object is the supertype of any Java type.
        Fruit a = superList.get(0); //doesn't compile
        Objects o = superList.get(0); // it works

        fruits.add(new Apple());

    }





}
