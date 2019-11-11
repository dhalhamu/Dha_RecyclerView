package com.example.do_recyclerview_task1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserViewDetails extends AppCompatActivity {


    private TextView tvtitle, tvdescription;
    private ImageView img;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvdescription = (TextView) findViewById(R.id.txtdesc);
        img =(ImageView) findViewById(R.id.userthumbnail);



        //Receive data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");



        //setting values
        tvtitle.setText(Title);
        tvdescription.setText(Description);
        img.setImageResource(image);
    }
}

