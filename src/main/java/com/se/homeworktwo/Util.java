package com.se.homeworktwo;

import java.util.*;

public class Util {

    public static String oo(String t){
        System.out.println(o(t));
        return o(t);
    }

    public static String o(String t){
        if(!t.equals("table")){
            return t;
        }
        return t;
    }

    public static String o(Map<String,String> t){

    StringBuilder mapAsString = new StringBuilder("{");
    for (String key : t.keySet()) {
        mapAsString.append(key + ":" + t.get(key) + ", ");
    }
    mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
    return mapAsString.toString();
    
    }
}
