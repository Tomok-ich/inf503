import java.util.Scanner;
public class TestArray1{
	public static void main(String[] args){
/*
		int a[] = new int[5]; // выделение памяти
		a[0] = 1;
		a[1] = 2;
		int b[] = new int[]{1, 2, 3, 4};
		int c[] = {1, 2, 3, 4};
		for (int i = 0; i < b.length; ++i) {
			System.out.println(c[i]);
		}
*/
/* 1
		double g[] = {1, 5, 0, 3};
		double temp = 0;
		for (int i = 0; i < g.length; ++i){
			if (g[i] > temp){
				temp = g[i];
			}
			else{
				temp = temp;
			}
		}
		System.out.println(temp);

*/
/* 2
		double g[] = {1, 5, 0, 3};
		double temp = 99999;
		for (int i = 0; i < g.length; ++i){
			if (g[i] < temp){
				temp = g[i];
			}
			else{
				temp = temp;
			}
		}
		System.out.println(temp);		
*/
/* 3
		double g[] = {1, 5, 0, 3};
		double temp = 0;
		for (int i = 0; i < g.length; ++i){
			temp = temp + g[i];
		}
		System.out.println(temp);
*/
/* 4
		double g[] = {1, 5, 0, 3};
		double temp = 0;
		//альтернатива for (double x : g){
		//	temp += g[i];
		}
		for (int i = 0; i < g.length; ++i){
			temp = temp + g[i];
		}
		System.out.println(temp/g.length);
*/ 
/* 5
		long g[] = {1, 5, 8, 3};
		long temp = 1;
		for (int i = 0; i < g.length; ++i){
			temp = temp * g[i];
		}
		System.out.println(temp);
*/
/* 6
		double g[] = {3.5, -2, 67, -89};
		double temp1 = 0;
		double temp2 = 0;
		for (int i = 0; i < g.length; ++i){
			if (i % 2 == 0){
				temp1 = temp1 + g[i];
			}
			else{
				temp2 += g[i];
			}
		}
		System.out.println(temp1 - temp2);	
*/
/* 7
		double a[] = {1, 6.7, 98};
		double b[] = {2, 8.3, 12};
		double[] c = new double[a.length + b.length];
		for (int i = 0; i < a.length; ++i) {
			c[i] = a[i];
		}
		System.out.print("[");
		for (int i = a.length; i < a.length + b.length; ++i) {
			c[i] = b[i - a.length];
		}
		for (int i = 0; i < c.length; ++i) {
			System.out.print(c[i] + ", ");
		}
		System.out.println("]");
*/
/* 8
		int[] numbs = {23, 54, 7, 4, -10, 89, 86};
		int[] res = new int[numbs.length / 3];
		for (int i = 0; i < res.length; ++i) {
			res[i] = numbs[3*i + 2];
		}
		for (int i = 0; i < res.length; ++i) {
			System.out.println(res[i]);
		}
*/
/* 9
		int[] a = {2, 3, 1, 4};
		int max = a[0];
		for (int i = 0; i < a.length; ++i) {
			max = a[i] > max ? a[i] : max; // тернарный оператор
		}
		for (int y = 1; y <= max; ++y) {
			for (int i = 0; i < a.length; ++i) {
				if(a[i] >= y) {
					System.out.print("x");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println(" ");
		}
*/
/* 10
		Scanner hit = new Scanner(System.in);
		int a[] = {1, 5, 3, 0, 8};
			
		System.out.println("Наличие какой цифры вы хотите проверить?");
		int c = hit.nextInt();
		boolean hi = true; 
		for (int i = 0; i < a.length; ++i){
			if (a[i] == c) {
				System.out.println("Число найдено");
				hi = false;
				break;
			}
		}
		if (hi){
			System.out.println("Число не найдено");
		}
*/
/*
		int a[] = {1, 2 ,3, 4, 5};
		int b[] = {1, 5, 3, 4, 8};
		int count = 0
		if (a.length != b.length) {
			System.out.println("Различные");
			return;
		}

		for (int i = 0; i < a.length; ++i) {
			if (a[i] != b[i]){
				System.out.println("Различные");
			return;
			}
		}
		
*/
/* 13
		int a[] = {1, 4, 5};
		int b[] = {3, 6, 2};
		int skproizv = 0;
		for (int i = 0; i < a.length; ++i){
			skproizv += a[i] * b[i];
		}
		System.out.println(skproizv);
*/
/* 12
		int a[] = {1, 4, 5, 2, 0};
		int b[] = {1, 6, 2, 10, 0};
		int hi = 0;
		for (int i = 0; i < a.length; ++i){
			for (int j = 0; j < b.length; ++j){
				if (a[i] == b[j]){
					System.out.println("Эквивалентны по цифре: " + a[i]);
					++hi;
					break;
				}
				else{
					hi = hi;
				}
			}

			if (hi == 0){
				System.out.println("Различны по цифре: " + a[i]);

			}
			else {
				hi = 0;
			}
		}
		for (int i = 0; i < b.length; ++i){
			for (int j = 0; j < a.length; ++j){
				if (b[i] == a[j]){
					++hi;
				}
				else{
					hi = hi;
				}
			}
		
			if (hi == 0){
				System.out.println("Различны по цифре: " + b[i]);

			}
			else {
				hi = 0;
			}
		}
*/
/* 14
		int [][] a = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		int [][] b = {
			{10,11,12},
			{4,5,6},
			{7,8,9}
		};
		if (a.length == b.length && a[0].length == b[0].length){
			for (int i = 0; i < a.length; ++i){
				for (int j = 0; j < a[i].length; ++j){
					System.out.print(a[i][j] + b[i][j] +", ");

				}
				System.out.println("");
			}
		}
*/
/*  15
		int [][] a = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		int [][] b = {{10,11,12},{4,5,6},{7,8,9}};
		if (a.length == b[0].length){
			for (int k = 0; k < b[k].length; ++k){
				int summn = 0;
				for (int i = 0; i < a.length; ++i){
					for (int j = 0; j < a[i].length; ++j){
						int pro = a[k][j] * b[j][i];
						summn += pro;
					}
					System.out.print(summn + ", ");
					summn = 0;
				}
				System.out.println("");
			}
		}		
*/
	}
}