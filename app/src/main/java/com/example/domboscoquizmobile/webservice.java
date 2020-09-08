package com.example.domboscoquizmobile;
import android.os.AsyncTask;

import android.util.Log;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson; //Biblioteca de Conversao para Json

/**
 * Created by lab2d on 20/08/2019 and using by student Guilherme RA20190108.
 */

 class Questions {
     public Double data;


}

 interface onRestListener {

    public void onRestUpd(Questions Valor);

}

public class webservice {


        private String URL_Con = "https://bosco-game-api.herokuapp.com/questions?=";

        // Create URL

        URL githubEndpoint;

        onRestListener reponder;

        // Create connection

        HttpsURLConnection myConnection;
        HttpURLConnection myConnection2;

        InputStreamReader responseBodyReader = null; //Dados Recebidos

        protected Questions Valor = null;

        public Questions getDado()
        {
            return Valor;
        }

        void Trata()
        {
            // Tenta estabelecer uma conexão com o bando de dados HTTPS

            if (URL_Con.startsWith("https")) {
                try {
                    if (myConnection.getResponseCode() == 200) {

                        // Success

                        InputStream responseBody = myConnection.getInputStream();

                        responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                        Gson gson = new Gson();
                        try {

                            Valor = gson.fromJson(responseBodyReader, Questions.class);
                            reponder.onRestUpd(Valor);

                        } catch (Exception e)

                        {

                            // Aqui voce poderia chamar outra interface para informar erro

                        }
                        myConnection.disconnect();
                    } else {

                        // Aqui voce poderia chamar outra interface para informar erro

                    }

                } catch (IOException e) {

                    e.printStackTrace();

                    // Aqui voce poderia chamar outra interface para informar erro

                }
            }
            else
            {
                try {

                        // Tenta estabelecer uma conexão com o bando de dados HTTP, lembrando sem segurança

                    if (myConnection2.getResponseCode() == 200) {

                        // Success

                        InputStream responseBody = myConnection2.getInputStream();
                        responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                        Gson gson = new Gson();
                        try {

                            Valor = gson.fromJson(responseBodyReader, Questions.class);

                            reponder.onRestUpd(Valor);

                        } catch (Exception e)

                        {

                            // Aqui voce poderia chamar outra interface para informar erro

                        }

                        myConnection2.disconnect();


                    } else {

                        // Aqui voce poderia chamar outra interface para informar erro

                    }

                } catch (IOException e) {

                    e.printStackTrace();

                    // Aqui voce poderia chamar outra interface para informar erro

                }
            }

        }



        protected void ChamaRest(String QueryQuestions)

        {

            // Create URL
            try {

                githubEndpoint = new URL(URL_Con+QueryQuestions);
                // Create connection
                if (URL_Con.startsWith("https")) {
                    myConnection =

                            (HttpsURLConnection) githubEndpoint.openConnection();

                    myConnection.setRequestMethod("GET");
                    myConnection.setRequestProperty("User-Agent", "as-v0.1");
                }
                else
                {
                    myConnection2 =

                            (HttpURLConnection) githubEndpoint.openConnection();
                    myConnection2.setRequestMethod("GET");
                }

                Trata();

            } catch (MalformedURLException e) {

                // Aqui voce poderia chamar outra interface para informar erro

                e.printStackTrace();

            } catch (IOException e) {

                // Aqui voce poderia chamar outra interface para informar erro

                e.printStackTrace();

            }

        }

        public  webservice(onRestListener resp,String QueryQuestions)

        {

            final String  queryQuestions = QueryQuestions;
            Valor= new Questions();
            reponder= resp;
            AsyncTask.execute(new Runnable() {

                @Override

                public void run() {

                    // All your networking logic
                    // should be here
                    ChamaRest(queryQuestions);

                }

            });

        }



}
