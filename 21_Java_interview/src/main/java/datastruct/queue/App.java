package datastruct.queue;

public class App {
    public static void main(String[] args) {
        queue newQueue = new queue(5);
        newQueue.insert(100);
        newQueue.insert(200);
        newQueue.insert(300);
        newQueue.insert(400);
        newQueue.insert(44);

        newQueue.view();
    }
}
