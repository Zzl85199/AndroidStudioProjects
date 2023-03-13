package com.example.week4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView, textView2;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        editText = (EditText) findViewById(R.id.editTextTextPersonName);
    }

    public void func1(View view){
        String x = editText.getText().toString();
        textView.setText(x);
    }
    public void func2(View view){
        int count = Integer.parseInt(textView2.getText().toString());
        count++;
        textView2.setText(String.valueOf(count));
    }
    public void bigger(View view){
        int size = (int) textView.getTextSize();
        textView.setTextSize(size+10);
    }
    public void smaller(View view){
        int size = (int) textView.getTextSize();
        textView.setTextSize(size-10);
    }
}