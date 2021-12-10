package dominoes;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DominoLowDifferenceStringImpl_Damani implements Domino {
	private String lowDifferenceString;
	private static final char LOW_DIFFERENCE_DELIMETER = '*';
	
	
	//pre: lowPlus8TimesHigh must be greater than 0 and less than 54
	//post: lowDifferenceString is set according to the input parameter.
	public DominoLowDifferenceStringImpl_Damani(int lowPlus8TimesHigh)
	{

		
		int lowPipCount = lowPlus8TimesHigh % 8;
		int highPipCount = (lowPlus8TimesHigh - lowPipCount)/8;
		int diff = highPipCount - lowPipCount;
		lowDifferenceString = lowPipCount + " " + LOW_DIFFERENCE_DELIMETER + " " + diff;
	}
	
	public static final int INDEX_OF_HIGH =0;
	public static final int INDEX_OF_SUM=1;
	
	//pre: the size of the list must be 2
	//post: Writes a new lowDifference String with the given low pip count and difference
	public DominoLowDifferenceStringImpl_Damani(List<Integer> highSum)
	{

		
		if (highSum.size() < 2)
			System.out.println("Size of list is not valid.");
		if (highSum.get(INDEX_OF_HIGH) > highSum.get(INDEX_OF_SUM))
			System.out.println("high pip count cannot be greater than sum");
		
		int highPipCount = highSum.get(INDEX_OF_HIGH);
		int sum = highSum.get(INDEX_OF_SUM);
		int lowPipCount = sum - highPipCount;
		

		int diff = highPipCount - lowPipCount;
		lowDifferenceString = lowPipCount + " " + LOW_DIFFERENCE_DELIMETER + " " + diff;
	
	}	

	@Override
	public int getHighPipCount() {
		
		
		char lpc = lowDifferenceString.charAt(0);
		char difference = lowDifferenceString.charAt(4);
		int lowPipCount = Character.getNumericValue(lpc);
		int diff = Character.getNumericValue(difference);
		int highPipCount = lowPipCount + diff;
		return highPipCount;
	}

	@Override
	public int getLowPipCount() {
		
		char lpc = lowDifferenceString.charAt(0);
		int lowPipCount = Character.getNumericValue(lpc);
		return lowPipCount;
	}

}

