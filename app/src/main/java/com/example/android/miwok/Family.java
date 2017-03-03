package com.example.android.miwok;

/**
 * Created by Administrator on 2017/2/26.
 */

public class Family {
    private  String defaultWordsOfF;
    private  String miwokWordsOfF;
    private int familyOfImageId;
    private int familyVoiceId;

    public Family(String defaultWordsOfF, String miwokWordsOfF){
        this.defaultWordsOfF = defaultWordsOfF;
        this.miwokWordsOfF = miwokWordsOfF;
    }

   public Family(String defaultWordsOfF, String miwokWordsOfF, int familyOfImageId) {
        this.defaultWordsOfF = defaultWordsOfF;
        this.miwokWordsOfF = miwokWordsOfF;
       this.familyOfImageId = familyOfImageId;
    }

    public Family(String defaultWordsOfF, String miwokWordsOfF, int familyOfImageId, int familyVoiceId) {
        this.defaultWordsOfF = defaultWordsOfF;
        this.miwokWordsOfF = miwokWordsOfF;
        this.familyOfImageId = familyOfImageId;
        this.familyVoiceId = familyVoiceId;
    }

    public String getDefaultWordsOfF(){
        return defaultWordsOfF;
    }

    public String getMiwokWordsOfF(){
        return miwokWordsOfF;
    }

    public int getFamilyOfImageId(){
        return familyOfImageId;
    }

    public int getFamilyVoiceId(){
        return familyVoiceId;
    }
}
