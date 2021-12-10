package dominoes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test_cases {
	public static void main(String args[]) {
		
		System.out.println("BEGIN TESTING DOMINOHIGHLOWIMPLL_DAMANI: ");
		
		
		
		Domino domino = new DominoHighLowImpl_Damani(5,2);
		Domino domino1 = new DominoHighLowImpl_Damani("4:0");
		int[] array1 = new int[] {7,3};
		Domino domino3 = new DominoHighLowImpl_Damani(array1);
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(0);
		set1.add(1);
		Domino domino4 = new DominoHighLowImpl_Damani(set1);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(3);
		Domino d7 = new DominoHighLowImpl_Damani(set2);
		
		assert domino.getHighPipCount() == 5;
		assert domino.getLowPipCount()==2;
		assert domino1.getHighPipCount()== 4;
		assert domino1.getLowPipCount()== 0;
		assert domino3.getHighPipCount()==5;
		assert domino3.getLowPipCount()==2;
		assert domino4.getHighPipCount()==1;
		assert domino4.getLowPipCount()==0;
		assert d7.getHighPipCount()==3;
		assert d7.getLowPipCount()==3;
		assert DominoHighLowImpl_Damani.isHighLowString("5:3");
		assert DominoHighLowImpl_Damani.isHighLowString("3:5")==false;
		assert DominoHighLowImpl_Damani.isHighLowString("12:0")==false;
		
		
		
		
		System.out.println("FINISH TESTING DOMINOHIGHLOWIMPLL_DAMANI!! ");
		
		System.out.println("BEGIN TESTING DOMINOHIGHLOWSETIMPL_DAMANI: ");
		
		Domino domino5 = new DominoHighLowSetImpl_Damani(6,4);
		Domino d10 = new DominoHighLowSetImpl_Damani(12,2);
		Domino domino6 = new DominoHighLowSetImpl_Damani("8,4");
		Domino domino7 = new DominoHighLowSetImpl_Damani(42);
		Domino d13 = new DominoHighLowSetImpl_Damani(0);
		Domino d15 = new DominoHighLowSetImpl_Damani(56);
		
		assert domino5.getHighPipCount()==6;
		assert domino5.getLowPipCount()==4;
		assert d10.getHighPipCount() != 6;
		assert d10.getLowPipCount()!=6;
		assert domino6.getHighPipCount()==6;
		assert domino6.getLowPipCount()== 2;
		assert domino7.getHighPipCount()==5;
		assert domino7.getLowPipCount()==2;
		assert d13.getHighPipCount()==0;
		assert d13.getLowPipCount()==0;
		assert d15.getHighPipCount() !=6;
		assert d15.getLowPipCount() !=6;
		assert DominoHighLowSetImpl_Damani.isSumDifferenceString("8,4");
		assert DominoHighLowSetImpl_Damani.isSumDifferenceString("3,6")==false;
		assert DominoHighLowSetImpl_Damani.isLowPlus8TimesHighInteger(0);
		assert DominoHighLowSetImpl_Damani.isLowPlus8TimesHighInteger(34);
		assert DominoHighLowSetImpl_Damani.isLowPlus8TimesHighInteger(56) == false;
		
		
		System.out.println("FINISH TESTING DOMINOHIGHLOWSETIMPL_DAMANI!! ");
		
		
		System.out.println("BEGIN TESTING DOMINOLOWDIFFERENCESTRINGIMPL_DAMANI: ");
		
		
		Domino d16 = new DominoLowDifferenceStringImpl_Damani(27);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(5);
		Domino d19 = new DominoLowDifferenceStringImpl_Damani(list2);
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(4);
		list1.add(6);
		Domino domino9 = new DominoLowDifferenceStringImpl_Damani(list1);
		
		assert d16.getHighPipCount()== 3;
		assert d16.getLowPipCount()==3;
		assert d19.getHighPipCount()==3;
		assert d19.getLowPipCount()==2;
		assert domino9.getHighPipCount()==4;
		assert domino9.getLowPipCount()==2;

		System.out.println("FINISH TESTING DOMINOLOWDIFFERENCESTRINGIMPL_DAMANI: ");
	}

	
}
