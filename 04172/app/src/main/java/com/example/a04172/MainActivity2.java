package com.example.a04172;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements {


    TextView tv;

    EditText et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv=(TextView)findViewById(R.id.textview);
        et=(EditText)findViewById(R.id.editText);

        Intent it =getIntent();
        int no =it.getIntExtra("編號"0);
        String s= it.getStringExtra("備忘");
        String ds= it.getStringExtra("日期");

        tv.setText(no+".");
        if(s.length()>0){
            et.setText(s.substring(3)+"\n"+ds);
        }
    }

    public void save(View view){
        Intent it2=new Intent();
        it2.putExtra("備忘",tv.getText()+""+et.getText());
        it2.putExtra("日期",new Date().toString());
        setResult(RESULT_OK,it2);//把值帶回去
        finish();
    }
    public void cancel(View view){

    }
}