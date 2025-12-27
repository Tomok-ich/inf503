public class DZ4{
	public static double exp(double x) {
        double result = 1.0;
        double term = 1.0;
        
        for (int n = 1; n < 100; n++) { // 100 итераций для точности
            term = term * x / n;
            result = result + term;
        }
        
        return result;
    }
     public static void main(String[] args){
    	System.out.println("Экспонента в степени x:" + exp(5));
    }
}