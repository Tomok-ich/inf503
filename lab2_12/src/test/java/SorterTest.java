import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SorterTest {

    @Test
    void testNormalArray() {
        int[] arr = {5, 2, 8, 1, 9, 3};
        Sorter.quickSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8, 9}, arr);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        Sorter.quickSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        Sorter.quickSort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        Sorter.quickSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        Sorter.quickSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {3, 1, 3, 2, 1};
        Sorter.quickSort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr);
    }

    @Test
    void testWithNegatives() {
        int[] arr = {-3, 5, -1, 0, -7};
        Sorter.quickSort(arr);
        assertArrayEquals(new int[]{-7, -3, -1, 0, 5}, arr);
    }
}
