public class BTree implements IntCollection {
    /*
    Значения в узлах левого поддерева <= значению в узле
     */
    /*
    Значения в узлах правого поддерева > значению в узле
     */

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(value);
        }
    }

    private Node root;
    private int size = 0;
    private int capacity = 0;

    public String toString() {
        return print(root);
    }

    private String print(Node node){
        if (node == null){
            return "";
        }

        return node.value  + " " + print(node.left) + " " + print(node.right);
    }

    public void add(int value) {
        if (root == null)
            root = new Node(value);
        else
            add(value, root);
        size++;
    }

    private void add(int value, Node node){
        if (value <= node.value) {
            if (node.left == null) { // добавляем в левое поддерево
                Node v = new Node(value);
                node.left = v;
            } else {
                add(value, node.left);
            }
        } else {
            if (node.right == null) { // добавляем в правое поддерево
                Node v = new Node(value);
                node.right = v;
            } else {
                add(value, node.right);
            }
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String[] getPath(int value) throws  NotFoundException, EmptyTreeException {
        if(root == null) {
            throw new EmptyTreeException("Дерево пустое");
        }

        this.capacity = (int) Math.log(size) + 2;
        String[] road = new String[capacity];

        if (road[0] == null) {
            if (value == root.value) {
                System.out.println(root + " корень дерева");
            }
            else {
                throw new NotFoundException("Такого числа нет в дереве",value);
            }
        }

        return getCurrPath(root, road, value, "-1", -1);
    }

    private String[] getCurrPath(Node node, String[] road, int value, String curr, int index) {
        Node left = node.left;
        Node right = node.right;
        if(!curr.equals("-1")) {
            road[index] = curr;
        }
        if(value == node.value) {
            for (int i = index+1; i < capacity; i++) {
                road[i] = null;
            }
            return road;
        }
        String[] result;
        if(left != null && node.value > value) {
            result = getCurrPath(left, road, value, "l", index+1);
            if(result[0] != null) {
                return result;
            }
        }
        if(right != null && node.value < value) {
            result = getCurrPath(right, road, value, "r", index+1);
            if(result[0] != null) {
                return result;
            }
        }
        return new String[capacity];
    }

    @Override
    public int max() {
        if(root == null) {
            return 0;
        }
        return findMax(root);
    }

    private int findMax(Node node) {
        if(node.right == null) {
            return node.value;
        }
        return findMax(node.right);
    }

    @Override
    public int min() {
        if(root == null) {
            return 0;
        }
        return findMin(root);
    }

    private int findMin(Node node) {
        if(node.left == null) {
            return node.value;
        }
        return findMin(node.left);
    }
}
