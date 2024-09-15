package CollectionPractice;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        st.push("asdf");
        st.push("qwer");
        st.push("yuio");
        st.push("hbm");

        System.out.println(st);

        for(String str: st){
            System.out.println(str);
        }
    }
}
