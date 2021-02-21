package datastruct.circularlinkedlist;

public class circularLinkedList {
    Node first;
    Node last;

    public circularLinkedList(){
        first = null;
        last = null;
    }

    public void InsertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;

        if(isEmpty()){
            last = newNode;
        }
        newNode.next = first;
        first = newNode;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void InsertLast(int data){
        Node newNode = new Node();
        newNode.data = data;

        if(isEmpty()){
            first = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }

    }

    public int deleteFirst(){
        int temp = first.data;
        if(first.next == null){
            last = null;
        }

        first = first.next;
        return temp;
    }

    public void DisplayList(){
        System.out.println("First --> Last");
        Node current = first;
        while(current != null){
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }
}
