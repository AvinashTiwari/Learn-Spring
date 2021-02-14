package datastruct.stack;

public class StackString {
    private int maxsize;
    private char[] stackArray;
    private int top;

    public StackString(int size){
        this.maxsize = size;
        this.stackArray = new char[maxsize];
        this.top =-1;

    }

    public void push(char j){
        if(isFull()){
            System.out.println("this stack is already full ");
        }else {
            top++;
            stackArray[top] = j;
        }
    }

    public char pop(){
        if(isEmpty()){
            System.out.println("this stack is already empty ");
            return '0';
        }else {
            int old_top = top;
            top--;
            return stackArray[old_top];
        }
    }

    public char peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top ==-1);
    }

    public boolean isFull(){
        return  (top == maxsize-1);
    }
}
