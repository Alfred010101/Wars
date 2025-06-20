
package com.code.Wars;

/**
 *
 * @author alfred
 */

public class PasswordRegex
{
    public static final String REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])\\p{Alnum}{6,}$";
}
