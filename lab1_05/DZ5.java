public class DZ5{
	 public static long factorial(int n) {
        if (n < 0) {
            return -1; // ошибка для отрицательных чисел
        }
        
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
     public static void main(String[] args){
    	System.out.println("Факториал числа x:" + factorial(3));
    }
}