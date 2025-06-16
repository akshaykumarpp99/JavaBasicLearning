package practice;

public class validAnagrams {
    public static void main(String[] args){

        String s = "Hello Akshay";
        String d = "Hello akshay";

        validAnagrams v = new validAnagrams();
        boolean res = v.chkVldAnagrams(s, d);
        System.out.println(res);
    }

    public boolean chkVldAnagrams(String s, String d){

        char[] sArray = s.toCharArray();
        char[] dArray = d.toCharArray();

        return new String(sArray).equals(new String(dArray));

    }
}
