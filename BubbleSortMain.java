package codeWithMosh;

import java.util.Arrays;

public class BubbleSortMain {

    public static void main(String[] args) {
        int[] numbers = {9, 3, 1, 7, 5, 6, 2};
        var sorter = new BubbleSort();
        sorter.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
