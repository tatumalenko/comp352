
// -----------------------------------------------------
// Assignment 
// Written by: Tatum Alenko (40055122)
// Description: 
// -----------------------------------------------------

import java.util.*;
import java.util.HashMap;
import java.util.function.Function;

/**
* Names and IDs    Tatum Alenko (40055122)
* <br>
* Course           COMP352
* <br>
* Assignment #     
* <br>
* Due Date         
* <br>
* This class describes...
*/
public class Analysis {
    public static void main(String[] args) {
        // List<Integer> ns = Arrays.asList(50000, 100000, 200000, 400000, 800000, 1600000, 3200000, 6400000, 12800000);
        // printRunTimes("repeat1", runTimes((Integer n) -> repeat1('*', n), ns));
        // printRunTimes("repeat2", runTimes((Integer n) -> repeat2('*', n), ns));
    }

    public static <T, R> void printRunTimes(String testName, Function<T, R> foo, List<T> args) {
        printRunTimes(testName, runTimes(foo, args));
    }

    public static <T> void printRunTimes(String testName, HashMap<T, Long> map) {
        System.out.println("Function: " + testName);
        System.out.println("Argument\tRun Time (ms)");
        System.out.println("-----------------------------");
        for (T key : map.keySet()) {
            System.out.println(String.format("%,d", key) + "\t\t" + String.format("%,d", map.get(key)));
        }
        System.out.println();
    }

    public static <T, R> HashMap<T, Long> runTimes(Function<T, R> foo, List<T> args) {
        HashMap<T, Long> test = new HashMap<>();

        long startTime, endTime, elapsed;
        int nargs = args.size();
        T iarg;
        R iresult;

        for (int i = 0; i < nargs; i++) {
            iarg = args.get(i);
            startTime = System.currentTimeMillis(); // record the starting time 
            iresult = foo.apply(iarg);
            endTime = System.currentTimeMillis(); // record the ending time
            elapsed = endTime - startTime; // compute the elapsed time
            test.put(iarg, elapsed);
        }
        return test;
    }
}