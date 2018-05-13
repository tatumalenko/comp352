
// -----------------------------------------------------
// Assignment 1 - COMP 352
// Written by: Tatum Alenko (40055122)
// Description:  This class implements a basic Insertion Sort algorithm using a 
// proper 'slide' shift technique (as opposed to the ubiquitous 
// 'shifting' implementation.
// -----------------------------------------------------

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

/**
 * Names and IDs Tatum Alenko (40055122) <br>
 * Course COMP352 <br>
 * Assignment #1 <br>
 * Due Date May 15, 2018 <br>
 * This class implements a basic Insertion Sort algorithm using a proper 'slide'
 * shift technique (as opposed to the ubiquitous 'shifting' implementation.
 */
public class ISort {
    public static void main(String[] args) {
        boolean debugFlagOn = false;
        ArrayList<String> list = new ArrayList<>(Arrays.asList(args));
        if (list.contains("debug")) {
            list.remove("debug");
            debugFlagOn = true;
        }
        int[] nums = Arrays.stream(list.toArray(new String[0])).mapToInt(Integer::parseInt).toArray();
        insertionSort(nums, debugFlagOn);
        long startTime = System.nanoTime(); // record the starting time
        insertionSort(nums, false);
        long endTime = System.nanoTime(); // record the ending time
        long elapsed = endTime - startTime; // compute the elapsed time
        System.out.println(IntStream.of(nums).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(" ")));
        System.out.println("completed in " + elapsed + "ns");
    }

    public static void insertionSort(int[] nums, boolean debug) {
        if (debug)
            debugPrint(nums, 0, -1);
        for (int i = 1; i < nums.length; i++) {
            int slideIndex = i;

            while (slideIndex >= -1) {
                if (debug && i != slideIndex)
                    debugPrint(nums, i, slideIndex);

                if (slideIndex > 0 && nums[i] < nums[slideIndex - 1]) {
                    slideIndex--;
                } else if (slideIndex == 0) {
                    if (debug && i != slideIndex)
                        debugPrint(nums, i, slideIndex);
                    break;
                } else if (slideIndex == -1) {
                    break;
                } else if (slideIndex > 0 && nums[i] >= nums[slideIndex - 1]) {
                    if (debug && i != slideIndex)
                        debugPrint(nums, i, slideIndex - 1);
                    break;
                }
                if (slideIndex == 0) {
                    if (debug && i != slideIndex)
                        debugPrint(nums, i, slideIndex);
                    slideIndex--;
                }
            }
            slide(nums, i, slideIndex < 0 ? 0 : slideIndex);
        }
    }

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int slideIndex = i;
            while (slideIndex > 0 && nums[i] < nums[slideIndex - 1])
                slideIndex--;
            slide(nums, i, slideIndex < 0 ? 0 : slideIndex);
        }
    }

    public static void slide(int[] nums, int curIndex, int desIndex) {
        int temp = nums[curIndex];
        for (int i = curIndex; i > desIndex && i > 0; i--)
            nums[i] = nums[i - 1];
        nums[desIndex] = temp;
    }

    public static void insertionSort2(int[] nums) {
        int j, temp;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];
            for (j = i; j > 0 && nums[i] < nums[j - 1]; j--)
                nums[j] = nums[j - 1];

            nums[j] = temp;
        }
    }

    public static void debugPrint(int[] nums, int i, int j) {
        String[] str = new String[nums.length + 1];
        for (int k = 0; k < nums.length; k++) {
            if (k == i && k == j) {
                str[k] = "[" + nums[k] + "]";
            } else if (k == i) {
                str[k] = "[" + nums[k] + "]";
            } else if (k == j) {
                str[k] = "i" + nums[k] + "i";
            } else {
                str[k] = Integer.toString(nums[k]);
            }
        }
        if (j == -1) {
            str[nums.length] = "|";
        } else if (nums[i] == nums[j]) {
            str[nums.length] = "=";
        } else if (nums[i] > nums[j]) {
            str[nums.length] = ">";
        } else if (nums[i] < nums[j]) {
            str[nums.length] = "<";
        }
        System.out.println(String.join(" ", str));
    }
}