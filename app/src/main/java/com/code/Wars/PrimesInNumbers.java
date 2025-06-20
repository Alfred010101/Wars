
package com.code.Wars;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * Given a positive number n > 1 find the prime factor decomposition of n. The
 * result will be a string with the following form :
 * "(p1**n1)(p2**n2)...(pk**nk)" with the p(i) in increasing order and n(i)
 * empty if n(i) is 1. Example: n = 86240 should return "(2**5)(5)(7**2)(11)"
 *
 * @author alfred
 */
public class PrimesInNumbers
{

    public static void run()
    {
        System.out.println(buildOutPutRefactor(7775460));
    }

    private static String buildOutPut(int number)
    {
        Map<String, List<Integer>> tupla = factores(number);
        List<Integer> factores =  tupla.get("factores");
        List<Integer> primos = tupla.get("primos");
        StringBuilder output = new StringBuilder();
        
        BiFunction<List<Integer>, Integer, Integer> fn = (list, pm) -> 
            {
                return (int)list.stream()
                    .filter(factor -> Objects.equals(factor, pm))
                    .count();
            };

        primos.stream()
                .distinct()
                .forEach(primo ->
        {
            int count = fn.apply(factores, primo);

            output.append("(");

            if (count > 1)
                output.append((String) (primo + "**" + count));
             else
                output.append(primo);

            output.append(")");
        });

        return output.toString();
    }
    
    //Mejora del metodo    
    private static String buildOutPutRefactor(int number)
    {
        List<Integer> factoresPrimos = factoresRefactor(number);
        
        StringBuilder output = new StringBuilder();

        factoresPrimos.stream()
                .distinct()
                .forEach(primo ->
        {
            
            int count = (int)factoresPrimos.stream()
                    .filter(factor -> Objects.equals(factor, primo))
                    .count();

            output.append("(")
                    .append((count > 1) ? (primo + "**" + count): primo)
                    .append(")");
        });

        return output.toString();
    }

    private static Map<String, List<Integer>> factores(int number)
    {
        List<Integer> factores = new ArrayList<>();
        List<Integer> primos = new ArrayList<>();

        for (int i = 2; i <= number; i++)
        {
            while (number % i == 0)
            {
                number /= i;
                factores.add(i);
                primos.add(i);
            }
        }

        return Map.of(
                "factores", factores,
                "primos", primos
        );
    }
    
    
    //Mejora del metodo    
    private static List<Integer> factoresRefactor(int number)
    {
        List<Integer> factoresPrimos = new ArrayList<>();

        for (int i = 2; i <= number; i++)
        {
            while (number % i == 0)
            {
                number /= i;
                factoresPrimos.add(i);
            }
        }

        return factoresPrimos;
    }
    
    private static String factors(int lst) 
    {
        String result = "";
        for (int fac = 2; fac <= lst; ++fac) 
        {
            int count = 0;
            while(lst % fac == 0) 
            {
                lst /= fac;
                ++count;
            }
            if (count > 0) 
            {
                result += "(" + fac + (count > 1 ? "**" + count : "") + ")";
            }
        }
        return result;
    }
}
