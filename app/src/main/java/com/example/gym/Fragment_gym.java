package com.example.gym;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fragment_gym extends Fragment{
    private TextView textView;
    private List<ItemGym> mItemContentList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_gym,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        initItemContent();
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recycle_view_gym);
        LinearLayoutManager linerManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linerManager);
        GymAdapter adapter = new GymAdapter (this,mItemContentList );
        recyclerView.setAdapter(adapter);

    }
    private void initItemContent() {
        ItemGym kola1 = new ItemGym("Gym1",R.drawable.gym11);
        ItemGym kola2 = new ItemGym("Gym2",R.drawable.gym22);
        ItemGym kola3 = new ItemGym("Gym3",R.drawable.gym33);
        ItemGym kola4 = new ItemGym("Gym4",R.drawable.gym44);
        ItemGym kola5 = new ItemGym("Gym5",R.drawable.gym5);
        mItemContentList .add(kola1);
        mItemContentList .add(kola2);
        mItemContentList .add(kola3);
        mItemContentList .add(kola4);
        mItemContentList .add(kola5);



    }
}
