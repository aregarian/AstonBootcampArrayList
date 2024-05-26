import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayTest {



    MyArrayList<Integer> myArrayList = new MyArrayList<>();



        @Test
        public void testAdd() {
            myArrayList.add(10);
            myArrayList.add(20);
            assertEquals(2, myArrayList.length());
            assertEquals(10, myArrayList.get(0));
            assertEquals(20, myArrayList.get(1));
        }

        @Test
        public void testRemove() {
            myArrayList.add(10);
            myArrayList.add(20);
            myArrayList.remove(0);
            assertEquals(1, myArrayList.length());
            assertEquals(20, myArrayList.get(0));
        }

        @Test
        public void testClear() {
            myArrayList.add(10);
            myArrayList.add(20);
            myArrayList.clear();
            assertEquals(0, myArrayList.length());
        }

        @Test
        public void testSort() {
            myArrayList.add(3);
            myArrayList.add(1);
            myArrayList.add(2);
            Comparator<Integer> comparator = Comparator.naturalOrder();
            myArrayList.sort(myArrayList, comparator);
            assertEquals(1, (int) myArrayList.get(0));
            assertEquals(2, (int) myArrayList.get(1));
            assertEquals(3, (int) myArrayList.get(2));
        }

    @Test
    public void insertThousandObject() {
        MyList<Integer> hehe = new MyArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {

            hehe.add(random.nextInt(100));
        }
        assertEquals(1000, hehe.length());
        assertFalse(hehe.isEmpty());
    }

    @Test
    public void checkRemove() {
        MyList<String> hehe = new MyArrayList<>();

        hehe.add("qwe");
        hehe.add("asd");
        hehe.add("zxc");
        hehe.add("123");

        assertEquals("asd", hehe.get(1));

        hehe.remove("asd");

        assertEquals("zxc", hehe.get(1));

        hehe.remove("zxc");
        assertEquals("123", hehe.get(1));

    }

    @Test
    public void testSet() {
        MyList<Object> list = new MyArrayList<>();
        list.add("Element1");
        list.add("Element2");

        assertEquals(2, list.length());
        assertEquals("Element1", list.get(0));
        assertEquals("Element2", list.get(1));
        list.set(1, "NewElement");

        assertEquals("NewElement", list.get(1));

    }
    @Test
    public void testGet() {
        MyList<Object> list = new MyArrayList<>();
        list.add("Element1");
        list.add("Element2");

        assertEquals(2, list.length());
        assertEquals("Element1", list.get(0));
        assertEquals("Element2", list.get(1));

        assertEquals("Element1", list.get(0));
        assertEquals("Element2", list.get(1));
    }
    @Test
    public void testAllClear() {
        MyList<Object> list = new MyArrayList<>();
        list.add("Element1");
        list.add("Element2");

        assertEquals(2, list.length());

        list.clear();

        assertEquals(0, list.length());
        for (int i = 0; i < list.length(); i++) {
            assertNull(list.get(i));
        }
    }






}
