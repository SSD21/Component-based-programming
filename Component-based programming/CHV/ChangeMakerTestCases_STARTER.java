package test;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.junit.Assert.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import change.ChangeMaker;
import change.ChangeMakerImpl_Damani;

public class ChangeMakerTestCases_STARTER
{
	//Student note (ask me about this) -
	//The following debugging switch is not typically found in Test Cases:
	final static boolean DEBUGGING = false;
	
	final static int DESIRED_TIMEOUT_IN_MILLISECONDS = (3)*1000;
	final static int TIMEOUT_USED_FOR_DEBUGGING_IN_MILLISECONDS = (10*((60)*1000));
	final static int TIMEOUT_IN_MILLISECONDS = (DEBUGGING ? TIMEOUT_USED_FOR_DEBUGGING_IN_MILLISECONDS : DESIRED_TIMEOUT_IN_MILLISECONDS);
	
	@Rule
	public Timeout timeoutForAllTestMethods = new Timeout(TIMEOUT_IN_MILLISECONDS);
	
	protected static ChangeMaker changeMaker_STUDENT;
	
	protected static String TEST_GOAL_MESSAGE;
	
	@Retention(value=RUNTIME)
	@Target(value=METHOD)
	public @interface Points {
		int value();
	}
	
	private static Set<Integer> getUSCoinDenominationSet()
	{
		return getDenominationSet(new Integer[]{1, 5, 10, 25, 100});
	}

	private static Set<Integer> getDenominationSet(Integer[] values)
	{
		Set<Integer> denominationSet = new HashSet<Integer>(Arrays.asList(values));
		assert denominationSet.size() == values.length : "The Integer array values has duplicates! : values = " + getPrettyString(values);
		//assert denominationSet.contains(null): "Set cannot contain null";
		//assert denominationSet != null: "Set cannot be null";
		//STUDENT: add check for null

		return denominationSet;
	}
	
	private static String getPrettyString(Set<Integer> set)
	{
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		Collections.reverse(list);
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for(int i = 0; i < list.size(); i++)
		{
			sb.append(list.get(i));
			if(i < list.size() - 1)
			{
				sb.append(", ");
			}
		}
		sb.append("}");
		return sb.toString();
	}
	
	private static String getPrettyString(Integer[] integerArray)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i = 0; i < integerArray.length; i++)
		{
			sb.append(integerArray[i]);
			if(i < integerArray.length - 1)
			{
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	private static String getPrettyString(List<Integer> list)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i = 0; i < list.size(); i++)
		{
			sb.append(list.get(i));
			if(i < list.size() - 1)
			{
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	protected ChangeMaker getChangeMaker(Set<Integer> denominations)
	{
		return new ChangeMakerImpl_Damani(denominations);
	}
	
	
	@Points(value=5)
	@Test
	public void canMakeExactChange__USCoins__65()
	{
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		int valueInCents = 65;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
		
	}
	
	@Points(value=5)
	@Test
	public void getExactChange__USCoins__65()
	{
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		int valueInCents = 65;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{0, 2, 1, 1, 0});
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}

	@Points(value=5)
	@Test
	public void canMakeExactChange__USCoins__55()
	{
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		int valueInCents = 55;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}

	@Points(value=5)
	@Test
	public void canMakeExactChange__USCoins__10()
	{
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		int valueInCents = 10;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}

	@Points(value=5)
	@Test
	public void canMakeExactChange__USCoins__11()
	{
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		int valueInCents = 11;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}

	@Points(value=5)
	@Test
	public void canMakeExactChange__USCoins__180004()
	{
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		int valueInCents = 180004;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);
		
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}

	@Points(value=5)
	@Test
	public void canMakeExactChange__32_16_8_4_2_1__0()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{32, 16, 8, 4, 2, 1});
		int valueInCents = 0;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Points(value=5)
	@Test
	public void getExactChange__32_16_8_4_2_1__0()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{32, 16, 8, 4, 2, 1});
		int valueInCents = 0;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0});
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}

	@Points(value=5)
	@Test
	public void canMakeExactChange__10E8_10E7_10E6_10E5_10E4_10E3_10E2_10E1_10E0__123456789()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[] {100000000, 10000000, 1000000, 100000, 10000, 1000, 100, 10,1});
		int valueInCents = 123456789;
		
		TEST_GOAL_MESSAGE = "Test" + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		
	}
	
	@Points(value=5)
	@Test
	public void getExactChange__10E8_10E7_10E6_10E5_10E4_10E3_10E2_10E1_10E0__123456789()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{100000000, 10000000, 1000000, 100000, 10000, 1000, 100, 10,1});
		int valueInCents = 123456789;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	
	@Points(value=5)
	@Test
	public void canMakeExactChange__144_89_55_34_21_13_8_5_3_2_1__0()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[] {144, 89, 55, 34, 21, 13, 8, 5 ,3, 2, 1});
		int valueInCents = 0;
		
		TEST_GOAL_MESSAGE = "Test" + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents , changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Points(value=5)
	@Test
	public void canMakeExactChange__144_89_55_34_21_13_8_5_3_2_1__201()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[] {144, 89, 55, 34, 21, 13, 8, 5 ,3, 2, 1});
		int valueInCents = 201;
		
		TEST_GOAL_MESSAGE = "Test" + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents , changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Points(value=5)
	@Test
	public void getExactChange__144_89_55_34_21_13_8_5_3_2_1__201()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{144,89,55,34,21,13,8,5,3,2,1});
		int valueInCents = 201;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{1,0,1,0,0,0,0,0,0,1,0});
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	
	@Points(value=5)
	@Test
	public void canMakeExactChange__16777216_2097152_262144_32768_4096_512_64_8_1__88888888()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[] {16777216, 2097152, 262144, 32768, 4096, 512, 64, 8, 1});
		int valueInCents = 88888888;
		
		TEST_GOAL_MESSAGE = "Test" + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents , changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Points(value=5)
	@Test
	public void getExactChange__16777216_2097152_262144_32768_4096_512_64_8_1__88888888()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{16777216, 2097152, 262144, 32768, 4096, 512, 64, 8, 1});
		int valueInCents = 88888888;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{5,2,3,0,5,3,0,7,0});
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}

	@Points(value=5)
	@Test
	public void calculateValueOfChangeList__537824_38416_2744_196_14_1__0_0_0_0_0_0()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[] {537824, 38416, 2744, 196, 14, 1});
		int correctValueInCents  = 0;
		//List<Integer> changeList = changeMaker_STUDENT.calculateValueOfChangeList(usCoinDenominationSet);
		List<Integer> correctChangeList = Arrays.asList(new Integer[] {0,0,0,0,0,0});
		TEST_GOAL_MESSAGE = "Test" + getPrettyString(denominationSet) + ".calculateValueOfChangeList(" + correctValueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		assertEquals(correctValueInCents, changeMaker_STUDENT.calculateValueOfChangeList(correctChangeList)); //changeList);
		
	}
	
	@Points(value=5)
	@Test
	public void calculateValueOfChangeList__144_89_55_34_21_13_8_5_3_2_1__0_0_0_0_0_0_0_3_2_1_0()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[] {144,89,55,34,21,13,8,5,3,2,1});
		int correctValueInCents  = 23;
		//List<Integer> changeList = changeMaker_STUDENT.calculateValueOfChangeList(usCoinDenominationSet);
		List<Integer> correctChangeList = Arrays.asList(new Integer[] {0,0,0,0,0,0,0,3,2,1,0});
//		System.out.println("denominationSet: " + denominationSet );
//		System.out.println("denominationSet: " + denominationSet.size() );
//		System.out.println("changeList: " + correctChangeList);
//		System.out.println("changeList: " + correctChangeList.size());
//		System.out.println(denominationSet.size() + "==" + correctChangeList.size() );
		TEST_GOAL_MESSAGE = "Test" + getPrettyString(denominationSet) + ".calculateValueOfChangeList(" + correctValueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		assertEquals(correctValueInCents, changeMaker_STUDENT.calculateValueOfChangeList(correctChangeList)); //changeList);
	}
	
	//sample
	@Test
	public void calculateValueOfChangeList__8000_400_20_1__0_1_4_12()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[] {8000,400,20,1});
		int correctValueInCents  = 492;
		List<Integer> correctChangeList = Arrays.asList(new Integer[] {0,1,4,12});
		TEST_GOAL_MESSAGE = "Test" + getPrettyString(denominationSet) + ".calculateValueOfChangeList(" + correctValueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		assertEquals(correctValueInCents, changeMaker_STUDENT.calculateValueOfChangeList(correctChangeList)); //changeList);
	}
	//sample
	@Test
	public void canMakeExactChange__10__6()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[] {10});
		int valueInCents = 6;
		
		TEST_GOAL_MESSAGE = "Test" + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents , changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	//sample
	@Test
	public void getExactChange__429981696_35831808_2985984_248832_20736_1728_144_12_1__14()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{429981696,35831808,2985984,248832,20736,1728,144,12,1});
		int valueInCents = 14;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{0,0,0,0,0,0,0,1,2});
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	
	@Points(value=5)
	@Test
	public void canMakeExactChange__8000_400_20_1__492()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[] {8000,400,20,1});
		int valueInCents = 492;
		
		TEST_GOAL_MESSAGE = "Test" + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents , changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Points(value=5)
	@Test
	public void getExactChange__8000_400_20_1__492()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{8000,400,20,1});
		int valueInCents = 492;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{0,1,4,12});
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	
	@Points(value=5)
	@Test
	public void calculateValueOfChangeList__USCoinSet__0_0_0_0_28()
	{
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		int correctValueInCents  = 28;
		//List<Integer> changeList = changeMaker_STUDENT.calculateValueOfChangeList(usCoinDenominationSet);
		List<Integer> correctChangeList = Arrays.asList(new Integer[] {0,0,0,0,28});
		TEST_GOAL_MESSAGE = "Test" + getPrettyString(usCoinDenominationSet) + ".calculateValueOfChangeList(" + correctValueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);
		assertEquals(correctValueInCents, changeMaker_STUDENT.calculateValueOfChangeList(correctChangeList)); //changeList);
		
		
	}
	
	//STUDENT SHOULD ADD MANY OTHER TEST CASES
	//WHAT HAS NOT BEEN TESTED?
	//ANY OTHER CORNER CASES?
//	@Test
//	public void infiniteLoop()
//	{
//		while (true) {}
//	}
}
