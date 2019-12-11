package com.amy.androidbambey2019;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import static com.amy.androidbambey2019.R.id.btnWeb;

public class Main2Activity extends AppCompatActivity {

    public Button btnCall, btnSms, btnWeb;
    public WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnCall = findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = "tel:771669604";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(n));
                startActivity(intent);
            }
        });

        btnSms = findViewById(R.id.btnSms);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Send SMS", "");
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);

                smsIntent.setData(Uri.parse("smsto:"));
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address"  , new String ("771669604"));
                smsIntent.putExtra("sms_body"  , "Test ");

                try {
                    startActivity(smsIntent);
                    finish();
                    Log.i("Finished sending SMS...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Main2Activity.this,
                            "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnWeb = findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }
}
