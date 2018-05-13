
// -----------------------------------------------------
// Assignment 
// Written by: Tatum Alenko (40055122)
// Description: This class contains constructors, get/set methods, toString, 
// equals and clone methods overrides.
// -----------------------------------------------------

import java.util.Arrays;
import java.util.stream.IntStream;
// import java.util.stream.IntegerStream;
import java.util.Collections;
import java.util.Random;

/**
 * Names and IDs Tatum Alenko (40055122) <br>
 * Course COMP249 <br>
 * Assignment # <br>
 * Due Date <br>
 * This class describes...
 */
public class Test {
    public static void main(String[] args) {
        int[] ns = IntStream.iterate(10, n -> n + 10).limit(100).toArray();

        // int[] nums = { 47, 39, 86, 1, 93, 20, 63, 73, 15, 2 };
        // ISort.insertionSort(nums);
        // System.out.println(Arrays.toString(nums));

        // System.out.println(Arrays.toString(ns));

        for (int n : ns) {
            // RANDOM CASE (don't sort later)
            int[] nums = IntStream.generate(() -> new Random().nextInt(100) + 0).limit(n).toArray();

            Integer[] nums3 = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++)
                nums3[i] = nums[i];

            // WORST CASE
            // Arrays.sort(nums3, Collections.reverseOrder());
            // BEST CASE
            // Arrays.sort(nums3);

            int[] nums2 = Arrays.stream(nums3).mapToInt(Integer::intValue).toArray();

            // System.out.println(Arrays.toString(nums2));

            long startTime = System.nanoTime(); // record the starting time
            ISort.insertionSort(nums2);
            long endTime = System.nanoTime(); // record the ending time
            long elapsed = endTime - startTime; // compute the elapsed time
            System.out.println(elapsed);
            // System.exit(0);
        }
    }
}