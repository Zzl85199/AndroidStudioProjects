package com.example.week9;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener, View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private EditText editText;
    private TextView textView, textView2, textView3;
    private Button button;
    private ListView listView;
    private Calendar c;


    String [] question = {"防疫時，要常怎樣?", "防疫時，出門在外要記得戴什麼?"};
    String [] answer = {"勤洗手", "口罩"};
    ArrayAdapter<String> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        c = Calendar.getInstance();
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);

        aa = new ArrayAdapter(this,android.R.layout.simple_list_item_1,question);
        listView.setAdapter(aa);
        listView.setOnItemClickListener(this);

    }

    public void button(View view) {
        EditText et = (EditText) findViewById(R.id.editTextTextPersonName);
        //Toast.makeText(this,"Hello, dear!"+et.getText().toString(), Toast.LENGTH_SHORT).show();
        //Snackbar.make(findViewById(R.id.root),"Hello, dear!"+et.getText().toString(),Snackbar.LENGTH_SHORT).show();
        AlertDialog.Builder bdr = new AlertDialog.Builder(this);
        bdr.setMessage("交談窗示範");
        bdr.setTitle("Are you ok?");
        bdr.setIcon(android.R.drawable.btn_star_big_on);
        bdr.setNegativeButton("Not good", (DialogInterface.OnClickListener) this); //試過不work, 可以試一下直接onclick listen 監聽
        bdr.setPositiveButton("Very good", (DialogInterface.OnClickListener) this); //試過不work, 可以試一下直接onclick listen 監聽
        bdr.setCancelable(true);
        bdr.show();

    }

    public void onClick(DialogInterface dialogInterface, int i){
        if(i == DialogInterface.BUTTON_POSITIVE){
            Snackbar.make(findViewById(R.id.root),"Hello, dear!\"你過得好我也快樂\"",Snackbar.LENGTH_SHORT).show();
        } else if (i == DialogInterface.BUTTON_NEGATIVE) {
            Toast.makeText(this, "為你祝福，希望你能過得順利", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this, "answer:"+answer[i],Toast.LENGTH_LONG).show();
        Snackbar snackbar = Snackbar.make(findViewById(R.id.root),"Snackbar With Action",Snackbar.LENGTH_SHORT);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Do again",Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }

    @Override
    public void onClick(View view) {
        if (view == textView2) {
            new DatePickerDialog(this, this,
                    c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();

        } else if (view==textView3){
            new TimePickerDialog(this,this,
                    c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),true).show();

        }

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        textView2.setText("Date:"+i+"/"+i1+"/"+i2);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        textView3.setText("Time:"+i+":"+i1);
    }
}