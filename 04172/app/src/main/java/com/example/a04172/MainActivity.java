package com.example.a04172;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {

    String [] memo = {
            "1.按一下可以編輯備忘錄",
            "2.常案可以清除備忘錄",
            "3.",
            "4.",
            "5.",
            "6.",
    };

    ListView lv ;

    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView)findViewById(listView);
        aa=new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent it=new Intent(this,MainActivity2.class);
        it.putExtra("編號",i+1);
        it.putExtra("備忘",memo[i]);
        it.putExtra("日期",new Date().toString());
        startActivityForResult(it,i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            memo[requestCode]=data.getStringExtra("備忘");
            aa.notifyDataSetChanged();
            Toast.makeText(this,"備忘資料於\n"+data.getStringExtra("日期")+"\n修改", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        memo[i]=""+(i+1)+".";
        aa.notifyDataSetChanged();
        return true;
    }
}