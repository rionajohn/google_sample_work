package com.google;

import java.util.*;

/** A class used to represent a Playlist */

class VideoPlaylist {
    String playlistName;
    ArrayList<Video> videos = new ArrayList<>(); //store videos in playlist

    public VideoPlaylist(String playlistName) {
        this.playlistName = playlistName; //name of playlist
    }
}
