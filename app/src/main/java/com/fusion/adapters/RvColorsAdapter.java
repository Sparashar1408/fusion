package com.fusion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class RvColorsAdapter extends RecyclerView.Adapter<RvColorsAdapter.Holder> {
    private Context context;
    private LayoutInflater layoutInflater;

    public RvColorsAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_colors, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (position == 0) {
            holder.circleImageView.setImageResource(R.color.app_green);
        } else if (position == 1) {
            holder.circleImageView.setImageResource(R.color.app_yellow);
        } else if (position == 2) {
            holder.circleImageView.setImageResource(R.color.app_purple);
        } else if (position == 3) {
            holder.circleImageView.setImageResource(R.color.colorAccent);
        } else if (position == 4) {
            holder.circleImageView.setImageResource(R.color.app_purple);
        } else if (position == 5) {
            holder.circleImageView.setImageResource(R.color.Black);
        } else {
            holder.circleImageView.setImageResource(R.color.app_dark_grey);
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class Holder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.item);
        }
    }
}
