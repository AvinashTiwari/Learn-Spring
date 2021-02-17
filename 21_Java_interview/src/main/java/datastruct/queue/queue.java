package datastruct.queue;

public class queue {
   private int maxsize;
   private long[] queArray;
   private int front;
   private int rear;
   private int nItems;
    public queue(int size){
        this.maxsize = size;
        this.queArray = new long[size];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public void insert(long j){
        if(rear == maxsize){
            rear = -1;
        }

        rear++;
        this.queArray[rear] =j;
        this.nItems++;
    }

    public long remove(){
       long temp =  queArray[front];
        front++;
        if(front == maxsize){
            front = 0;
        }
        this.nItems--;

        return temp;
    }

    public  long peekfront(){
       return queArray[front];
    }

    public boolean isEmpty(){
        return  (this.nItems == 0);
    }

    public  boolean isFull(){
        return  (this.nItems == this.maxsize);
    }

    public void view(){
        System.out.println("[ ");
        for(int i =0; i < queArray.length; i++){
            System.out.println(queArray[i] + " ");
        }
        System.out.println(" ] ");
    }
}
