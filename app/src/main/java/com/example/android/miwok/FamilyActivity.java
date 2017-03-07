package com.example.android.miwok;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        final ArrayList<Family> familyArrayList = new ArrayList<Family>();

        familyArrayList.add(new Family("father", "əpə",R.drawable.family_father, R.raw.family_father));
        familyArrayList.add(new Family("mother", "əṭa",R.drawable.family_mother, R.raw.family_mother));
        familyArrayList.add(new Family("son", "angsi", R.drawable.family_son, R.raw.family_son));
        familyArrayList.add(new Family("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        familyArrayList.add(new Family("older brother", "taachi", R.drawable.family_older_brother));
        familyArrayList.add(new Family("younger brother", "chalitti", R.drawable.family_younger_brother));
        familyArrayList.add(new Family("older sister", "teṭe", R.drawable.family_older_sister));
        familyArrayList.add(new Family("younger sister", "kolliti", R.drawable.family_younger_sister));
        familyArrayList.add(new Family("grandmother", "ama", R.drawable.family_grandmother));
        familyArrayList.add(new Family("grandfather", "paapa", R.drawable.family_grandfather));

        FamilyAdapter familyAdapter = new FamilyAdapter(this, familyArrayList);

        familyListView =(ListView) findViewById(R.id.family_list);
        familyListView.setAdapter(familyAdapter);

        familyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Family familiy =  familyArrayList.get(position);
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
        });
    }

    public void mediaPlayRelease(){
        if (mediaPlayer !=null){
            mediaPlayer.release();
        }
        mediaPlayer = null;


    }

    @Override
    public void onStop(){
        super.onStop();
        mediaPlayer.release();

    }

}
