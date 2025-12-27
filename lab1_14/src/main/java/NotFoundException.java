public class NotFoundException extends Exception {

    private int value;

    public NotFoundExeption(String Message, int value) {
        super(Message);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
