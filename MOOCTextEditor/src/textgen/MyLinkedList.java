package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next= tail;
		tail.prev = head;
		size = 0;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	
	{
		if(element == null) {
			throw new NullPointerException("nullPointer");
		}
		// TODO: Implement this method
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.prev=tail.prev;
		tail.prev.next=newNode;
		newNode.next=tail;
		tail.prev=newNode;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		
		if(index<0 || index>size-1) {
			throw new IndexOutOfBoundsException("Out of Bounds");
		}
		LLNode<E> it = head.next;
		for(int i = 0; i < index;i++) {
			it=it.next;
		}
		return it.data;
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
		if(element == null) {
			throw new NullPointerException("nullPointer");
		}
		
		if(index<0 || index>size) {
			throw new IndexOutOfBoundsException("Out of Bounds");
		}
//		size++;
		LLNode<E> newNode = new LLNode<E>(element);
		if(index==size) {
			add(element);
		}else {
			LLNode<E> it = head;
			size++;
			for(int i = 0 ; i < index ;i++) {
				it=it.next;
			}
			newNode.prev=it;
			it.next.prev=newNode;
			newNode.next=it.next;
			it.next=newNode;
		}
		
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException("outBounds");
		}
		size--;
		LLNode<E>it = head.next;
		for(int i = 0 ; i <index;i++) {
			it=it.next;
		}
		it.prev.next=it.next;
		it.next.prev=it.prev;
//		it.next=null;
//		it.prev=null;
		return it.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(element == null) {
			throw new NullPointerException("nullPointer");
		}
		// TODO: Implement this method
		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException("outBounds");
		}
		size--;
		LLNode<E>it = head.next;
		for(int i = 0 ; i <index;i++) {
			it=it.next;
		}
		E saeed = it.data;
		it.data=element;
		return saeed;
	}
	public void printAll() {
		LLNode<E> it = head.next;
		while(it.data!=null) {
			System.out.println(it.data);
			it=it.next;
		}
	}
	public static void main(String[] args) {
	    // program code here
		
		MyLinkedList<String> shortList;
		shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		shortList.printAll();
	  }
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
