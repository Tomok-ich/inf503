public class TestWhile {
	public static void main(String arguments[]) {
		short a = 0;
		while (true) {
			
			if (++a < 1000) return;
			System.out.println(a);
		}
		//System.out.println("Цикл завершен");
	}
}
		