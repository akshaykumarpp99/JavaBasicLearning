package AutomationPractice;

import java.util.Arrays;
import java.util.Collections;

public class ArrayManipulation {

    public static void main(String[] args) {
        Integer[] A = {10,20,30,40,50};
        A[3]=90;
        Integer[] B = Arrays.copyOf(A, A.length);
        Arrays.sort(B,Collections.reverseOrder());
        for(int b1: B){
            System.out.println(b1);
        }
    }
}
