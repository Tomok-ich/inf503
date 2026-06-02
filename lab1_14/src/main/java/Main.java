package src.main.java;

public class Main {
    public static void main(String[] args) throws NotFoundExeption, EmptyTreeExeption {
        BTree bTree = new BTree();
        bTree.add(10);
        bTree.add(6);
        bTree.add(4);
        bTree.add(8);
        bTree.add(5);

        System.out.println(bTree);

        try {
            System.out.println(Arrays.toString(bTree.getPath(10)));
        } catch (EmptyTreeExeption e) {
            System.out.println("Дерево пустое");
        }
        catch (NotFoundExeption e) {
            System.out.println("Число " + e.getValue() + " не найдено в дереве");
        }
        System.out.println("Максимальное число в дереве = " + bTree.max());
        System.out.println("Минимальное число в дереве равно = " + bTree.min());
    }
}
