package com.example.application.infrastructure;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;



public class Client {
    public void post() {
        String response;
        try {
            Unirest.post("http://localhost:8080/pilot/landed/123").asString().getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

        System.out.println("landed");
    }
}
