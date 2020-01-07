package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NicknameActivity extends AppCompatActivity {
    private SharedPreferences pref;
    private Button nexttoage;
    private EditText nickname;
    private Intent ageintent;
    private Intent nicknameintent;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        nickname = findViewById(R.id.nickname_fill);
        pref= getSharedPreferences("data",MODE_PRIVATE);
        nexttoage = findViewById(R.id.nexttoage);

    }

    public void next(View view){//有alertdialog
        nicknameintent = new Intent(NicknameActivity.this,AgeActivity.class);
        SharedPreferences pref= getSharedPreferences("data",MODE_PRIVATE);
        pref.edit()
                .putString("nickname",nickname.getText().toString())
                .apply();

        if(nickname.getText().length()==0){
            new AlertDialog.Builder(this)
                    .setTitle("錯誤")
                    .setMessage("請輸入暱稱")
                    .setPositiveButton("OK",null)
                    .show();
        }

        startActivity(nicknameintent);
        finish();

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        setResult(RESULT_OK);
        finish();
    }

}