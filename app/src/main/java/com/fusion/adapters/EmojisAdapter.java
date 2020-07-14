package com.fusion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;
import com.vdurmont.emoji.Emoji;

import java.util.ArrayList;

public class EmojisAdapter extends RecyclerView.Adapter<EmojisAdapter.Holder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Emoji> list;

    public EmojisAdapter(Context context, ArrayList<Emoji> strings) {
        this.context = context;
        this.list = strings;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_emojis, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tvItem.setText(list.get(position).getUnicode() + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView tvItem;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
        }
    }
}
