package AutomationPractice;

import java.util.HashMap;
import java.util.Map;

public class WordOccurance {

    public void CountNumberofCharacterOccured(String str){
        Map<String,Integer> record = new HashMap<>();
        String[] words = str.split(" ");
        for(String word: words){
            record.put(word, record.getOrDefault(word,0)+1);
        }
        System.out.println("Words count: "+record.get("Akshay"));
    }
}
