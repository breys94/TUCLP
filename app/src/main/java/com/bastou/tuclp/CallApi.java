package com.bastou.tuclp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CallApi extends AsyncTask<Object, Void, String> {


    @Override
    protected String doInBackground(Object... params) {
        Log.e("test", "lenght "+params.length);
        if(params.length == 2 && params[1] instanceof CallUrlResponse && params[0] instanceof String) {

            Log.e("test", "lenght "+params.length);

            CallUrlResponse call = (CallUrlResponse) params[1];
           try {
               StringBuilder sb = new StringBuilder();
               URL url = new URL((String)params[0]);
               HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
               InputStream is = conn.getInputStream();
               InputStreamReader isr = new InputStreamReader(is);
               BufferedReader br = new BufferedReader(isr);
               String inputLine;
               while ((inputLine = br.readLine()) != null) {
                  sb.append(inputLine);
               }
               br.close();
               call.urlResult(sb.toString());
               return sb.toString();

           } catch (Exception e) {
               Log.e("test", "lenght "+params.length);
               e.printStackTrace();
           }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String str) {

    }

}