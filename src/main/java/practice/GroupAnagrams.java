package practice;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        GroupAnagrams gA = new GroupAnagrams();
        List<List<String>> res = gA.groupAnagrams(strs);
        for(int i=0; i<res.toArray().length;i++) {
            System.out.println(res.get(i));
        }
    }

    public List<List<String>> groupAnagrams(String[] args){
//        Store all results in map(String, list(string))
//        loop the string array
    //        convert all strings to char array
    //        sort the array
    //        convert to charArray into string and store it
    //        store in map every new sorted chararray as key and a new arrayList as value
    //        get the sorted chararray and add the string array as value.

        Map<String, List<String>> res = new HashMap<>();
        for(String str: args){
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            String sorted = new String(cArr);
            res.putIfAbsent(sorted, new ArrayList<>());
            res.get(sorted).add(str);
        }
        return new ArrayList<>(res.values());
    }
}
