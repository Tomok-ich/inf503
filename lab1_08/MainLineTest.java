public class MainLineTest{
	public static void main(String[] args){
		Line line = new Line();

		/*

			Инициализируем внутреннюю структуру с помощью переменных

		*/
		Point start = new Point();
		start.x = 1;
		start.y = 2;

		Point end = new Point();
		end.x = 5;
		end.y = 7;

		line.start = start;
		line.end = end;

		System.out.println(line);
	}
}