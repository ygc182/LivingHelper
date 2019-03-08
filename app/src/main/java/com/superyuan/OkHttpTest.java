package com.superyuan;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttpTest {


    public static void main(String[] args){
        OkHttpTest test = new OkHttpTest();
        String json = test.bowlingJson("Jeke", "Tom");
//        String res = test.post("http://www.roundsapp.com/post", json);
//        System.out.println("post res: "+ res);


        String getRes = test.get("http://www.baidu.com");
        System.out.println("get-res: " + getRes);
    }



    public String bowlingJson(String player1, String player2) {
        return "{'winCondition':'HIGH_SCORE',"
                + "'name':'Bowling',"
                + "'round':4,"
                + "'lastSaved':1367702411696,"
                + "'dateStarted':1367702378785,"
                + "'players':["
                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
                + "]}";
    }


    public String post(String url, String bodyJson){
        String response = null;

        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        RequestBody requestBody = RequestBody.create(MediaType.get("application/json; charset=utf-8"), bodyJson);
        FormBody formBody = new FormBody.Builder()
                .add("name", "tom")
                .add("password", "asdf")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try {
            response = okHttpClient.newCall(request).execute().body().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }





    public String get(String url) {
        String response = null;
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try {
            response = okHttpClient.newCall(request).execute().body().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }


}
