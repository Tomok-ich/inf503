import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
// 1. считывание из файла
// 2. преобразование строки в число
// 3. вывод картинки потрехмерному массиву
public class Color{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("kow.rgb"));
		int [][][] img = new int[74][80][3];
		String rectangle = "\u2588";
		for (int i = 0; i < 74; ++i){
			for (int j = 0; j < 80; ++j){
				for (int k = 0; k < 3; k++){
					String color = scanner.next();
					int num = 0;
					int ten = 1;
					for (int m = color.length() - 1; m >= 0; --m){
						num += ten*((int)color.charAt(m) - 48);
						ten *= 10;
					}
					img[i][j][k] = num;
				}
			}
		}
		scanner.close();
		for (int i = 0; i < 74; ++i){
			for (int j = 0; j < 80; ++j){
				System.out.print("\033[38;2;" + img[i][j][0] +
					";" + img[i][j][1] + ";" + img[i][j][2] + "m" + rectangle + rectangle);

			}
			System.out.println();
		}


	}
}