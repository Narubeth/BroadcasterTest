package rmutr.narubeth.saowarak.norapol.broadcastertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ImageView talkNameImageView, newTestMaleImageView, newTestFemaleImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Image Controller
        ImageController();

    }   // Main Method

    private void ImageController() {
        talkNameImageView.setOnClickListener(this);
        newTestMaleImageView.setOnClickListener(this);
        newTestFemaleImageView.setOnClickListener(this);
    }

    private void bindWidget() {
        talkNameImageView = (ImageView) findViewById(R.id.imageView2);
        newTestMaleImageView = (ImageView) findViewById(R.id.imageView3);
        newTestFemaleImageView = (ImageView) findViewById(R.id.imageView4);

    }

    @Override
    public void onClick(View view) {

        String[] resultStrings = null;
        int intIcon = R.drawable.nameread;

        switch (view.getId()) {
            case R.id.imageView2:
                resultStrings = getResources().getStringArray(R.array.talkname);
                intIcon = R.drawable.nameread;
                break;
            case R.id.imageView3:
                resultStrings = getResources().getStringArray(R.array.testmale);
                intIcon = R.drawable.testboy;
                break;
            case R.id.imageView4:
                resultStrings = getResources().getStringArray(R.array.testfemale);
                intIcon = R.drawable.gtest;
                break;
            default:
                break;
        }   // switch


        //Intent to Detail ListView
        Intent objIntent = new Intent(MainActivity.this, DetailListView.class);
        objIntent.putExtra("Title", resultStrings);
        objIntent.putExtra("Icon", intIcon);
        startActivity(objIntent);

    }   //onClick
}   //Main Class
