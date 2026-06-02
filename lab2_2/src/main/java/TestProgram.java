package src.main.java;

public class TestProgram {
    public static void main(String[] args) {
        System.out.println("=== List503 (ArrayList503) ===");
        List503<String> list = new ArrayList503<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(2, "X");
        for (String s : list) System.out.println(s);
        System.out.println("Size: " + list.size());

        System.out.println("\n=== Set503 (Set503Impl) ===");
        Set503<Integer> set = new Set503Impl<>();
        set.add(10);
        set.add(20);
        set.add(10);
        for (int i : set) System.out.println(i);
        System.out.println("Contains 20? " + set.contains(20));

        System.out.println("\n=== Map503 (Map503Imp) ===");
        Map503<String, Integer> map = new Map503Imp<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("two", 22);
        for (Map503.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());

        System.out.println("\n=== Bazar (Iterable example) ===");
        Bazar.main(null);
    }
}