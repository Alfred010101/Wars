package com.code.Wars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alfred
 */
public class DeleteOccurrences
{

    public static void exec()
    {
        int[] elemets = deleteNthFinal(new int[]
        {
            1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1
        }, 3);
        Arrays.stream(elemets)
                .boxed()
                .forEach(System.out::println);
//System.out.println(Arrays.);
// salida {1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 }
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences)
    {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < elements.length; i++)
        {
            if (count.get(elements[i]) == null)
                count.put(elements[i], 1);
            else
                count.replace(elements[i], count.get(elements[i]) + 1);

            if (count.get(elements[i]) <= maxOccurrences)
                list.add(elements[i]);
        }
        
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
    public static int[] deleteNthFinal(int[] elements, int maxOccurrences)
    {
        final Map<Integer, Integer> count = new HashMap<>();
        final List<Integer> list = new ArrayList<>();

        for (final Integer integer : elements)
        {
            final Integer value = count.put(integer, count.getOrDefault(integer, 0) + 1);
            if (value == null || value < maxOccurrences)
                list.add(integer);
        }
        
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

//1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5
//1 2 3 1 1 2 2 3345
