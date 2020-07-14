package com.fusion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;
import com.fusion.model.ChatModel;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter {
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    private Context mContext;
    private ArrayList<ChatModel> messageList;

    public ChatAdapter(Context context, ArrayList<ChatModel> messageList) {
        mContext = context;
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_message_sent, parent, false);
            return new SentMessageHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_message_received, parent, false);
            return new ReceivedMessageHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatModel message = (ChatModel) messageList.get(position);
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MESSAGE_SENT:
                ((SentMessageHolder) holder).bind(position);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceivedMessageHolder) holder).bind(position);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        ChatModel message = (ChatModel) messageList.get(position);
        if (message.isSender()) {
            // If the current user is the sender of the message
            return VIEW_TYPE_MESSAGE_SENT;
        } else {
            // If some other user sent the message
            return VIEW_TYPE_MESSAGE_RECEIVED;
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    private class SentMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText;
        private CardView cardView;
        RelativeLayout rlVideo;

        SentMessageHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            rlVideo = itemView.findViewById(R.id.rl_video);
            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
        }

        void bind(int message) {
            if (message >= 4) {
                rlVideo.setVisibility(View.VISIBLE);
                cardView.setVisibility(View.GONE);
            } else {
                rlVideo.setVisibility(View.GONE);
                cardView.setVisibility(View.VISIBLE);
                messageText.setText("                  ");
            }

        }
    }

    private class ReceivedMessageHolder extends RecyclerView.ViewHolder {
        private final CardView cardView;
        TextView messageText;
        ImageView profileImage;
        RelativeLayout rlVideo;

        ReceivedMessageHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            rlVideo = itemView.findViewById(R.id.rl_video);
            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
            profileImage = (ImageView) itemView.findViewById(R.id.image_message_profile);
        }

        void bind(int message) {
            if (message >= 4) {
                rlVideo.setVisibility(View.VISIBLE);
                profileImage.setVisibility(View.GONE);
                cardView.setVisibility(View.GONE);
            } else {
                rlVideo.setVisibility(View.GONE);
                profileImage.setVisibility(View.VISIBLE);
                cardView.setVisibility(View.VISIBLE);
                messageText.setText("                  ");
            }
        }
    }

}
