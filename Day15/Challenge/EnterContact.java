package com.example.intentchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class EnterContact extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etNumber, etWebsite, etLocation;
    ImageView ivHappy, ivNeutral, ivUnhappy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_contact);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etWebsite = findViewById(R.id.etWebsite);
        etLocation = findViewById(R.id.etLocation);

        ivHappy = findViewById(R.id.ivHappy);
        ivUnhappy = findViewById(R.id.ivUnhappy);
        ivNeutral = findViewById(R.id.ivNeutral);

        ivUnhappy.setOnClickListener(this);
        ivNeutral.setOnClickListener(this);
        ivHappy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty() || etWebsite.getText().toString().isEmpty()||etLocation.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter all Fields!", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent();
            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("number", etNumber.getText().toString().trim());
            intent.putExtra("website", etWebsite.getText().toString().trim());
            intent.putExtra("location", etLocation.getText().toString().trim());

            if(v.getId()==R.id.ivHappy){
                intent.putExtra("mood", "happy");
            }
            else if(v.getId()==R.id.ivNeutral){
                intent.putExtra("mood", "neutral");
            }
            else{
                intent.putExtra("mood", "unhappy");
            }
            setResult(RESULT_OK, intent);
            EnterContact.this.finish();
        }
    }
}