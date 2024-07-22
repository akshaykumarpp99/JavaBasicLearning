package HakerEarthProblems;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        BigInteger factorial = BigInteger.ONE;

        for(int i=2;i<=N;i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(factorial);
        scanner.close();
    }
}