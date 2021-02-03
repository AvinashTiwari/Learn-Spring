package String.reversal;

public class StringReversalOne {
    public static void main(String[] args) {
        Reverse("Avinash");
    }

    public static void  Reverse(String Str){

        StringBuilder input1 = new StringBuilder();

        // append a string into StringBuilder input1
        input1.append(Str);

        // reverse StringBuilder input1
        input1.reverse();

        // print reversed String
        System.out.println(input1);
    }

}
