package com.example.a0417;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent it= getIntent();//獲得傳來的資料
        int p1=it.getIntExtra("age",0);
        String p2=it.getStringExtra("name");
        String p3[]=it.getStringArrayExtra("status");

        String getvalue="";
        for(int i=0;i<p3.length;i++)
        getvalue+=p3[i]+"\t";

        TextView txv=(TextView)findViewById(R.id.textView2);
        txv.setText("name"+p2+",age:"+p1+",the status:"+getvalue);
    }

    public void goBack(View view) {
        finish();
    }
}