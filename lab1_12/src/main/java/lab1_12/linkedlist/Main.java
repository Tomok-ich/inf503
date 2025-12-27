package lab1_12.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(52);
        System.out.println(linkedList.size());
        try {
            System.out.println(linkedList.get(0));
//            System.out.println(linkedList.get(666));
            System.out.println(linkedList.get(52));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Вы указали неверный индекс");
        } catch (NoooException ex) {
            System.out.println("Проклято");
            System.exit(666);
        }

    }
}
