package com.javaninja.genercis;

import java.util.HashSet;
import java.util.Set;


public class UnboundedWildcards {


    public static void main(String[] args) {
        Set<?> set = new HashSet<Object>();

    }

    // Unbounded wildcard type - typesafe and flexible
    static int numElementsInCommon(Set<?> s1, Set<?> s2){
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }

}
