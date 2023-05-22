package Pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

//import java.util.LinkedList;
//import java.util.Map;

//import net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry.Ambiguous.Node;

@Test
public class RecentlyPlayedSong {

	
    public int capacity;
    public Map<String, LinkedList<String>> songUserList;
    public Map<String,Set<String>> songUserMap;

//    public class Node {
//        String song;
//        String user;
//
//        public Node(String song, String user) {
//            this.song = song;
//            this.user = user;
//        }
//    }
   
    public RecentlyPlayedSong(int capacity) {
    	
            this.capacity = capacity;
            this.songUserList = new HashMap<>();
            this.songUserMap = new HashMap<>();
        }
    public void playSong(String song, String user) {
    	if(capacity<=0)
    		return;
    	LinkedList<String> tmpArray = null;
    	Set<String> tmpSet = null;
    	LinkedList<String> newList = new LinkedList<String>();
    	Set<String> newSet = new HashSet<String>();
    	
    	tmpArray = songUserList.getOrDefault(user, newList);
    	tmpSet = songUserMap.getOrDefault(user, newSet);
    	
    	if(tmpSet.contains(song)) {
    		tmpArray.remove(song);
    		tmpArray.add(song);
    	} else {
    		tmpArray.add(song);
    		if(tmpArray.size() >= capacity) {
    			tmpArray.removeFirst();
    		}
    	}
    	songUserList.put(user,tmpArray);
    	songUserMap.put(user, newSet);
//        if (songUserMap.containsKey(user)) {
//            Node node = songUserMap.get(user);
//            recentlyPlayed.remove(node);
//        } else if (recentlyPlayed.size() >= capacity) {
//            Node removedNode = recentlyPlayed.removeLast();
//            songUserMap.remove(removedNode.user);
//        }
//
//        Node newNode = new Node(song, user);
//        songUserMap.put(user, newNode);
//        recentlyPlayed.addFirst(newNode);
    }
    
    public List<String> getRecentlyPlayedSongs(String user) {
    	return songUserList.get(user);
//        List<String> songs = new ArrayList<>();
//        Node currentNode = songUserMap.get(user);
//
//        while (currentNode != null) {
//            songs.add(currentNode.song);
//            currentNode = recentlyPlayed.get(recentlyPlayed.indexOf(currentNode) + 1);
//        }
//
//        return songs;
    }
    
    
   
//    public class RecentlyPlayedSong {	
//	 	private int capacity;
//	    private Map<String, List<String>> userToSongMap;
//	    public void RecentlyPlayedSong(int capaity) {
//	    	this.capacity = capacity;
//	    	this.userToSongMap = new HashMap<>();
//	    }
//	    public void playSong (String song,String user) {
//	    	 if (userToSongMap.containsKey(user)) {
//	    		 List playList = userToSongMap.get(user);
//	    		 
//	    		 
//	         } else if (recentlyPlayed.size() >= capacity) {
//	         }
//	    }

}


//Coding Assignment
//OVERVIEW
//Create an in-memory store for recently played songs that can accommodate N songs per user, with a fixed initial capacity. This store must have the capability to store a list of song-user pairs, with each song linked to a user. It should also be able to fetch recently played songs based on the user and eliminate the least recently played songs when the store becomes full.
//EXAMPLE
//Illustration, when 4 different songs were played by a user & Initial capacity is 3: 
//Let's assume that the user has played 3 songs - S1, S2 and S3.
//The playlist would look like -> S1,S2,S3
//When S4 song is played -> S2,S3,S4 
//When S2 song is played -> S3,S4,S2 
//When S1 song is played -> S4,S2,S1
//SUBMISSION GUIDELINES
//Share your code via a git repo. 
//EXPECTATIONS
//Pick any object oriented language of your choice to solve the problem
//Adhere to clean coding standards and principles. OOP is recommended (A sample list of coding conventions to refer https://www.browserstack.com/guide/coding-standards-best-practices)
//Write tests to validate the logic
//

