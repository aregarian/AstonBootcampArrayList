import java.util.Comparator;

public class MyArrayList<E> implements MyList<E>{

    private Object[] values;

    private int size = 0;

    private final static int INITCAPACITY = 10;

    private int arraySize = INITCAPACITY;

    public MyArrayList(int size) {
        this.size = size;
        values = new Object[this.size];
    }

    public MyArrayList() {
        values = new Object[INITCAPACITY];

    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param obj the element to search for in the list
     * @return the index of the element, or -1 if the element is not found
     */
    public int indexOf(Object obj) {
        for (int k = 0; k < size; k++) {
            if (values[k].equals(obj)) {
                return k;
            }
        }
        return -1;
    }

    /**
     * Checks if the list is empty.
     *
     * This method checks if the list has a size of 0 to determine if it is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }



    /**
     * Returns the number of valid elements in the list.
     *
     * This method calculates the length of the list by counting the non-null elements.
     *
     * @return The number of valid elements in the list.
     */
    @Override
    public int length() {
        int length = 0;
        for (Object value : values) {
            if (value != null) {
                length++;
            }
        }
        return length;
    }


    /**
     * Adds the specified object to the end of the list.
     *
     * This method adds the object `obj` to the end of the list after resizing it if necessary.
     *
     * @param obj the object to be added to the list
     */
    @Override
    public void add(Object obj) {
        resize();
        values[size] = obj;
        size++;
    }


    /**
     * Removes the specified object from the list.
     *
     * This method removes the object `o` from the list by shifting all elements after it to the left.
     * If the object is found in the list, it is removed, and the size of the list is decremented.
     *
     * @param o the object to be removed from the list
     */
    @Override
    public void remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            System.arraycopy(values, index + 1, values, index, size - index - 1);
            size--;
            values[size] = null;
        }
    }


    /**
     * Removes the element at the specified index from the list.
     *
     * This method removes the element at the given index from the list by shifting all subsequent elements to the left.
     * If the index is greater than the current size of the list, it throws an IndexOutOfBoundsException.
     *
     * @param index the index of the element to be removed from the list
     * @throws IndexOutOfBoundsException if the index is greater than the current size of the list
     */
    @Override
    public void remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(values, index + 1, values, index, size - index - 1);
        values[--size] = null;
        resize();
    }


    /**
     * Clears all elements from the list.
     *
     * This method clears all elements from the list by setting each element to null.
     * It also resets the size of the list to 0.
     */
    @Override
    public void clear() {
        for (int k = 0; k < size; k++) {
            values[k] = null;
        }
        size = 0;
    }


    /**
     * Returns the element at the specified index in the list.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public Object get(int index) {
        if (index < size && index >= 0) {
            return values[index];
        } else {
            throw new IndexOutOfBoundsException();
        }

    }


    /**
     * Retrieves and returns the element at the specified index in the list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public void add(int index, Object element) {
        resize();
        System.arraycopy(values, index, values,index + 1,size - index);
        values[index] = element;
        size++;

    }

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
    @Override
    public void set(int index, Object obj) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object oldObject = values[index];
        values[index] = obj;

    }

    /**
     * Resizes the internal array if the size of the list exceeds the array size or is less than a quarter of the array size.
     *
     * This method checks if the size of the list has exceeded the current array size. If it has, it increases the array size to 1.5 times the current size plus 1 and copies the elements to a new array with the increased size.
     *
     * It also checks if the size of the list is less than a quarter of the array size. If it is, it reduces the array size to 1.5 times the current size plus 1 and copies the elements to a new array with the decreased size.
     */
    private void resize() {
        if (size >= arraySize) {
            Object[] newValues = new Object[size * 3 / 2 + 1];
            System.arraycopy(values, 0, newValues, 0, size);
            values = newValues;
        }

        if (size >= INITCAPACITY && size < arraySize / 4) {
            Object[] newValues = new Object[size * 3 / 2 + 1];
            System.arraycopy(values, 0, newValues, 0, size);
            values = newValues;
        }
    }



    /**
     * Sorts the elements in the list using the quicksort algorithm with the specified comparator.
     *
     * @param list the MyList instance to be sorted
     * @param comparator the comparator used to determine the order of elements
     */
    public void sort(MyList<E> list, Comparator<E> comparator) {
        if (list == null || list.length() <= 1) {
            return;
        }
        quickSort(list, 0, list.length() - 1, comparator);
    }


    /**
     * Recursively sorts a subarray of the list using the quicksort algorithm with the specified comparator.
     *
     * @param list the MyList instance to be sorted
     * @param low the starting index of the subarray to be sorted
     * @param high the ending index of the subarray to be sorted
     * @param comparator the comparator used to determine the order of elements
     */
    private void quickSort(MyList<E> list, int low, int high, Comparator<E> comparator) {
        if (low < high) {
            int pi = partition(list, low, high, comparator);
            quickSort(list, low, pi - 1, comparator);
            quickSort(list, pi + 1, high, comparator);
        }
    }

    /**
     * Partitions a subarray of the list based on a pivot element for the quicksort algorithm.<br/>
     *<br/>
     * @param list the MyList instance to be partitioned<br/>
     * @param low the starting index of the subarray to be partitioned<br/>
     * @param high the ending index of the subarray to be partitioned<br/>
     * @param comparator the comparator used to determine the order of elements<br/>
     * @return the index of the pivot element after partitioning<br/>
     */
    private int partition(MyList<E> list, int low, int high, Comparator<E> comparator) {
        E pivot = (E) list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare((E) list.get(j), pivot) < 0) {
                i++;
                E temp = (E) list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        E temp = (E) list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }
}
