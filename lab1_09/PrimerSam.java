public class PrimerSam{
	public static void main(String[] args){
		int [][] arr = {
			{1,2,3}, //2
			{4,5,6,7}, //5.5
			{0,2} // 1
		};
		System.out.println(maxInAvg(arr));
	}
	static double avg(int[] a){
		double summ = 0;
		int n = a.length;
		for (int i = 0; i < n; ++i){
			summ += a[i];
		}
		return summ/n;
	}

	static double maxInAvg(int[][] arr){
		double max = avg(arr[0]);
		for (int i = 1; i < arr.length; ++i){
			double avgArr = avg(arr[i]);
			if (max < avgArr){
				max = avgArr;
			}
		}
		return max;
	}
}