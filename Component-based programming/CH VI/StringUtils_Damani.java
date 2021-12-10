package utils;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface StringUtils_Damani {
	
	public static String reverse(String str) {
		assert str != null: "String cannot be null";
		
		String codePointstr = codePoints(str);
		StringBuilder sb = new StringBuilder();
		for(int i=codePointstr.length()-1;i>=0;  i--) {
			int c = codePointstr.codePointAt(i);
			char[] reverseLetters = Character.toChars(c);
			sb.append(reverseLetters);
		}
		String reverseString = sb.toString();
		return reverseString;
		//return new StringBuilder(str).reverse().toString();
		
//		char[] temp = str.toCharArray();
//		int frontend,backend = 0;
//		backend = temp.length-1;
//		
//		
//		for(frontend = 0; frontend<backend; frontend++, backend--) {
//			char temp2 = temp[frontend];
//			temp[frontend] = temp[backend];
//			temp[backend] = temp2;
//			
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for(char c: temp) {
//			sb.append(c);
//		}
//		String reverseString = sb.toString();
//		return reverseString;
		
		
		//int offset =0;
		//int count = 1;
		//int length = codePointstr.length();
		//char[] letters = str.toCharArray();
		
			//int number_of_chars = codePointstr.offsetByCodePoints(offset, count);
			//offset = number_of_chars;
			
			//letters[i] = letters[length-1-i];
			//letters[length-1-i] = (char)c;

		
		
		
//		
//		String reverseString = new String(new_sb2);
//		return reverseString;
		
//		int length = str.length();
//		int totalCodePointCount = str.codePointCount(0, length);
//		int OFFSET = 0;
//		int count = totalCodePointCount;
//		
//		for(int i=0; i<totalCodePointCount; i++) {
//			int codePointValue = str.codePointAt(i);
//			String character = new String(new int[] {codePointValue}, OFFSET, count);
//			int numberOfChars = str.offsetByCodePoints(i, count);
//		}
	}
	public static boolean isPalindrome(String str) {
		assert str != null: "String cannot be null";
		
		String reverseString = StringUtils_Damani.reverse(str);
		if(str.equals(reverseString))
				return true;
		return false;
	}
	public static int getCount(String str, String pattern) {
		assert str != null: "String cannot be null";
		assert pattern != null: "Pattern cannot be null";
		assert !(pattern.isEmpty()): "Pattern cannot be an empty string";
		
		
		
//		int offset = 0;
//		int length = str.length();
//		int count = str.codePointCount(0, length);
//		for(int i=0; i<=count; i++) {
//			new String(new int[] {str.codePointAt(i)}, offset,count);
//		}
//		return str.offsetByCodePoints(offset, count);
//		
		String newStr = codePoints(str);
		String newPattern = codePoints(pattern);
		int count =0;
		Pattern p = Pattern.compile(newPattern);
		Matcher match = p.matcher(newStr);
		//int matcher = match.groupCount();
		int startingIndex = 0;
		
		while(match.find(startingIndex)) {
			//for(int i=0;i <= matcher ;i++)
			count++;
			startingIndex = match.start() + 1;
		}
		
		return count;
		
		
//		int i=0;
//		int count=0;
//		int length = pattern.length();
//		while((i=str.indexOf(pattern,i)) != -1) {
//			count++;
//			i += length;	
//		}
//		return count;
		
//		int count=0;
//		StringBuilder sb = new StringBuilder(str);
//		StringBuilder new_sb = new StringBuilder(pattern);
//		StringBuilder new1 = new StringBuilder();
//		StringBuilder new2 = new StringBuilder();
//		for (int i=0; i<str.length(); i++) {
//			int code_point1 = sb.codePointAt(i);
//			char[] letters1 = Character.toChars(code_point1);
//			new1.append(letters1);
//		}
//		String newString1 = new1.toString();
//		for(int j=0; j<pattern.length(); j++) {
//			int code_point2 = new_sb.codePointAt(j);
//			char[] letters2 = Character.toChars(code_point2);
//			new2.append(letters2);
//			//char[] letters = Character.toChars(code_point);
//			
//		}
//		String newString2 = new2.toString();
//		
		
		
			
	}

	public static String rotate(String str, int rotation) {
		assert str != null: "String cannot be null";
		assert rotation <= str.length():"rotation not possible, rotation number too large";
		
		if (rotation == 0)
			return str;
		if(str == "")
			return str;
		//String rotatedString ="";
		if(rotation < 0) { 
			int finalRotation = -(rotation);
			String rotatedString = str.substring(finalRotation) + str.substring(0, finalRotation);
			return rotatedString;
		}
		
		String rotatedString = str.substring(str.length()-rotation) + str.substring(0, str.length()-rotation);
		return rotatedString;
	}
	
	//precondition: int shift cannot be negative
	public static String shift(String lettersOnlyString, int shift) {
		assert lettersOnlyString != null:"String cannot be null";
		assert !(lettersOnlyString.isEmpty()):"String shouldnot be empty";
		assert isValidString(lettersOnlyString): "String contains digits or special characters!!";
		assert shift >= 0: "value of shift cannot be negative";
		assert shift <= lettersOnlyString.length():"value of shift cannot be greater than length of the string";
		assert isLowerCaseString(lettersOnlyString):"Letters are uppercase";
		assert !(lettersOnlyString.contains(Character.toString('z')));
		
		String shiftedString ="";
		for (char letter : lettersOnlyString.toCharArray()) {
			int index = (int) letter;
			index += shift;
			if(index > (int) 'z') {
				index -= 26;
			}
		char characters = (char) index;
		shiftedString += characters;
		}
		return shiftedString;
		
//		StringBuilder sb = new StringBuilder(lettersOnlyString);
//		char[] letters = lettersOnlyString.toCharArray();
//		
//		
//		for(int i=0; i < letters.length; i++) {
//			sb.append(lettersOnlyString.charAt(lettersOnlyString.length()-1));
//			//if(Character.isLetter(letters[i]))
//			letters[i] += shift;
//			
//		}
//		
//		String letterString = new String(letters);
//		return letterString;

		
		
		
	}
	public static boolean areAnagrams(String str1, String str2) {
		assert str1 != null:"String 1 cannot be null";
		assert str2!= null: "String 2 cannot be null";
		
		int length1 = str1.length();
		int length2 = str2.length();
		
		if(length1 != length2)
			return false;
		
		for(char c: str1.toCharArray()) {
			if(str2.indexOf(c) < 0) {
				return false;
			}
		}
		for(char c: str2.toCharArray()) {
			if(str1.indexOf(c) < 0) {
				return false;
			}
		}
		return true;
//		char[] letters1 = str1.toCharArray();
//		char[] letters2 = str2.toCharArray();
//		
//		StringBuilder sb = new StringBuilder(str1);
//		StringBuilder new_sb = new StringBuilder();
//		for (int i=0; i<str1.length(); i++) {
//			int code_point = sb.codePointAt(i);
//			letters1 = Character.toChars(code_point);
//			new_sb.append(letters1);
//		}
//		String newString1 = new_sb.toString();
//		
//		StringBuilder sb2 = new StringBuilder(str2);
//		StringBuilder new_sb2 = new StringBuilder();
//		for (int i=0; i<str2.length(); i++) {
//			int code_point = sb2.codePointAt(i);
//			letters2 = Character.toChars(code_point);
//			new_sb2.append(letters2);
//		}
//		String newString2 = new_sb2.toString();
////		System.out.println(letters1);
////		System.out.println(letters2);
//		
//		Arrays.sort(letters1);
//		Arrays.sort(letters2);
//		for(int i=0; i<length1; i++) { 
//			if(letters1[i] != letters2[i]) {
//				
//				return false;
//			}
//		}
//		
//		return true;
		

	}
	public static boolean isValidString(String str) {
		str = str.toLowerCase();
		char[] letterArray = str.toCharArray();
		for(int i=0; i<letterArray.length; i++) {
			char letter = letterArray[i];
			if(!(letter >= 'a' && letter <= 'z')) {
				return false;
			}
		}
		return true;
	}
	
	public static String codePoints(String str) {
		//int count = str.codePointCount(0, str.length());
		StringBuilder sb = new StringBuilder(str);
		StringBuilder new_sb = new StringBuilder();
		for (int i=0; i<str.length(); i++) {
			int code_point = sb.codePointAt(i);
			char[] letters = Character.toChars(code_point);
			new_sb.append(letters);
		}
		String newString = new_sb.toString();
		return newString;
	}
	
	public static boolean isLowerCaseString(String str) {
		char[] letters = str.toCharArray();
		for(int i=00;i<letters.length; i++) {
			if(!Character.isLowerCase(letters[i]))
				return false;
		}
		return true;
	}

}
