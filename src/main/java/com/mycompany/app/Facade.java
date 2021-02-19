package com.mycompany.app;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class Facade {


    public static JSONObject getValue(String number, String operation) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://parcialarep.herokuapp.com/calculator/calculate?number=" + number + "&operation="+operation)
                .asString();
        return new JSONObject(response.getBody());
    }
}
