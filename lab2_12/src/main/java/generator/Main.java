package generator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GeneratorState state = new GeneratorState();

        Thread generatorThread = new Thread(new NumberGeneratorTask(state));
        generatorThread.start();

        System.out.println("Генератор запущен. Доступные команды: get, max, stop");

        while (true) {
            String command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("get")) {
                System.out.println("Текущее число: " + state.getCurrentValue());
            }

            else if (command.equalsIgnoreCase("max")) {
                System.out.print("Введите новое максимальное значение: ");
                String numberInput = scanner.nextLine().trim();

                try {
                    int newMax = Integer.parseInt(numberInput);
                    if (newMax < 0) {
                        System.out.println("Ошибка: число не может быть отрицательным.");
                        continue;
                    }
                    state.setMax(newMax);
                    System.out.println("Максимальное значение успешно изменено на: " + newMax);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: вы ввели не число!");
                }
            }

            else if (command.equalsIgnoreCase("stop")) {
                generatorThread.interrupt();
                System.out.println("Программа завершена.");
                break;
            }

            else {
                System.out.println("Неизвестная команда. Доступны только: get, max, stop");
            }
        }
        scanner.close();
    }
}
