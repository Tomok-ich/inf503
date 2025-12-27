import java.util.Scanner;
// char - '' String - "" // программы содержат тех информацию которая не имеет отношения к исполнению программы
public class Labirint{
	public static void main(String[] args) {// точка входа (с этого места начинает исполнятся программа) метод main(?)
	 
	 String [][] lab = {
	 	{"1","1","1","0","1","1","1"},
	 	{"1","1","1","0","0","0","1"},
	 	{"1","1","1","1","1","0","0"},
	 	{"1","1","1","1","0","0","0"},
	 	{"1","1","1","0","0","1","1"},
	 	{"1","0","0","0","1","1","1"},
	 	{"1","0","1","1","1","1","1"}
	 };
	 String [][] slab =  {
	 	{"?","?","?","x","?","?","?"},
	 	{"?","?","?","?","?","?","?"},
	 	{"?","?","?","?","?","?","?"},
	 	{"?","?","?","?","?","?","?"},
	 	{"?","?","?","?","?","?","?"},
	 	{"?","?","?","?","?","?","?"},
	 	{"?","?","?","?","?","?","?"}
	 };

	 for (int i = 0; i < slab.length; ++i){
	 	System.out.print("[");
	 	for (int j = 0; j < slab[i].length; ++j){
	 		System.out.print(slab[i][j] + ",");
	 	}
	 	System.out.println("]");
	 }

	 Scanner in = new Scanner(System.in);
	 boolean exitFlag = false;
	 String pos = "x";
	 int i = 0;
	 int j = 3;
	 while (!exitFlag){
	 	
	 	System.out.println("Выберите одну из следующих команд для передвижения: u, d, r, l");
		String c = in.next();
	 	switch (c) {
			case "U": 
			case "u": System.out.println("Up"); slab[i][j] = lab[i][j]; slab[--i][j] = pos; --i; break; // : - выполни действие если правда
			case "D":
			case "d": System.out.println("Down");slab[i][j] = lab[i][j]; slab[++i][j] = pos; ++i; break;
			case "R":
			case "r": System.out.println("Right");slab[i][j] = lab[i][j]; slab[i][++j] = pos; ++j; break;	
			case "L":
			case "l": System.out.println("Left");slab[i][j] = lab[i][j]; slab[i][--j] = pos; --j; break;
			case "X":
			case "x": exitFlag = true; break;
			default: System.out.println("No");break;
			}

		for (int k = 0; k < slab.length; ++k){
 		System.out.print("[");
 			for (int l = 0; l < slab[i].length; ++l){
 				System.out.print(slab[k][l] + ",");
 				}
 		System.out.println("]");
 		}
     }

	}
}