//************************************************************************
//  LinkedHeadTailListInterface.java       Author: Em Powers
//							
//
//  Represents a linked list where values can only be added to the 
//  beginning or the end and can be accessed at any index.
//************************************************************************


public class LinkedHeadTailList<T> implements HeadTailListInterface<T> 
{
	private Node head, tail;
	private int numberOfEntries; 
	
	/**
 	* Creates an empty linked list with a given initial capacity.
 	* Sets the first node to null and the last node to null. 
 	* 
 	*/
	
	public LinkedHeadTailList()
		{
			head = null;
			tail = null;
			numberOfEntries = 0;
		}
	
	/**
	 * Adds a new entry to the beginning of the list. 
	 * Entries currently in the list are shifted down.
	 * The list's size is increased by 1.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 */
	
	@Override
	public void addFront(T newEntry){
		Node newNode = new Node(newEntry);
			
	    if (head == null) {
	    	head = newNode;
	    	tail = newNode;
	    	numberOfEntries++;
	    }else{
	    	newNode.next = head;
	    	head = newNode; 
	    }
	    numberOfEntries++;
	}
	
	/**
	 * Adds a new entry to the end of the list. 
	 * Entries currently in the list are unaffected.
	 * The list's size is increased by 1.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 */
	
	@Override
	public void addBack(T newEntry) {
		
		Node newNode = new Node(newEntry);		
		
		if (head == null) {
			head = newNode;
			numberOfEntries = 1;
		}else {
			Node thisNode = head;
			
			while (thisNode.next != null) {
				thisNode = thisNode.next;
			}
			
			thisNode.next = newNode;
			tail = thisNode;
			numberOfEntries++;
		}
	}
	
	/**
	 * Removes an entry from the beginning of the list. 
	 * Entries currently in the list are shifted up.
	 * The list's size is decreased by 1.
	 * 
	 * @return A reference to the removed entry or null if the list is empty.
	 */
	
	@Override
	public T removeFront() {
		
		T result = null; 
		Node newNode = head;
	   
		if (numberOfEntries != 0 && head != null) {
			
	    	assert !isEmpty();
	    		newNode = head;
	    		head = head.next;
	    		newNode.next = null;
	    		return (T) newNode.data; 
	    }
	    numberOfEntries--;
	    return result; 
	}
	
	/**
	 * Removes an entry from the end of the list. 
	 * Entries currently in the list are unaffected.
	 * The list's size is decreased by 1.
	 * 
	 * @return A reference to the removed entry or null if the list is empty.
	 */
	
	@Override
	public T removeBack() {
		T result = null;
		Node newNode = tail;
		   
		if (numberOfEntries != 0 && tail.next != null) {
			newNode = tail.next;
			tail.next = null; 
			return (T) newNode.data; 
		}
		numberOfEntries--;
		return result;
	}
	
	/** Removes all entries from this list. */
	
	@Override
	public void clear() {
			head = null;
		}
		
	/**
	 * Retrieves the entry at a given position in this list.
	 * 
	 * @param givenPosition An integer that indicates the position of the desired entry.
	 * @return A reference to the indicated entry or null if the index is out of bounds.
	 */
	
	@Override
	public T getEntry(int givenPosition) {
			T anEntry = null;
			Node newNode = new Node(anEntry);	
			
			assert !isEmpty() && (0 < givenPosition) && (givenPosition < numberOfEntries);
			
				Node currentNode = head;
				
				for (int counter = 0; counter < numberOfEntries; counter++) {
					
					if (counter == givenPosition) {
						return (T) currentNode.data;
					}
				
					currentNode = currentNode.getNextNode();
				}
				
				assert currentNode != null;
		
		return anEntry;
	}
	
	/**
	 * Displays the contents of the list to the console, in order.
	 */
	
	@Override
	public void display() {
		
		Node temp = head;
		
		System.out.print("[");
		
		 for (int counter = 0; counter < numberOfEntries; counter++){
			if (head != null && temp != null) {
				 
				System.out.print(temp.data);
				temp = temp.next;
			}
			
			if (counter + 1 != numberOfEntries && temp != null) {
				System.out.print(", ");
			}
		 }
		
		System.out.print("]");
		
		if (numberOfEntries > 1 ) {
			if (head != null) {
			System.out.println("   head=" + head.data + " " + " tail=" + tail.data);
			}	
		}
	}
	
	/**
	 * Checks whether this list contains a given entry.
	 * 
	 * @param anEntry the object to search for in the list.
	 * @return the position of the entry that was found or -1 if the object is not found.
	 */
	
	@Override
	public int contains(T anEntry) {
		int counter = -1;
		
			Node currentNode = head;
			
			for (int i = 0; i < numberOfEntries; i++) {
				
				if (anEntry.equals(currentNode.data)) {
					return i;
				}
			
				currentNode = currentNode.getNextNode();
			}
			
			assert currentNode != null;

		return -1;
	}

	/**
	 * Gets the length of this list.
	 * 
	 * @return The integer number of entries currently in the list.
	 */
	
	@Override
	public int size() {
		return numberOfEntries;
	}
	
	/**
	 * Checks whether this list is empty.
	 * 
	 * @return True if the list is empty, or false if the list contains one or more elements.
	 */
	
	@Override
	public boolean isEmpty() {
		if (numberOfEntries == 0) {
			return true;
		}else {
			return false;
		}
	}
}
