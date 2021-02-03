package palidrome;

public class palidormeOne {
    public static void main(String[] args) {
        System.out.println(palidorme("abba"));
        System.out.println(palidorme("abbz"));
    }

    public static  boolean palidorme(String str){
        StringBuilder strb = new StringBuilder();
        strb.append(str);
        String reverse  = strb.reverse().toString();
        return  reverse.equals(str);
    }
}
