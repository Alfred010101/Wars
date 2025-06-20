package com.code.Wars;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

/**
 *
 * @author alfred
 */
public class RomanNumerals
{
    private static final String[][] tabla = 
    {
        {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
        {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},        
        {"", "C", "CC"," CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
        {"", "M", "MM", "MMM", "", "", "", "", "", "", ""}
        
    };
    
    private static final Map<String, Integer> romanToNumber = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000
    );
    
    private static final int[] valores =    {1000, 900, 500, 400, 100, 90,  50, 40,  10, 9,   5, 4,  1};
    private static final String[] simbolos = {"M", "CM","D", "CD", "C", "XC","L","XL","X","IX","V","IV","I"};


    public static String toRoman(int n)
    {
        StringBuilder str = new StringBuilder();
        int[] numbers = Arrays.stream(new StringBuilder(String.valueOf(n))
                        .reverse()
                        .toString()
                        .split("")
                )
                .mapToInt(Integer::parseInt)                
                .toArray();
        
        for (int i = 0; i < numbers.length; i++)
            str.insert(0,tabla[i][numbers[i]]);
        
        
        return str.toString();
//          return toRomanII( n);
    }
    
    public static String toRomanII(int n)
    {
        StringBuilder str = new StringBuilder();
        
        for (int i = 0; i < valores.length; i++)
            while(n >= valores[i])
            {
                n -= valores[i];
                str.append(simbolos[i]);
            }
        
        return str.toString();
    }

    public static int fromRoman(String romanNumeral)
    {
        
        int[] numbers = Stream.of(romanNumeral.split(""))
                .mapToInt(c ->  romanToNumber.get(c))
                .toArray();
        
        int i = 0, number = 0;
        
        for ( ; i < numbers.length - 1; i++)
            if(numbers[i] >= numbers[i + 1])
                number += numbers[i];
            else
                number -= numbers[i];
        
        return number += numbers[i];
    }

}
