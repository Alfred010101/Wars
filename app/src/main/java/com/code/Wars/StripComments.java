package com.code.Wars;

/**
 *
 * @author alfred
 */
public class StripComments
{

    public static void exec()
    {
        var str = StripComments.stripCommentsRefactor(
                "apples, pears # and bananas\ngrapes\nbananas !apples",
                new String[]
                {
                    "#", "!"
                });
//        var str = StripComments.stripCommentsRefactor(
//                "a #b\nc\nd $e f g",
//                new String[]
//                {
//                    "#", "$"
//                });
        System.out.println(str);
    }

    public static String stripComments(String text, String[] commentSymbols)
    {

        StringBuilder newString = new StringBuilder();

        for (String string : text.split("\n"))
        {
            int index = -1;
            for (String commentSymbol : commentSymbols)
            {
                int idx = string.indexOf(commentSymbol);
                if (idx > -1 && (index == -1 || idx < index))
                    index = idx;
            }

            newString.append(string.substring(0, 
                    (index > -1) ? index : string.length()).stripTrailing())
                .append("\n");
        }

        return newString.deleteCharAt(newString.length() - 1).toString();
    }
    
    public static String stripCommentsRefactor(String text, String[] commentSymbols)
    {
        return text.replaceAll("(?m)\\h*([" + String.join("",commentSymbols) + "].*)?$", "");
    }

}
