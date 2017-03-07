package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
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
    private AudioManager audioManager;

    //全局的audio focus changeListener
     AudioManager.OnAudioFocusChangeListener audioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener(){
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange ==
                            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                        //暂时停止，很短的时间就会重新得到AudioFocus
                        //暂停播放 并且从头开始播放
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                    }else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        //停止播放，已经失去了Audio Focus
                        //并且释放这个audioChangeListener

                        mediaPlayRelease();

                    }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        //重停止的地方开始播放
                        mediaPlayer.start();
                    }
                }


            };

    private ArrayList<Words> numberofEList = new ArrayList<Words>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        //创建AudioManager
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

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

                //先执行初始化释放releaseMediaPlayer（）
                mediaPlayRelease();

                //当点击之后我们使用AudioFocus来管理音频
                // Request audio focus for playback, result 判断是否可以开始audioFocus
                int result = audioManager.requestAudioFocus(audioFocusChangeListener,
                        // Use the music stream.//获取流为music
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.获取很少断的音频
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                //如果返回为requestgranted就是请求audio focus成功
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback 开始播放音乐
                    mediaPlayRelease();
                    mediaPlayer = MediaPlayer.create(view.getContext(), words.getVoiceId() );
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        //播放完一条语音时候
                        public void onCompletion(MediaPlayer mp) {
                            mediaPlayRelease();
                        }
                    });
                }
            }
        });





    }

    public void mediaPlayRelease(){
        if (mediaPlayer != null){
            mediaPlayer.release();
        }

        mediaPlayer = null;

        //此时释放audio focus
        audioManager.abandonAudioFocus(audioFocusChangeListener);
    }

    @Override
    public void onStop(){
        super.onStop();
        mediaPlayRelease();
    }
}
