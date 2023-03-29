package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;
    Spinner spinner, spinner2, spinner3, spinner4;
    TextView textView;
    EditText editText;
    String[] action, action2, action3, action4, action5, action6, action7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        editText = findViewById(R.id.editTextTextPersonName);
        action = getResources().getStringArray(R.array.ticket);
        action2 = getResources().getStringArray(R.array.type);
        action3 = getResources().getStringArray(R.array.TPE);
        action4 = getResources().getStringArray(R.array.TAO);
        action5 = getResources().getStringArray(R.array.TAI);
        action6 = getResources().getStringArray(R.array.KAO);
        action7 = getResources().getStringArray(R.array.Discount);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, action);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, action2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, action7);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter3);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedItem = spinner.getItemAtPosition(position).toString();
                if (selectedItem.equals("TPE")) {
                    ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, action3);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter3);
                } else if (selectedItem.equals("TAO")) {
                    ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, action4);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter3);
                } else if (selectedItem.equals("TAI")) {
                    ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, action5);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter3);
                } else if (selectedItem.equals("KAO")) {
                    ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, action6);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter3);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // do nothing
            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    editText.setText("");
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price=0;
                double discount=0, discount2=1;
                String type="";
                price = Integer.parseInt(editText.getText().toString());
                type = spinner2.getSelectedItem().toString();

                if(spinner4.getSelectedItem().toString().equals("不打折")){
                    discount = 1;
                } else if (spinner4.getSelectedItem().toString().equals("9折卷")) {
                    discount = 0.9;
                }else {
                    discount = 0.8;
                }

                if(spinner.getSelectedItem().toString().equals("TPE") && spinner3.getSelectedItem().toString().equals("美麗華")){
                    discount2 = 0.9;
                }
                if (spinner.getSelectedItem().toString().equals("TAO") && spinner3.getSelectedItem().toString().equals("A7")) {
                    discount2 = 0.6;
                }

                if(type.equals("adult")){
                    price *= (100*discount*discount2);
                } else if (type.equals("children")) {
                    price *= (50*discount*discount2);
                }else {
                    price *= (70*discount*discount2);
                }

                textView.setText("總價：" + price);
            }
        });





    }
}