import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> hehe = new MyArrayList<>();

        hehe.add(12);
        hehe.add(12);
        hehe.add(45);
        hehe.add(36);
        hehe.add(11);
        hehe.add(12);
        hehe.add(12);
        hehe.add(12);
        hehe.sort(hehe, Comparator.naturalOrder());

        for (int i = 0; i < hehe.length(); i++) {
            System.out.println(hehe.get(i));
        }
    }
}
