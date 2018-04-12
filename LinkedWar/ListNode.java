//Name: Blake Schollmeyer
//Username: bas76530
//700no: 700517653
//Assignment Number: a6
//Folder Name: LinkedWar
//Due: 3/15/16

 /** Node in a linked list. */
 public class ListNode<E> {

   /** The item stored in this node. */
   private E item;

   /** The node following this one. */
   private ListNode<E> next;

   /** Put item in a node with no next node. */
   public ListNode(E item) {
     this.item = item;
     next = null;
   }

   /** Put item in a node with the specified next node. */
   public ListNode(E item, ListNode<E> next) {
     this.item = item;
     this.next = next;
   }

   /** Return the item stored in this node. */
   public E getItem() {
     return item;
   }

   /** Return the next node. */
   public ListNode<E> getNext() {
     return next;
   }

   /** Replace the item stored in this node. */
   public void setItem(E item) {
     this.item = item;
   }

   /** Set the next node. */
   public void setNext(ListNode<E> next) {
     this.next = next;
   }

 }

