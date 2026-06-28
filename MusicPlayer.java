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
    }
    
    public void addSong(Song Song){}
    public boolean removeSong(String idOrTitle){}
    public Song searchSong(String keyword){}
    public void viewAllSongs(){}
    
    public Song nextSong(){}
    public Song previousSong(){}
    public Song shufflePlay(){}
    
    public void loadSampleSongs(){}
}
