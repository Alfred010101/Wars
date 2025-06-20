package com.code.Wars;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * You are given an array(list) strarr of strings and an integer k. 
 * Your task is to return the first longest string consisting 
 * of k consecutive strings taken in the array.
 * 
 * Examples:
 * strarr = ["tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"], k = 2
 * 
 * Concatenate the consecutive strings of strarr by 2, we get:
 * 
 * treefoling   (length 10)  concatenation of strarr[0] and strarr[1]
 * folingtrashy ("      12)  concatenation of strarr[1] and strarr[2]
 * trashyblue   ("      10)  concatenation of strarr[2] and strarr[3]
 * blueabcdef   ("      10)  concatenation of strarr[3] and strarr[4]
 * abcdefuvwxyz ("      12)  concatenation of strarr[4] and strarr[5]
 * 
 * Two strings are the longest: "folingtrashy" and "abcdefuvwxyz".
 * The first that came is "folingtrashy" so 
 * longest_consec(strarr, 2) should return "folingtrashy".
 * 
 * In the same way:
 * longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"
 * n being the length of the string array, if n = 0 or k > n or k <= 0 return "" (return Nothing in Elm, "nothing" in Erlang).
 * 
 * @author alfred
 */
public class LongestConsec
{

    public static void exec()
    {
        System.out.println(LongestConsec.longestConsecRefactor(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));
//        testing(LongestConsec.longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2), "abigailtheta");
//        testing(LongestConsec.longestConsec(new String[] {"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1), "oocccffuucccjjjkkkjyyyeehh");
//        testing(LongestConsec.longestConsec(new String[] {}, 3), "");
    }

    private static String longestConsec(String[] strarr, int k)
    {
        if(strarr.length == 0 || k > strarr.length || k <= 0)        
            return "";
        
        int length = 0;
        
        List<Integer> posFinal = new ArrayList();
        
        for (int i = 0; i <= strarr.length - k; i++)
        {
            int tmpLength = strarr[i].length();
            List<Integer> pos = new ArrayList();
            pos.add(i);
            for (int j = 1; j < k; j++)
            {
                tmpLength += strarr[i + j].length(); 
                pos.add(i + j);
            }
            
            if(tmpLength > length)
            {    
                length = tmpLength;
                posFinal = new ArrayList<>(pos);
            }
        }
        
        StringBuilder str = new StringBuilder();
        
        for (int i = 0; i < posFinal.size(); i++)
            str.append(strarr[posFinal.get(i)]);
        
        return str.toString();
    }
    
    private static String longestConsecRefactor(String[] strarr, int k)
    {
        if(strarr.length == 0 || k > strarr.length || k <= 0)        
            return "";
        
        String strFinal = "";
        
        for (int i = 0; i <= strarr.length - k; i++)
        {
            StringBuilder str = new StringBuilder();
            str.append(strarr[i]);
            for (int j = 1; j < k; j++)            
                str.append(strarr[i + j]);
            
            if(str.length() > strFinal.length())
                strFinal = str.toString();
        }
        
        return strFinal;
    }
}
