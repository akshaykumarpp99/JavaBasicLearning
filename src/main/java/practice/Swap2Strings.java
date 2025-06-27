package practice;

public class Swap2Strings {
    public void swapTwoStrings(String s1, String s2) {

        s1=s1+s2;

        s2=s1.substring(0, s1.length()-s2.length());
        s1=s1.substring(s2.length());

        System.out.println("S1 "+s1);
        System.out.println("S2 "+s2);

    }

    public static void main(String[] args) {
        ////       Swap 2 Strings
        Swap2Strings s1 = new Swap2Strings();
        s1.swapTwoStrings("Akshay","wifi");
    }
}
