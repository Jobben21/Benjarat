package com.example.ben.example.Data;

public class BloodProfile  {


    private String Date;
    private String name;
    private String level;
    private String value;
    private int image;
    private String unit;
    private int seekbar;
    private int progressbar;
    private int secondprogressbar;
    private int maxprogressbar;
    private int maxseekbar;

    public BloodProfile(){

    }

    public BloodProfile(String Date,String name, String level,String value,int image,String unit,int seekbar, int progressbar, int secondprogressbar, int maxprogressbar, int maxseekbar) {

        this.Date = Date;
        this.name = name;

        this.level = level;
        this.value = value;
        this.image = image;

        this.unit = unit;

        this.seekbar = seekbar;
        this.progressbar = progressbar;
        this.secondprogressbar = secondprogressbar;
        this.maxprogressbar = maxprogressbar;
        this.maxseekbar = maxseekbar;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public void setValue(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getSeekbar() {
        return seekbar;
    }

    public void setSeekbar(int seekbar) {
        this.seekbar = seekbar;
    }

    public int getProgressbar() {
        return progressbar;
    }

    public void setProgressbar(int progressbar) {
        this.progressbar = progressbar;
    }

    public int getSecondprogressbar() {
        return secondprogressbar;
    }

    public void setSecondprogressbar(int secondprogressbar) {
        this.secondprogressbar = secondprogressbar;
    }

    public int getMaxprogressbar() {
        return maxprogressbar;
    }

    public void setMaxprogressbar(int maxprogressbar) {
        this.maxprogressbar = maxprogressbar;
    }

    public int getMaxseekbar() {
        return maxseekbar;
    }

    public void setMaxseekbar(int maxseekbar) {
        this.maxseekbar = maxseekbar;
    }


}
