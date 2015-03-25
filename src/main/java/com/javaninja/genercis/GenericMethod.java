package com.javaninja.genercis;

import java.util.*;


public class GenericMethod {


    public <T> T compareObjects(T first, T second){
        first.equals(second);
        return first;
    }

    public <T> void compareObjects(T first, T second, int i){
        first.equals(second);
    }
}
