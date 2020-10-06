public class Node
 {Book info;
   Node next;
   Node() {}
   Node(Book x, Node q) {info=x;next=q;}
   Node(Book x) {this(x,null);} 
 }
