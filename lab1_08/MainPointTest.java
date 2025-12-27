public class MainPointTest{
	public static void main(String[] args){
		// опеределяем переменную point типа Point
		// инициализируем её новым обьектом new Point()
		// (экземпляр класса)
		Point point = new Point();

		/*

			инициализируем внутреннюю структуру, используя оператор доступа.
			. как доступ к внутренней структуре класса
		*/
		point.x = 0.5;
		point.y = 1.6;

		System.out.println(point.x + "; " + point.y);

		point.move(-1, 5);

		System.out.println(point.x + "; " + point.y);

	}
}