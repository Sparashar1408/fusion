package com.fusion.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fusion.R;
import com.fusion.adapters.FriendsAdapter;
import com.fusion.databinding.FragmentFriendsBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {
    private FragmentFriendsBinding friendsBinding;
    private FriendsAdapter friendsAdapter;
    private int pos;

    public FriendsFragment(int position) {
        this.pos = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        friendsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_friends, container, false);
        View view = friendsBinding.getRoot();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        friendsAdapter = new FriendsAdapter(getActivity(), pos);
        friendsBinding.rvFriends.setAdapter(friendsAdapter);
        friendsBinding.rvFriends.setLayoutManager(layoutManager);
    }
}
