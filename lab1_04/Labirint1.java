import java.util.Scanner;

public class Labirint1 {
    public static void main(String[] args) {
        String[][] lab = {
            {"1","1","1","0","1","1","1"},
            {"1","1","1","0","0","0","1"},
            {"1","1","1","1","1","0","0"},
            {"1","1","1","1","0","0","0"},
            {"1","1","1","0","0","1","1"},
            {"1","0","0","0","1","1","1"},
            {"1","0","1","1","1","1","1"}
        };
        
        String[][] slab = {
            {"?","?","?","x","?","?","?"},
            {"?","?","?","?","?","?","?"},
            {"?","?","?","?","?","?","?"},
            {"?","?","?","?","?","?","?"},
            {"?","?","?","?","?","?","?"},
            {"?","?","?","?","?","?","?"},
            {"?","?","?","?","?","?","?"}
        };

        int i = 0;
        int j = 3;
        boolean exitFlag = false;
        Scanner in = new Scanner(System.in);

        while (!exitFlag) {
            // Отображение лабиринта
            for (int k = 0; k < slab.length; k++) {
                System.out.print("[");
                for (int l = 0; l < slab[k].length; l++) {
                    System.out.print(slab[k][l] + ",");
                }
                System.out.println("]");
            }

            System.out.println("Выберите команду (u/d/r/l/x): ");
            String c = in.next();
            
            int newI = i;
            int newJ = j;

            switch (c.toLowerCase()) {
                case "u": newI--; break;
                case "d": newI++; break;
                case "r": newJ++; break;
                case "l": newJ--; break;
                case "x": exitFlag = true; break;
                default: System.out.println("Неверная команда!");
            }

            if (exitFlag) break;

            // Проверка границ
            if (newI >= 0 && newI < lab.length && newJ >= 0 && newJ < lab[0].length) {
                // Всегда открываем клетку, на которую пытаемся перейти
                slab[newI][newJ] = lab[newI][newJ];
                
                if (lab[newI][newJ].equals("0")) {
                    // Перемещаем игрока только если клетка проходима
                    slab[i][j] = "0";
                    i = newI;
                    j = newJ;
                    slab[i][j] = "x";
                    
                    // Проверка на выход
                    if (i == 6 && (j == 1)) {
                        System.out.println("Поздравляем! Вы нашли выход!");
                        exitFlag = true;
                    }
                } else {
                    System.out.println("Стенка! Нельзя пройти.");
                }
            } else {
                System.out.println("Движение за границы лабиринта!");
            }
        }
        in.close();
    }
}