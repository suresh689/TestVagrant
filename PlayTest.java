package javaDemo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PlayTest {

    /**
     * to store the capacity */
    private int capacity;
    /**to store the play songs*/
    private Map<String, LinkedList<String>> store;

    public PlayTest(int capacity) {
        this.capacity = capacity;
        this.store = new HashMap<>();
    }

/** In this method we are creating the playlist map with user as kay and values as recently played songs.
 * If song not present in list we are adding.
 * if the capacity is greaterthen zero we are removing the first inserted one */
    public void playSong(String user, String song) {
        if (!store.containsKey(user)) {
            store.put(user, new LinkedList<>());
        }

        LinkedList<String> playlist = store.get(user);

        if (playlist.size() >= capacity) {
            playlist.removeFirst();
        }

        playlist.add(song);
    }

    public static void main(String ar[]){
        PlayTest capacity = new PlayTest(3);

        capacity.playSong("user1", "S1");
        capacity.playSong("user1", "S2");
        capacity.playSong("user1", "S3");

        System.out.println(capacity.store);

        capacity.playSong("user1", "S4");

        System.out.println(capacity.store);

        capacity.playSong("user1", "S2");
        System.out.println(capacity.store); // Output: [S3, S4, S2]

        capacity.playSong("user1", "S1");
        System.out.println(capacity.store);
    }
}
