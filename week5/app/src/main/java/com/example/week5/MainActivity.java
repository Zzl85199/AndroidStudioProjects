package com.example.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener, View.OnTouchListener {
    Button button, button2;
    TextView textView;
    int total = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);

        button.setOnLongClickListener(this);
        button2.setOnLongClickListener(this);
        textView.setOnLongClickListener(this);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        textView.setOnClickListener(this);

        textView.setOnTouchListener(this);
    }
    public void plus(View view){
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        textView.setText(String.valueOf(total++));
    }
    public void minus(View view){
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);

        textView.setText(String.valueOf(total--));
    }

    @Override
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.button){
            total = 0;
        }else if (view.getId() == R.id.button2){
            total = 1000;
        }else if (view.getId() == R.id.textView){
            total += 2;
        }
        textView.setText(""+total);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button){
            total++;
        }else if (view.getId() == R.id.button2){
            total--;
        }
        textView.setText(String.valueOf(total));
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            vb.vibrate(3000);
        }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
            vb.cancel();
        }
        return true;
    }
}