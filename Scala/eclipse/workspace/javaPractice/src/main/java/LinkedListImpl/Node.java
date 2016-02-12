package LinkedListImpl;

public class Node {

    private String bookName;
    private double price;

    private Node next;

    public Node(String bookName, double price){
        this.bookName = bookName;
        this.price = price;
    }

    public String toString(){
        return "Price of " + bookName + " is " + price;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getBookName() {
        return bookName;
    }

    public double getPrice() {
        return price;
    }
}
