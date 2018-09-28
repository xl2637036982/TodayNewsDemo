package com.example.administrator.todaynewsdemo;

public class News {
    private int image1;
    private  int image2;
    private  int image3;
    private  String text1;
    private  String text2;
    private  int Type;


    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public int getImage3() {
        return image3;
    }

    public void setImage3(int image3) {
        this.image3 = image3;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public News(int image1, int image2, int image3, String text1, String text2,int type) {
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.text1 = text1;
        this.text2 = text2;
        this.Type =  type;

    }
}