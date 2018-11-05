package com.example.ben.example.Data;

import static java.sql.Types.NULL;

public class BloodTest {

    public static String Volume = "volume";
    public static String Low = "low volume";
    public static String Normal = "normal volume";
    public static String High = "high volume";
    public static String High_B = "borderline (high) volume";
    public static String High_risk = "high risk volume";

    public String Date;
    public int sugar;
    public int sodium;
    public double potassium;
    public int cholesteral;
    public int ldl;
    public int hdl;
    public int trigryceride;

    public BloodTest(){

    }

    public BloodTest(String Date,int sugar, int sodium, double potassium, int cholesteral, int ldl, int hdl, int trigryceride) {
        this.Date = Date;
        this.sugar = sugar;
        this.sodium = sodium;
        this.potassium = potassium;
        this.cholesteral = cholesteral;
        this.ldl = ldl;
        this.hdl = hdl;
        this.trigryceride = trigryceride;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getSugar() {

        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public int getCholesteral() {
        return cholesteral;
    }

    public void setCholesteral(int cholesteral) {
        this.cholesteral = cholesteral;
    }

    public int getLdl() {
        return ldl;
    }

    public void setLdl(int ldl) {
        this.ldl = ldl;
    }

    public int getHdl() {
        return hdl;
    }

    public void setHdl(int hdl) {
        this.hdl = hdl;
    }

    public int getTrigryceride() {
        return trigryceride;
    }

    public void setTrigryceride(int trigryceride) {
        this.trigryceride = trigryceride;
    }


    public String getSugar_Level() {

        String m1 = "";

        if(sugar > 10 && sugar < 79){
            m1 = Low;
        }
        else if(sugar >= 80 && sugar <= 110){
            m1 = Normal;
        }
        else if(sugar > 110){
            m1 = High;
        }
        else if (sugar < 1 ){
            m1 = Volume;
        }


        return m1;
    }

    public String getSodium_Level() {

        String m1 = "";

        if(sodium >= 135 && sodium <=146){

            m1 = Normal;
        }
        else if(sodium >= 10 && sodium < 135 ){
            m1 = Low;
        }
        else if(sodium > 146){
            m1 = High;
        }
        else if (sodium <= 10){
            m1 = Volume;
        }

        return m1;
    }

    public String getPotassium_Level() {

        String m1 = "";

        if(potassium >= 3.4 && potassium <= 4.5){

            m1 = Normal;
        }
        else if(potassium >= 1 && potassium < 3.4){
            m1 = Low;
        }
        else if( potassium > 4.5){
            m1 = High;
        }
        else if (potassium < 1){
            m1 = Volume;
        }

        return m1;
    }

    public String getCholesterol_Level() {

        String m1 = "";

        if(cholesteral > 1 && cholesteral < 200){
            m1 = Normal;
        }
        else if(cholesteral >= 200  && cholesteral <=240){
            m1 = High_B;
        }
        else if(cholesteral > 241){
            m1 = High_risk;
        }
        else if (cholesteral < 1){
            m1 = Volume;
        }

        return m1;
    }

    public String getLDL_Level() {

        String m1 = "";

        if(ldl > 1 && ldl < 130){
            m1 = Normal;
        }
        else if( ldl>131 && ldl < 200){
            m1 = High_B;
        }
        else if( ldl> 201 ){
            m1 = High_risk;
        }
        else if(ldl < 1){
            m1 = Volume;
        }

        return m1;
    }

    public String getHDL_Level() {

        String m1 = "";

        if(hdl >= 36 ){
            m1 = Normal;
        }
        else if(hdl < 35 && hdl >= 1){
            m1 = Low;
        }
        else if(hdl < 1){
            m1 = Volume;
        }

        return m1;
    }

    public String getTrigryceride_Level() {

        String m1 = "";

        if(trigryceride >1 && trigryceride <150){

            m1 = Normal;
        }
        else if(trigryceride >= 150 && trigryceride <= 500){
            m1 = High_B;
        }
        else if(trigryceride > 500){
            m1 = High_risk;
        }
        else if (trigryceride < 1){
            m1 = Volume;
        }

        return m1;
    }
}
