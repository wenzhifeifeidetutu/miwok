package com.example.android.miwok;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/2/22.
 */

public class NumberClicListen implements View.OnClickListener {
    @Override
    public void onClick(View v) {
       // Toast.makeText(v.getContext(), "you click list of numbers",Toast.LENGTH_SHORT ).show();
        Intent numberIntent = new Intent(v.getContext(), NumberActivity.class);
        v.getContext().startActivity(numberIntent);
    }


}
