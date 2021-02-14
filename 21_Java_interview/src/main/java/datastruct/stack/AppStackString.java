package datastruct.stack;

public class AppStackString {
    public static void main(String[] args) {
        String str= "Hello";
        int stackSize = str.length();
        StackString theStack = new StackString(stackSize);
        for(int j = 0; j < str.length() ; j++){
            char ch = str.charAt(j);
            theStack.push(ch);
        }

       String result = "";
        while(!theStack.isEmpty()){
            char value = theStack.pop();
            result = result +value;
            System.out.println(value);
        }

        System.out.println(result);
    }
}
