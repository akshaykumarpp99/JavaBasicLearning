package HakerEarthProblems;

import java.util.Scanner;

public class Divisibility {

//  Question
//      You are provided an array A of size N that contains non-negative integers.
//      Your task is to determine whether the number that is formed by selecting the last digit of all the N numbers is divisible by 10.
//
//      Note: View the sample explanation section for more clarification.
//
//  Input format
//
//    - First line: A single integer N denoting the size of array A
//    - Second line: N space-separated integers.

//  Output format
//
//    - If the number is divisible by 10, then print Yes. Otherwise, print No.


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//      Declaring the Array size here
        int arraySize = sc.nextInt();
        int[] arr = new int[arraySize];
        int finalnum = 0;
        String summationOfReminder = "";

//      Storing the integers into int array "arr" variable.
        for (int i=0; i<=arraySize-1;i++){
            int elements = sc.nextInt();
            arr[i]=elements;
        }

//      Concatinating all last digits present in the int array
        for(int array: arr){
            int temp = array%10;
            summationOfReminder = summationOfReminder+(array%10);
            System.out.println("Last digit of "+array+" is "+temp);
        }

        finalnum = Integer.parseInt(summationOfReminder);

//      Checking whether the number is divisible by 10 or not
        if(finalnum%10==0) {
            System.out.println("There for the number formed is "+finalnum+" which is divisible by 10");
        } else {
            System.out.println("There for the number formed is "+finalnum+" which is not divisible by 10");
        }

    }
}
