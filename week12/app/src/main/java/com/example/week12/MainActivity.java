package com.example.week12;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {

    //global variables
    static final String DB_Name = "HotlineDB";
    static final String TB_Name = "hotlist";
    static final int MAX=8;
    static final String[] FROM = new String[] {"name", "phone", "email"};
    SQLiteDatabase db;
    Cursor cur;
    SimpleCursorAdapter adapter;
    EditText etName, etPhone, etEmail;
    Button btInsert, btUpdate, btDelete;
    ListView lv;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.editText);
        etPhone = (EditText) findViewById(R.id.editText2);
        etEmail = (EditText) findViewById(R.id.editText3);
        btInsert = (Button) findViewById(R.id.button);
        btUpdate = (Button) findViewById(R.id.button2);
        btDelete = (Button) findViewById(R.id.button3);

        //OnClickListener
        btInsert.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btDelete.setOnClickListener(this);

        //open or create database
        db = openOrCreateDatabase(DB_Name, Context.MODE_PRIVATE, null);

        //create table
        String createTable = "CREATE TABLE IF NOT EXISTS "+TB_Name+
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "name VARCHAR(32), "+
                "phone VARCHAR(16), "+
                "email VARCHAR(64))";

        //execSQL
        db.execSQL(createTable);
        //Query database
        cur = db.rawQuery("SELECT * FROM "+TB_Name, null);

        //若是空的則寫入測試資料
        if (cur.getCount()==0) {
            addData("長庚大學", "03-2118800", "cgu@mail.cgu.edu.tw");
        }

        //建立Adapter 物件
        adapter = new SimpleCursorAdapter(this, R.layout.layout, cur,
                FROM,
        new int [] {R.id.name, R.id.phone, R.id.email}, 0);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);

        //lv Listener
        lv.setOnItemClickListener(this);
        lv.setOnItemClickListener(this);
        requery();
    }

    private void addData (String name, String phone, String email) {
        ContentValues cv = new ContentValues(3);
        cv.put(FROM[0], name);
        cv.put(FROM[1], phone);
        cv.put(FROM[2], email);

        //insert into the database
        db.insert(TB_Name, null, cv);
    }

    private void update(String name, String phone, String email) {
        ContentValues cv = new ContentValues(3);
        cv.put(FROM[0], name);
        cv.put(FROM[1], phone);
        cv.put(FROM[2], email);

        //update the database
        db.update(TB_Name, cv, "_id="+id, null);
    }

    private void requery() {
        cur=db.rawQuery("SELECT * from hotlist", null);
        adapter.changeCursor(cur);
        if(cur.getCount()==MAX)
            btInsert.setEnabled(false);
        else
            btInsert.setEnabled(true);
        btUpdate.setEnabled(false);
        btDelete.setEnabled(false);
    }


    @SuppressLint("Range")
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //get to the selected position
        cur.moveToPosition(i);

        //set the id
        id = cur.getInt(0);

        //read name, tel, email and show
        etName.setText(cur.getString(cur.getColumnIndex(FROM[0])));
        etPhone.setText(cur.getString(cur.getColumnIndex(FROM[1])));
        etEmail.setText(cur.getString(cur.getColumnIndex(FROM[2])));

        //set the button status
        btUpdate.setEnabled(true);
        btDelete.setEnabled(true);

    }

    public void onDelete() {

        //delete the record from database
        db.delete(TB_Name, "_id="+id, null);

        //update the listview
        requery();
    }

    public void call(View view) {
        //call the phone
        @SuppressLint("Range") String uri="tel:"+ cur.getString(cur.getColumnIndex(FROM[1]));
        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(it);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        onItemClick(adapterView, view, i, l);
        //call the phone
        call(view);
        return true;

    }

    @Override
    public void onClick(View view) {

        //get the data from editText
        String nameStr = etName.getText().toString().trim();
        String phoneStr = etPhone.getText().toString().trim();
        String emailStr = etEmail.getText().toString().trim();

        //if data is not keyin
        if (nameStr.length()==0||phoneStr.length()==0||emailStr.length()==0)
            return;
        else {
            //determine the method from which button
            //add, update, delete button
            if (view.getId()==R.id.button)
                addData(nameStr, phoneStr,emailStr);
            else if (view.getId()==R.id.button2)
                update(nameStr, phoneStr,emailStr);
            else
                onDelete();
        }
        //update the listview
        requery();

        //hide the keyboard
        View v = findViewById(android.R.id.content);
        if (v != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }

    }
}