package com.example.hw1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button2;
    private Button button;
    private Button button3;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        editText = findViewById(R.id.editTextTextPersonName);
        textView = findViewById(R.id.textView);
        String text = textView.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float currentSize = textView.getTextSize();
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, currentSize - 1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float currentSize = textView.getTextSize();
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, currentSize + 1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();

                textView.setText(input + ", " + text);
                editText.setText("");
            }
        });
    }
}
