package practice;

public class ReverseAString {
    public void reverseAString(String str){
        String res="";
        System.out.println("Before Reverse: "+str);

        for(int i=str.length()-1; i>=0;i--){
            res=res+str.charAt(i);
        }

        System.out.println("After Reverse: "+res);

    }
}
