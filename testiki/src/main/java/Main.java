class Box {
    int value;
}

public class Main {
    public static void process(Box a, Box b) {
        a.value = 10;
        b = a;
        b.value = 20;
        b = new Box();
        b.value = 30;
    }
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();

        box1.value = 1;
        box2.value = 2;

        process(box1, box2);

        System.out.println(box1.value);
        System.out.println(box2.value);
    }
}
