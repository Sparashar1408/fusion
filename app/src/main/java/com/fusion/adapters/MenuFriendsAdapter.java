package com.fusion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MenuFriendsAdapter extends RecyclerView.Adapter<MenuFriendsAdapter.Holder> {
    private Context context;
    private LayoutInflater layoutInflater;

    public MenuFriendsAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_menu_friends, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        /*if (pos != 0) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(-30, 0, 0, 0);
            holder.view.setLayoutParams(lp);
        } else {
        }*/

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class Holder extends RecyclerView.ViewHolder {
        private CircleImageView view;

        public Holder(@NonNull View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.view);
        }
    }
}
