package Homework2;

import java.util.*;

public class TaskGraph {

    static class Node {
        int id;                                   // номер действия
        List<Node> dependsOn = new ArrayList<>(); // зависимости
        Thread thread;

        Node(int id, Node... deps) {
            this.id = id;
            this.dependsOn.addAll(Arrays.asList(deps));

            // Поток, который сначала дождётся всех зависимостей,
            this.thread = new Thread(() -> {
                try {
                    for (Node dep : dependsOn) {
                        dep.thread.join();
                    }

                    Thread.sleep(200);
                    System.out.println("Действие " + id + " (поток: " + Thread.currentThread().getName() + ")");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Thread-" + id);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3, n1);
        Node n4 = new Node(4, n1);
        Node n5 = new Node(5, n2);
        Node n6 = new Node(6, n2);
        Node n7 = new Node(7, n2);
        Node n8 = new Node(8, n4, n5);
        Node n9 = new Node(9, n3, n8);
        Node n10 = new Node(10, n7);
        Node n11 = new Node(11, n9, n6);
        Node n12 = new Node(12, n11, n10);

        Node[] all = {n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12};
        for (Node n : all) {
            n.thread.start();
        }

        n12.thread.join();
    }
}
