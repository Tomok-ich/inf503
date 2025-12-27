public class DZ6{
	 // Сравнение двух чисел
    public static int compare(int a, int b) {
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        } else {
            return 0;
        }
    }
    
    // Обмен элементов в массиве
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    // Сортировка пузырьком
    public static int[] sort(int[] array) {
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(array[j], array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }
    public static void main(String[] args){
        int [] a = {1, -2, 9, 54, 13};
        sort(a);
        System.out.println("Отсортированный массив: " + java.util.Arrays.toString(a));
    }
}