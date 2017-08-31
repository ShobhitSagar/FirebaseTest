package com.shobhitsagar.firebasetest;

/**
 * Created by shobhitsagar on 27/08/17.
 */

public class Artist {

    private String ID;
    private String Name;

//    public Artist () {
//
//    }

    public Artist(String ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public String getArtistID() {
        return ID;
    }

    public String getArtistName() {
        return Name;
    }

}
