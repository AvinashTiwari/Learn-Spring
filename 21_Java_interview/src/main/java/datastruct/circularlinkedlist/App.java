package datastruct.circularlinkedlist;



public class App {
    public static void main(String[] args) {
        circularLinkedList mylist = new circularLinkedList();
        mylist.InsertFirst(100);
        mylist.InsertFirst(50);
        mylist.InsertFirst(99);
        mylist.InsertFirst(1);
        mylist.InsertLast(2001);

        mylist.DisplayList();

    }
}
