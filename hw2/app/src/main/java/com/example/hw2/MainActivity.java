package com.example.hw2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button16;
    private EditText editText;
    public boolean firstclick = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button16 = findViewById(R.id.button16);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstclick){
                    editText.setText("");
                    firstclick = false;
                }
                editText.append("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstclick){
                    editText.setText("");
                    firstclick = false;
                }
                editText.append("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstclick){
                    editText.setText("");
                    firstclick = false;
                }
                editText.append("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstclick){
                    editText.setText("");
                    firstclick = false;
                }
                editText.append("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstclick){
                    editText.setText("");
                    firstclick = false;
                }
                editText.append("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstclick){
                    editText.setText("");
                    firstclick = false;
                }
                editText.append("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstclick){
                    editText.setText("");
                    firstclick = false;
                }
                editText.append("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstclick){
                    editText.setText("");
                    firstclick = false;
                }
                editText.append("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstclick){
                    editText.setText("");
                    firstclick = false;
                }
                editText.append("9");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstclick){
                    editText.setText("");
                    firstclick = false;
                }
                editText.append("+");
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstclick){
                    editText.setText("");
                    firstclick = false;
                }
                editText.append("0");
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstclick){
                    editText.setText("");
                    firstclick = false;
                }
                editText.append("-");
            }
        });

    }

    public void calculate(View view) {
        editText = findViewById(R.id.editTextTextPersonName);
        String input = String.valueOf(editText.getText());
        String[] nums = input.split("[+-]");
        String[] ops = input.replaceAll("[0-9]+", "").split("");
        int ans = Integer.parseInt(nums[0]);

        for (int i = 0; i < ops.length; i++) {
            int num = Integer.parseInt(nums[i + 1]);
            if (ops[i].equals("+")) {
                ans += num;
            } else {
                ans -= num;
            }
        }
        if (ans < 0) {
            editText.setTextColor(Color.RED);
        } else {
            editText.setTextColor(Color.BLACK);
        }
        editText.setText(String.valueOf(ans));
    }
}