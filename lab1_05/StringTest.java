public class StringTest{
	public static void main(String[] args){
		String s = "ЛАбораторная работа 5 5";
		String b = s;
		s = "ghost";

		System.out.println(b);

		System.out.println("ДЛина строки:" + s.length());
		System.out.println("2 символ" + s.charAt(1));

		String copyS = s + "";

		s = s.replace("5", "6");

		System.out.println(s);

		System.out.println("строки равны?" + (s.equals(copyS)));


	}
}