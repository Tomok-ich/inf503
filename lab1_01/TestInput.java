import java.util.Scanner;
// char - '' String - ""
public class TestInput{
	public static void main(String[] args) {
	 Scanner in = new Scanner(System.in);

	 
	 while (true){
	 	System.out.println("Выберите одну из следующих команд для передвижения: u, d, r, l");
		String c = in.next();
		// equals пишется чтобы сравнивать именно значения, а не ссылки на место в памяти у ссылочного типа данных(string)
		if (c.equals("u") || c.equals("U")){
			System.out.println("Движемся вверх");
		}
		else if (c.equals("d") || c.equals("D")){
			System.out.println("Движемся вниз");
		}
		else if (c.equals("r") || c.equals("R")){
			System.out.println("Движемся вправо");
		}
		else if (c.equals("l") || c.equals("L")){
			System.out.println("Движемся влево");
		}
		else if (c.equals("x") || c.equals("X")){
			System.out.println("Вы вышли из команд");
			break;
		}
		else {
			System.out.println("Такого направления не существует");
		}

		}
	}
}