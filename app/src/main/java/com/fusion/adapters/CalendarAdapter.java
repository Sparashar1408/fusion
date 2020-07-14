package com.fusion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;
import com.fusion.activities.MenuActivity;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.Holder> {
    private Context context;
    private LayoutInflater layoutInflater;

    public CalendarAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_calendar, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        MenuFriendsAdapter menuFriendsAdapter = new MenuFriendsAdapter(context);
        holder.recyclerView.setAdapter(menuFriendsAdapter);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        holder.recyclerView.addItemDecoration(new MenuActivity.ItemDecorator(-30));
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class Holder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rv_friends);
        }
    }
}
