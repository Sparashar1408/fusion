package com.fusion.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;
import com.fusion.adapters.ChatAdapter;
import com.fusion.databinding.FragmentChatBottomSheetBinding;
import com.fusion.model.ChatModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatBottomSheetFragment extends BottomSheetDialogFragment {
    private FragmentChatBottomSheetBinding sheetBinding;
    private Boolean aBoolean = false;
    private ArrayList<ChatModel> modelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sheetBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat_bottom_sheet, container, false);
        View view = sheetBinding.getRoot();
//        sheetBinding.scrollView.setSmoothScrollingEnabled(false);
        setChatAdapter();
        return view;
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
        bottomSheetDialog.setContentView(R.layout.fragment_chat_bottom_sheet);
        try {
            Field behaviorField = bottomSheetDialog.getClass().getDeclaredField("behavior");
            behaviorField.setAccessible(true);
            final BottomSheetBehavior behavior = (BottomSheetBehavior) behaviorField.get(bottomSheetDialog);
            assert behavior != null;
            behavior.setDraggable(false);
//            behavior.setHalfExpandedRatio(0.8f);
            behavior.setPeekHeight(1200);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getTheme() {
        return R.style.AppBottomSheetDialogTheme;
    }

    private void setChatAdapter() {
        modelArrayList = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            ChatModel chatModel = new ChatModel();
            aBoolean = !aBoolean;
            chatModel.setSender(aBoolean);
            modelArrayList.add(chatModel);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        ChatAdapter chatAdapter = new ChatAdapter(getActivity(), modelArrayList);
        sheetBinding.rvChat.setAdapter(chatAdapter);
        linearLayoutManager.setAutoMeasureEnabled(true);
        sheetBinding.rvChat.setLayoutManager(linearLayoutManager);
        sheetBinding.rvChat.setNestedScrollingEnabled(false);
        sheetBinding.rvChat.setHasFixedSize(false);
    }
}
