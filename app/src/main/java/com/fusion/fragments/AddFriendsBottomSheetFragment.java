package com.fusion.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fusion.R;
import com.fusion.adapters.AddInviteFriendAdapter;
import com.fusion.databinding.FragmentAddFriendsBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.lang.reflect.Field;

public class AddFriendsBottomSheetFragment extends BottomSheetDialogFragment {
    private FragmentAddFriendsBottomSheetBinding sheetBinding;
    private AddInviteFriendAdapter addInviteFriendAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sheetBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_friends_bottom_sheet, container, false);
        View view = sheetBinding.getRoot();
//        sheetBinding.scrollView.setSmoothScrollingEnabled(false);
        setInviteFriendsAdapter();
        setFriendsAdapter();
        sheetBinding.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sheetBinding.btnMore.setVisibility(View.GONE);
                addInviteFriendAdapter.showMore();
            }
        });
        return view;
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
        bottomSheetDialog.setContentView(R.layout.fragment_add_friends_bottom_sheet);
        try {
            Field behaviorField = bottomSheetDialog.getClass().getDeclaredField("behavior");
            behaviorField.setAccessible(true);
            final BottomSheetBehavior behavior = (BottomSheetBehavior) behaviorField.get(bottomSheetDialog);
            assert behavior != null;
            behavior.setDraggable(false);
//            behavior.setHalfExpandedRatio(0.6f);
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

    private void setInviteFriendsAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        addInviteFriendAdapter = new AddInviteFriendAdapter(getActivity());
        sheetBinding.rvInviteFriends.setAdapter(addInviteFriendAdapter);
//        linearLayoutManager.setAutoMeasureEnabled(true);
        sheetBinding.rvInviteFriends.setLayoutManager(linearLayoutManager);
        sheetBinding.rvInviteFriends.setNestedScrollingEnabled(true);
        sheetBinding.rvInviteFriends.setHasFixedSize(false);
    }


    private void setFriendsAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        addInviteFriendAdapter = new AddInviteFriendAdapter(getActivity());
        sheetBinding.rvFriends.setAdapter(addInviteFriendAdapter);
//        linearLayoutManager.setAutoMeasureEnabled(true);
        sheetBinding.rvFriends.setLayoutManager(linearLayoutManager);
        sheetBinding.rvFriends.setNestedScrollingEnabled(true);
        sheetBinding.rvFriends.setHasFixedSize(false);
    }
}
