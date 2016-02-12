package LinkedListImpl;

public class LinkedList {

    private Node head = null;
    private int listCount = 0;

    public boolean isEmpty(){
        return (head == null);
    }

    public void addNote(String bookName, double price){
        Node tmp = new Node(bookName, price);
        Node current = head;

        while (current.getNext() != null){
            current = current.getNext();
        }

        current.setNext(tmp);
        listCount++;
    }

    public Node get(int index){

        Node current = head;

        for (int i = 1; i < index; i++) {
            if(current.getNext() == null){
                return null;
            }else {
                current = current.getNext();
            }
        }

        return current;
    }

    public int size(){
        return listCount;
    }

    public boolean remove(int index){

        if(index < 1 || index > size()){
            return false;
        }else{

            Node current = head;

            for (int i = 1; i < index; i++) {
                if(current.getNext() == null){
                    return false;
                }else {
                    current = current.getNext();
                }
            }
            current.setNext(current.getNext().getNext());
        }
        return true;
    }

    public Node reverseLinkedList(Node head){

        if(head == null)  {
            return null;
        }else if( head.getNext() == null) {
            return head;
        }else {

                Node sec  = head.getNext();
                Node third = sec.getNext();

                head.setNext(null);
                sec.setNext(head);

                Node current = third;
                Node previous = sec;

                while (current.getNext() != null){

                    Node next = current.getNext();

                    current.setNext(previous);

                    previous = current;
                    current = next;
                }

                head = previous;
            }
        return head;
    }
}
