package com.ekeitho.midpoint;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ekeitho on 4/9/16.
 */
public class FriendsHistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private FriendsHistoryAdapter adapter;
    private LinearLayoutManager manager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        adapter = new FriendsHistoryAdapter();
        manager = new LinearLayoutManager(getActivity());
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friends_history_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.friends_history_recycler);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
