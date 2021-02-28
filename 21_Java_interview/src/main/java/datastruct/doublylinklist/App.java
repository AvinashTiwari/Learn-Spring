package datastruct.doublylinklist;



public class App {
    public static void main(String[] args) {
         DoublyLinkedList mylist = new DoublyLinkedList();
        mylist.insertFirst(100);
        mylist.insertFirst(50);
        mylist.insertFirst(99);
        mylist.insertLast(1);
        mylist.insertLast(2001);
        mylist.displayForward();
        mylist.DisplayBackward();


    }
}
