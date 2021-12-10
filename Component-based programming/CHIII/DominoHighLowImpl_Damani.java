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
		
		this.highPipCount=highPipCount;
		this.lowPipCount = lowPipCount;
		 
	}
	public static final char HIGH_LOW_STRING_SEPARATOR = ':';
	public static boolean isHighLowString(String str)
	{
		if(str==null)
			return false;
		if(str.length()<3)
			return false;
		//if(!str.contains(""+HIGH_LOW_STRING_SEPARATOR))
		//	return false;
		Scanner readStr = new Scanner(str).useDelimiter("\\"+HIGH_LOW_STRING_SEPARATOR);
		if(!readStr.hasNextInt())
			return false;
		//String[] arrOfStr = str.split(":", 2);
		char hpc = str.charAt(0);
		char lpc = str.charAt(2);
		char sep = str.charAt(1);
		
		return lpc <= hpc & hpc >= lpc && sep == HIGH_LOW_STRING_SEPARATOR;
			
				
	}
	
	public DominoHighLowImpl_Damani(String highLowString)
	{
		
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
		
		int sum=sumDifference[INDEX_OF_SUM];
		int diff = sumDifference[INDEX_OF_DIFFERENCE];
		
		highPipCount=(sum + Math.abs(diff))/2;
		lowPipCount=(sum- Math.abs(diff))/2;
		
		
	}
	//part of pre: 1<=highLowSet.size()<=2
	//part of pre: !highLowSet.contains(null)
	public DominoHighLowImpl_Damani(Set<Integer> highLowSet)
	{
		
		Object[] array = highLowSet.toArray();
		
		if(array.length==1) {
			highPipCount=(int) array[0];
			lowPipCount=(int) array[0];
		}
		if(array.length == 2) {
			highPipCount = (int)array[1];
			lowPipCount = (int) array[0];
		}
		
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
