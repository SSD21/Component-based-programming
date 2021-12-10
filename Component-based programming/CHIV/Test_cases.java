package dominoes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test_cases {
	public static void main(String args[]) {
		
		//Domino newConstructor = new DominoHighLowImpl_Damani(3,0,3,2);
		//System.out.println("highPipCount = " + newConstructor.getHighPipCount());
		//System.out.println("lowPipCOunt = " + newConstructor.getLowPipCount());
		System.out.println("BEGIN TESTING DOMINOHIGHLOWIMPLL_DAMANI: ");
		
		
		
		Domino domino = new DominoHighLowImpl_Damani(5,2);
		Domino domino1 = new DominoHighLowImpl_Damani("4:0");
		//Domino testcase3 = new DominoHighLowImpl_Damani("12,2");
		//Domino testcase4 = new DominoHighLowImpl_Damani("0,2");
		int[] array1 = new int[] {7,3};
		Domino domino3 = new DominoHighLowImpl_Damani(array1);
		//int[] array2 = new int[] {1,11};
		//Domino testcase5 = new DominoHighLowImpl_Damani(array2);
		//int[] array3 = new int[] {9,0};
		//Domino testcase6 = new DominoHighLowImpl_Damani(array3);
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(0);
		set1.add(1);
		Domino domino4 = new DominoHighLowImpl_Damani(set1);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(3);
		Domino d7 = new DominoHighLowImpl_Damani(set2);
		
		//Set<Integer> set3 = new HashSet<Integer>();
		//set3.add(12);
		//set3.add(2);
		//Domino testcase7 = new DominoHighLowImpl_Damani(set3);
		//Domino domino10 = new DominoHighLowImpl_Damani(24,12);
		
		Domino testcase8 = new DominoHighLowImpl_Damani(2,2,1,2);
		
		//Domino testcase9 = new DominoHighLowImpl_Damani(3,0,3,2);
		
		//assert testcase9.getHighPipCount() == 3;
		//assert testcase9.getLowPipCount()==3;
		assert testcase8.getHighPipCount() == 5;
		assert testcase8.getLowPipCount()==2;
		
		assert domino.getHighPipCount() == 5;
		assert domino.getLowPipCount()==2;
		assert domino1.getHighPipCount()== 4;
		assert domino1.getLowPipCount()== 0;
		assert domino3.getHighPipCount()==5;
		assert domino3.getLowPipCount()==2;
		//assert domino4.getHighPipCount()==1;
		//assert domino4.getLowPipCount()==0;
		assert d7.getHighPipCount()==3;
		assert d7.getLowPipCount()==3;
		assert DominoHighLowImpl_Damani.isHighLowString("5:3");
		assert DominoHighLowImpl_Damani.isHighLowString("3:5")==false;
		//assert DominoHighLowImpl_Damani.isHighLowString("12:0")==false;
		//assert domino10.getHighPipCount() != 6;
		//assert domino10.getLowPipCount()!=6;
		
		
		
		System.out.println("FINISH TESTING DOMINOHIGHLOWIMPLL_DAMANI!! ");
		
		System.out.println("BEGIN TESTING DOMINOHIGHLOWSETIMPL_DAMANI: ");
		
		Domino domino5 = new DominoHighLowSetImpl_Damani(6,4);
		//Domino d10 = new DominoHighLowSetImpl_Damani(12,2);
		Domino domino7 = new DominoHighLowSetImpl_Damani(42);
		Domino d13 = new DominoHighLowSetImpl_Damani(0);
		//Domino d15 = new DominoHighLowSetImpl_Damani(56);
		//assert DominoHighLowSetImpl_Damani.isSumDifferenceString("7,3");
		Domino testcase = new DominoHighLowSetImpl_Damani("7,3");
		Domino testcase2 = new DominoHighLowSetImpl_Damani("1,1");
		Domino finaltestcase = new DominoHighLowSetImpl_Damani("10,2");
		
		assert domino5.getHighPipCount()==6;
		assert domino5.getLowPipCount()==4;
		//assert d10.getHighPipCount() != 6;
		//assert d10.getLowPipCount()!=6;
		assert domino7.getHighPipCount()==5;
		assert domino7.getLowPipCount()==2;
		assert d13.getHighPipCount()==0;
		assert d13.getLowPipCount()==0;
		//assert d15.getHighPipCount() !=6;
		//assert d15.getLowPipCount() !=6;
		assert testcase.getHighPipCount()==5;
		assert testcase.getLowPipCount()==2;
		assert testcase2.getHighPipCount()==1;
		assert testcase2.getLowPipCount()==0;
		assert DominoHighLowSetImpl_Damani.isSumDifferenceString("8,4");
		assert DominoHighLowSetImpl_Damani.isSumDifferenceString("3,6")==false;
		assert DominoHighLowSetImpl_Damani.isLowPlus8TimesHighInteger(0);
		assert DominoHighLowSetImpl_Damani.isLowPlus8TimesHighInteger(34);
		//assert DominoHighLowSetImpl_Damani.isLowPlus8TimesHighInteger(56) == false;
		assert DominoHighLowSetImpl_Damani.isSumDifferenceString("7,1");
		assert DominoHighLowSetImpl_Damani.isSumDifferenceString("12,0");
		assert finaltestcase.getHighPipCount() == 6;
		assert finaltestcase.getLowPipCount()==4;
		
		
		
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
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(2);
		list3.add(6);
		//Domino testcase10 = new DominoLowDifferenceStringImpl_Damani(list3);
		
		//assert testcase10.getHighPipCount() == 2;
		//assert testcase10.getLowPipCount() == 4;
		assert d16.getHighPipCount()== 3;
		assert d16.getLowPipCount()==3;
		assert d19.getHighPipCount()==3;
		assert d19.getLowPipCount()==2;
		assert domino9.getHighPipCount()==4;
		assert domino9.getLowPipCount()==2;

		System.out.println("FINISH TESTING DOMINOLOWDIFFERENCESTRINGIMPL_DAMANI: ");
	}

	
}
