package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2017/3/8.
 */

public class myViewPagerAdapter extends FragmentPagerAdapter{
    //我们不希望只支持英语 我们可以利用Context 来将字符串id与字符串连接起来；这样就可以使用多语言支持
    private Context myContext;

    public myViewPagerAdapter( Context context, FragmentManager fm) {
        super(fm);
        myContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1) {
            return new FamiyFragment();
        } else if (position == 2) {
            return new ColorFragment();
        } else {
            return new PharassFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return myContext.getString(R.string.category_numbers);
        }else if (position == 1) {
            return myContext.getString(R.string.category_family);
        }else if (position == 2) {
            return myContext.getString(R.string.category_colors);
        }else {
            return myContext.getString(R.string.category_phrases);
        }
    }
}
