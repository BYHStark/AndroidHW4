package com.example.gym;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public class MainUI extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Fragment_news fragmentNews;
    private Fragment_class fragmentClass;
    private Fragment_coach_gym fragment_coach_gym;
    //private Fragment_coach fragmentCoach;
    private Fragment_me fragmentMe;

    private Fragment[] fragments;
    private int lastfragment;//用于记录上个选择的Fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ui);
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bnv);

        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
        initFragment();
    }
    //初始化fragment和fragment数组
    private void initFragment()
    {

        fragmentNews = new Fragment_news();
        fragmentClass = new Fragment_class();
        //fragmentCoach = new Fragment_coach();
        fragment_coach_gym=new Fragment_coach_gym();
        fragmentMe = new Fragment_me();

        fragments = new Fragment[]{fragmentNews, fragmentClass, fragment_coach_gym, fragmentMe};
        lastfragment=0;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainview, fragmentNews).show(fragmentNews).commit();

    }

    //判断选择的菜单
    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.id1:
                {
                    if(lastfragment!=0)
                    {
                        switchFragment(lastfragment,0);
                        lastfragment=0;

                    }

                    return true;
                }
                case R.id.id2:
                {
                    if(lastfragment!=1)
                    {
                        switchFragment(lastfragment,1);
                        lastfragment=1;

                    }

                    return true;
                }
                case R.id.id3:
                {
                    if(lastfragment!=2)
                    {
                        switchFragment(lastfragment,2);
                        lastfragment=2;

                    }

                    return true;
                }
                case R.id.id4:
                {
                    if(lastfragment!=3)
                    {
                        switchFragment(lastfragment,3);
                        lastfragment=3;

                    }

                    return true;
                }

            }


            return false;
        }
    };
    //切换Fragment
    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if(fragments[index].isAdded()==false)
        {
            transaction.add(R.id.mainview,fragments[index]);


        }
        transaction.show(fragments[index]).commitAllowingStateLoss();


    }
}
