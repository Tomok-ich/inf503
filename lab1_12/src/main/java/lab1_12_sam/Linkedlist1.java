package lab1_12_sam;

public class Linkedlist1 {
    private class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }


    private Node first;
    private Node last;
    private Node current;
    private int cnt;


    public Linkedlist1() {
        this.cnt = 0;
        this.first = null;
        this.last = null;
    }

    public void append(int value) {
        Node nodel = new Node(value);
        if (first == null) { // список пустой
            first = nodel;
            last = nodel;
        }
        else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = nodel;
            last = nodel;
        }
        cnt += 1;
    }

    public void add(int value, int ind) {
        if (ind < 0 || ind > cnt) {
            System.out.println("Нельзя добавить элемент на позицию " + ind);
            return;
        }
        Node newNode = new Node(value);
        current = first;

        if (cnt == 0) {
            first = newNode;
            last = newNode;
        }

        // Случай 2: Добавление в начало
        else if (ind == 0) {
            newNode.next = first;
            first = newNode;
        }

        // Случай 3: Добавление в конец
        else if (ind == cnt) {
            last.next = newNode;
            last = newNode; // обновляем указатель на последний элемент
        }
        else {
            Node current = first;
            // Двигаемся до элемента ПЕРЕД нужной позицией
            for (int i = 0; i < ind - 1 ; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        cnt += 1;
    }

    public int remove(int ind) {
        if (cnt == 0) {
            System.out.println("Список пуст, нечего удалять");
            return -1;
        }

        if (ind < 0 || ind >= cnt) {
            System.out.println("Неверный индекс: " + ind);
            return -1;
        }

        int removedValue;

        if (ind == 0) {
            removedValue = first.value;
            first = first.next;

            if (cnt == 1) {
                last = first.next;
            }
        }
        else {
            Node current = first;

            for (int i = 0; i < ind - 1; i++) {
                current = current.next;
            }
//            remove(3)
//               c   c.n c.n.n
//          1 -> 2 -> 3 -> 4 -> 5 -> null
            removedValue = current.next.value;

            current.next = current.next.next;

            if (current.next == null) {
                last = current;
            }
        }

        cnt -= 1;
        return removedValue;
    }

    public int pop() {
        current = first;
        if (cnt == 0) {
            System.out.println("Нечего удалить");
            return -1;
        }

        if (cnt == 1) {
            int val = first.value;
            first = null;
            last = null;
            cnt = 0;
            return val;
        }
        // в цикде доходим до предпоследнего
//                         |          c.n.n
//          1 -> 2 -> 3 -> 4 -> 5 -> null
        while (current.next.next != null) {
            current = current.next;
        }
        int val = current.next.value;
        last = current;
        last.next = null;
        cnt--;

        return val;
    }

    public int size() {
        return cnt;
    }


}