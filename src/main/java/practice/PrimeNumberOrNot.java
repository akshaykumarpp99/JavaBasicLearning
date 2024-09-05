package practice;

public class PrimeNumberOrNot {
    public void primeNumberOrNot(int num){
        int res=0;
        if(num<=1){
            System.out.println(num+" is not a Prime Number");
        }
        for(int i=2; i<num;i++){
            if(num%2==0){
                System.out.println(num+" is not a Prime Number");
                break;
            }
            System.out.println(num+" is a Prime Number");
            break;
        }

    }
}
