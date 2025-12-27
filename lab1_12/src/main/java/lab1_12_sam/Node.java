package lab1_12_sam;

public class Main {
    public static void main(String[] args) {
        LinkedList503 linkedList = new LinkedList503();
        System.out.println(linkedList.size());
        linkedList.add(0);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(-151);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(-150);
        linkedList.add(-150);
        linkedList.add(-150);
        linkedList.add(-3);
        linkedList.add(0);
        linkedList.add(0);
        linkedList.showFullList();
        linkedList.add(2, 2);
        linkedList.showFullList();
        linkedList.remove(1);
        linkedList.remove(5);
        linkedList.showFullList();
        System.out.println("Удалили и вернули значение:");
        System.out.println(linkedList.pop());
        linkedList.showFullList();
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(3));
        System.out.println("-----------------------------------");
//        linkedList.showFullList();
        linkedList.sort();
//        linkedList.showFullList();
        System.out.println(linkedList);
    }
}