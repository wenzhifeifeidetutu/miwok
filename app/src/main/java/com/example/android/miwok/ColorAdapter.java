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

public class ColorAdapter extends ArrayAdapter<Color> {

    public ColorAdapter(Context context, ArrayList<Color> colorslist){
        super(context, 0, colorslist);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.color_e_m, parent, false);
        }
        Color color = getItem(position);

        TextView colorOfM = (TextView)listItemView.findViewById(R.id.color_miwok);
        TextView colorOfE = (TextView)listItemView.findViewById(R.id.color_english);

        colorOfM.setText(color.getColorOfMiwok());
        colorOfE.setText(color.getColorOfdefault());
        ImageView imageView = (ImageView)listItemView.findViewById(R.id.color_of_images);
        imageView.setImageResource(color.getColorOfImageId());

        return listItemView;
    }


}
