package com.example.andoidl_01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextTheme;
    private EditText editTextMes;
    private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();


    }
    private void initView(){
        editTextEmail = findViewById(R.id.edtxt_e);
        editTextTheme = findViewById(R.id.edtxt_th);
        editTextMes = findViewById(R.id.edtxt_m);
        button = findViewById(R.id.btn_send);
    }
    private void initListener(){
        button.setOnClickListener(view -> {
            String email, theme, text;
            email = editTextEmail.getText().toString();
            theme = editTextTheme.getText().toString();
            text = editTextMes.getText().toString();
            nextToEmail(email, theme, text);

        });



    }
    public void nextToEmail(String email, String theme, String text){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, theme);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "message"));
    }

}