package lab1_12.linkedlist;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(5);
        list.add(0);
        list.add(17);
        list.add(-3);
        list.add(8);

        try {
            System.out.println(list.get(13));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();

            System.out.println("Вы указали неверный индекс, повторите ввод");
        } catch (NoNoNo13Exception e) {
            System.err.println("Только не 13");
            System.exit(13);
        }

        System.out.println("Continue");
    }
}
