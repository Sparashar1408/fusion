package com.fusion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;

public class FriendRequestAdapter extends RecyclerView.Adapter<FriendRequestAdapter.Holder> {
    private Context context;
    private LayoutInflater layoutInflater;

    public FriendRequestAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_firend_requests, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (position == 3) {
            holder.llAcceptDecline.setVisibility(View.VISIBLE);
        } else holder.llAcceptDecline.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class Holder extends RecyclerView.ViewHolder {
        private LinearLayout llAcceptDecline;

        public Holder(@NonNull View itemView) {
            super(itemView);
            llAcceptDecline = itemView.findViewById(R.id.ll_accept_decline);
        }
    }
}
