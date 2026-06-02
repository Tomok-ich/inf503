public class TestMapper {

    public static void main(String[] args) throws Exception {

        Game game = new Game(null);
        JSONMapper mapper = new JSONMapper();
        System.out.println(mapper.writeObject(game));
    }
}