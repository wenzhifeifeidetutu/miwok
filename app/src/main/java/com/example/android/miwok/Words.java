package com.example.android.miwok;

/**
 * Created by Administrator on 2017/2/23.
 */

public class Words {
    private String defaultwords;
    private String miwok;
    private int imageId;
    private int voiceId;

    public Words(){

    }

    public Words(String defaultwords, String miwok){
        this.defaultwords = defaultwords;
        this.miwok = miwok;
    }

    public Words(String defaultwords, String miwok, int imageId) {
        this.defaultwords = defaultwords;
        this.miwok = miwok;
        this.imageId = imageId;
    }

    public Words(String defaultwords, String miwok, int imageId, int voiceId){
        this.defaultwords = defaultwords;
        this.miwok = miwok;
        this.imageId = imageId;
        this.voiceId =voiceId;
    }

    public String getDefaultwords(){
        return defaultwords;

    }

    public String getMiwok(){
        return miwok;
    }

    public int getImageId(){
        return imageId;
    }

    public int getVoiceId() {
        return voiceId;
    }
}
