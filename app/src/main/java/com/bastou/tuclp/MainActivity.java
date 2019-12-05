package com.bastou.tuclp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.bastou.tuclp.api.LoaderAmiibo;
import com.bastou.tuclp.model.Amiibo;
import com.bastou.tuclp.model.AmiiboSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // The string will appear to the user in the login screen
    // you can put your app's name
    final String REALM_PARAM = "YourAppName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CallApi().execute("https://www.amiiboapi.com/api/amiibo", new CallUrlResponse() {
            @Override
            public void urlResult(String res) {
                try {

                    JSONObject json = new JSONObject(res);
                    ArrayList<Amiibo> amiibos = LoaderAmiibo.loadAmiibo(json);
                    Log.e("test", amiibos.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
