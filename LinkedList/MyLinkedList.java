/**
 *
 * @author AYESHA PERERA
 */

public class MyLinkedList {
    
    static Node node;

    static class Node {

        int data;
	Node link;

	Node(int d) {
            data = d;
            link = null;
	}
        
    }
    
    Node reverseList(Node n){
        
        Node head = n;
        Node prev = null;
        Node next = null;
        
        while (head != null) {            
            next = head.link;
            head.link = prev;
            prev = head;
            head = next;           
        }
        n = prev;
        return n; 
    
    }
    
    void printList(Node n){
        while (n != null) {
            System.out.print(n.data + "  ");
            n = n.link;
        }
    }
        
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.node = new Node(45);
        myList.node.link = new Node(98);
        myList.node.link.link = new Node(3);
        myList.node.link.link.link = new Node(5);
       
        myList.printList(node);
        System.out.println("");
        node = myList.reverseList(node);
        myList.printList(node);
        

    }
}
