package com.example.sahranalbum;

public class MyModel {
    String songName;
    Boolean isFav;
    String prename;

    public MyModel(String songName, Boolean isFav,String prename) {
        this.songName = songName;
        this.isFav = isFav;
        this.prename = prename;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Boolean getFav() {
        return isFav;
    }

    public void setFav(Boolean fav) {
        isFav = fav;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }
}
