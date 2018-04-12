//Name: Blake Schollmeyer
//Username: bas76530
//700no: 700517653
//Assignment Number: a6
//Folder Name: LinkedWar
//Due: 3/15/16

public interface Queue<E> {

    // Add target to the back of this Queue
    public void add(E target);

    // Return true if this Queue is empty
    public boolean isEmpty();

    // Remove and return front item to  from this queue
    public E remove();

    // Had to add this to get it to run
    public E peek();

    // added this to allow for size() in ArrayQueue
    public int size();

}
