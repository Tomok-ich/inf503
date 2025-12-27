import java.util.Scanner;
// char - '' String - "" // программы содержат тех информацию которая не имеет отношения к исполнению программы
public class TestSwitch{
	public static void main(String[] args) {// точка входа (с этого места начинает исполнятся программа) метод main(?)
	 Scanner in = new Scanner(System.in);

	 boolean exitFlag = false;
	 while (!exitFlag){
	 	System.out.println("Выберите одну из следующих команд для передвижения: u, d, r, l");
		String c = in.next();

		switch (c) {
			case "U": 
			case "u": System.out.println("Up");break; // : - выполни действие если правда
			case "D":
			case "d": System.out.println("Down");break;
			case "R":
			case "r": System.out.println("Right");break;
			case "L":
			case "l": System.out.println("Left");break;
			case "X":
			case "x": exitFlag = true; break;
			default: System.out.println("No");break;
		}
	}
	}
}