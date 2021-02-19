package datastruct.singlyLinkedlist;

public class App {
    public static void main(String[] args) {
        SinglyLinkedList mylist = new SinglyLinkedList();
        mylist.insertFirst(100);
        mylist.insertFirst(50);
        mylist.insertFirst(99);
        mylist.insertLast(1);
        mylist.displayList();

    }
}
