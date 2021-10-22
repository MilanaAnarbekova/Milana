package com.example.myapplication;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.YELLOW;

import static com.example.myapplication.R.drawable.button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;

import java.lang.reflect.GenericArrayType;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText text1, text2;
    private TextView welcome1;
    private TextView welcome;
    private TextView welcome2;
    private String email = "admin@gmail.com";
    private String password = "admin";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        welcome1 = findViewById(R.id.welcome1);
        welcome2 = findViewById(R.id.welcome2);
        welcome = findViewById(R.id.welcome);
        button.setOnClickListener(this::onClick);
        text1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void afterTextChanged(Editable s) {
                if (text1.getText().toString().length() > 0) {
                    button.setBackground(ContextCompat.getDrawable(MainActivity.this,R.drawable.button2));

                } else {
                    button.setBackground(ContextCompat.getDrawable(MainActivity.this,R.drawable.button));
                }
            }
        });
    }

    private void onClick(View View) {
        if (text1.getText().toString().equals(email) && text2.getText().toString().equals(password)) {
            text1.setVisibility(View.GONE);
            text2.setVisibility(View.GONE);
            button.setVisibility(View.GONE);
            welcome1.setVisibility(View.GONE);
            welcome2.setVisibility(View.GONE);

            Toast.makeText(this, "Вы успешно зарегались! ", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Не правильный логин или пароль! ", Toast.LENGTH_SHORT).show();

        }
    }
}


