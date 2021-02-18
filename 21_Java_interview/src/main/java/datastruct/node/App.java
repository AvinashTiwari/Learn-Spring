package datastruct.node;

public class App {
    public static void main(String[] args) {
        Node nodea = new Node();
        nodea.data = 4;

        Node nodeb = new Node();
        nodeb.data = 3;


        Node nodec = new Node();
        nodec.data = 7;

        Node noded = new Node();
        noded.data = 8;


        nodea.next = nodeb;
        nodeb.next = nodec;
        nodec.next = noded;

        System.out.println(listLength(nodea));
    }

    public static int listLength(Node node){
        int length =0;
        Node currentNode = node;
        while(currentNode != null){

            length++;
            currentNode = currentNode.next;
        }

        return  length;
    }
}
