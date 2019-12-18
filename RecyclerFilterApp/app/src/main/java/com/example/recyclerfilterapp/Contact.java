package com.example.recyclerfilterapp;

public class Contact {


    private String mContact_name ;
    private String mContact_number ;

    public Contact(){}
    public Contact(String name , String number){
        this.mContact_name = name ;
        this.mContact_number  = number ;
    }//


    public String getContact_name() {
        return mContact_name;
    }

    public void setContact_name(String contact_name) {
        mContact_name = contact_name;
    }

    public String getContact_number() {
        return mContact_number;
    }

    public void setContact_number(String contact_number) {
        mContact_number = contact_number;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "mContact_name='" + mContact_name + '\'' +
                ", mContact_number='" + mContact_number + '\'' +
                '}';
    }
}
