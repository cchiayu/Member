package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {
    private int REQUEST_CODE_EMAILACTIVITY=101;
    private EditText age;
    private Button nexttogender;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        age = findViewById(R.id.age_fill);

        final Intent ageintent = getIntent();//得到暱稱資料

        nexttogender = findViewById(R.id.nexttogender);
        nexttogender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ageintent = new Intent(AgeActivity.this, GenderActivity.class);
                ageintent
                        .putExtra("user",ageintent.getStringExtra("user"))
                        .putExtra("password",age.getText().toString());

                startActivity(ageintent);
            }
        });

    }
}

