package com.mycompany.app;


import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.mycompany.app.utils.Cos;
import com.mycompany.app.utils.Sin;
import com.mycompany.app.utils.Tan;

import static spark.Spark.*;

/**
 * Web Spark app class
 * @author Angie Daniela Ruiz Alfonso
 */
public class App {
	
	//taken form taller-spark

    public static void main(String[] args) {
    	port(getPort());
        Gson gson = new Gson();
        
       System.out.println(getPort());
    
       get("/calculator/calculate", (req, res) -> {
           String number = req.queryParams("number");
           String operation = req.queryParams("operation");
           String rta = calculate(operation,number);
           return new JsonParser().parse(rta).getAsJsonObject();
		});

    }

    private static String calculate(String operation, String number){
        String result = null;
        System.out.println(operation);
        if (operation.equals("cos")){
            result= Cos.calculate(number);
        }
        else if (operation.equals("sin")){
            result = Sin.calculate(number);
        }

        else if (operation.equals("tan")){
            result = Tan.calculate(number);
        }

        return "{\"value\":"+result+"}";
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; // returns default port if heroku-port isn't set(i.e. on localhost)
    }
}