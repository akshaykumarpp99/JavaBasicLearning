package practice;

public class ReverseAString {
    public void reverseAString(String str){

        String res="";

        System.out.println("Before Reverse: "+str);
        for(int i=str.length()-1; i>=0;i--){
            res = res + str.charAt(i);
        }
        System.out.println("After Reverse: "+res);



    }

    public static void main(String[] args) {
//        ReverseAString rstr = new ReverseAString();
//        rstr.reverseAString("akshay");

        String s1 = "Akshay";

        char[] c = s1.toCharArray();
        char[] res = new char[c.length];
//        String res = "";

        for(int i=c.length-1, j=0;i>=0;i--,j++){
            System.out.println("i: "+i+" j: "+ j);
            res[j] = c[i];
        }
        System.out.println(new String(res));
    }
}
