package CollectionPractice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionBasics {

//    Iterable (Interface): This interface can be used in foreach statement
//        =>    Collection (Interface):
//                    =>      List (Interface)
//                               =>     Arraylist(Class)
//                               =>     LinkedList(Class)
//                    =>      Queue(Interface)
//                               =>     PriorityQueue(Class)
//                    =>      Set(Interface)
//                               =>     HashSet(Class)

    public static void show(){

        Collection<String> collection = new ArrayList<>();
//        We can add the strings in 2 ways
//        1st method is by adding one by one String as given below

//        collection.add("a");
//        collection.add("b");
//        collection.add("c");
//        System.out.println(collection);

//        2nd method is adding all strings in one go
        Collections.addAll(collection, "a","b","c");
        System.out.println(collection);
        var stringArray = "Akshay";
    }

}
