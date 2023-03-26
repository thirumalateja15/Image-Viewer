package com.example.imageviewer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ImagAdapter extends RecyclerView.Adapter<ImagAdapter.MyHolder> {

    Context context;
    ArrayList<String> arrayList = new ArrayList<>();

    public ImagAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.imgbox, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String id = arrayList.get(position);
        Glide.with(context).load(id).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView img;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.image);
        }
    }
}
