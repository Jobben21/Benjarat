package com.example.ben.example.Data;

import java.util.ArrayList;

public class BloodInformation {

    private String name;
    private String level;
    private String value;
    private String unit;
    private int image;
    private int seekbar;
    private int progressbar;
    private int secondprogressbar;
    private int maxprogressbar;
    private int maxseekbar;
    private String Info1;
    private String Info2;
    private String Info3;
    private String Info4;
    private String Info5;
    private String Info6;


    public BloodInformation(){

    }
    public BloodInformation(String name, String level, String value, String unit,
                            int image, int seekbar, int progressbar, int secondprogressbar, int maxprogressbar, int maxseekbar, String info1, String info2, String info3, String info4, String info5, String info6) {
        this.name = name;
        this.level = level;
        this.value = value;
        this.unit = unit;
        this.image = image;
        this.seekbar = seekbar;
        this.progressbar = progressbar;
        this.secondprogressbar = secondprogressbar;
        this.maxprogressbar = maxprogressbar;
        this.maxseekbar = maxseekbar;
        this.Info1 = info1;
        this.Info2 = info2;
        this.Info3 = info3;
        this.Info4 = info4;
        this.Info5 = info5;
        this.Info6 = info6;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public String getInfo1() {
        return Info1;
    }

    public void setInfo1(String info1) {
        Info1 = info1;
    }

    public String getInfo2() {
        return Info2;
    }

    public void setInfo2(String info2) {
        Info2 = info2;
    }

    public String getInfo3() {
        return Info3;
    }

    public void setInfo3(String info3) {
        Info3 = info3;
    }

    public String getInfo4() {
        return Info4;
    }

    public void setInfo4(String info4) {
        Info4 = info4;
    }

    public String getInfo5() {
        return Info5;
    }

    public void setInfo5(String info5) {
        Info5 = info5;
    }

    public String getInfo6() {
        return Info6;
    }

    public void setInfo6(String info6) {
        Info6 = info6;
    }




}
