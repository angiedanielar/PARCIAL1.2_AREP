package com.mycompany.app.utils;

public class Tan {

    public static String calculate(String value){

        Double rta= Math.tan(Double.parseDouble(value)) ;
        return  String.valueOf(rta);
    }
}
