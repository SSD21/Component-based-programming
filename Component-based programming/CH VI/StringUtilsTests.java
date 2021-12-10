package test;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.StringUtils_Damani;

public class StringUtilsTests
{
	@Test
	public void reverse_abc()
	{
		String str = "abc";
		String correctAnswer = "cba";
		String actualAnswer = StringUtils_Damani.reverse(str);
		assertEquals(correctAnswer, actualAnswer);
	}
//	@Test
//	public void reverse_emoji1()
//	{
//		String str = "😄😍😜";
//		String correctAnswer = "😜😍😄" ;
//		String actualAnswer = StringUtils_Damani.reverse(str);
//		assertEquals(correctAnswer, actualAnswer);
//	}
//	
	@Test
	public void isPalindrome_emojis12(){
		String str1 = "😄😍😜";
		boolean correctAnswer = false;
		boolean actualAnswer = StringUtils_Damani.isPalindrome(str1);
		assertEquals(correctAnswer, actualAnswer);
		
		
	}
	
	@Test
	public void isPalindrome_empty()
	{
		String str = "";
		boolean correctAnswer = true;
		boolean actualAnswer = StringUtils_Damani.isPalindrome(str);
		assertEquals(correctAnswer, actualAnswer);
	}
	
	@Test
	public void isPalindrome_ab()
	{
		String str = "ab";
		boolean correctAnswer = false;
		boolean actualAnswer = StringUtils_Damani.isPalindrome(str);
		assertEquals(correctAnswer, actualAnswer);
	}
	
	@Test
	public void isPalindrome_exclamationPoint()
	{
		String str = "!";
		boolean correctAnswer = true;
		boolean actualAnswer = StringUtils_Damani.isPalindrome(str);
		assertEquals(correctAnswer, actualAnswer);
	}
	
	@Test
	public void isPalindrome_panama()
	{
		String str = "A man, a plan, a canal, Panama!";
		boolean correctAnswer = false;
		boolean actualAnswer = StringUtils_Damani.isPalindrome(str);
		assertEquals(correctAnswer, actualAnswer);
	}
	
	@Test(expected=AssertionError.class)
	public void getCount_abc_null()
	{
		String str = "abc";
		String pattern = null;
		StringUtils_Damani.getCount(str, pattern);
	}
	
	@Test
	public void getCount_abc_a()
	{
		String str = "abc";
		String pattern = "a";
		int correctAnswer = 1;
		int actualAnswer = StringUtils_Damani.getCount(str, pattern);
		assertEquals(correctAnswer, actualAnswer);
	}
	

	@Test
	public void getCount_emoji1() {
		String str = "🐋🐍😀";
		String pattern = "🐍😀";
		int correctAnswer = 1;
		int actualAnswer = StringUtils_Damani.getCount(str, pattern);
		assertEquals(correctAnswer, actualAnswer);
	}
	@Test
	public void getCount_ab55d_5()
	{
		String str = "ab55d";
		String pattern = "5";
		int correctAnswer = 2;
		int actualAnswer = StringUtils_Damani.getCount(str, pattern);
		assertEquals(correctAnswer, actualAnswer);
	}
	
	@Test
	public void getCount_ab55d_55()
	{
		String str = "ab55d";
		String pattern = "55";
		int correctAnswer = 1;
		int actualAnswer = StringUtils_Damani.getCount(str, pattern);
		assertEquals(correctAnswer, actualAnswer);
	}

	@Test(expected=AssertionError.class)
	public void getCount_ab55d_empty()
	{
		String str = "ab55d";
		String pattern = "";
		StringUtils_Damani.getCount(str, pattern);
	}
	
	@Test
	public void getCount_empty_a()
	{
		String str = "";
		String pattern = "a";
		int correctAnswer = 0;
		int actualAnswer = StringUtils_Damani.getCount(str, pattern);
		assertEquals(correctAnswer, actualAnswer);
	}

	@Test(expected=AssertionError.class)
	public void getCount_empty_empty()
	{
		String str = "";
		String pattern = "";
		StringUtils_Damani.getCount(str, pattern);
	}
	
	@Test
	public void getCount_ab555cd_55()
	{
		String str = "ab555cd";
		String pattern = "55";
		int correctAnswer = 2;
		int actualAnswer = StringUtils_Damani.getCount(str, pattern);
		assertEquals(correctAnswer, actualAnswer);
	}

	//I CHANGED MY MIND:
	@Test
	public void rotate_abc_1()
	{
		String str = "abc";
		int delta = 1;
		String correctAnswer = "cab";
		String actualAnswer = StringUtils_Damani.rotate(str, delta);
		assertEquals(correctAnswer, actualAnswer);
	}

	//I CHANGED MY MIND:
	@Test
	public void rotate_abc_Neg2()
	{
		String str = "abc";
		int delta = -2;
		String correctAnswer = "cab";
		String actualAnswer = StringUtils_Damani.rotate(str, delta);
		assertEquals(correctAnswer, actualAnswer);
	}
	
	public void rotate_emoji_Neg2()
	{
		String str = "🐋🐍😀";
		int delta = -2;
		String correctAnswer = "😀🐋🐍";
		String actualAnswer = StringUtils_Damani.rotate(str, delta);
		assertEquals(correctAnswer, actualAnswer);
	}

	//I CHANGED MY MIND:
	@Test(expected=AssertionError.class)
	public void rotate_abc_7()
	{
		String str = "abc";
		int delta = 7;
		StringUtils_Damani.rotate(str, delta);
	}

	@Test
	public void shift_abc_2()
	{
		String str = "abc";
		int delta = 2;
		String correctAnswer = "cde";
		String actualAnswer = StringUtils_Damani.shift(str, delta);
		assertEquals(correctAnswer, actualAnswer);
	}

	@Test(expected=AssertionError.class)
	public void shift_abc_7()
	{
		String str = "abc";
		int delta = 7;
		String correctAnswer = "hij";
		String actualAnswer = StringUtils_Damani.shift(str, delta);
		assertEquals(correctAnswer, actualAnswer);
	}

	@Test(expected=AssertionError.class)
	public void shift_xyz_3()
	{
		String str = "xyz";
		int delta = 3;
		String correctAnswer = "abc";
		String actualAnswer = StringUtils_Damani.shift(str, delta);
		assertEquals(correctAnswer, actualAnswer);
	}

	//I CHANGED MY MIND:
	@Test(expected=AssertionError.class)
	public void shift_xyz_Neg2()
	{
		String str = "xyz";
		int delta = -2;
		
		StringUtils_Damani.shift(str, delta);
	}

	@Test(expected=AssertionError.class)
	public void shift_aBc_2()
	{
		String str = "aBc";
		int delta = 2;
		String correctAnswer = "cDe";
		String actualAnswer = StringUtils_Damani.shift(str, delta);
		assertEquals(correctAnswer, actualAnswer);
	}

	@Test(expected=AssertionError.class)
	public void shift_ABC_2()
	{
		String str = "ABC";
		int delta = 2;
		String correctAnswer = "CDE";
		String actualAnswer = StringUtils_Damani.shift(str, delta);
		assertEquals(correctAnswer, actualAnswer);
	}

	@Test(expected=AssertionError.class)
	public void shift_null_3()
	{
		String str = null;
		int delta = 3;
		
		StringUtils_Damani.shift(str, delta);
	}

	//I CHANGED MY MIND:
	@Test(expected=AssertionError.class)
	public void shift_empty_3()
	{
		String str = "";
		int delta = 3;
		
		StringUtils_Damani.shift(str, delta);
	}

	@Test(expected=AssertionError.class)
	public void shift_exclamationPointPeriod_1()
	{
		String str = "!.";
		int delta = 1;
		StringUtils_Damani.shift(str, delta);
	}
	
	@Test
	public void areAnagrams_empty_empty()
	{
		String str1 = "";
		String str2 = "";
		boolean correctAnswer = true;
		boolean actualAnswer = StringUtils_Damani.areAnagrams(str1, str2);
		assertEquals(correctAnswer, actualAnswer);
	}
	
	@Test
	public void areAnagrams_racecar_carrace()
	{
		String str1 = "racecar";
		String str2 = "carrace";
		boolean correctAnswer = true;
		boolean actualAnswer = StringUtils_Damani.areAnagrams(str1, str2);
		assertEquals(correctAnswer, actualAnswer);
	}
	
	@Test
	public void areAnagrams_hello_low()
	{
		String str1 = "hello";
		String str2 = "low";
		boolean correctAnswer = false;
		boolean actualAnswer = StringUtils_Damani.areAnagrams(str1, str2);
		assertEquals(correctAnswer, actualAnswer);
	}
	
	@Test
	public void areAnagrams_emoji1_emoji2()
	{
		String str1 = "🐋🐍😀";
		String str2 = "🐍🐋😀";
		boolean correctAnswer = true;
		boolean actualAnswer = StringUtils_Damani.areAnagrams(str1, str2);
		assertEquals(correctAnswer, actualAnswer);
	}
}
