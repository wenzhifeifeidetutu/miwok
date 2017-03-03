package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    private ArrayList<Words> numberofEList = new ArrayList<Words>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        numberofEList.add(new Words("one", "lutti", R.drawable.number_one, R.raw.number_one));
        numberofEList.add(new Words("two", "otiiko", R.drawable.number_two,R.raw.number_two ));
        numberofEList.add(new Words("three","tolookosu", R.drawable.number_three, R.raw.number_three));
        numberofEList.add(new Words("fore","oyyisa", R.drawable.number_four, R.raw.number_four));
        numberofEList.add(new Words("five","massokka", R.drawable.number_five, R.raw.number_five));
        numberofEList.add(new Words("six","temmokka", R.drawable.number_six,R.raw.number_six ));
        numberofEList.add(new Words("seven","kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numberofEList.add(new Words("eight","kawinta", R.drawable.number_eight, R.raw.number_eight));
        numberofEList.add(new Words("nine","wo’e", R.drawable.number_nine, R.raw.number_nine));
        numberofEList.add(new Words("ten","na’aacha", R.drawable.number_ten, R.raw.number_ten));

        //LinearLayout rootView = (LinearLayout)findViewById(R.id.activity_number);
        ListView numberofElistView =(ListView)findViewById(R.id.numbers_list);
        //GridView numberofEG = (GridView)findViewById(R.id.numbers_list);


        final WordAdapter wordAdapter = new WordAdapter(this, numberofEList);

        numberofElistView.setAdapter(wordAdapter);
        //numberofEG.setAdapter(itemsAdapter);
        numberofElistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //list.get(int)
                Words words = numberofEList.get(position);
                mediaPlayRelease();
                mediaPlayer = MediaPlayer.create(view.getContext(), words.getVoiceId() );
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayRelease();
                    }
                });

            }
        });



    }

    public void mediaPlayRelease(){
        if (mediaPlayer != null){
            mediaPlayer.release();
        }

        mediaPlayer = null;
    }
}
