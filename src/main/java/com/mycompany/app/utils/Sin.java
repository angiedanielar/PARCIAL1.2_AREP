package com.mycompany.app.utils;

public class Sin {

    public static String calculate(String value){

        Double rta= Math.sin(Double.parseDouble(value)) ;
        return  String.valueOf(rta);
    }

}
