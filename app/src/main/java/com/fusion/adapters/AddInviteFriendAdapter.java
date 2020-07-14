package com.fusion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;

public class AddInviteFriendAdapter extends RecyclerView.Adapter<AddInviteFriendAdapter.Holder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private boolean showMore = false;

    public AddInviteFriendAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_invite_friend, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (showMore)
            return 6;
        else return 2;
    }

    public void showMore() {
        showMore = true;
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
