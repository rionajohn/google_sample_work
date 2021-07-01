package com.google;

import java.util.*;

public class VideoPlayer{

  private final VideoLibrary videoLibrary;
  int noVideos = 0;
  Video videoPlaying = null; //currently playing
  Video newVideoPlay = null; //video about to be played
  Video randomVid = null; //random video

  HashMap<String,VideoPlaylist> listPlaylist = new HashMap<>();

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all available videos: ");
    ArrayList video_list = new ArrayList(videoLibrary.getVideos());
    video_list.sort(Comparator.comparing(Video::getTitle));
    for(int i = 0; i < (videoLibrary.getVideos().size()); i++){
      System.out.println(video_list.get(i).toString().replace(",", ""));
    }
  }

  public void playVideo(String videoId) {
    newVideoPlay = videoLibrary.getVideo(videoId);

    if (newVideoPlay == null){ //video does not exist
      System.out.println("Cannot play video: Video does not exist");
    }else{ //video exists
      if (videoPlaying == null){ //playing new video
        System.out.println("Playing video: " + newVideoPlay.getTitle());
        videoPlaying = newVideoPlay;
      }else { //if a video is playing already
        System.out.println("Stopping video: " + videoPlaying.getTitle());
        System.out.println("Playing video: " + newVideoPlay.getTitle());
        videoPlaying = newVideoPlay;
      }
    }
  }

  public void stopVideo() {
    if (videoPlaying != null){//video playing
      System.out.println("Stopping video: " + newVideoPlay.getTitle());
      videoPlaying = null;
      newVideoPlay = null; //So that nothing is playing next
    }else{
      System.out.println("Cannot stop video: No video is currently playing");
    }
  }

  public void playRandomVideo() {
    noVideos = videoLibrary.getVideos().size();
    Random rand = new Random();
    int randIndex = rand.nextInt(noVideos); //number of videos
    randomVid = videoLibrary.getVideos().get(randIndex);

    if (noVideos == 0) {
      System.out.println("No videos available");
    } else {
      if (videoPlaying == null) { // play random
        System.out.println("Playing video: " + randomVid.getTitle());
        videoPlaying = randomVid;
      } else { //stop playing current song, play random
        System.out.println("Stopping video: " + videoPlaying.getTitle());
        System.out.println("Playing video: " + randomVid.getTitle());
        videoPlaying = randomVid;
      }
    }
  }
  public void pauseVideo() {
    if(newVideoPlay != null){
      if (videoPlaying != null){//video playing
        System.out.println("Pausing video: " + newVideoPlay.getTitle());
        videoPlaying = null;
      }else{
        System.out.println("Video already paused: " + newVideoPlay.getTitle());
        videoPlaying = null;
      }
    }else{
      System.out.println("Cannot continue video: No video is currently playing");
    }

  }

  public void continueVideo() {
    if(newVideoPlay != null){
      if (videoPlaying == null){//video paused
        System.out.println("Continuing video: " + newVideoPlay.getTitle());
        videoPlaying = newVideoPlay;
      }else{
        System.out.println("Cannot continue video: Video is not paused");
        videoPlaying = newVideoPlay; //to make sure something is still "playing"
      }
    }else{
      System.out.println("Cannot pause video: No video is currently playing");
    }
  }

  public void showPlaying() {
    if(newVideoPlay != null){
      String title = newVideoPlay.getTitle();
      String videoId = newVideoPlay.getVideoId();
      List<String> tags = newVideoPlay.getTags();
      String tagsString = tags.toString().replace(",","");

      if(videoPlaying != null){//something is playing
        System.out.println("Currently playing: " + title + " " + videoId + " " + tagsString);
        videoPlaying = newVideoPlay;
      }else{
        System.out.println("Currently playing: " + title + " " + videoId + " " + tagsString + " - PAUSED");
        videoPlaying = newVideoPlay;
      }
    }else {
      System.out.println("No video is currently playing");
    }

  }

  //Part 2 starts here

  public void createPlaylist(String playlistName) {
    if (playlistName.contains(" ")){
      System.out.println("No space should be there");
    }else if(listPlaylist.containsKey(playlistName.toUpperCase())){
      System.out.println("Cannot create playlist: A playlist with the same name already exists");
    }else{
      System.out.println("Successfully created new playlist: " + playlistName);
      listPlaylist.put(playlistName.toUpperCase(),new VideoPlaylist(playlistName));//adding to the list of playlists
    }
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}