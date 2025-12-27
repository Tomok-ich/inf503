public class TestFunc1{
	public static void main(String[] args){
		int max = max(5, 6);

		System.out.println(max);

		int[] arr = {1, 2, 3, 4};
		int[] r = revers(arr);

		for (int n : r){
			System.out.println(n);
		}

		replace(arr,  3, -3);
		for (int n : arr){
			System.out.println(n);
		}
	}

	public static int max(int a, int b){
		return a > b ? a : b;
	}
	public static int[] revers(int[] arr){
		int [] result = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--){
			result[(arr.length - 1) - i] = arr[i];
		}
		return result;
	}
	public static void replace(int[] arr, int position, int element){
		arr[position] = element;
	}
}