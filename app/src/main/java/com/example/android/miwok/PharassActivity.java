package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PharassActivity extends AppCompatActivity {
    private ListView pharassListView ;
    private  MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharass);

        final ArrayList<Pharass> pharassArrayList =new ArrayList<Pharass>();
        //clear this imageId is -1;
        pharassArrayList.add(new Pharass("Where are you going","minto wuksus",-1, R.raw.phrase_where_are_you_going ));
        //pharassArrayList.add(new Pharass("What is your name?","tinnə oyaase'nə",R.drawable.color_black ));
        pharassArrayList.add(new Pharass("What is your name?","tinnə oyaase'nə",-1, R.raw.phrase_what_is_your_name ));
        pharassArrayList.add(new Pharass("My name is...","oyaaset...",-1, R.raw.phrase_my_name_is  ));
        pharassArrayList.add(new Pharass("How are you feeling?","michəksəs?",-1, R.raw.phrase_how_are_you_feeling  ));
        pharassArrayList.add(new Pharass("I’m feeling good.","kuchi achit",-1, R.raw.phrase_im_feeling_good  ));
        pharassArrayList.add(new Pharass("Are you coming?","əənəs'aa?",-1, R.raw.phrase_are_you_coming  ));
        pharassArrayList.add(new Pharass("Yes, I’m coming.","həə’ əənəm",-1,R.raw.phrase_yes_im_coming  ));
        pharassArrayList.add(new Pharass("I’m coming.","əənəm",-1, R.raw.phrase_im_coming  ));
        pharassArrayList.add(new Pharass("Let’s go.","yoowutis",-1, R.raw.phrase_lets_go ));
        pharassArrayList.add(new Pharass("Come here","ənni'nem", -1, R.raw.phrase_come_here ));

        pharassListView = (ListView) findViewById(R.id.pharass_list);

        PharassAdapter pharassAdapter =new PharassAdapter(this, pharassArrayList);

        pharassListView.setAdapter(pharassAdapter);

        pharassListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Pharass pharass =  pharassArrayList.get(position);
                mediaPlayRelease();

                mediaPlayer = MediaPlayer.create(PharassActivity.this, pharass.getPharassVoiceId()  );
                mediaPlayer.start();
                //如果播放完就release掉
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
