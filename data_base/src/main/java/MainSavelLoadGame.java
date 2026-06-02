import java.io.*;

public class MainSavelLoadGame {
    public static void main(String[] args) {
        // Инциализация
        Game game = new Game(10.,20.,5,9);

        byte[] savedGame;
        // Объект который превращает массив байт в выходной поток
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        // Класс трансформирующий объект в оперативной памяти в выходной поток
        try {
            ObjectOutputStream os = new ObjectOutputStream(bos);
            // пишем объект game
            os.writeObject(game);

            savedGame = bos.toByteArray();
            FileOutputStream fos = new FileOutputStream("game.sav");
            fos.write(savedGame);
            fos.flush();
            fos.close();

            // Прочитать файл

            FileInputStream fis = new FileInputStream("game.sav");

            ObjectInputStream is = new ObjectInputStream(fis);

            Game loadedGame = (Game) is.readObject();

            fis.close();
            System.out.println(loadedGame);


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
