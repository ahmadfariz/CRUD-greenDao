package com.ahmadfariz.crudgreendao;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView nama;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nama=itemView.findViewById(R.id.item_name);
    }

    public TextView getName() {
        return nama;
    }

}