package playedSong;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import org.testng.annotations.Test;

import Pojo.RecentlyPlayedSong;

public class recentlyPlayedSongTest {
	
	 private RecentlyPlayedSong store;
	 

	    @Before
	    public void init() {
	    		System.out.println("hello");
	    	 store = new RecentlyPlayedSong(3);
	    }
	 
	    @Test
	    public void testGetRecentlyPlayedSongs() {
	    	System.out.println("hehe");
	        store.playSong("S1", "User1");
	        store.playSong("S2", "User1");
	        store.playSong("S3", "User1");
	        List<String> songs = store.getRecentlyPlayedSongs("User1"); 
	        for(String hehe : songs) {
	        	System.out.println("rah" + hehe);
	        }
	        Assert.assertEquals(Arrays.asList("S1", "S2", "S3"), songs);
	    }

	    @Test
	    public void testPlaySongWithFullStore() {
	        store.playSong("S1", "User1");
	        store.playSong("S2", "User1");
	        store.playSong("S3", "User1");
	        store.playSong("S4", "User1");
	        List<String> songs = store.getRecentlyPlayedSongs("User1");
	        Assert.assertEquals(Arrays.asList("Song4", "Song3", "Song2"), songs);
	    }

	    @Test
	    public void testPlaySameSongAgain() {
	        store.playSong("S1", "User1");
	        store.playSong("S2", "User1");
	        store.playSong("S3", "User1");
	        store.playSong("S2", "User1");
	        List<String> songs = store.getRecentlyPlayedSongs("User1");
	        Assert.assertEquals(Arrays.asList("Song2", "Song3", "Song1"), songs);
	    }

	    @Test
	    public void testPlaySongWithMultipleUsers() {
	        store.playSong("Song1", "User1");
	        store.playSong("Song2", "User1");
	        store.playSong("Song3", "User1");
	        store.playSong("Song4", "User1");
	        store.playSong("Song2", "User1");
	        store.playSong("Song1", "User1");

	    }
	    






}
