package com.fusion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;

import java.util.ArrayList;

public class MenuVideoAdapter extends RecyclerView.Adapter<MenuVideoAdapter.Holder> {
    private Context context;
    private ArrayList<String> videoList;
    private LayoutInflater layoutInflater;

    public MenuVideoAdapter(Context context, ArrayList<String> videoList) {
        this.context = context;
        this.videoList = videoList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_video, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
