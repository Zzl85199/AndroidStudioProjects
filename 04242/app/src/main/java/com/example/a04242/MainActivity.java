package com.example.a04242;

import static java.sql.Types.VARCHAR;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    String tb_name;
    TextView txv;

    EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv=(TextView) findViewById(textView);

        tb_name="contact";
        db=openOrCreateDatabase("test", Context.MODE_PRIVATE,null);//database的名字

        String createtable = "create table if not exist "+tb_name+" (";

        createtable+= " name VARCHAR(32),"; //欄位名稱
        createtable+= " phone VARCHAR(16),";
        createtable+= " mail VARCHAR(64)";

        db.execSQL(createtable);

        //do a query
        Cursor c =db.rawQuery("select * from "+tb_name,null);//游標
        if(c.getCount()==0){
            txv.setText("查無資料");
        }
        else{
            String str ="總共有"+c.getCount()+"筆\n";
                    str+="-----------";
                            do{
                                str+="name:"+c.getString(0)+"\n";
                                str+="phone:"+c.getString(1)+"\n";
                                str+="mail:"+c.getString(2)+"\n";
                                str+="-----------";
                            }while(c.moveToNext());
                            txv.setText(str);

        }
        db.close();
    }
    private void addData(){
        et1=(EditText)findViewById(R.id.editTextTextPersonName);
        et2=(EditText)findViewById(R.id.editTextTextPersonName2);
        et3=(EditText)findViewById(R.id.editTextTextPersonName3);
        ContentValues cv = new ContentValues(3);
        cv.put("name",et1.getText().toString());
        cv.put("phone",et2.getText().toString());
        cv.put("mail",et3.getText().toString());
        db.insert(tb_name,null,cv);
    }
}