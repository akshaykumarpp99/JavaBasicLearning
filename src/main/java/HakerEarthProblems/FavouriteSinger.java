package HakerEarthProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FavouriteSinger {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numOfSongs = sc.nextInt();
        System.out.println("Total number of songs in Bob's Playlist: "+numOfSongs);

        Map<Integer,Integer> singerCount = new HashMap<>();
        for(int i=0;i<numOfSongs;i++){
            int singer = sc.nextInt();
            singerCount.put(singer,singerCount.getOrDefault(singer,0)+1);
        }

//      Finding the max value in the map
        int maxcount=0;
        for(int count:singerCount.values()){
            if(count>maxcount){
                maxcount=count;
            }
        }

//      Finding the Number of favourite singers
        int favouriteSingers=0;
        for(int count: singerCount.values()){
            if(maxcount==count){
                favouriteSingers++;
            }
        }
        System.out.println("Bob's number of favourite singers: "+favouriteSingers);
    }
}
