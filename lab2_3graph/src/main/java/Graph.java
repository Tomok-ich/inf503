package src.main.java;

import java.util.*;

public class Graph implements Iterable<Node> {

    private Map<Node, Set<Node>> graphMap = new HashMap<>();

    public void add(Node node, Node... dependencies) {
        graphMap.put(node, new HashSet<>(Arrays.asList(dependencies)));
    }

    @Override
    public Iterator<Node> iterator() {
        return new GraphIterator(graphMap);
    }

    private class GraphIterator implements Iterator<Node> {

        private Map<Node, Set<Node>> copy;

        public GraphIterator(Map<Node, Set<Node>> original) {
            copy = new HashMap<>();

            for (Map.Entry<Node, Set<Node>> entry : original.entrySet()) {
                copy.put(entry.getKey(), new HashSet<>(entry.getValue()));
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public Node next() {
            for (Map.Entry<Node, Set<Node>> entry : copy.entrySet()) {
                if (entry.getValue().isEmpty()) {

                    Node result = entry.getKey();

                    copy.remove(result);

                    for (Set<Node> deps : copy.values()) {
                        deps.remove(result);
                    }

                    return result;
                }
            }

            throw new RuntimeException("Граф содержит цикл!");
        }
    }
}