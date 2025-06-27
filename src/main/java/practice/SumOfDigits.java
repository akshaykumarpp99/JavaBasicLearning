package practice;

public class SumOfDigits {
    public void sumOfDigits(int num){
        int store = 0;
        while(num>0){
            store = store + num%10;
            num=num/10;
        }
        System.out.println("sum of digist: "+store);
    }

    public static void main(String[] args) {
        SumOfDigits s = new SumOfDigits();
        s.sumOfDigits(123);
    }
}
