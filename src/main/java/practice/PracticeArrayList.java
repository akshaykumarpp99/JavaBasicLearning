package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PracticeArrayList {

    public static void main(String[] args) {
        List<String> colors = new ArrayList<String>();
        colors.add("RED");
        colors.add("GREEN");
        colors.add("BLUE");
        colors.add(1,"Black");

        System.out.println(colors.get(3));
        System.out.println("Before"+colors);

//        Update the array 3rd element with "Yellow"
        System.out.println(colors.set(2,"Yellow"));
        System.out.println("After Update" +colors);

        colors.remove(3);
        System.out.println("After reemoving 3rd element"+colors);


        if(colors.contains("black")){
            System.out.println("True");
        } else {
            System.out.println("false");
        }

        for (String ele : colors) {
            System.out.println(ele);
        }
        Collections.sort(colors);
        System.out.println(colors);

        List<String> colors1 = new ArrayList<>();
        colors1.add("nothing");
        Collections.copy(colors,colors1);
        System.out.println(colors);

    }
}
