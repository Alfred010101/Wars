package com.code.Wars;

import java.util.Collections;
import java.util.LinkedList;

/**
 * In this little assignment you are given a string of space separated numbers,
 * and have to return the highest and lowest number.
 *
 * All numbers are valid Int32, no need to validate them.
 *
 * There will always be at least one number in the input string.
 *
 * Output string must be two numbers separated by a single space, and highest
 * number is first.
 *
 * @author Alfred
 */
public class HighestAndLowest
{

    public static void run()
    {
//        System.out.println(highAndLow("1 2 3 4 5"));    // return "5 1". 
        System.out.println(highAndLow("1 2 -3 4 5"));    // return "5 -3". 
//        System.out.println(highAndLow("1 9 3 4 -5"));    // return "9 -5". 
    }

    private static String highAndLow(String numbers)
    {
        LinkedList<Integer> data = new LinkedList<>();
        for (String string : numbers.split(" "))
        {
            data.add(Integer.valueOf(string));
        }
        Collections.sort(data);
        return data.getLast() + " " + data.getFirst();
    }
}
