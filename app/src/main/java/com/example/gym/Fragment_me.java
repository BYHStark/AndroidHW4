package com.example.gym;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Fragment_me extends Fragment{
    private TextView textView;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_me,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button tet = (Button) getView().findViewById(R.id.signout_bt_1);
        tet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent signin_1 = new Intent(getActivity(),Fragment_class.class);
//                startActivity(signin_1);

            }
        });
        Button btn1 = (Button) getView().findViewById(R.id.Message);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Message.class);
                startActivity(intent);
            }
        });

    }

}