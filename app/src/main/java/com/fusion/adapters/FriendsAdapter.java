package com.fusion.adapters;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;
import com.fusion.activities.MenuActivity;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.Holder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private int pos;

    public FriendsAdapter(Context context, int pos) {
        this.context = context;
        this.pos = pos;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_profile_friends, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (pos == 0) {
            holder.rlMain.setVisibility(View.GONE);
            holder.rlSecond.setVisibility(View.VISIBLE);
            if (position == 1) {
                GradientDrawable gradientDrawable = (GradientDrawable) holder.rlSecond.getBackground();
                gradientDrawable.setColor(context.getResources().getColor(R.color.Chocolate));
            }
        } else {
            if (pos == 1) {
                holder.rlPoster.setVisibility(View.INVISIBLE);
                holder.rlFriend.setVisibility(View.VISIBLE);
            } else {
                holder.rlPoster.setVisibility(View.VISIBLE);
                holder.rlFriend.setVisibility(View.GONE);
            }
            holder.rlMain.setVisibility(View.VISIBLE);
            holder.rlSecond.setVisibility(View.GONE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            MenuFriendsAdapter menuFriendsAdapter = new MenuFriendsAdapter(context);
            holder.recyclerView.setAdapter(menuFriendsAdapter);
            holder.recyclerView.setLayoutManager(linearLayoutManager);
            holder.recyclerView.addItemDecoration(new MenuActivity.ItemDecorator(-30));
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class Holder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        private RelativeLayout rlMain;
        private ImageView ivPoster, ivAddFriend;
        private RelativeLayout rlSecond;
        private RelativeLayout rlPoster, rlFriend;

        public Holder(@NonNull View itemView) {
            super(itemView);
            rlMain = itemView.findViewById(R.id.rl_main);
            ivAddFriend = itemView.findViewById(R.id.iv_add_friend);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            recyclerView = itemView.findViewById(R.id.rv_main_friends);
            rlSecond = itemView.findViewById(R.id.rl_main_friends);
            rlPoster = itemView.findViewById(R.id.rl_poster);
            rlFriend = itemView.findViewById(R.id.rl_add_friend);
        }
    }
}
