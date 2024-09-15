package practice;

import java.util.HashMap;

public class CountTheNumberOfCharInString {

    public void countTheNumberOfCharInString(String str){
        int numofChars=0;
        char[] l;
        l = str.toCharArray();
        System.out.println(l.length);
    }

    public void numberOfSpecificChars(String str){
        char[] l;
        l = str.toCharArray();
        HashMap<Character,Integer> h = new HashMap<>();

        for(char c: l){
            if(h.containsKey(c)){
                h.put(c,h.get(c)+1);
            } else {
                h.put(c,1);
            }
        }
        System.out.println(h);
    }

}
