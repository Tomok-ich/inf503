public class TestMapper {

    public static void main(String[] args) {

        Game game = new Game("Gamer");
        JSONMapper mapper = new JSONMapper();
        String json = mapper.writeObject(game);
        System.out.println(json);
    }
}