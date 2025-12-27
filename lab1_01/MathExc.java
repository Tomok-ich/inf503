public class MathExc{
	public static void main(String[] args){
// Task 2
		int b1 = 10, c1 = 20, ind = 2, b2 = 5, big = 20;


		//int h1 = (b1 + c1) % ((++b2 / b1++));
		boolean h2 = (b1 < c1) && (b2 == -99) || (ind >= 0);
		int h3 = (b1 | c1) & (big ^ b1);

		System.out.println("Task 2");
		System.out.println("1)" + "ошибка деления на ноль");
        System.out.println("2)" + h2);
		System.out.println("3)" + h3);

// Task 3
        double x = -2.0; // x = 2
        double precision = 0.00001;
        
        // Вычисление e^x
        double result = 1.0; // Начальное значение (n=0)
        double term = 1.0;
        int n = 1;
        
        // Вычисляем первый член для n=1
        term = term * x / n;
        
        // Суммируем члены ряда, пока они значимы
        while (true) {
            // Проверяем, не стал ли член слишком маленьким
            if (term >= 0) {
                if (term < precision) break;
            } else {
                if (-term < precision) break;
            }
            
            result += term;
            n++;
            term = term * x / n;
        }
        System.out.println("Task 3");
        System.out.println("e^" + x + " = " + result);
	}
}