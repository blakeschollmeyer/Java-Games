//Name: Blake Schollmeyer
//Username: bas76530
//700no: 700517653
//Assignment Number: a6
//Folder Name: LinkedWar
//Due: 3/15/16

public class LinkedQueue<E> implements Queue<E> {

    /*The front of the ListNode in the Queue*/
    private ListNode<E> front;
    /*The front of the ListNode in the Queue*/
    private ListNode<E> back;



    /*The stack is initially empty.*/
    public LinkedQueue() {
        front = null;
        back = null;
    }

    public void add(E target)
    {
		ListNode<E> node = new ListNode<E>(target);
		if(isEmpty()){
			front = node;
			back = node;
		}else{
			back.setNext(node);
			back = node;
		}
	}

    public boolean isEmpty() {
		return front == null;
	}

	public E remove(){
		if(isEmpty()){
			throw new EmptyStructureException();
		}
		E result = front.getItem();
		front = front.getNext();
		return result;
	}

   public int size() {
      int tally = 0;
      for (ListNode<E> node = front;
           node != null;
           node = node.getNext()) {
        tally++;
      }
      return tally;
    }

 public E peek(){
     if (isEmpty()){
         throw new EmptyStructureException();
	 }
	      E result = back.getItem();
          return result;
  }


}

