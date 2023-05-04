package com.example.hw3;

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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener, CompoundButton.OnCheckedChangeListener, View.OnFocusChangeListener {
    Spinner spinner, spinner2, spinner3;
    String[] city, TPE, Taichung, Kaohsiung, Performance1, Performance2;
    EditText editText,editText3;
    Button button;
    private Calendar calendar;
    TextView date, time, textView;
    CheckBox check;
    int[] chkid = {R.id.checkBox, R.id.checkBox2, R.id.checkBox3};
    ImageView imageView, imageView2, imageView3;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    RadioGroup coupon;
    int price = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int id : chkid){
            check = findViewById(id);
            check.setOnCheckedChangeListener(this);
        }
        imageView = findViewById(R.id.imageView) ;
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView11);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        editText = findViewById(R.id.editTextTextPersonName1);
        editText3 = findViewById(R.id.editTextTextPersonName3);
        listView = findViewById(R.id.ListView);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        coupon = findViewById(R.id.coupon);
        city = getResources().getStringArray(R.array.city);
        TPE = getResources().getStringArray(R.array.TPE);
        Taichung = getResources().getStringArray(R.array.Taichung);
        Kaohsiung = getResources().getStringArray(R.array.Kaohsiung);
        Performance1 = getResources().getStringArray(R.array.Performance1);
        Performance2 = getResources().getStringArray(R.array.Performance2);
        calendar = Calendar.getInstance();
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        AlertDialog.Builder bdr = new AlertDialog.Builder(this);

        date.setOnClickListener(this);
        time.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, city);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        editText3.setOnFocusChangeListener(this);

        coupon.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioButton:
                        editText3.setEnabled(true);
                        editText3.setText("請輸入號碼");
                        break;
                    case R.id.radioButton2:
                        editText3.setEnabled(false);
                        editText3.setText("無法輸入");
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chkvalue = "";
                boolean firstchk = true;
                for (int id : chkid){
                    check = findViewById(id);
                    if (check.isChecked()) {
                        if(firstchk){
                            chkvalue += "你點了：";
                            firstchk = false;
                        }
                        chkvalue += check.getText() + ",";
                    }
                }
                if (chkvalue.isEmpty()) {
                    chkvalue = "你沒有點任何東西";
                }
                cal();
                textView.setText(date.getText()+" "+time.getText()+","+
                        spinner.getSelectedItem().toString()+","+
                        spinner2.getSelectedItem().toString()+","+
                        spinner3.getSelectedItem().toString()+","+
                        editText.getText()+"張,票券編號："+
                        editText3.getText()+","+
                        chkvalue+"共"+String.valueOf(price)+"元"
                        );
                bdr.setMessage("確認清單");
                bdr.setTitle("確定加入listView清單嗎？");
                bdr.setIcon(android.R.drawable.btn_star_big_on);
                bdr.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Snackbar.make(findViewById(R.id.root), "不加入清單，請重新確認您的選項！謝謝", Snackbar.LENGTH_SHORT).show();
                    }
                });
                bdr.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Snackbar.make(findViewById(R.id.root), "謝謝您的訂購" + textView.getText().toString(), Snackbar.LENGTH_INDEFINITE).show();
                        arrayAdapter.add("謝謝您的訂購" + textView.getText().toString());
                        listView.setAdapter(arrayAdapter);
                    }
                });
                bdr.setCancelable(true);
                bdr.show();
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = spinner.getItemAtPosition(i).toString();
                if (selectedItem.equals("Kaohsiung")){
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, Kaohsiung);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                } else if (selectedItem.equals("Taichung")) {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, Taichung);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, TPE);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = spinner2.getItemAtPosition(i).toString();
                if (selectedItem.equals("台北小巨蛋")||selectedItem.equals("台中國家歌劇院")||selectedItem.equals("大東表演中心")){
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, Performance2);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter);
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, Performance1);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void cal(){
        RadioButton radioButton = findViewById(R.id.radioButton);
        int unit = 0;

        if (spinner3.getSelectedItem().equals("步步驚笑")||spinner3.getSelectedItem().equals("生命中最美好的五分鐘")) {
            price = 1000 * Integer.parseInt(editText.getText().toString());
        }else {
            price = 800 * Integer.parseInt(editText.getText().toString());
        }
        for(int id : chkid){
            check = findViewById(id);
            if (id==R.id.checkBox && check.isChecked()) {
                unit += 50;
            } else if (id==R.id.checkBox2 && check.isChecked()) {
                unit += 40;
            } else if (id==R.id.checkBox3 && check.isChecked()) {
                unit += 80;
            }
        }
        price += unit * Integer.parseInt(editText.getText().toString());
        if (radioButton.isChecked() & editText3.getText().toString().equals("116")) {
            price *= 0.8;
        }
    }
    @Override
    public void onClick(View view) {
        if (view == date) {
            new DatePickerDialog(this, this,
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        } else if (view == time){
            new TimePickerDialog(this,this,
                    calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true).show();
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        date.setText(i+"/"+(i1+1)+"/"+i2);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        time.setText(i+":"+i1);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b){
            switch (compoundButton.getId()){
                case R.id.checkBox:
                    imageView.setVisibility(View.VISIBLE);
                    break;
                case R.id.checkBox2:
                    imageView2.setVisibility(View.VISIBLE);
                    break;
                case R.id.checkBox3:
                    imageView3.setVisibility(View.VISIBLE);
                    break;
            }
        }else {
            switch (compoundButton.getId()){
                case R.id.checkBox:
                    imageView.setVisibility(View.GONE);
                    break;
                case R.id.checkBox2:
                    imageView2.setVisibility(View.GONE);
                    break;
                case R.id.checkBox3:
                    imageView3.setVisibility(View.GONE);
                    break;
            }
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        editText3.setText("");
    }
}