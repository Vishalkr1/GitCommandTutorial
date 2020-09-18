package com.example.bloggingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    private PostList[] postLists;
    private Context context;

    public Adapter( Context context, PostList[] postLists) {
        this.postLists = postLists;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.post_item, parent, false);
        return new Adapter.Viewholder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Adapter.Viewholder holder, int position) {
        final PostList postList = postLists[position];
        holder.userId.setText(postList.getId().toString()+".");
        holder.heading.setText(postList.getTitle());
        holder.body.setText(postList.getBody());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, postList.getTitle()+" was clicked", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return postLists.length;
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        public TextView userId, heading, body;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            heading = itemView.findViewById(R.id.postHeading);
            body = itemView.findViewById(R.id.postBody);
        }
    }
}
