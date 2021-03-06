package rmutr.narubeth.saowarak.norapol.broadcastertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class DetailListView extends AppCompatActivity {

    //Explicit
    private String[] titleStrings;
    private int iconAnInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_view);


        //Receive Value From Intent
        receiveValue();

        //Create ListView
        createListViw();

    }   // Main Method

    public void clickBackListView(View view) {
        finish();
    }

    private void createListViw() {

        MyAdapter objMyAdapter = new MyAdapter(DetailListView.this, titleStrings, iconAnInt);
        ListView myListView = (ListView) findViewById(R.id.listView);
        myListView.setAdapter(objMyAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                //intent to ShowVideoActivity
                Intent objIntent = new Intent(DetailListView.this, ShowVideoActivity.class);
                objIntent.putExtra("Title", titleStrings[i]);
                objIntent.putExtra("Video", R.raw.talkname1);
                startActivity(objIntent);

            }   //event
        });

    }   //createListView

    private void receiveValue() {

        titleStrings = getIntent().getStringArrayExtra("Title");
        iconAnInt = getIntent().getIntExtra("icon", R.drawable.nameread);

        for (int i=0;i<titleStrings.length;i++) {
            Log.d("Test", "titleString[" + Integer.toString(i) + "] = " + titleStrings[i]);
        }
    } // receiveValue
}   // Main Class
