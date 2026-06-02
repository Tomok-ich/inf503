package src.serialization;

import java.io.*;

/**
 * 1. Проинициализировать "игру"
 * 2. Сохранить игру
 * 3. Восстановить игру
 */
public class MainSaveLoadGame {

    public static void main(String[] args) throws Exception {
        // 1 ---------------------------------------------
        Game game = new Game(10., 20., 5, 9);

        // 2 ---------------------------------------------
        byte[] savedGame;
        // Объект, который превращает массив байт в выходной поток
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        // Класс, трансформирующий объект в оперативной памяти в выходной поток
        ObjectOutputStream os = new ObjectOutputStream(bos);
        // пишем объект game в выходной поток
        os.writeObject(game);
        // Массив байт, содержащий "слепок" объекта
        savedGame = bos.toByteArray();
        // сохраним в файл
        FileOutputStream fos = new FileOutputStream("game.sav");
        fos.write(savedGame);
        fos.flush();
        fos.close();

        // 3 -------------------------------------------

        FileInputStream fis = new FileInputStream("game.sav");

        ObjectInputStream is = new ObjectInputStream(fis);

        Game loadedGame = (Game)is.readObject();
        fis.close();

        System.out.println(loadedGame);

    }
}
