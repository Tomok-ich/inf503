package lab1_12_sam;

public class LinkedList503 {
    public static void main(String[] args) throws Exception {
        Linkedlist1 linkedlist = new Linkedlist1();
        linkedlist.remove(0);
        linkedlist.append(1);
        linkedlist.append(2);
        linkedlist.append(3);
        linkedlist.append(4);
        linkedlist.append(5);
        System.out.println(linkedlist);
        linkedlist.add(10, 3);
        System.out.println(linkedlist);
        linkedlist.pop();
        System.out.println(linkedlist);
        linkedlist.remove(2);
        System.out.println(linkedlist);
        System.out.println(linkedlist.size());


    }
}
