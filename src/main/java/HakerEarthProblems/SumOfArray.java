package HakerEarthProblems;

import java.util.Scanner;

public class SumOfArray {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the number of strings you want to enter: ");
        int N = sc.nextInt();

        long[] arrray = new long[N];

        for (int i = 0; i < N; i++)
        {
            arrray[i] = sc.nextLong();
        }
        long sum = 0;
        for (int i = 0; i < N; i++)
        {
            sum = sum + arrray[i];
        }
        System.out.println(sum);
    }
}
