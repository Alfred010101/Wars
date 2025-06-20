
package com.code.Wars;

/**
 * Move the first letter of each word to the end of it, 
 * then add "ay" to the end of the word. 
 * Leave punctuation marks untouched.
 * 
 * pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
 * pigIt('Hello world !');     // elloHay orldway !
 * 
 * @author alfred
 */
public class SimplePigLatin 
{
    
    public static void exec()
    {
        System.out.println(pigIt("Hello world !"));
    }
    
    public static String pigIt(String str) 
    {
        StringBuilder newString = new StringBuilder();
        
        for (String array : str.split(" "))
            if(array.matches("^[?!].*"))
                newString.append(array)
                        .append(" ");
            else
                newString.append(array.substring(1))
                        .append(array.charAt(0))
                        .append("ay ");
        
        return newString.toString().trim();
    }
    
}
