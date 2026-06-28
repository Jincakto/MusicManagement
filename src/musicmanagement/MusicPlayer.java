/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicmanagement;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author votha
 */
public class MusicPlayer {
    private CircularLinkList playlist;
    private Stack<Song> history;
    private ArrayList<Song> shuffleList;

    public MusicPlayer() {
        playlist = new CircularLinkList(null, null, null);
        history = new Stack<>();
        shuffleList = new ArrayList<>();
    }
    
    public void addSong(Song Song){
        playlist.addSong(Song);
    }
    
    public boolean removeSong(String idOrTitle){
        return playlist.removeSong(idOrTitle);
    }
    
    public Song searchSong(String keyword){
        return playlist.searchSong(keyword);
    }
    public void viewAllSongs(){
        playlist.viewAllSongs();
    }
    
    public Song nextSong(){
        Song currentSong = playlist.getCurrentSong();
        
        if(currentSong != null){
            history.push(currentSong);
        }
        Song next = playlist.getNextSong();
        return next;
    }
    
    public Song previousSong(){
        if(history.isEmpty()){
            return null;
        }
        return history.pop();
    }
    
    public Song playRepeat(){
        return playlist.getCurrentSong();
    }
    
    public Song shufflePlay(){
        return null;
    }
    
    public void loadSampleSongs(){
        addSong(new Song("S01", "Believer", "Imagine Dragons", 204));
        addSong(new Song("S02", "Faded", "Alan Walker", 212));
        addSong(new Song("S03", "Shape Of You", "Ed Sheeran", 235));
        addSong(new Song("S04", "Closer", "Chainsmoker", 240));
    }
}
