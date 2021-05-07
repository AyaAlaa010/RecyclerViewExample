package com.example.recyclerviewexample;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StoryDetailsActivity extends AppCompatActivity {
story mystory;
ImageView myimage;
TextView firstText,secondText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_details);
        myimage=(ImageView) findViewById(R.id.mystory_img);
        firstText=(TextView) findViewById(R.id.txt1);
        secondText=(TextView) findViewById(R.id.txt2);
        if(getIntent().hasExtra("story")) {

            mystory = (story) getIntent().getSerializableExtra("story");

        }
        myimage.setImageResource(mystory.getImageStory());
        firstText.setText(mystory.getName());
        secondText.setText(mystory.getDescription());}

}