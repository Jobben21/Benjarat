package com.example.ben.example.Data;

import java.util.HashMap;
import java.util.Map;

public class B_information {


    private String b1;
    private String B_data;
    private String B_high_volum;
    private String B_low_volum;
    private String B_normal_volum;
    private String B_unit;
    private String B_data_information;
    private String B_data_information2;
    private String imageview;


    public B_information(String b1, String b_data, String b_high_volum, String b_low_volum,
                         String b_normal_volum, String b_unit,String b_data_information,String b_data_information2,
                         String imageview) {
        this.b1 = b1;
        this.B_data = b_data;
        this.B_high_volum = b_high_volum;
        this.B_low_volum = b_low_volum;
        this.B_normal_volum = b_normal_volum;
        this.B_unit = b_unit;
        this.B_data_information = b_data_information;
        this.B_data_information2 = b_data_information2;
        this.imageview = imageview;
    }


    public B_information() {

    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB_data() {
        return B_data;
    }

    public void setB_data(String b_data) {
        B_data = b_data;
    }

    public String getB_high_volum() {
        return B_high_volum;
    }

    public void setB_high_volum(String b_high_volum) {
        B_high_volum = b_high_volum;
    }

    public String getB_low_volum() {
        return B_low_volum;
    }

    public void setB_low_volum(String b_low_volum) {
        B_low_volum = b_low_volum;
    }

    public String getB_normal_volum() {
        return B_normal_volum;
    }

    public void setB_normal_volum(String b_normal_volum) {
        B_normal_volum = b_normal_volum;
    }

    public String getB_unit() {
        return B_unit;
    }

    public void setB_unit(String b_unit) {
        B_unit = b_unit;
    }

    public String getB_data_information() {
        return B_data_information;
    }

    public void setB_data_information(String b_data_information) {
        B_data_information = b_data_information;
    }

    public String getB_data_information2() {
        return B_data_information2;
    }

    public void setB_data_information2(String b_data_information2) {
        B_data_information2 = b_data_information2;
    }

    public String getImageview() {
        return imageview;
    }

    public void setImageview(String imageview) {
        this.imageview = imageview;
    }




}