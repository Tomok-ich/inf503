package src.main.java.ru.itis.inf503.lab2_2;

public class TestIterator {

    public static void main(String[] args) {

        System.out.println("===== TEST SET =====");

        Set503gen<String> set = new Set503GenImpl<>();

        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A");

        System.out.println("Set contents:");
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("Contains B: " + set.contains("B"));
        System.out.println("Size: " + set.size());

        set.remove("B");

        System.out.println("After remove B:");
        for (String s : set) {
            System.out.println(s);
        }


        System.out.println("===== TEST LIST =====");

        List503<String> list = new List503Impl<>();

        list.add("L1");
        list.add("L2");
        list.add("L3");

        System.out.println("List contents:");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("Get index 1: " + list.get(1));

        list.remove(1);

        System.out.println("After remove index 1:");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("Size: " + list.size());


        System.out.println("===== TEST MAP =====");

        Map503<String, Integer> map = new Map503Impl<>();

        map.put("Alex", 20);
        map.put("Maria", 22);
        map.put("Ivan", 30);
        map.put("Alex", 25);

        System.out.println("Get Alex: " + map.get("Alex"));

        System.out.println("Keys:");
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        System.out.println("Values:");
        for (Integer val : map.values()) {
            System.out.println(val);
        }

        System.out.println("Entries:");
        for (Map503.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        map.remove("Ivan");

        System.out.println("Keys after remove Ivan:");
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        System.out.println("Size: " + map.size());
    }
}