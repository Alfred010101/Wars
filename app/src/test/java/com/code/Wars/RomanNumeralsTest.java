package com.code.Wars;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author alfred
 */

public class RomanNumeralsTest {

    @Test
    public void testToRoman() {
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(1), is("I"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(2), is("II"));
        assertThat("4 converts to 'IV'", RomanNumerals.toRoman(4), is("IV"));
        assertThat("5 converts to 'V'", RomanNumerals.toRoman(5), is("V"));
        assertThat("6 converts to 'VI'", RomanNumerals.toRoman(6), is("VI"));
        assertThat("9 converts to 'IX'", RomanNumerals.toRoman(9), is("IX"));
        assertThat("10 converts to 'X'", RomanNumerals.toRoman(10), is("X"));
        assertThat("23 converts to 'XXIII'", RomanNumerals.toRoman(23), is("XXIII"));
        assertThat("44 converts to 'XLIV'", RomanNumerals.toRoman(44), is("XLIV"));
        assertThat("59 converts to 'LIX'", RomanNumerals.toRoman(59), is("LIX"));
        assertThat("75 converts to 'LXXV'", RomanNumerals.toRoman(75), is("LXXV"));
        assertThat("92 converts to 'XCII'", RomanNumerals.toRoman(92), is("XCII"));
        assertThat("261 converts to 'CCLXI'", RomanNumerals.toRoman(261), is("CCLXI"));
        assertThat("1000 converts to 'M'", RomanNumerals.toRoman(1000), is("M"));
        assertThat("1450 converts to 'MCDL'", RomanNumerals.toRoman(1450), is("MCDL"));
        assertThat("1990 converts to 'MCMXC'", RomanNumerals.toRoman(1990), is("MCMXC"));
        assertThat("2008 converts to 'MMVIII'", RomanNumerals.toRoman(2008), is("MMVIII"));
        assertThat("2537 converts to 'MMDXXXVII'", RomanNumerals.toRoman(2537), is("MMDXXXVII"));
        assertThat("3999 converts to 'MMMCMXCIX'", RomanNumerals.toRoman(3999), is("MMMCMXCIX"));
    }

    @Test
    public void testFromRoman() {
        assertThat("'I' converts to 1", RomanNumerals.fromRoman("I"), is(1));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("II"), is(2));
        assertThat("'IV' converts to 4", RomanNumerals.fromRoman("IV"), is(4));
        assertThat("'V' converts to 5", RomanNumerals.fromRoman("V"), is(5));
        assertThat("'VI' converts to 6", RomanNumerals.fromRoman("VI"), is(6));
        assertThat("'IX' converts to 9", RomanNumerals.fromRoman("IX"), is(9));
        assertThat("'X' converts to 10", RomanNumerals.fromRoman("X"), is(10));
        assertThat("'XXIII' converts to 23", RomanNumerals.fromRoman("XXIII"), is(23));
        assertThat("'XLIV' converts to 44", RomanNumerals.fromRoman("XLIV"), is(44));
        assertThat("'LIX' converts to 59", RomanNumerals.fromRoman("LIX"), is(59));
        assertThat("'LXXV' converts to 75", RomanNumerals.fromRoman("LXXV"), is(75));
        assertThat("'XCII' converts to 92", RomanNumerals.fromRoman("XCII"), is(92));
        assertThat("'CCLXI' converts to 261", RomanNumerals.fromRoman("CCLXI"), is(261));
        assertThat("'M' converts to 1000", RomanNumerals.fromRoman("M"), is(1000));
        assertThat("'MCDL' converts to 1450", RomanNumerals.fromRoman("MCDL"), is(1450));
        assertThat("'MCMXC' converts to 1990", RomanNumerals.fromRoman("MCMXC"), is(1990));
        assertThat("'MMVIII' converts to 2008", RomanNumerals.fromRoman("MMVIII"), is(2008));
        assertThat("'MMDXXXVII' converts to 2537", RomanNumerals.fromRoman("MMDXXXVII"), is(2537));
        assertThat("'MMMCMXCIX' converts to 3999", RomanNumerals.fromRoman("MMMCMXCIX"), is(3999));
    }
}

