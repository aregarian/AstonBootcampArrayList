public interface MyList<E> {


    /**
     * Checks if the list is empty.
     *
     * This method checks if the list has a size of 0 to determine if it is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    boolean isEmpty();


    /**
     * Returns the number of valid elements in the list.
     *
     * This method calculates the length of the list by counting the non-null elements.
     *
     * @return The number of valid elements in the list.
     */
    int length();

    /**
     * Adds the specified object to the end of the list.
     *
     * This method adds the object `obj` to the end of the list after resizing it if necessary.
     *
     * @param e the object to be added to the list
     */
    void add(Object e);


    /**
     * Removes the specified object from the list.
     *
     * This method removes the object `o` from the list by shifting all elements after it to the left.
     * If the object is found in the list, it is removed, and the size of the list is decremented.
     *
     * @param o the object to be removed from the list
     */
    void remove(Object o);


    /**
     * Removes the element at the specified index from the list.
     *
     * This method removes the element at the given index from the list by shifting all subsequent elements to the left.
     * If the index is greater than the current size of the list, it throws an IndexOutOfBoundsException.
     *
     * @param index the index of the element to be removed from the list
     * @throws IndexOutOfBoundsException if the index is greater than the current size of the list
     */
    void remove(int index);


    /**
     * Clears all elements from the list.
     *
     * This method clears all elements from the list by setting each element to null.
     * It also resets the size of the list to 0.
     */
    void clear();

    /**
     * Returns the element at the specified index in the list.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    Object get(int index);


    /**
     * Retrieves and returns the element at the specified index in the list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    void add(int index, Object element);


    /**
     * Replaces the element at the specified index with the specified object.
     * <p>
     * This method sets the element at the given index to the specified object.
     * If the index is equal to or greater than the current size of the list, it throws an IndexOutOfBoundsException.
     *
     * @param index the index of the element to replace
     * @param obj   the new object to set at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    void set(int index, Object obj);

}
