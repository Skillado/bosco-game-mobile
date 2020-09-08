package com.example.domboscoquizmobile;

import android.os.AsyncTask;
import android.util.Log;

import com.example.domboscoquizmobile.models.API;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class HTTPsSERVICE extends AsyncTask<Void,Void, API> {

    private final String api;

    public HTTPsSERVICE(String api) {
        this.api = api;
    }

    @Override
    protected API doInBackground(Void... voids){
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL("https://bosco-game-api.herokuapp.com/questions/"+this.api);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept","application/json");
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()){
               resposta.append(scanner.next());

                Log.d("myTag", resposta.toString());
            }
            }
        catch (MalformedURLException e ){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  new Gson().fromJson(resposta.toString(),API.class);
    }
}
