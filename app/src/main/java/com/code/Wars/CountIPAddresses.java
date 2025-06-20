package com.code.Wars;

import java.util.function.Function;
import java.util.stream.IntStream;

/**
 *
 * @author alfred
 */
public class CountIPAddresses
{

    public static long ipsBetween(String start, String end)
    {

        Function<String[], Long> fn = (array) -> 
                IntStream.range(0, array.length)
                .mapToLong(i -> Integer.parseInt(array[i]) * (long) Math.pow(256, 3 - i))
                .sum();

        return fn.apply(end.split("\\.")) - fn.apply(start.split("\\."));
    }
}
