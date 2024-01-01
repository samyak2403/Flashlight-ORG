package com.arrowwould.flashlightxt.model;

public class ContactModel {

    private int img;
    private String name;
    private String number;

    public ContactModel(int img, String name, String number) {
        this.img = img;
        this.name = name;
        this.number = number;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
