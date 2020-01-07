package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_MAINACTIVITY =102 ;

    private EditText gender;
    private Intent genderintent;
    private Button endbutton;
    private SharedPreferences pref;
    private EditText gender1;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        gender = findViewById(R.id.gender_fill);
        //能得到密碼資料
        genderintent = getIntent();

        endbutton = findViewById(R.id.backtomain);


       final Intent genderintent = getIntent();//能得到密碼資料

        final Button endbutton = findViewById(R.id.backtomain);

        endbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainActivityintent = new Intent(GenderActivity.this,MainActivity.class);
                pref = getSharedPreferences("data",MODE_PRIVATE);
                MainActivityintent
                        .putExtra("nickname",pref.getString("nickname",""))
                        .putExtra("age",genderintent.getStringExtra("age"))
                       .putExtra("gender",gender.getText().toString());

                MainActivityintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

                startActivity(MainActivityintent);

//
            }
        });
    }
}
