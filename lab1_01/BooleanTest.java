public class BooleanTest {
	public static void main(String arguments[]){
		boolean varBool1 = true;
		boolean varBool2 = true;




		System.out.println("|var1|var2| &  |  | |  ^ |  ! |");
		System.out.println("-------------------------------");
		System.out.println("|" + varBool1 + "|" + "|" + varBool1 + "|" + "|" + (varBool1 & varBool1) + "|" + "|" + (varBool1 | varBool1) + "|" + "|" + (varBool1 ^ varBool1) + "|" + "|" + (!varBool1) + "|");
		System.out.println("-------------------------------");
		varBool1 = true;
		varBool2 = false;
		System.out.println("|" + varBool1 + "|" + "|" + varBool2 + "|" + "|" + (varBool1 & varBool2) + "|" + "|" + (varBool1 | varBool2) + "|" + "|" + (varBool1 ^ varBool2) + "|" + "|" + (!varBool1) + "|");
		System.out.println("-------------------------------");
		varBool2 = false;
		varBool1 = true;
		System.out.println("|" + varBool2 + "|" + "|" + varBool1 + "|" + "|" + (varBool2 & varBool1) + "|" + "|" + (varBool2 | varBool1) + "|" + "|" + (varBool2 ^ varBool1) + "|" + "|" + (!varBool2) + "|");
		System.out.println("-------------------------------");
		varBool1 = false;
		varBool2 = false;
		System.out.println("|" + varBool1 + "|" + "|" + varBool2 + "|" + "|" + (varBool2 & varBool2) + "|" + "|" + (varBool2 | varBool2) + "|" + "|" + (varBool2 ^ varBool2) + "|" + "|" + (!varBool2) + "|");
		System.out.println("-------------------------------");
	}
}