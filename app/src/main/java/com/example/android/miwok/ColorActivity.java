package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private ListView colorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        colorList = (ListView)findViewById(R.id.color_list);

        final ArrayList<Color> colorArrayList = new ArrayList<Color>();
        colorArrayList.add(new Color("red", "weṭeṭṭi",R.drawable.color_red, R.raw.color_red));
        colorArrayList.add(new Color("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        colorArrayList.add(new Color("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        colorArrayList.add(new Color("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        colorArrayList.add(new Color("black", "kululli", R.drawable.color_black, R.raw.color_black));
        colorArrayList.add(new Color("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        colorArrayList.add(new Color("dusty yellow", "ṭopiisə", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorArrayList.add(new Color("mustard yellow", "chiwiiṭə", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        ColorAdapter colorAdapter = new ColorAdapter(this, colorArrayList);

        colorList.setAdapter(colorAdapter);

        colorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Color color = colorArrayList.get(position);
                mediaPlayerRelease();
                mediaPlayer = MediaPlayer.create(ColorActivity.this, color.getColorVoiceID());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayerRelease();
                    }
                });
            }
        });

    }

    public void mediaPlayerRelease() {
        if (mediaPlayer != null){
            mediaPlayer.release();
        }

        mediaPlayer = null;
    }


    @Override
    public void onStop(){
        super.onStop();
        mediaPlayerRelease();
    }


}
