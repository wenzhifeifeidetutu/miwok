package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private ListView familyListView;

    private AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener =new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                mediaPlayRelease();
            }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        final ArrayList<Family> familyArrayList = new ArrayList<Family>();

        //获取audioservice
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        familyArrayList.add(new Family("father", "əpə",R.drawable.family_father, R.raw.family_father));
        familyArrayList.add(new Family("mother", "əṭa",R.drawable.family_mother, R.raw.family_mother));
        familyArrayList.add(new Family("son", "angsi", R.drawable.family_son, R.raw.family_son));
        familyArrayList.add(new Family("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        familyArrayList.add(new Family("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyArrayList.add(new Family("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyArrayList.add(new Family("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyArrayList.add(new Family("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyArrayList.add(new Family("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyArrayList.add(new Family("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        FamilyAdapter familyAdapter = new FamilyAdapter(this, familyArrayList);

        familyListView =(ListView) findViewById(R.id.family_list);
        familyListView.setAdapter(familyAdapter);

        familyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Family familiy =  familyArrayList.get(position);
                mediaPlayRelease();
                //使用audio manager来管理
                int audioManagerResult = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT );
                if (audioManagerResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mediaPlayRelease();
                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, familiy.getFamilyVoiceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mediaPlayRelease();
                        }
                    });
                }


                

            }
        });
    }

    public void mediaPlayRelease(){
        if (mediaPlayer !=null){
            mediaPlayer.release();
        }
        mediaPlayer = null;
        //释放掉audio focus
        audioManager.abandonAudioFocus(onAudioFocusChangeListener);


    }

    @Override
    public void onStop(){
        super.onStop();
        //在释放mediaplay之前必须初始化不然是个空的方法
        mediaPlayRelease();

    }

}
