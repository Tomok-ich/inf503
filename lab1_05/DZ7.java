public class DZ7{
	// Рекурсивная функция для вычисления суммы
    public static double recursSum(double[] array, int index) {
        if (index == array.length) {
            return 0;
        }
        return array[index] + recursSum(array, index + 1);
    }
    
    // Функция для вычисления среднего через рекурсию
    public static double recursSred(double[] array) {
        if (array.length == 0) {
            return 0;
        }
        return recursSum(array, 0) / array.length;
    }
    public static void main(String[] args){
    	double[] avgArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        System.out.println("Среднее массива: " + recursSred(avgArray));
    }
}