import java.util.Scanner;
import java.util.Arrays;

public class Tree1 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        int[] tree = {7, 1, 8, 11, 4, 2, 5, 6, 3, 9, 13, 12, 14, 10, 17};


        System.out.println();
        System.out.println(Arrays.toString(findElement(12, 0, tree, new String[(int) Math.log(tree.length) + 1], -1, "-1")));
    }


    public static String[] findElement(int x, int nodeIndex, int[] tree, String[] road, int id, String curr) {
        if(curr != "-1") {
            road[id] = curr;
        }
        if(x == tree[nodeIndex]) {
            return road;
        }


        String[] result;
        if(2*nodeIndex+1 < tree.length) {
            result = findElement(x, 2*nodeIndex+1, tree, road, id+1, "l");


            if(result[0] != null) {

                return result;
            }

        }
        if(2*nodeIndex+2 < tree.length) {
            result = findElement(x, 2*nodeIndex+2, tree, road, id+1, "r");

            if(result[0] != null) {
                return result;
            }

        }
        return new String[(int) Math.log(tree.length) + 1];

    }


}