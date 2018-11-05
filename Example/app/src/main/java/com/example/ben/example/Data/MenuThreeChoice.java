package com.example.ben.example.Data;

import android.util.Log;

public class MenuThreeChoice {


    private int num;
    private int bloodValue;

    public static String Volume = "volume";
    public static String Low = "low volume";
    public static String Normal = "normal volume";
    public static String High = "high volume";
    public static String High_B = "borderline (high) volume";
    public static String High_risk = "high risk volume";

    public MenuThreeChoice(){

    }

    public MenuThreeChoice(int num, int bloodValue) {
        this.num = num;
        this.bloodValue = bloodValue;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getBloodValue() {
        return bloodValue;
    }

    public void setBloodValue(int bloodValue) {
        this.bloodValue = bloodValue;
    }

    public String getBloodLevel(){

        String message = "";

        Log.d("Menuthree", String.valueOf(num)+" "+bloodValue);

        if(num == 0){

            if(bloodValue > 10 && bloodValue < 79){
                message = Low;
            }
            else if(bloodValue >= 80 && bloodValue <= 110){
                message = Normal;
            }
            else if(bloodValue > 110){
                message = High;
            }
            else if (bloodValue < 1 ){
                message = Volume;
            }

        }
        else if(num == 1){

            if(bloodValue >= 135 && bloodValue <=146){

                message = Normal;
            }
            else if(bloodValue >= 10 && bloodValue < 135 ){
                message = Low;
            }
            else if(bloodValue > 146){
                message = High;
            }
            else if (bloodValue <= 10){
                message = Volume;
            }

        }
        else if(num == 2){

            if(bloodValue >= 3.4 && bloodValue <= 4.5){

                message = Normal;
            }
            else if(bloodValue >= 1 && bloodValue < 3.4){
                message = Low;
            }
            else if(bloodValue > 4.5){
                message = High;
            }
            else if (bloodValue < 1){
                message = Volume;
            }
        }
        else if(num == 3){

            if(bloodValue > 1 && bloodValue < 200){
                message = Normal;
            }
            else if(bloodValue >= 200  && bloodValue <=240){
                message = High_B;
            }
            else if(bloodValue > 241){
                message = High_risk;
            }
            else if (bloodValue < 1){
                message = Volume;
            }

        }

        else if(num == 4){

            if(bloodValue > 1 && bloodValue < 130){
                message = Normal;
            }
            else if( bloodValue>131 && bloodValue < 200){
                message = High_B;
            }
            else if(bloodValue> 201 ){
                message = High_risk;
            }
            else if(bloodValue < 1){
                message = Volume;
            }
        }

        else if(num == 5){

            if(bloodValue > 36 ){
                message = Normal;
            }
            else if(bloodValue < 35){
                message = Low;
            }
            else if(bloodValue < 1){
                message = Volume;
            }
        }

        else if(num == 6){

            if(bloodValue >1 && bloodValue <150){

                message = Normal;
            }
            else if(bloodValue >= 150 && bloodValue <= 500){
                message = High_B;
            }
            else if(bloodValue > 500){
                message = High_risk;
            }
            else if (bloodValue < 1){
                message = Volume;
            }
        }

        Log.d("Menuthree",message+" "+9);
        return message;


    }


}
