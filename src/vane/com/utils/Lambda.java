package vane.com.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by wenshaobo on 2018/3/29.
 */
public class Lambda {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java","Scala","C++","Haskell","Lisp");

        System.out.println("start with J :");
        filter(languages,(str)->str.startsWith("J"));


    }
    public static<T> void filter(List<T> names, Predicate<T> condition) {
        for(T name:names){
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }
}
