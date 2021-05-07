package com.example.recyclerviewexample;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class storyAdapter extends RecyclerView.Adapter<storyAdapter.storyHolder> {
    ArrayList<story> storyArrayList=new ArrayList<> ();
    Context context;
   StoriesI storiesI;
    public storyAdapter(ArrayList<story> storyArrayList, Context context, StoriesI storiesI
    ) {
        this.storyArrayList = storyArrayList;
        this.context = context;
        this.storiesI =storiesI;

    }

    @NonNull
    @Override
    public storyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.design_includemenu,parent,false);
        storyHolder mystoryHolder=new storyHolder(view);
        return mystoryHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull storyHolder holder, int position) {
       story mystory=storyArrayList.get(position) ;
        holder.tvname.setText(mystory.getName());
        holder.storyView.setImageResource(mystory.getImageStory());
//      holder.itemView.setOnClickListener(new View.OnClickListener() {
//           @Override
//         public void onClick(View v) {
//               deleteNote(position);
//          }
//        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               Intent intent=new Intent(context,StoryDetailsActivity.class);
//                intent.putExtra("story",mystory);
//                context.startActivity(intent);
                storiesI.onStoryClick(mystory);


            }
        });
        holder.tvname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"tv name",Toast.LENGTH_LONG).show();
            }
        });
        holder.imgViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storiesI.onMoreClick(mystory,v);

            }
        });

    }

    @Override
    public int getItemCount() {
        return storyArrayList.size();
    }
   public void deleteNote(int position)
   {
        new AlertDialog.Builder(context).setTitle("Delete Story")
                .setMessage("Are you sure to delete this note")
                .setNegativeButton("cancel",null)
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        storyArrayList.remove(position);
                        notifyDataSetChanged();
                    }
                }).show();

    }

    public class storyHolder extends RecyclerView.ViewHolder {
    ImageView storyView;
       TextView tvname;
        ImageView imgViewMenu;
        public storyHolder(@NonNull View itemView) {
            super(itemView);
            storyView=itemView.findViewById(R.id.img_background);
            tvname=itemView.findViewById(R.id.mytv_story);
            imgViewMenu=itemView.findViewById(R.id.mymenue);
        }
    }



 }
