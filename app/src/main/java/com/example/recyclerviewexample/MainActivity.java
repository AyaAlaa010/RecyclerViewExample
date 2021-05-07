package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.PopupMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<story> mystoryArray;
    RecyclerView myrecycler;
    storyAdapter myadapter;

    StoriesI  storiesI = new StoriesI() {
        @Override
        public void onStoryClick(story mystory) {
            Intent intent=new Intent(MainActivity.this,StoryDetailsActivity.class);
            intent.putExtra("story",mystory);
            startActivity(intent);
        }

        @Override
        public void onMoreClick(story mystory, View v) {
            PopupMenu popupMenu=new PopupMenu(MainActivity.this,v);
            popupMenu.getMenuInflater().inflate(R.menu.mypopupmenue,popupMenu.getMenu());
            popupMenu.show();
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if(item.getItemId()==R.id.mypop_delete){

                        deleteStory(mystory);
                    }
                    return false;
                }
            });
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mystoryArray = new ArrayList<>();
        mystoryArray.add(new story("story1", R.drawable.story1));
        mystoryArray.add(new story("story2", R.drawable.story2));
        mystoryArray.add(new story("story3", R.drawable.story1));
        mystoryArray.add(new story("story4", R.drawable.story2));
        mystoryArray.add(new story("story5", R.drawable.story1));
        myrecycler = (RecyclerView) findViewById(R.id.myrecycler);
        myadapter = new storyAdapter(mystoryArray, MainActivity.this,storiesI);
        myrecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        myrecycler.setAdapter(myadapter);

    }
    public void deleteStory( story mystory){
        mystoryArray.remove(mystory);
        myadapter.notifyDataSetChanged();



    }
}