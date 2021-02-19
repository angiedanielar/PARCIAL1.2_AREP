package com.mycompany.app.utils;

public class Cos {

    public static String calculate(String value){

        Double rta= Math.cos(Double.parseDouble(value)) ;
        return  String.valueOf(rta);
    }
}
