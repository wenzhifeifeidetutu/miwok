package com.example.android.miwok;

/**
 * Created by Administrator on 2017/2/26.
 */

public class Color {
    private String colorOfdefault;

    private String colorOfMiwok;

    private int colorOfImageId;

    private int colorVoiceID;

    public  Color(String colorOfdefault, String colorOfMiwok){
        this.colorOfdefault = colorOfdefault;
        this.colorOfMiwok = colorOfMiwok;
    }

    public Color(String colorOfdefault, String colorOfMiwok, int colorOfImageId){
        this.colorOfdefault = colorOfdefault;
        this.colorOfMiwok = colorOfMiwok;
        this.colorOfImageId = colorOfImageId;
    }

    public Color(String colorOfdefault, String colorOfMiwok, int colorOfImageId, int colorVoiceID){
        this.colorOfdefault = colorOfdefault;
        this.colorOfMiwok = colorOfMiwok;
        this.colorOfImageId = colorOfImageId;
        this.colorVoiceID = colorVoiceID;
    }

    public String getColorOfdefault(){
        return colorOfdefault;
    }

    public String getColorOfMiwok(){
        return colorOfMiwok;
    }

    public int getColorOfImageId(){
        return colorOfImageId;
    }

    public int getColorVoiceID() {
        return colorVoiceID;
    }
}
