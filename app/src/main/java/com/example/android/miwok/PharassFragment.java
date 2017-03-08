package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PharassFragment extends Fragment {
    private ListView pharassListView ;
    private MediaPlayer mediaPlayer;

    private AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK||focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                mediaPlayRelease();
            }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            }
        }
    };


    public PharassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.activity_pharass, container, false);
        audioManager = (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);


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

        pharassListView = (ListView) rootView.findViewById(R.id.pharass_list);

        PharassAdapter pharassAdapter =new PharassAdapter(getActivity(), pharassArrayList);

        pharassListView.setAdapter(pharassAdapter);

        pharassListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pharass pharass =  pharassArrayList.get(position);
                mediaPlayRelease();

                int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayRelease();
                    mediaPlayer = MediaPlayer.create(getActivity(), pharass.getPharassVoiceId()  );
                    mediaPlayer.start();
                    //如果播放完就release掉
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mediaPlayRelease();
                        }
                    });
                }


            }
        });
        return rootView;
    }

    public void mediaPlayRelease(){
        if (mediaPlayer != null){
            mediaPlayer.release();
        }

        mediaPlayer = null;
        //这里要把adudiofocus给释放掉
        audioManager.abandonAudioFocus(onAudioFocusChangeListener);
    }

    @Override
    public void onStop(){
        super.onStop();
        mediaPlayRelease();
    }

}
