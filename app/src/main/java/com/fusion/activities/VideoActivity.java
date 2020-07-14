package com.fusion.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;
import com.fusion.adapters.EmojisAdapter;
import com.fusion.adapters.FriendRequestAdapter;
import com.fusion.adapters.VideoAdapter;
import com.fusion.databinding.ActivityVideoBinding;
import com.fusion.fragments.AddFriendsBottomSheetFragment;
import com.fusion.fragments.ChatBottomSheetFragment;
import com.fusion.fragments.VideoBottomSheetFragment;
import com.fusion.interfaces.ClickInterface;
import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;

import java.util.ArrayList;


public class VideoActivity extends AppCompatActivity implements ClickInterface, View.OnClickListener {
    private ActivityVideoBinding videoBinding;
    private ArrayList<Emoji> emojisList;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        videoBinding = DataBindingUtil.setContentView(this, R.layout.activity_video);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            pos = bundle.getInt("value");
        }
        emojisList = new ArrayList<Emoji>();
        videoBinding.ivInfo.setOnClickListener(this);
        videoBinding.ivChat.setOnClickListener(this);
        videoBinding.ivVideo.setOnClickListener(this);
        videoBinding.ivAdd.setOnClickListener(this);
        videoBinding.ivHide.setOnClickListener(this);
        videoBinding.ivReact.setOnClickListener(this);
        videoBinding.ivSetting.setOnClickListener(this);
        videoBinding.ivClose.setOnClickListener(this);
        setAdapter();
        setRequestsAdapter();
        getAllEmojis("");
//        emojisList = getAllEmojis("");
    }

    public void getAllEmojis(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("smile");
        arrayList.add("smiley");
        arrayList.add("grinning");
        arrayList.add("smiley");
        arrayList.add("blush");
        arrayList.add("wink");
        arrayList.add("heart_eyes");
        arrayList.add("kissing_heart");
        arrayList.add("kissing_closed_eyes");
        arrayList.add("kissing");
        arrayList.add("kissing_smiling_eyes");
        for (int i = 0; i < arrayList.size(); i++) {
            Emoji emoji = EmojiManager.getForAlias(arrayList.get(i));
            emojisList.add(emoji);
        }
        /*ArrayList<String> emojis = new ArrayList<>();
        for (Emoji emoji : EmojiManager.getAll()) {
            emojis.add(emoji.getUnicode());
        }
        emojisList = emojis;*/
//        Collections.sort(emojisList);
        setEmojisAdapter();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    private void setRequestsAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        FriendRequestAdapter friendRequestAdapter = new FriendRequestAdapter(this);
        videoBinding.rvRequests.setAdapter(friendRequestAdapter);
        videoBinding.rvRequests.setLayoutManager(linearLayoutManager);

    }

    private void setEmojisAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        EmojisAdapter emojisAdapter = new EmojisAdapter(this, emojisList);
        videoBinding.rvEmojis.setAdapter(emojisAdapter);
        videoBinding.rvEmojis.setLayoutManager(linearLayoutManager);
    }

    private void setAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        VideoAdapter videoAdapter = new VideoAdapter(this,pos);
        videoBinding.rvFriends.setAdapter(videoAdapter);
        videoAdapter.setClickListener(this);
        videoBinding.rvFriends.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void click() {
        videoBinding.llBtm.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_info:
                videoBinding.rlTop.setVisibility(View.VISIBLE);
                videoBinding.llBottom.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_chat:
                ChatBottomSheetFragment chatBottomSheetFragment = new ChatBottomSheetFragment();
                chatBottomSheetFragment.show(getSupportFragmentManager(), "");
                break;
            case R.id.iv_video:
                VideoBottomSheetFragment videoBottomSheetFragment = new VideoBottomSheetFragment();
                videoBottomSheetFragment.show(getSupportFragmentManager(), "");
                break;
            case R.id.iv_add:
                AddFriendsBottomSheetFragment addFriendsBottomSheetFragment = new AddFriendsBottomSheetFragment();
                addFriendsBottomSheetFragment.show(getSupportFragmentManager(), "");
                break;
            case R.id.iv_react:
                if (videoBinding.rvEmojis.getVisibility() == View.VISIBLE) {
                    videoBinding.rvEmojis.setVisibility(View.GONE);
                } else
                    videoBinding.rvEmojis.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_hide:
                break;
            case R.id.iv_setting:
                Intent intent = new Intent(this, GroupSettingActivity.class);
                intent.putExtra("name", "name");
                startActivity(intent);
                break;
            case R.id.iv_close:
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.dialog);
                TextView tvCancel, tvExit;
                tvCancel = dialog.findViewById(R.id.tv_cancel);
                tvExit = dialog.findViewById(R.id.tv_exit);
                tvExit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                tvCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
        }
    }
}
