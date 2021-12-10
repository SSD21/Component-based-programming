package dominoes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DominoHighLowSetImpl_Damani implements Domino {
	private Set<Integer> highLowSet;
	//pre: send any pair of numbers
	//post: determine true or false if numbers are valid
	
	public DominoHighLowSetImpl_Damani(int highPipCount, int lowPipCount)
	{

		highLowSet = new HashSet<Integer>();
		highLowSet.add(highPipCount);
		highLowSet.add(lowPipCount);
		
		
	}
	public static final char SUM_DIFFERENCE_DELIMETER =',';
	public static boolean isSumDifferenceString(String str)
	{
		if (str == null)
			return false;
		if (str.length() < 3)
			return false;
		//if (!str.contains("" + SUM_DIFFERENCE_DELIMETER))
		//	return false;
		Scanner readStr = new Scanner(str).useDelimiter("\\"+SUM_DIFFERENCE_DELIMETER);
		if(!readStr.hasNextInt())
			return false;
		//String[] arrOfStr = str.split(",", 2); 
		char hpc = str.charAt(0);
		char lpc = str.charAt(2);
		char sep = str.charAt(1);
		return lpc <= hpc && hpc >= lpc   && sep == SUM_DIFFERENCE_DELIMETER;
	}
	public DominoHighLowSetImpl_Damani(String sumDifferenceString)
	{ 
		//String[] arrOfStr = sumDifferenceString.split("SUM_DIFFERENCE_DELIMETER", 2);

		Scanner readStr = new Scanner (sumDifferenceString).useDelimiter ("\\" + SUM_DIFFERENCE_DELIMETER);
		
		int sum = readStr.nextInt();
		int diff = readStr.nextInt();
		//int sum = Integer.parseInt(arrOfStr[0]);
		//int diff = Integer.parseInt(arrOfStr[1]);
		int highPC = (sum/2) + (Math.abs(diff)/2);
		int lowPC = (sum/2) - (Math.abs(diff)/2);
		highLowSet = new HashSet<Integer>();
		highLowSet.add(highPC);
		highLowSet.add(lowPC);
		//check		
		
	}
	public static boolean isLowPlus8TimesHighInteger(int k)
	{
		if (!(0<=k && k <=54 ))//max k can be 54 when lpc and hpc are 6, min can be 0 when hpc an dlpc are 0
			return false;
		int lowPipCount = k%8;
		int highPipCount = (k-lowPipCount)/8;
		return highPipCount >= MINIMUM_PIP_COUNT && highPipCount <=MAXIMUM_PIP_COUNT && lowPipCount >= MINIMUM_PIP_COUNT && lowPipCount <=MAXIMUM_PIP_COUNT && highPipCount >=lowPipCount; 
	}
	
	public DominoHighLowSetImpl_Damani(int lowPlus8TimesHigh)
	{

		int lowPipCount = lowPlus8TimesHigh % 8;
		int highPipCount = (lowPlus8TimesHigh - lowPipCount) / 8;
		
		highLowSet = new HashSet<Integer>();
		highLowSet.add(lowPipCount);
		highLowSet.add(highPipCount);
			
	}
	@Override
	public int getHighPipCount() {
			
			assert highLowSet.size() == 2 || highLowSet.size() == 1;
			Integer[] array1 = highLowSet.toArray(new Integer[0]);
			
			int highPipCount;
			if(array1.length==1)
				highPipCount = array1[0];
			else
				highPipCount = array1[1];
			return highPipCount;

		
	}
	@Override
	public int getLowPipCount() {
		Object[] array = highLowSet.toArray();
		assert highLowSet.size() == 2 || highLowSet.size() == 1;
		Integer[] array1 = highLowSet.toArray(new Integer[0]);
		
		
		return array1[0];
	}
	
}
