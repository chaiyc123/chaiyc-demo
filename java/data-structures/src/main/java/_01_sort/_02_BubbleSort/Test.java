package _01_sort._02_BubbleSort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        BubbleSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
