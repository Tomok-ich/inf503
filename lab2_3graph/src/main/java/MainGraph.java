package src.main.java;

public class MainGraph {
    public static void main(String[] args) {

        Graph graph = new Graph();

        Node d = new Node("d");
        Node c = new Node("c");
        Node a = new Node("a");
        Node f = new Node("f");
        Node g = new Node("g");
        Node b = new Node("b");

        graph.add(d);
        graph.add(c);
        graph.add(a, d, c);
        graph.add(f, d);
        graph.add(g, d, c, f);
        graph.add(b, f, g, a, c);

        for (Node n : graph) {
            System.out.println(n.getName());
        }
    }
}