package com.shobhitsagar.firebasetest;

/**
 * Created by shobhitsagar on 27/08/17.
 */

public class Artist {

    private String artistID;
    private String artistName;

//    public Artist () {
//
//    }

    public Artist(String artistID, String artistName) {
        this.artistID = artistID;
        this.artistName = artistName;
    }

    public String getArtistID() {
        return artistID;
    }

    public String getArtistName() {
        return artistName;
    }

}
