package com.example.recyclerwithcontextmenu;

public class Thing {

    private int thing_id  ;
    private String thing_name ;

    public Thing(int id , String name){
        this.thing_id = id ;
        thing_name = name ;
    }

    public int getThing_id() {
        return thing_id;
    }

    public void setThing_id(int thing_id) {
        this.thing_id = thing_id;
    }

    public String getThing_name() {
        return thing_name;
    }

    public void setThing_name(String thing_name) {
        this.thing_name = thing_name;
    }


}
