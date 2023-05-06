package com.example.week12_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickable(View view) {
        //Searching for a location
        /*
        //說明
        geo:latitude,longitude?q=query
        geo:0,0?q=my+street+address
        geo:0,0?q=latitude,longitude(label)
         */

        //Searching for a specific address will display a pin at that location.
        //Search 長庚大學地址
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=台灣桃園市龜山區文化一路259號長庚大學"); //fill in
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        txv.setText("fun1");
    }

    public void clickable2(View view) {
        // Search for restaurants nearby
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=restaurants"); //fill in
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        txv.setText("fun2");

    }


    public void clickable3(View view) {
        // Search for restaurants in Chang Gung University
        Uri gmmIntentUri = Uri.parse("geo:25.0331302,121.3875233?q=restaurants"); //fill in
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        txv.setText("fun3");
    }

    public void clickable4(View view) {
        // Searching for 中正road nearby
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=中正路");//fill in
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        txv.setText("fun4");

    }

    public void clickable5(View view) {
        // Searches for 中正road near Chang Gung University
        Uri gmmIntentUri = Uri.parse("geo:25.0331302,121.3875233?q=中正路"); //fill in
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        txv.setText("fun5");

    }

    public void clickable6(View view) {
        // Display a label at the location of Chang Gung University
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=25.0331302,121.3875233(Chang+Gung+University)"); //fill in
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        txv.setText("fun6");

    }

    public void clickable7(View view) {
        //Launching turn-by-turn navigation
        //google.navigation:q=a+street+address
        //google.navigation:q=latitude,longitude
        //d for driving (default)
        //b for bicycling
        //l for two-wheeler
        //w for walking
        //t for tolls 通行費
        //h for highways 高速公路
        //f for ferries 渡輪
        //The below Intent will request turn-by-turn navigation 導航 to Taipei Zoo, in Taiwan:
        Uri gmmIntentUri = Uri.parse("google.navigation:q=Taipei+zoo,+Taipei,+Taiwan"); //fill in
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        txv.setText("fun7");

    }

    public void clickable8(View view) {
        //The below Intent will request turn-by-turn navigation 導航 to Taipei Zoo, in Taiwan to avoid th
        Uri gmmIntentUri = Uri.parse("google.navigation:q=Taipei+zoo,+Taipei,+Taiwan&avoid=th"); //fill in
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        txv.setText("fun8");

    }


    public void clickable9(View view) {
        //The below Intent will request turn-by-turn navigation 導航 to Taipei Zoo, in Taiwan by walk
        Uri gmmIntentUri = Uri.parse("google.navigation:q=Taipei+zoo,+Taipei,+Taiwan&mode=w"); //fill in
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        txv.setText("fun9");

    }

    public void clickable10(View view) {
        //Displaying a Street View panorama
        //google.streetview:cbll=latitude,longitude&cbp=0,bearing,0,zoom,tilt
        //google.streetview:panoid=id&cbp=0,bearing,0,zoom,tilt

        // Displays an image of the Swiss Alps
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988"); //fill in
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        txv.setText("fun10");

    }


    /*
    Building a Google Street View URL
    Basic Google Map URL http://maps.google.com/maps?q=
    q= Query - anything passed in this parameter is treated as if it had been typed into the query box on the maps.google.com page.
    Basic url to display GPS cords location
    http://maps.google.com/maps?q=31.33519,-89.28720
    http://maps.google.com/maps?q=&layer=c
    layer= Activates overlays. Current options are "t" traffic, "c" street view. Append (e.g. layer=tc) for simultaneous.
    http://maps.google.com/maps?q=&layer=c&cbll=
    cbll= Latitude,longitude for Street View
    http://maps.google.com/maps?q=&layer=c&cbll=31.33519,-89.28720
    http://maps.google.com/maps?q=&layer=c&cbll=31.335198,-89.287204&cbp=
    cbp= Street View window that accepts 5 parameters:
    Street View/map arrangement, 11=upper half Street View and lower half map, 12=mostly Street View with corner map
    Rotation angle/bearing (in degrees)
    Tilt angle, -90 (straight up) to 90 (straight down)
    Zoom level, 0-2
    Pitch (in degrees) -90 (straight up) to 90 (straight down), default 5
    The one below is: (11) upper half Street View and lower half map, (0) Facing North, (0) Straight Ahead, (0) Normal Zoom, (0) Pitch of 0
    This one works as is, just change the cords and if you want to face a different direction (the 0 after 11) http://maps.google.com/maps?q=&layer=c&cbll=31.335198,-89.287204&cbp=11,0,0,0,0
     */

    public void clickable11(View view) {
        // Opens Street View between two Pyramids in Giza. The values passed to the
        // cbp parameter will angle the camera slightly up, and towards the east.
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=29.9774614,31.1329645&cbp=0,30,0,0,-15"); //fill in
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        txv.setText("fun11");
    }



    public void clickable12(View view) {
        Intent it = new Intent();
        //search for keyword "長庚大學"
        //fill in
        it.setAction(Intent.ACTION_WEB_SEARCH);
        it.putExtra(SearchManager.QUERY,"長庚大學");
        startActivity(it);
        txv.setText("fun12");
    }

    public void clickable13(View view) {
        Intent it = new Intent();
        it.setAction(Intent.ACTION_VIEW);
        //search for google website
        //fill in
        it.setData(Uri.parse("http://www.google.com"));
        startActivity(it);
        txv.setText("fun13");
    }

    public void clickable14(View view) {
        Intent it = new Intent();
        it.setAction(Intent.ACTION_VIEW);
        //search for a location via latitude and longitude
        it.setData(Uri.parse("geo:25.0337323,121.5619046")); //fill in
        startActivity(it);
        txv.setText("fun14");
    }

    public void clickable15(View view) {
        Intent it = new Intent();
        it.setAction(Intent.ACTION_VIEW);
        //search for 大安森林公園
        it.setData(Uri.parse("geo:0,0?q=大安森林公園")); //fill in
        startActivity(it);
        txv.setText("fun15");
    }


}