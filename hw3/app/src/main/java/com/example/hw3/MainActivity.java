package com.example.hw3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editTextTextPersonName);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView2);

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editText.setText("");
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lines = Integer.parseInt(String.valueOf(editText.getText()));
                String stars = "";
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < lines; i++) {
                    int numStars = 2 * (i + 1) - 1;
                    for (int j = 0; j < numStars; j++) {
                        sb.append("*");
                    }
                    if (i < lines - 1) {
                        sb.append("\n"); // 最後一行不需要換行符號
                    }
                }
                textView.setText(sb);
            }
        });
    }
}