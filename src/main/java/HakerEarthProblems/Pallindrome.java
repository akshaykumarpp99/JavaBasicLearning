package HakerEarthProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pallindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        char[] array = name.toLowerCase().toCharArray();
        String result="false";

        if(array.length/2!=0){

            for(int i=0,temp=array.length-1;i<array.length/2;i++,temp--){

                if(array[i] == array[temp]){
                    result="true";
                } else {
                    result="false";
                }
            }
        }
        if(result=="true") {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
