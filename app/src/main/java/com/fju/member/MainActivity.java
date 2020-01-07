package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nickname;
    private TextView age;
    private TextView gender;
    private static  final int NNACTIVITY = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nickname = findViewById(R.id.nickname_fill);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        if (TextUtils.isEmpty(nickname.getText().toString())&&TextUtils.isEmpty(age.getText().toString())&&TextUtils.isEmpty(gender.getText().toString())){
            Intent intent = new Intent(MainActivity.this, NicknameActivity.class);
            startActivity(intent,NNACTIVITY);

        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NNACTIVITY){
            if (requestCode == RESULT_OK){
                finish();
            }else{
               String nickname =getSharedPreferences("test",MODE_PRIVATE)
                        .getString(nickname," ");
               SharedPreferences age = getSharedPreferences("test",MODE_PRIVATE);
                           .getString(age,"");
                String gender = getSharedPreferences("test",MODE_PRIVATE);
                           .getString("GENDER","");
                nickname.setText(nickname);
                age.setText(age);
                gender.setText(gender);
            }
        }
    }
}
