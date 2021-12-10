package dominoes;

import java.util.Scanner;
import java.util.Set;

public class DominoHighLowImpl_Damani implements Domino {
	private int highPipCount;
	private int lowPipCount;
	
	//public static boolean isHighLowValid (int a, int b) {
	//	boolean foundConstraintViolation = false;
	//	boolean is_a_inRange = isInRange(a, MINIMUM_PIP_COUNT, MAXIMUM_PIP_COUNT);
	//	if (is_a_inRange) {
	//		return foundConstraintViolation;
	//	}
	//	boolean is_b_inRange = isInRange(b,MINIMUM_PIP_COUNT, MAXIMUM_PIP_COUNT);
	//	boolean is_a_lessThan_b = (a<b);
	//	if (!is_a_lessThan_b)
	//		return !foundConstraintViolation;
	//	return true;
	//}
	
	//public static boolean isInRange(int i, int start, int end) {
	//	return (start<=i) && (i <=end);
	//}
	public DominoHighLowImpl_Damani(int highPipCount, int lowPipCount)
	{
		assert highPipCount >= MINIMUM_PIP_COUNT && highPipCount <= MAXIMUM_PIP_COUNT : "high pip count is out of bounds!!";
		assert lowPipCount >= MINIMUM_PIP_COUNT && lowPipCount <= MAXIMUM_PIP_COUNT: "low pip count is out of bounds!!";
		assert highPipCount >= lowPipCount : "high pip count cannot be less than low pip count!!";
		this.highPipCount=highPipCount;
		this.lowPipCount = lowPipCount;
		 
	}
	public static final char HIGH_LOW_STRING_SEPARATOR = ':';
	public static boolean isHighLowString(String str) 
	{
		//if(str==null)
		//	return false;
		assert str != null : "String cannot be null!!";
		//if(str.length()<3)
		//	return false;
		assert str.length() == 3 : "String length is not 3, not valid string!!";
		//if(!str.contains(""+HIGH_LOW_STRING_SEPARATOR))
		//	return false;
		Scanner readStr = new Scanner(str).useDelimiter("\\"+HIGH_LOW_STRING_SEPARATOR);
		if(!readStr.hasNextInt())
			return false;
		String[] arrOfStr = str.split(":", 2);
		char hpc = str.charAt(0);	

		char lpc = str.charAt(2);
		char sep = str.charAt(1);
		
		
		return lpc <= hpc & hpc >= lpc && sep == HIGH_LOW_STRING_SEPARATOR;
		
			
				
	}
	
	public DominoHighLowImpl_Damani(String highLowString)
	{
		assert isHighLowString(highLowString)==true : "string is not a high low stirng";
		char highPipCountChar = highLowString.charAt(0);
		char lowPipCountChar=highLowString.charAt(2);
		highPipCount=Character.getNumericValue(highPipCountChar);
		lowPipCount=Character.getNumericValue(lowPipCountChar);
		
		
		
	}
	
	public static final int INDEX_OF_SUM = 0;
	public static final int INDEX_OF_DIFFERENCE = 1;
	//part of pre: sumDifference.length==2
	//part of pre: sumDifference[INDEX_OF_SUM]>= sumDifference[INDEX_OF_DIFFERENCE]
	public DominoHighLowImpl_Damani(int[] sumDifference)
	{
		assert sumDifference != null :"sumDifference array cannot be null!!";
		assert sumDifference.length == 2 : "Array length is not 2!!";
		assert sumDifference[INDEX_OF_SUM] >= sumDifference[INDEX_OF_DIFFERENCE] : "sum should be greater than difference!!";
		
		int sum=sumDifference[INDEX_OF_SUM];
		int diff = sumDifference[INDEX_OF_DIFFERENCE];
		
		assert (sum-diff) % 2 == 0 : "(sum-diff) cannot be odd"; //check
		assert !(sum%2==1 && diff==0) :"difference cannot be zero when the sum is odd!!"; //check
		
		assert 2*MINIMUM_PIP_COUNT <= sum && sum <= 2*MAXIMUM_PIP_COUNT ;
		assert -(MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT) <=diff; //check
		assert diff <= MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT;
		
		highPipCount=(sum + Math.abs(diff))/2;
		lowPipCount=(sum- Math.abs(diff))/2;
		
		
	}
	//part of pre: 1<=highLowSet.size()<=2
	//part of pre: !highLowSet.contains(null)
	public DominoHighLowImpl_Damani(Set<Integer> highLowSet)
	{
		assert !highLowSet.contains(null) : "high low set is null";
		assert highLowSet.size() >=1 || highLowSet.size() <=2: "size of array is out of bounds!!";
		
		Integer[] array = highLowSet.toArray(new Integer[highLowSet.size()]);
		
		
		if(array.length==1) {
			assert MINIMUM_PIP_COUNT <= array[0]: "pip count is out of bounds!";
			assert array[0] <= MAXIMUM_PIP_COUNT: "pip count is out of bounds!";

			this.highPipCount = (int)array[0];
			this.lowPipCount = (int)array[0];
			
		}
		if(array.length == 2) {
			assert MINIMUM_PIP_COUNT <= array[0] :"hihg pip count is out of bounds!";
			assert array[0] <= MAXIMUM_PIP_COUNT :"high pip count is out of bounds!";
			assert MINIMUM_PIP_COUNT <= array[1] :"low pip count is out of bounds!";
			assert array[1] <= MAXIMUM_PIP_COUNT :"low pip count is out of bounds!";
			
			if(array[0] > array[1])
			{	
				this.lowPipCount = array[1];
				this.highPipCount = array[0];
			}
			else
			{
				this.lowPipCount = array[0];
				this.highPipCount = array[1];
			}
		}
		
	}
	//part of pre: (MINIMUM_PIP_COUNT/2) <= highPipCountDivisionBy2Quotient
	//part of pre: 0 <= highPipCountDivisionBy3Remainder < 3
	//part of pre: (MINIMUM_PIP_COUNT/2) <= lowPipCountDivisionBy2Quotient <= (MAXIMUM_PIP_COUNT/2)
	//part of pre: 0 <= lowPipCountDivisionBy3Remainder <3
	public DominoHighLowImpl_Damani(int highPipCountDivisionBy2Quotient, int highPipCountDivisionBy3Remainder, int lowPipCountDivisionBy2Quotient, int lowPipCountDivisionBy3Remainder) {
		
		assert (MINIMUM_PIP_COUNT/2) <= highPipCountDivisionBy2Quotient && highPipCountDivisionBy2Quotient <= (MAXIMUM_PIP_COUNT/2) : "HighPipCountDivisionBy2Quotient is invalid";
		assert 0 <= highPipCountDivisionBy3Remainder && highPipCountDivisionBy3Remainder < 3 : highPipCountDivisionBy3Remainder + " should be greater than 0 or less than 3";
		assert (MINIMUM_PIP_COUNT/2) <= lowPipCountDivisionBy2Quotient && lowPipCountDivisionBy2Quotient <= (MAXIMUM_PIP_COUNT/2) : "LowPipCountDivisionBy2Quotient is invalid";
		assert 0 <= lowPipCountDivisionBy3Remainder && lowPipCountDivisionBy3Remainder < 3 : lowPipCountDivisionBy3Remainder + " is greater than zero or less than three";
		
		
		int highPipCount = 0;
		int lowPipCount = 0;
		
		boolean ishighPipCount = false;

		for(int i = MAXIMUM_PIP_COUNT; i >= MINIMUM_PIP_COUNT; i--)
		{
			boolean iIsHPCQuotient = (i / 2 == highPipCountDivisionBy2Quotient);
			boolean iIsHPCRemainder = (i % 3 == highPipCountDivisionBy3Remainder);

			
			if(iIsHPCQuotient && iIsHPCRemainder)
			{
				highPipCount = i;
				ishighPipCount = true;
			}
			else if(!iIsHPCQuotient && !iIsHPCRemainder && i == MINIMUM_PIP_COUNT && highPipCount == 0)
			{
				
				ishighPipCount = false;
			}

		}
		assert ishighPipCount == true : "HighPipCount not found";
		
		boolean lowPipCountFound = false;
		
		for(int i = MAXIMUM_PIP_COUNT; i >= MINIMUM_PIP_COUNT; i--)
		{

			boolean iIsLPCQuotient = (i / 2 == lowPipCountDivisionBy2Quotient);
			boolean iIsLPCRemainder = (i % 3 == lowPipCountDivisionBy3Remainder);
			
			if(iIsLPCQuotient && iIsLPCRemainder)
			{
				lowPipCount = i;
				lowPipCountFound = true;
			}
			else if(!iIsLPCQuotient && !iIsLPCRemainder && i == MINIMUM_PIP_COUNT && lowPipCount == 0)
			{
				
				lowPipCountFound = false;
			}
		}
		assert lowPipCountFound == true :"LowPipCount not found";
		
		this.highPipCount = highPipCount;
		this.lowPipCount = lowPipCount;
	}

	@Override
	public int getHighPipCount() {
		return highPipCount;
	}

	@Override
	public int getLowPipCount() {
		return lowPipCount;
	}

	
	
}
