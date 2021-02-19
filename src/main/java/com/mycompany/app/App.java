package com.mycompany.app;

import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.Spark.port;

public class App {
    public static void main(String[] args) {

        port(getPort());
        Gson gson = new Gson();

        System.out.println(getPort());

        get("/calculator/calculate", (req, res) -> {
            String number = req.queryParams("number");
            String operation = req.queryParams("operation");
            return Facade.getValue(number,operation);
        });

    }


    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; // returns default port if heroku-port isn't set(i.e. on localhost)
    }
}
