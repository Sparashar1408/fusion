package com.fusion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;
import com.fusion.interfaces.ClickInterface;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.Holder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private ClickInterface clickInterface;
    int pos;

    public VideoAdapter(Context context, int pos) {
        this.context = context;
        this.pos = pos;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_video_list, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.rlMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickInterface.click();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public void setClickListener(ClickInterface listener) {
        this.clickInterface = listener;
    }

    public class Holder extends RecyclerView.ViewHolder {
        private RelativeLayout rlMain;

        public Holder(@NonNull View itemView) {
            super(itemView);
            rlMain = itemView.findViewById(R.id.rl_main);
        }
    }
}
