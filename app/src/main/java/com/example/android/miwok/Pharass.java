package com.example.android.miwok;

/**
 * Created by Administrator on 2017/2/26.
 */

public class Pharass {

    private String defaultOfPharass;

    private String miwokOfPharass;

    private int pharassOfImageId = NOT_IMAGEID;

    private static  int NOT_IMAGEID = -1;

    private int pharassVoiceId ;

    public Pharass(String defaultOfPharass, String miwokOfPharass ) {
        this.defaultOfPharass = defaultOfPharass;
        this.miwokOfPharass = miwokOfPharass;
//        this.pharassOfImageId = pharassOfImageId;
    }
    public Pharass(String defaultOfPharass, String miwokOfPharass, int pharassOfImageId ) {
        this.defaultOfPharass = defaultOfPharass;
        this.miwokOfPharass = miwokOfPharass;
        this.pharassOfImageId = pharassOfImageId;
    }

    public Pharass(String defaultOfPharass, String miwokOfPharass, int pharassOfImageId, int pharassVoiceId ) {
        this.defaultOfPharass = defaultOfPharass;
        this.miwokOfPharass = miwokOfPharass;
        this.pharassOfImageId = pharassOfImageId;
        this.pharassVoiceId = pharassVoiceId;
    }

    public String getDefaultOfPharass(){
        return defaultOfPharass;
    }

    public String getMiwokOfPharass(){
        return miwokOfPharass;
    }
    //如何隐藏是否有id
    public boolean hasImage(){
       if (pharassOfImageId == NOT_IMAGEID){
           return false;
       }else {
           return true;
       }
    }

   public int getPharassOfImageId(){
        return pharassOfImageId;
    }

    public int getPharassVoiceId(){
        return pharassVoiceId;
    }

}
