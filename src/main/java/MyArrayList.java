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

    public int indexOf(Object obj) {
        for (int k = 0; k < size; k++) {
            if (values[k].equals(obj)) {
                return k;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void add(Object obj) {
        resize();
        values[size] = obj;
        size++;

    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);


        return false;
    }

    @Override
    public void clear() {
        for (int k = 0; k < size; k++) {
            values[k] = null;
        }
        size = 0;
    }

    @Override
    public Object get(int index) {
        if (index < size && index >= 0) {
            return values[index];
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public void add(int index, Object element) {
        resize();
        System.arraycopy(values, index, values,index + 1,size - index);
        values[index] = element;
        size++;

    }

    @Override
    public Object set(int index, Object obj) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object oldObject = values[index];
        values[index] = obj;

        return oldObject;

    }

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
    public void sort(MyList<E> list, Comparator<E> comparator) {
        if (list == null || list.length() <= 1) {
            return;
        }
        quickSort(list, 0, list.length() - 1, comparator);
    }

    private void quickSort(MyList<E> list, int low, int high, Comparator<E> comparator) {
        if (low < high) {
            int pi = partition(list, low, high, comparator);
            quickSort(list, low, pi - 1, comparator);
            quickSort(list, pi + 1, high, comparator);
        }
    }

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
