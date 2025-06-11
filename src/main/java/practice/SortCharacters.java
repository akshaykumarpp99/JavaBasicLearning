package practice;

import java.util.Arrays;

public class SortCharacters {
    public static void main(String[] args) {
        String s = "asdfghgfdsasdfgfdsaaa";

        char[] c = s.toCharArray();
        Arrays.sort(c);
        System.out.println(new String(c));
    }
}
