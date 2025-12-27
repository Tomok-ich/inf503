public class FillArr {
	public static void fill(char[] arr) {
		arr[0] = 'l';
		arr[1] = 'r';
		arr[2] = 'l';
	}
	public static void main(String[] args) {
		char [] route = new char[4];

		fill(route);

		for (int i = 0; i < route.length; ++i){
			System.out.println(route[i]);
		}

		String h = "a";
		System.out.println(h.charAt(0));
	}
}