package samtask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String message = "To look good, choose to go out to a cool zoo on a hot afternoon, or look into a good book too.";
        System.out.println(searchO(message));

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Твое имя: " + name);
    }

    public static int searchO(String message) {
        int result = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == 'o' || message.charAt(i) == 'O') {
                result += 1;
            }
        }
        return result;
    }
}
