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
        playlist = new CircularLinkList();
        history = new Stack<>();
        shuffleList = new ArrayList<>();
    }
    
    public void addSong(Song Song){
        playlist.insertSong(song);
    }

    public Song getNextSong(){
        if(isEmpty()){
            return null;
        }

        if (current == null){
            current = head;
        } else {
            current = current.next;
        }
        return current.data;
    }
    
    public boolean removeSong(String idOrTitle){
        return playlist.deleteSong(idOrTitle);
    }
    
    public Song searchSong(String keyword){
        return playlist.searchSong(keyWord);
    }
    public void viewAllSongs(){
        playlist.displaySongs();
    }
    
    public Song nextSong(){}
    public Song previousSong(){}
    public Song shufflePlay(){}
    
    public void loadSampleSongs(){}
}
