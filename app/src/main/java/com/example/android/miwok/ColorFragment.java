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
public class ColorFragment extends Fragment {
    private MediaPlayer mediaPlayer;
    private ListView colorList;

    private AudioManager audioManager;

    //设置全局监听器
    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                mediaPlayerRelease();
            }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            }
        }
    };

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.activity_color, container, false);
        colorList = (ListView)rootView.findViewById(R.id.color_list);
        audioManager = (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Color> colorArrayList = new ArrayList<Color>();
        colorArrayList.add(new Color("red", "weṭeṭṭi",R.drawable.color_red, R.raw.color_red));
        colorArrayList.add(new Color("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        colorArrayList.add(new Color("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        colorArrayList.add(new Color("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        colorArrayList.add(new Color("black", "kululli", R.drawable.color_black, R.raw.color_black));
        colorArrayList.add(new Color("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        colorArrayList.add(new Color("dusty yellow", "ṭopiisə", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorArrayList.add(new Color("mustard yellow", "chiwiiṭə", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        ColorAdapter colorAdapter = new ColorAdapter(getActivity(), colorArrayList);

        colorList.setAdapter(colorAdapter);

        colorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Color color = colorArrayList.get(position);
                //如果这里不是先释放会出现空的mediaplay方法， 因为还没初始化
                mediaPlayerRelease();

                //获取AudioManager服务
                int audioFocusResult = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (audioFocusResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mediaPlayerRelease();
                    mediaPlayer = MediaPlayer.create(getActivity(), color.getColorVoiceID());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mediaPlayerRelease();
                        }
                    });
                }

            }
        });
        return rootView;
    }

    public void mediaPlayerRelease() {
        if (mediaPlayer != null){
            mediaPlayer.release();
        }

        mediaPlayer = null;
        audioManager.abandonAudioFocus(onAudioFocusChangeListener);
    }


    @Override
    public void onStop(){
        super.onStop();
        mediaPlayerRelease();
    }

}
