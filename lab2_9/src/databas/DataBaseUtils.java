package src.databas;

import java.io.*;

public class DataBaseUtils {
    private static final String FILE_NAME = "many.tbl";
    public void save(Many many) throws IOException {

        // используем вариант try с ресурсами, который
        // обеспечит автоматическое закрытие перечисленных ресурсов
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream os = new ObjectOutputStream(bos);
             FileOutputStream fos = new FileOutputStream(FILE_NAME, true);
             DataOutputStream dos = new DataOutputStream(fos)
        ) {
            // Сериализуем объект в ByteArrayOutputStream
            os.writeObject(many);
            // из ByteArrayOutputStream извлекаем массив, содержащий объект many
            byte[] array = bos.toByteArray();

            // пишем id записи
            dos.writeInt(many.getId());
            // пишем 1, т.е. запись актуальна (не удалена)
            dos.writeByte(1);
            // пишем размер сериализоанного объекта
            dos.writeInt(array.length);
            // пишем объект в сериализованном виде
            dos.write(array);
        }
    }

    public Many findById(Integer id) throws Exception {
        Many result = null;

        try(DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))){
            while (dis.available() > 0) {
                int n = dis.readInt();
                int flag = dis.readByte();
                int size = dis.readInt();
                if (flag == 1 && n == id) {
                    byte[] buffer = new byte[size];
                    dis.readFully(buffer);
                    ObjectInputStream os = new ObjectInputStream(new ByteArrayInputStream(buffer));
                    result = (Many) os.readObject();
                    break;
                } else {
                    dis.skipBytes(size);
                }
            }
        }
        return result;
    }

    public void deleteById(Integer id) throws Exception {
        // Храним позицию в которой находится нужная запись
        int position = 0;
        // Флаг, показывающий нашли или нет нужную запись
        boolean find = false;

        try(DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))){
            while (dis.available() > 0) {
                int n = dis.readInt();
                int flag = dis.readByte();
                int size = dis.readInt();
                if (flag == 1 && n == id) {
                    find = true;
                    break;
                } else {
                    dis.skipBytes(size);
                }
                position += 4 + 1 + 4 + size;
            }
        }

        if (find) {
            // RandomAccessFile - класс для чтения/записи файла в определенной позиции
            try (RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "rw")) {
                long offset = position + 4; // Позиция, где нужно изменить байт
                raf.seek(offset); // Перемещаемся на нужную позицию
                raf.writeByte(0); // Записываем байт со значением 0
            }
        }
    }
}
