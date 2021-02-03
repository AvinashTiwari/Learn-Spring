package String.reversal;

public class StringReverseTWo {
    public static void main(String[] args) {
        Reverse("Avinash");
    }

    public static void  Reverse(String Str){
       String reversed = "";

         for(char c : Str.toCharArray()){
             reversed = c + reversed;
        }
        System.out.println(reversed);
    }
    }

