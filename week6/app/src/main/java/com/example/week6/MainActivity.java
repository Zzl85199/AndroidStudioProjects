package com.example.week6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher, CompoundButton.OnCheckedChangeListener {
    TextView textview2,textView3;
    EditText editText;
    Button button,button2;
    RadioGroup radioGroup;
    CheckBox ck,checkBox,checkBox2,checkBox3,checkBox4;
    int[] chkid = {R.id.checkBox,R.id.checkBox2,R.id.checkBox3,R.id.checkBox4};
    ImageView imageView,imageView2,imageView3,imageView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        editText = findViewById(R.id.editTextTextPersonName);
        radioGroup = findViewById(R.id.radioGroup1);
        for (int id : chkid){
            ck = findViewById(id);
            ck.setOnCheckedChangeListener(this);
        }
        /*checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);*/
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        editText.addTextChangedListener(this);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    public void cal(){
        int count = 0;
        int price = 0;

        if(editText.getText().toString().equals("")){
            count = 0;
        }else {
            count = Integer.parseInt(editText.getText().toString());
        }

        if(radioGroup.getCheckedRadioButtonId() == R.id.radioButton){
            price = (int)(100*0.8)*count;
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.radioButton2) {
            price = 100*count;
        }
        else {
            price = (int)(100*0.5)*count;
        }
        textview2.setText("總金額：" + price + "元");
    }

    public void order(){
        String choice = "你想要購買：";
        /*if (checkBox.isChecked()){
            choice += checkBox.getText().toString() + ",";
            imageView.setVisibility(View.VISIBLE);
        }
        if (checkBox2.isChecked()){
            choice += checkBox2.getText().toString() + ",";
            imageView2.setVisibility(View.VISIBLE);
        }
        if (checkBox3.isChecked()){
            choice += checkBox3.getText().toString() + ",";
            imageView3.setVisibility(View.VISIBLE);
        }
        if (checkBox4.isChecked()){
            choice += checkBox4.getText().toString() + ",";
            imageView4.setVisibility(View.VISIBLE);
        }*/
        for (int id:chkid) {
                ck = findViewById(id);
                if (ck.isChecked()){
                    choice += ck.getText().toString() + ",";
                }
        }
        textView3.setText(choice);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button){
            cal();
        }
        else if (view.getId() == R.id.button2){
            order();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        cal();
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        cal();
    }

    @Override
    public void afterTextChanged(Editable editable) {
        cal();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        int visible = View.VISIBLE;
        int gone = View.GONE;

        if (isChecked){
            switch (compoundButton.getId()){
                case R.id.checkBox:
                    imageView.setVisibility(visible);
                    break;
                case R.id.checkBox2:
                    imageView2.setVisibility(visible);
                    break;
                case R.id.checkBox3:
                    imageView3.setVisibility(visible);
                    break;
                case R.id.checkBox4:
                    imageView4.setVisibility(visible);
                    break;
            }
        }
        else {
            switch (compoundButton.getId()){
                case R.id.checkBox:
                    imageView.setVisibility(gone);
                    break;
                case R.id.checkBox2:
                    imageView2.setVisibility(gone);
                    break;
                case R.id.checkBox3:
                    imageView3.setVisibility(gone);
                    break;
                case R.id.checkBox4:
                    imageView4.setVisibility(gone);
                    break;
            }
        }
        String choice = "你想要購買：";
        for (int id:chkid) {
            ck = findViewById(id);
            if (ck.isChecked()){
                choice += ck.getText().toString() + ",";
            }
        }
        textView3.setText(choice);
    }
}