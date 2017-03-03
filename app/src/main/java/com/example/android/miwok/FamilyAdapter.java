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

public class FamilyAdapter extends ArrayAdapter<Family> {

    public FamilyAdapter(Context context, ArrayList<Family> Family){
       super(context, 0, Family);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemView = convertView;

        Family family = getItem(position);
        //convertView is null?
        if (listitemView == null){
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.family_e_m, parent, false);

        }
        TextView familyofdefault = (TextView) listitemView.findViewById(R.id.englishOfFamily);
        familyofdefault.setText(family.getDefaultWordsOfF());

        TextView familyofmiwok = (TextView) listitemView.findViewById(R.id.miwokOfFamily);
        familyofmiwok.setText(family.getMiwokWordsOfF());

        ImageView imageView = (ImageView) listitemView.findViewById(R.id.family_of_images);
        imageView.setImageResource(family.getFamilyOfImageId());
        return listitemView;
    }



}
