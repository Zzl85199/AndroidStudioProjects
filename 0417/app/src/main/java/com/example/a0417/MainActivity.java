package com.example.a0417;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lv,lv2;
    TextView tv;
    ArrayList<String> selected = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView)findViewById(R.id.listView);
        lv.setOnItemClickListener(this);

        tv=(TextView)findViewById(R.id.textView);

        lv2=(ListView)findViewById(R.id.listView2);
        String [] str={"台北","桃園","台中","高雄"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,str);
        lv2.setAdapter(adapter);
        lv2.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String text=adapterView.getItemAtPosition(i).toString();
        if(selected.contains(text)){
            selected.remove(text);
            view.setBackgroundResource(R.color.white);
        }else{
            selected.add(text);
            view.setBackgroundResource(R.color.green);
        }

        String msg="";
        if(selected.size()>0){
            msg="U have ordered:";
            for(String str:selected)
                msg+=" "+str;
        }
       tv.setText(msg);
    }

    public void goPage2(View view){
        //Intent it =new Intent(this,MainActivity2.class);
        Intent it =new Intent();
        it.setClass(this,MainActivity2.class);
        it.putExtra("age",18);//傳值過去
        it.putExtra("name","Jessica");
        String [] array={"good","very well"};//傳array過去
        it.putExtra("status",array);
        startActivity(it);
    }


}