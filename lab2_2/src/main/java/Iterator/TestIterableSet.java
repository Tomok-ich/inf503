package Iterator;

public class TestIterableSet {
    public static void main(String[] args) {
        Set503Impl<Fruit> set = new Set503Impl<>();

        set.add(new Fruit("Яблоко 1"));
        set.add(new Fruit("Яблоко 2"));
        set.add(new Fruit("Яблоко 3"));

        System.out.println("Множество фруктов:");
        for (Fruit f : set) {
            System.out.println(f);
        }
    }
}