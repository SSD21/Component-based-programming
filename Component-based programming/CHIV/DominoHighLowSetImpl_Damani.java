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

		assert highPipCount >= MINIMUM_PIP_COUNT && highPipCount <= MAXIMUM_PIP_COUNT : "high pip count is out of bounds!!";
		assert lowPipCount >= MINIMUM_PIP_COUNT && lowPipCount <= MAXIMUM_PIP_COUNT: "low pip count is out of bounds!!";
		assert highPipCount >= lowPipCount : "high pip count cannot be less than low pip count!!";
		highLowSet = new HashSet<Integer>();
		highLowSet.add(highPipCount);
		highLowSet.add(lowPipCount);
		
		
	}
	public static final char SUM_DIFFERENCE_DELIMETER =',';
	public static boolean isSumDifferenceString(String str)
	{
		//if (str == null)
		//	return false;
		assert str != null :"String is null, not valid!!";
		//if (str.length() < 3)
		//	return false;
		assert str.length() >=3 || str.length() <=4: "String length is not valid!!";
		//if (!str.contains("" + SUM_DIFFERENCE_DELIMETER))
		//	return false;
	
		Scanner readStr = new Scanner(str).useDelimiter("\\"+SUM_DIFFERENCE_DELIMETER);
		if(!readStr.hasNextInt())
			return false;
		
		int sum =0;
		int diff = 0;
		char sep = '0';
		if(str.length()==4) {
			char sumChar = str.charAt(0);
			char sumChar2 = str.charAt(1);
			sep = str.charAt(2);
			char diffChar = str.charAt(3);
			String sumString = String.valueOf(sumChar) + String.valueOf(sumChar2);
			String diffString = String.valueOf(diffChar);
			sum = Integer.parseInt(sumString);
			diff = Integer.parseInt(diffString);
			
			
		}
		if(str.length()==3) {
			char sumChar = str.charAt(0);
			char diffChar = str.charAt(2);
			sep = str.charAt(1);
			String sumString = String.valueOf(sumChar);
			String diffString = String.valueOf(diffChar);
			sum = Integer.parseInt(sumString);
			diff = Integer.parseInt(diffString);
		}
		if(sum < diff) {
			return false;
		}
		
		return diff <= sum && sum >= diff && sep== SUM_DIFFERENCE_DELIMETER; //check
		//return (2 * MINIMUM_PIP_COUNT <= sum &&  sum <= 2 * MAXIMUM_PIP_COUNT) &&
		//		(-(MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT) <= diff) && 
		//		(diff <= MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT);
	}
	public DominoHighLowSetImpl_Damani(String sumDifferenceString)
	{ 
		
		assert isSumDifferenceString(sumDifferenceString) :"String is not valid!!";
		
		int sum =0;
		int diff = 0;
		char sep = '0';
		if(sumDifferenceString.length()==4) {
			char sumChar = sumDifferenceString.charAt(0);
			char sumChar2 = sumDifferenceString.charAt(1);
			sep = sumDifferenceString.charAt(2);
			char diffChar = sumDifferenceString.charAt(3);
			String sumString = String.valueOf(sumChar) + String.valueOf(sumChar2);
			String diffString = String.valueOf(diffChar);
			sum = Integer.parseInt(sumString);
			diff = Integer.parseInt(diffString);
				
				
		}
		if(sumDifferenceString.length()==3) {
			char sumChar = sumDifferenceString.charAt(0);
			char diffChar = sumDifferenceString.charAt(2);
			sep = sumDifferenceString.charAt(1);
			String sumString = String.valueOf(sumChar);
			String diffString = String.valueOf(diffChar);
			sum = Integer.parseInt(sumString);
			diff = Integer.parseInt(diffString);
		}
		//char sumChar = sumDifferenceString.charAt(0);
		//char diffChar=sumDifferenceString.charAt(2);
		//int sum = Character.getNumericValue(sumChar);
		//int diff = Character.getNumericValue(diffChar);
		
		
		int highPipCount= (Math.round((sum + diff)/2));
		int lowPipCount= (Math.round((sum - diff)/2));
		
		highLowSet = new HashSet<Integer>();
		highLowSet.add(highPipCount);
		highLowSet.add(lowPipCount);
	}
	public static boolean isLowPlus8TimesHighInteger(int k)
	{
		assert (MINIMUM_PIP_COUNT + 8*MINIMUM_PIP_COUNT) <= k :"integer lowPlus8TimesHigh is out of bounds!!";
		assert k <= (MAXIMUM_PIP_COUNT+8*MAXIMUM_PIP_COUNT) : "integer lowPlus8TimesHigh is out of bounds!!";
		//if (!(2*MINIMUM_PIP_COUNT<=k && k <=2*MAXIMUM_PIP_COUNT && k <= 9*(k/8)))//max k can be 54 when lpc and hpc are 6, min can be 0 when hpc an dlpc are 0
		//	return false;
		assert k <= 9*(k/8);
		int lowPipCount = k%8;
		int highPipCount = (k-lowPipCount)/8;
		return highPipCount >= MINIMUM_PIP_COUNT && highPipCount <=MAXIMUM_PIP_COUNT && lowPipCount >= MINIMUM_PIP_COUNT && lowPipCount <=MAXIMUM_PIP_COUNT && highPipCount >=lowPipCount; 
	}
	
	public DominoHighLowSetImpl_Damani(int lowPlus8TimesHigh)
	{
		assert isLowPlus8TimesHighInteger(lowPlus8TimesHigh) :"Integer not valid";
		//assert (MINIMUM_PIP_COUNT + 8*MINIMUM_PIP_COUNT) <= lowPlus8TimesHigh :"integer lowPlus8TimesHigh is out of bounds!!";
		//assert lowPlus8TimesHigh <= (MAXIMUM_PIP_COUNT+8*MAXIMUM_PIP_COUNT) : "integer lowPlus8TimesHigh is out of bounds!!";
		//assert lowPlus8TimesHigh <= 9*(lowPlus8TimesHigh/8) : "Not a valid int lowPlus8TimesHigh";
		
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
