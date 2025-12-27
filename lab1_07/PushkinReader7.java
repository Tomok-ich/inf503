import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PushkinReader7 {
    public static void main(String[] args) throws FileNotFoundException {
        Pattern pattern1 = Pattern.compile("(поэт)");
        Scanner sc = new Scanner(new File("pushkin.txt"));
        int counter = 1;
        int currentMatches = 0;
        int breaker = 5;
        while(sc.hasNext()) {
            String line = sc.nextLine();
            if(pattern1.matcher(line).find()) {
                System.out.printf("%s - %s\n", line, counter);
                currentMatches += 1;
            }
            if(currentMatches == breaker) {
                break;
            }

            counter+=1;
        }

        sc.close();
    }
}