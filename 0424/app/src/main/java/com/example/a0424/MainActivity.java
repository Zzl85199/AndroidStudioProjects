package com.example.a0424;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //一樣的方法撥打電話
    public void click(View view) {
        Intent it =new Intent();
        it.setAction(Intent.ACTION_VIEW);
        Uri uri=Uri.parse("tel:800");
        it.setData(uri);
        startActivity(it);
    }
    public void click2(View view) {
        Intent it =new Intent(Intent.ACTION_DIAL,Uri.parse("tel:800"));
        startActivity(it);
    }
    //直接撥電話出去
    public void click3(View view) {
        Intent it =new Intent(Intent.ACTION_CALL,Uri.parse("tel:800"));
        startActivity(it);
    }
    //加入通訊錄
    public void click4(View view) {
        Intent it =new Intent();
        it.setAction(ContactsContract.Intents.Insert.ACTION);
        it.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        it.putExtra(ContactsContract.Intents.Insert.NAME,"客服電話").putExtra(ContactsContract.Intents.Insert.PHONE,"800");
        startActivity(it);
    }
    //寄EMAIL
    public void click5(View view) {
        Intent it =new Intent();
        it.setAction(Intent.ACTION_VIEW);
        Uri uri=Uri.parse("mailto:ping91041686@gmail.com");
        it.setData(uri);
        it.putExtra(Intent.EXTRA_CC,new String[]{"test.cgu.edu.tw","ccc@gmail.cgu.edu.tw"});//寄副本，有多個時用陣列給他
        it.putExtra(Intent.EXTRA_SUBJECT,"hello");
        it.putExtra(Intent.EXTRA_TEXT,"Hello,\n Thanks for your kind help");
        startActivity(it);
    }
    //寄簡訊
    public void click6(View view) {
        Intent it =new Intent(Intent.ACTION_VIEW,Uri.parse("sms:0917008416?body=hello"));
        it.putExtra("sms_body","test123");
        startActivity(it);
    }
    //查台北車站(地理位置)
    public void click7(View view) {
        Intent it =new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=台北車站"));
        startActivity(it);
    }
    //查台北車站(經緯度)
    public void click8(View view) {
        Intent it =new Intent(Intent.ACTION_VIEW,Uri.parse("geo:25.047095,121.517308"));
        startActivity(it);
    }
    //呼叫搜尋引擎
    public void click9(View view) {
        Intent it =new Intent();
        it.setAction(Intent.ACTION_WEB_SEARCH);
        it.putExtra(SearchManager.QUERY,"長庚大學");
        startActivity(it);
    }
//用目前城式呼叫ACTIVITY2
    public void click10(View view) {
        Intent it =new Intent();
        it.setClass(this,MainActivity2.class);
        startActivity(it);
    }

}