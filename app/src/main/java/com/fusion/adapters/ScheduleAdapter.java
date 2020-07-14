package com.fusion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;
import com.fusion.interfaces.ClickInterface;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.Holder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private ClickInterface clickInterface;

    public ScheduleAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_schedule, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.ivItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickInterface.click();
            }
        });
        /*if (position == 0) {
            holder.ivItem.setImageDrawable(context.getResources().getDrawable(R.drawable.iv_netflix));
        } else if (position == 1) {
            holder.ivItem.setImageDrawable(context.getResources().getDrawable(R.drawable.iv_netflix));
        } else if (position == 2) {
            holder.ivItem.setImageDrawable(context.getResources().getDrawable(R.drawable.iv_netflix));
        } else if (position == 3) {
            holder.ivItem.setImageDrawable(context.getResources().getDrawable(R.drawable.iv_netflix));
        } else if (position == 4) {
            holder.ivItem.setImageDrawable(context.getResources().getDrawable(R.drawable.iv_netflix));
        } else {
            holder.ivItem.setImageDrawable(context.getResources().getDrawable(R.drawable.iv_netflix));
        }*/
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public void setListerner(ClickInterface listerner) {
        this.clickInterface = listerner;
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView ivItem;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ivItem = itemView.findViewById(R.id.iv_item);
        }
    }
}
