package CollectionPractice;

import java.util.HashMap;

public class HashmapTest {
    public static void main(String[] args) {
        HashMap<Integer, Character> h = new HashMap<>();
        h.put(1,'A');
        h.put(2,'k');
        h.put(3,'S');
        h.put(4,'H');
        System.out.println(h.get(3));
    }
}
