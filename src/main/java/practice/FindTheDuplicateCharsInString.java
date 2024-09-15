package practice;

import java.util.HashMap;
import java.util.Set;

public class FindTheDuplicateCharsInString {

    public void findTheDuplicateCharsInString(String str) {

        char[] c;
        c=str.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap<>();

        for(char c1:c){
            if(hashMap.containsKey(c1)){
                hashMap.put(c1,hashMap.get(c1)+1);
            } else {
                hashMap.put(c1,1);
            }
        }

//        Saving all keys in a SET to iterate them to find the duplicates
        Set<Character> s = hashMap.keySet();
        for(char c1: s){
            if(hashMap.get(c1)>1){
                System.out.println(c1+"==>"+hashMap.get(c1));
            }
        }
    }
}
