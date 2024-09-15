package CollectionPractice;

import java.util.ArrayList;

public class ArraylistTest {

    public static void main(String[] args) {
        ArrayList<Integer> allNum = new ArrayList<>();
        allNum.add(34);
        allNum.add(56);
        allNum.add(198);
        allNum.add(987);
        allNum.add(7654);

        System.out.println(allNum);
        int sum=0;
        for(int num: allNum){
            sum+=num;
        }
        System.out.println(sum);
    }
}
