package com.example.gym;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import java.util.ArrayList;

public class Fragment_coach extends Fragment{
    private TextView textView;
    private List<ItemContent> mItemContentList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_coach,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

//        Button button = (Button)getView().findViewById(R.id.call_button);
//        if(button==null){
//            Log.e("error!!!!!!!!!!!!!!", "onActivityCreated: ");
//        }
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_LONG).show();
//            }
//        });

        initItemContent();
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recycle_view);
        LinearLayoutManager linerManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linerManager);
        MyAdapter adapter = new MyAdapter (mItemContentList );
        recyclerView.setAdapter(adapter);




    }
    private void initItemContent() {
        ItemContent kola1 = new ItemContent("Emily",R.drawable.dc1);
        ItemContent kola2 = new ItemContent("Hannah",R.drawable.dc2);
        ItemContent kola3 = new ItemContent("Jacob",R.drawable.dc3);
        ItemContent kola4 = new ItemContent("Daniel",R.drawable.dc4);
        ItemContent kola5 = new ItemContent("Jack",R.drawable.dc5);
        mItemContentList .add(kola1);
        mItemContentList .add(kola2);
        mItemContentList .add(kola3);
        mItemContentList .add(kola4);
        mItemContentList .add(kola5);



    }
}
