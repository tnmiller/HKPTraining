package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvWelcome;
    Button btnSubmit;
    EditText etName;
    public static final String MY_PREFS_FILENAME = "com.example.sharedpreferences.Names";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.tvWelcome);
        etName = findViewById(R.id.etName);
        btnSubmit = findViewById(R.id.btnSubmit);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_FILENAME, MODE_PRIVATE);
        String user = prefs.getString("user", null);

        tvWelcome.setText("Welcome to my app "+user+"!");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                tvWelcome.setText("Welcome to my app "+name+"!");

                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_FILENAME, MODE_PRIVATE).edit();
                editor.putString("user", name);
                editor.commit();
            }
        });
    }
}