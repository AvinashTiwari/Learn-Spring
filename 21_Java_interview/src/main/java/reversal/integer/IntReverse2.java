package reversal.integer;

public class IntReverse2 {

    public static void main(String[] args) {
        Reverse("123456");
        Reverse("-123456");
    }

    public static void  Reverse(String Str){

        StringBuilder input1 = new StringBuilder();
        boolean isNegative = false;
        if(Str.contains("-"))
        {
            isNegative = true;
        }
        // append a string into StringBuilder input1
        Str = Str.replace("-","");
        input1.append(Str);


        // reverse StringBuilder input1
        input1.reverse();

        // print reversed String

        if(isNegative){
            System.out.println(Integer.parseInt(input1.toString()) * -1);
        }else
        {
            System.out.println(Integer.parseInt(input1.toString()));
        }
    }
}
