//Name: Blake Schollmeyer
//UserId: bas76530
//700no: 700517653
//Assignment Number: a4
//Folder Name: IdiotsDelight

public interface Stack<E> {

	// Return true if this stack is empty.
	public boolean isEmpty();

	// Return the top Object on this stack. Do not modify the stack.
	// @throws EmptyStructureException if the stack is empty.

	public E peek();

	// Remove and return the top Object on this stack.
	// @throws EmptyStructureException if the stack is empty.

	public E pop();

	// Add target to the top of the stack.
	public void push(E target);

	public int getSize();


}