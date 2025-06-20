
package com.code.Wars;

/**
 *
 * @author alfred
 */
public class AlternatingSplit
{
    public static void exec()
    {
        System.out.println(encrypt("This is a test!", 2));
        System.out.println(decrypt("s eT ashi tist!", 0));
    }

    private static String encrypt(final String text, final int n)
    {
        String stringFinal = text;
        StringBuilder newString = new StringBuilder();
        
        for (int i = 0; i < n; i++)
        {
            for(int j = 0; j < stringFinal.length(); j++)
                newString.insert((j % 2 == 0) ? j : j / 2, stringFinal.charAt(j));
            
            stringFinal = newString.toString();
            newString.delete(0, newString.length());
        }
        
        return stringFinal;
    }
    
    private static String decrypt(final String encryptedText, final int n)
    {
        if(encryptedText == null || encryptedText.isEmpty() || n <= 0)
            return encryptedText;
        
        String stringFinal = encryptedText;
        StringBuilder newString = new StringBuilder();
        
        for (int i = 0; i < n; i++)
        {
            for(int j = 0; j < stringFinal.length() / 2; j++)
                newString.append(stringFinal.charAt(stringFinal.length() / 2 + j))
                        .append(stringFinal.charAt(j));
            stringFinal = newString.toString();
            newString.delete(0, newString.length());
        }
        
        return stringFinal + ((encryptedText.length() % 2 == 0) ? "" : encryptedText.charAt(encryptedText.length() - 1));
    }
}
