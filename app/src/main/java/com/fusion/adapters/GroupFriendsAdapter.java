package com.fusion.adapters;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;
import com.fusion.activities.MenuActivity;

public class GroupFriendsAdapter extends RecyclerView.Adapter<GroupFriendsAdapter.Holder> {
    private Context context;
    private LayoutInflater layoutInflater;

    public GroupFriendsAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_group_bottom, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (position == 0) {
            holder.tvTitle.setText("ATL Kats");
            GradientDrawable gradientDrawable = (GradientDrawable) holder.rlMain.getBackground();
            gradientDrawable.setColor(context.getResources().getColor(R.color.app_dark_grey));
        } else if (position == 1) {
            holder.tvTitle.setText("Yoda6");
            GradientDrawable gradientDrawable = (GradientDrawable) holder.rlMain.getBackground();
            gradientDrawable.setColor(context.getResources().getColor(R.color.Plum));
        } else if (position == 2) {
            holder.tvTitle.setText("WeAre2");
            GradientDrawable gradientDrawable = (GradientDrawable) holder.rlMain.getBackground();
            gradientDrawable.setColor(context.getResources().getColor(R.color.CadetBlue));
        } else {
            holder.tvTitle.setText("SciFiLovas");
            GradientDrawable gradientDrawable = (GradientDrawable) holder.rlMain.getBackground();
            gradientDrawable.setColor(context.getResources().getColor(R.color.Black));
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        MenuFriendsAdapter menuFriendsAdapter = new MenuFriendsAdapter(context);
        holder.rvView.setAdapter(menuFriendsAdapter);
        holder.rvView.setLayoutManager(linearLayoutManager);
        holder.rvView.addItemDecoration(new MenuActivity.ItemDecorator(-30));
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class Holder extends RecyclerView.ViewHolder {
        private RecyclerView rvView;
        private RelativeLayout rlMain;
        private TextView tvTitle;

        public Holder(@NonNull View itemView) {
            super(itemView);
            rvView = itemView.findViewById(R.id.rv_main_friends);
            rlMain = itemView.findViewById(R.id.rl_main);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
