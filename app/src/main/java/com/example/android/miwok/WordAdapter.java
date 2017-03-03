package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/23.
 */

public class WordAdapter extends ArrayAdapter<Words> {

    public WordAdapter(Context context, ArrayList<Words> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        //convertView is null
        if(listItemView == null){
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.number_e_m, parent,false);

        }

        Words words = getItem(position);
        TextView defaultwords = (TextView)listItemView.findViewById(R.id.english);
        defaultwords.setText(words.getDefaultwords());
        TextView miwok = (TextView)listItemView.findViewById(R.id.miwok);
        miwok.setText(words.getMiwok());
        ImageView imageView =(ImageView)listItemView.findViewById(R.id.number_of_images);
        imageView.setImageResource(words.getImageId());

        return listItemView;
    }




}
