package com.example.temperaturecricket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    TextView tvAns;
    Button btnCalc;
    EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnCalc = findViewById(R.id.btnCalc);
        tvInfo = findViewById(R.id.tvInfo);
        tvAns = findViewById(R.id.tvAns);
        tvAns.setVisibility(View.GONE);

        tvInfo.setText(R.string.instructions);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int chirps = Integer.parseInt(etNumber.getText().toString().trim());
                double tempc = chirps/3.0+4;
                double tempf = tempc*(9/5)+32;

                tvAns.setText("The approximate temperature outside is "+tempc+ " degrees Celsius ("+tempf+" degrees Fahrenheit).");
                tvAns.setVisibility(View.VISIBLE);
            }
        });

    }
}