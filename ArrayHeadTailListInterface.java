//************************************************************************
//  ArrayHeadTailListInterface.java       Author: Jinghong Luo 
//							Salomun Min
//							Megan Powers
//
//  Represents an array where values can only be added to the 
//  beginning or the end and can be accessed at any index.
//************************************************************************


import java.util.Arrays;
public class ArrayHeadTailListInterface<T> implements HeadTailListInterface<T>
{
	private T[] listArray;
	private int numberOfElements;
	/**
 	* Creates an empty list with a given initial capacity.
 	*
 	* @param intCapacity The initial integer capacity.
 	*/
	public ArrayHeadTailListInterface(int initialCapacity)
	{
    	@SuppressWarnings("unchecked")
    	T[] tempArray = (T[]) new Comparable[initialCapacity];
    	listArray = tempArray;
    	numberOfElements = 0;
	}

/**
	 * Adds a new entry to the beginning of the list. 
	 * Entries currently in the list are shifted down.
	 * The list's size is increased by 1.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 */

	@Override
	public void addFront(T newEntry)
	{
    	int lastIndex = numberOfElements-1;
    	int capacity = listArray.length;
    	if (numberOfElements + 1 >= capacity + 1) {
        	int newCapacity = 3 * capacity;
        	listArray = Arrays.copyOf(listArray, newCapacity);
    	}
    	if (numberOfElements != 0) {
        	for (int index = lastIndex; index >= 0; index--) {
            	if (listArray[index] != null) {
                	listArray[index + 1] = listArray[index];
            	}
        	}
        	listArray[0] = newEntry;
        	numberOfElements++;
    	}
    	else{
        	listArray[0] = newEntry;
        	numberOfElements++;
    	}
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
    	int initialIndex = 0;
    	int lastIndex = numberOfElements-1;
    	int capacity = listArray.length;
    	if (numberOfElements+1 >= capacity) {
        	capacity *=3;
        	listArray = Arrays.copyOf(listArray, capacity);
    	}
    	if (numberOfElements != 0)
    	{
        	listArray[lastIndex+1] = newEntry;
        	numberOfElements++;
    	}
    	else
    	{
        	listArray[0] = newEntry;
        	numberOfElements++;
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
		if(numberOfElements != 0) {
			int givenPosition = 0;
	    	assert !isEmpty();
	    	result = listArray[givenPosition];
	    	if (givenPosition < numberOfElements)
	        	assert (givenPosition < numberOfElements);
	    	int removedIndex = 0;
	    	int lastIndex = numberOfElements;
	    	for (int index = removedIndex; index < lastIndex; index++) {
	        	listArray[index] = listArray[index + 1];
	    	}
	    	numberOfElements--;
		}
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
		if (numberOfElements != 0) {
			int givenPosition = numberOfElements;
			assert !isEmpty();
			result = listArray[givenPosition - 1];
			listArray[givenPosition - 1] = null;
			numberOfElements = numberOfElements - 1;
			if (givenPosition < listArray.length)
				assert (givenPosition < numberOfElements);
		}
    	
    	return result;
	}

	/** Removes all entries from this list. */

	@Override
	public void clear() {
    	for (int index = 0; index <= numberOfElements; index++) {
        	listArray[index] = null;
    	}
    	numberOfElements = 0;
	}

	/**
	 * Retrieves the entry at a given position in this list.
	 * 
	 * @param givenPosition An integer that indicates the position of the desired entry.
	 * @return A reference to the indicated entry or null if the index is out of bounds.
	 */

	@Override
	public T getEntry(int givenPosition) {
    	if ((givenPosition >= 0) && (givenPosition <= numberOfElements)) {
        	assert !isEmpty();
        	return listArray[givenPosition];
    	}
    	return null;
	}

	/**
	 * Displays the contents of the list to the console, in order.
	 */
	
	@Override
	public void display() {
    	System.out.print(numberOfElements + " elements; capacity = " + listArray.length + " ");
    	System.out.print("[");
    	for (int i = 0; i < listArray.length; i++) {
        	if(listArray[i]!=null){
            	System.out.print(listArray[i]);
            	if(i+1 != numberOfElements)
            	{
                	System.out.print(", ");
            	}
        	}
    	}
    	System.out.println("]");
	}

	/**
	 * Checks whether this list contains a given entry.
	 * 
	 * @param anEntry the object to search for in the list.
	 * @return the position of the entry that was found or -1 if the object is not found.
	 */

	@Override
	public int contains(T anEntry) {
    	int found = 0;
    	int index = 0;
    	for (int i = 0; i < listArray.length; i++)
    	{
        	if (anEntry.equals(listArray[i]))
        	{
            	return (i);
        	}
    	}
    	return -1;
	}

	/**
	 * Gets the length of this list.
	 * 
	 * @return The integer number of entries currently in the list.
	 */

	@Override
	public int size()
	{
    	return numberOfElements;
	}

	/**
	 * Checks whether this list is empty.
	 * 
	 * @return True if the list is empty, or false if the list contains one or more   
    elements.
	 */


	@Override
	public boolean isEmpty() {
    	if (numberOfElements == 0) {
        	return true;
    	}else {
        	return false;
    	}
	}
}
