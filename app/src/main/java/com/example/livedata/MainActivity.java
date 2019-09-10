package com.example.livedata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button plus1;
    private Button plus2;
    private Button minus1;
    private Button minus2;
    private TextView number1Text;
    private TextView number2Text;
    private MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus1 = findViewById(R.id.button2);
        plus2 = findViewById(R.id.button4);
        minus1 = findViewById(R.id.button);
        minus2 = findViewById(R.id.button3);
        number1Text = findViewById(R.id.textView);
        number2Text = findViewById(R.id.textView2);

        myViewModel = ViewModelProviders.of(MainActivity.this).get(MyViewModel.class);
        LiveData<String> liveDataNumber1 = myViewModel.generateRandomNumber1();
        liveDataNumber1.observe(MainActivity.this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                number1Text.setText(s);
            }
        });

        myViewModel = ViewModelProviders.of(MainActivity.this).get(MyViewModel.class);
        LiveData<String> liveDataNumber2 = myViewModel.generateRandomNumber2();
        liveDataNumber2.observe(MainActivity.this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                number2Text.setText(s);
            }
        });

        LiveData<String> liveDataPlus1 = myViewModel.plusNumber1();
        liveDataPlus1.observe(MainActivity.this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                number1Text.setText(s);
            }
        });

        LiveData<String> liveDataPlus2 = myViewModel.plusNumber2();
        liveDataPlus2.observe(MainActivity.this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                number2Text.setText(s);
            }
        });

        LiveData<String> liveDataMinus1 = myViewModel.minusNumber1();
        liveDataMinus1.observe(MainActivity.this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                number1Text.setText(s);
            }
        });

        LiveData<String> liveDataMinus2 = myViewModel.minusNumber2();
        liveDataMinus2.observe(MainActivity.this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                number2Text.setText(s);
            }
        });



        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.plus1();
            }
        });
        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.plus2();
            }
        });

        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.minus1();
            }
        });

        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.minus2();
            }
        });
    }
}