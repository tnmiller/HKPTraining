package com.example.intentchallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvApp;
    Button btnContact;
    ImageView ivMood, ivPhone, ivWeb, ivLocation;
    final int CREATE_CONTACT = 1;
    String name = "", number="", web="", location="", mood="";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CREATE_CONTACT){
            if(resultCode==RESULT_OK){
                ivLocation.setVisibility(View.VISIBLE);
                ivMood.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                number = data.getStringExtra("number");
                web = data.getStringExtra("website");
                location = data.getStringExtra("location");
                mood = data.getStringExtra("mood");

                if(mood.equals("happy")){
                    ivMood.setImageResource(R.drawable.happy);
                }
                else if(mood.equals("neutral")){
                    ivMood.setImageResource(R.drawable.neutral);
                }
                else{
                    ivMood.setImageResource(R.drawable.unhappy);
                }
            }
            else{
                Toast.makeText(this, "No data passed through!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvApp = findViewById(R.id.tvApp);
        btnContact = findViewById(R.id.btnContact);
        ivMood = findViewById(R.id.ivMood);
        ivPhone = findViewById(R.id.ivPhone);
        ivWeb = findViewById(R.id.ivWeb);
        ivLocation = findViewById(R.id.ivLocation);

        ivLocation.setVisibility(View.GONE);
        ivMood.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.intentchallenge.EnterContact.class);
                startActivityForResult(intent, CREATE_CONTACT);
            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+web));
                startActivity(intent);
            }
        });

        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+location));
                startActivity(intent);
            }
        });


    }
}