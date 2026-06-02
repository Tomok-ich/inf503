public class Sortirivka{ 
	public static void main(String[] args){
		String a[] = {"балаклава", "алфавит", "грезы", "прохор", "ёлочка"};
		String rus_alf = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
		boolean flag = true;
		while (flag){
			flag = false;
			for (int i = 0; i < a.length - 1; ++i){
				int j = 0;
				while (a[i].charAt(j) == a[i + 1].charAt(j)){
					if (j == a[i].length() - 1){
						break;
					}
					++j;
				}
				if (rus_alf.indexOf(a[i].charAt(j)) == -1){
					if (a[i+1].charAt(j) < a[i].charAt(j)){
						String temp = a[i];
						a[i] = a[i + 1];
						a[i + 1] = temp;
						flag = true;
					}
				}
				else {
					if (rus_alf.indexOf(a[i + 1].charAt(j)) < rus_alf.indexOf(a[i].charAt(j))){
						String temp = a[i];
						a[i] = a[i + 1];
						a[i + 1] = temp;
						flag = true;
					}
				}
			}
		}
		for (int i = 0; i < a.length; ++i){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}