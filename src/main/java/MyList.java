import java.util.Arrays;
import java.util.Comparator;
import java.util.ListIterator;

public interface MyList<E> {

    boolean isEmpty();

    int length();

    void add(Object e);

    boolean remove(Object o);

    void clear();

    Object get(int index);

    void add(int index, Object element);

    Object set( int index, Object obj);

}
