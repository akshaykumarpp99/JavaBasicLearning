package practice;

import java.util.HashMap;
import java.util.Set;

public class FindTheDuplicateCharsInString {

    public void findTheDuplicateCharsInString(String str) {

//        char[] c;
//        c=str.toLowerCase().toCharArray();
//        HashMap<Character,Integer> hashMap = new HashMap<>();
//
//        for(char c1:c){
//            if(hashMap.containsKey(c1)){
//                hashMap.put(c1,hashMap.get(c1)+1);
//            } else {
//                hashMap.put(c1,1);
//            }
//        }

        char[] c;

        c = str.toLowerCase().toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(char n: c){
            if(hashMap.containsKey(n)){
                hashMap.put(n, hashMap.get(n)+1);
            } else {
                hashMap.put(n,1);
            }
        }



//

        Set<Character> s = hashMap.keySet();
        for(char c1: s){
            if(hashMap.get(c1)>1){
                System.out.println(c1+"==>"+hashMap.get(c1));
            }
        }
    }

    public static void main(String[] args) {
        FindTheDuplicateCharsInString f = new FindTheDuplicateCharsInString();
        f.findTheDuplicateCharsInString("Akshay Kumar");
    }
}
