package String.reversal;

public class StringThree {
    public static void main(String[] args) {
        Reverse("Avinash");
    }

    public static void  Reverse(String Str){
        String reversed = Str.chars()
                .mapToObj(c -> (char)c)
                .reduce("", (s,c) -> c+s, (s1,s2) -> s2+s1);
    }
}
