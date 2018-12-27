package com.example.gym;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import java.util.HashMap;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class PageAdapter extends FragmentPagerAdapter {

    private int num;
    private HashMap<Integer, Fragment> mFragmentHashMap = new HashMap<>();

    public PageAdapter(FragmentManager fm, int num) {
        super(fm);
        this.num = num;
    }

    @Override
    public Fragment getItem(int position) {

        return createFragment(position);
    }

    @Override
    public int getCount() {
        return num;
    }

    private Fragment createFragment(int pos) {
        Fragment fragment = mFragmentHashMap.get(pos);

        if (fragment == null) {
            switch (pos) {
                case 0:
                    fragment = new Fragment_coach();
                    Log.i("fragment", "fragment1");
                    break;
                case 1:
                    fragment = new Fragment_gym();
                    Log.i("fragment", "fragment2");
                    break;

            }
            mFragmentHashMap.put(pos, fragment);
        }
        return fragment;
    }
}

