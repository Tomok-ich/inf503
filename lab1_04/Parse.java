public class Parse{
	public static void main(String[] args){
		String color = "7374274";
		int num = 0;
		int ten = 1;
		for (int i = color.length() - 1; i >= 0; --i){
			num += ten*((int)color.charAt(i) - 48);
			ten *= 10;
		}
		System.out.println(num);
	}
}