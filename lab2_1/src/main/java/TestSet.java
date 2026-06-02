public class TestSet {
    public static void main(String[] args) {
        Set503Impl set503impl = new Set503Impl();
        for (int i = 0; i < 10; i++) {
            set503impl.add(i);
        }
        System.out.println(set503impl.size());
        System.out.println(set503impl);

        for(Object i : set503impl.toArray()){
            System.out.println(i);
        }
    }
}
