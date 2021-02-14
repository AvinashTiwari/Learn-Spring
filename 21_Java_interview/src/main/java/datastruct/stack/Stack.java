package datastruct.stack;

public class Stack {
    private int maxsize;
    private long[] stackArray;
    private int top;

    public Stack(int size){
        this.maxsize = size;
        this.stackArray = new long[maxsize];
        this.top =-1;

    }

    public void push(long j){
        if(isFull()){
            System.out.println("this stack is already full ");
        }else {
            top++;
            stackArray[top] = j;
        }
    }

    public long pop(){
        if(isEmpty()){
            System.out.println("this stack is already empty ");
            return -1;
        }else {
            int old_top = top;
            top--;
            return stackArray[old_top];
        }
    }

    public long peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top ==-1);
    }

    public boolean isFull(){
        return  (top == maxsize-1);
    }
}
