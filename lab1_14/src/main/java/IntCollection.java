public interface IntCollection {
    void add(int value);
    int size();
    String[] getPath(int value) throws NotFoundExeption, EmptyTreeExeption;
    int max() throws EmptyTreeExeption;
    int min() throws EmptyTreeExeption;

}
