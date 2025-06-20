package com.code.Wars;

import java.util.Arrays;

/**
 * Given two arrays of strings a1 and a2 return a sorted array r in
 * lexicographical order of the strings of a1 which are substrings of strings of
 * a2.
 *
 * Example 1: a1 = ["arp", "live", "strong"] a2 = ["lively", "alive", "harp",
 * "sharp", "armstrong"] returns ["arp", "live", "strong"]
 *
 * Example 2: a1 = ["tarp", "mice", "bull"] a2 = ["lively", "alive", "harp",
 * "sharp", "armstrong"] returns []
 *
 * @author alfred
 */
public class WhichAreIn
{

    public static void exec()
    {
        String a[] = new String[]
        {
            "arp", "strong", "mongo", "live"
        };
        String b[] = new String[]
        {
            "lively", "alive", "harp", "sharp", "armstrong"
        };
//    	String r[] = new String[] { "arp", "live", "strong" };
        String r[] = WhichAreIn.inArray(a, b);

        for (String string : r)
        {
            System.out.println(string);
        }

    }

    private static String[] inArray(String[] array1, String[] array2)
    {
        return Arrays.stream(array1)
                .filter(val ->
                {
                    return Arrays.stream(array2)
                            .anyMatch(dat -> dat.contains(val));
                }).sorted()
                .toList()
                .toArray(String[]::new);
    }
}
