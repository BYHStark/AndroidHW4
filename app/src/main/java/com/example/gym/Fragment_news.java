package com.example.gym;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class Fragment_news extends Fragment {
    private List<ItemNews> mItemContentList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_news,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initItemContent();
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recycle_news);
        LinearLayoutManager linerManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linerManager);
        NewsAdapter adapter = new NewsAdapter (mItemContentList );
        recyclerView.setAdapter(adapter);

    }
    private void initItemContent() {
        ItemNews kola1 = new ItemNews("Running",R.drawable.nao1,"Running is an Attitude");
        ItemNews kola2 = new ItemNews("Swimming",R.drawable.nao2,"Become Thinner");
        ItemNews kola3 = new ItemNews("Basketball",R.drawable.nao3,"Burn my calorie");
        ItemNews kola4 = new ItemNews("Badminton",R.drawable.nao4,"Shuttlexcock");
        mItemContentList .add(kola1);
        mItemContentList .add(kola2);
        mItemContentList .add(kola3);
        mItemContentList .add(kola4);





    }
}
