package reversal.integer;

public class IntReversalOne {
    public static void main(String[] args) {
        System.out.println(reverseInteger(12345678));
        System.out.println(reverseInteger(-12345678));
    }

    public static int reverseInteger(int number) {
        boolean isNegative = number < 0 ? true : false;
        if (isNegative) {
            number = number * -1;
        }
        int reverse = 0;
        int lastDigit = 0;
        while (number >= 1) {
            lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number = number / 10;
        }
        return isNegative == true ? reverse * -1 : reverse;
    }
}
