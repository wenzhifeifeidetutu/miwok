package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/26.
 */

public class PharassAdapter extends ArrayAdapter<Pharass> {
    public PharassAdapter(Context context, ArrayList<Pharass> pharassArrayList){
        super(context, 0, pharassArrayList);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        //convertView is null
        if (listItemView == null){
            //Use LayoutInflater to convent a view
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.pharass_e_m, parent, false);
        }

        TextView pharassOfdefault = (TextView)listItemView.findViewById(R.id.pharass_english);
        TextView pharassOfMiwok = (TextView)listItemView.findViewById(R.id.pharass_miwok);

        //get the currentItemView
        Pharass pharass = getItem(position);

        pharassOfdefault.setText(pharass.getDefaultOfPharass());
        pharassOfMiwok.setText(pharass.getMiwokOfPharass());

        ImageView imageView = (ImageView)listItemView.findViewById(R.id.pharass_of_images);

        if (pharass.hasImage()){
            imageView.setImageResource(pharass.getPharassOfImageId());
        }else {
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
