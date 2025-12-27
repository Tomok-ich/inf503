import java.util.Arrays;

public class Tree3 {
    public static void main(String[] args) {
        int[] tree = {7, 1, 8, 11, 4, 2, 5, 6, 3, 9, 13, 12, 14, 10, 17};
        System.out.println(findMin( 0, tree, -1, 0));
        System.out.println(Arrays.toString(findMinRoad( 0, tree, -1, 0)));
    }

    public static char[] findMinRoad(int nodeIndex, int[] tree, int id, int savedMax) {
        char[] road = new char[(int) Math.log(tree.length) + 1];
        int maxId = findMin( nodeIndex, tree, id, savedMax);
        int counter = 0;
        while(maxId > 0) {
            if(maxId % 2 == 0) {
                road[counter] += 'r';
                maxId = (maxId - 2) / 2;
            } else {
                road[counter] += 'l';
                maxId = (maxId - 1) / 2;
            }
            counter++;
        }
        return road;
    }
    public static int findMin(int nodeIndex, int[] tree, int id, int savedMin) {
        if(tree[savedMin] > tree[nodeIndex]) {
            savedMin = nodeIndex;
        }

        int result1 = 0;
        if(2*nodeIndex+1 < tree.length) {
            result1 = findMin( 2*nodeIndex+1, tree, id+1, savedMin);
        }
        int result2 = 0;
        if(2*nodeIndex+2 < tree.length) {
            result2 = findMin( 2*nodeIndex+2, tree, id+1, savedMin);
        }
        if(tree[result1] > tree[savedMin] && tree[result2] > tree[savedMin]) {
            return savedMin;
        }
        return tree[result1] < tree[result2] ? result1 : result2;

    }
}