package JavaAlgo.src.main.java.datastructure.recursion.text;

import JavaAlgo.src.main.java.datastructure.recursion.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestE03BinarySearch {

    @Test
    @DisplayName("测试递归二分查找")
    public void test1() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        Assertions.assertEquals(0, BinarySearch.search(a, 7));
        Assertions.assertEquals(1, BinarySearch.search(a, 13));
        Assertions.assertEquals(2, BinarySearch.search(a, 21));
        Assertions.assertEquals(3, BinarySearch.search(a, 30));
        Assertions.assertEquals(4, BinarySearch.search(a, 38));
        Assertions.assertEquals(5, BinarySearch.search(a, 44));
        Assertions.assertEquals(6, BinarySearch.search(a, 52));
        Assertions.assertEquals(7, BinarySearch.search(a, 53));

        Assertions.assertEquals(-1, BinarySearch.search(a, 0));
        Assertions.assertEquals(-1, BinarySearch.search(a, 15));
        Assertions.assertEquals(-1, BinarySearch.search(a, 60));
    }
}
