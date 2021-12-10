package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class IntegerClass_Damani {
	public static void main(String args[]) {
		int k=4;
		System.out.println("isEven(" + k + ") = " + IntegerUtils_Damani.isEven(k) +"\n"); //straightforward
		
		int x=0;
		System.out.println("isEven(" + x + ") = " + IntegerUtils_Damani.isEven(x) + "\n"); //extreme
		
		int y=101010;
		System.out.println("isEven(" + y + ") = " + IntegerUtils_Damani.isEven(y) + "\n"); //bizarre
		
		int s = 5;
		System.out.println("isOdd(" + s + ") = " + IntegerUtils_Damani.isOdd(s) + "\n"); //straightforward
		
		int t= 0;
		System.out.println("isOdd(" + t + ") = " + IntegerUtils_Damani.isOdd(t)+"\n"); //extreme
		
		int w=110100;
		System.out.println("isOdd(" + w + ") = " + IntegerUtils_Damani.isOdd(w)+"\n"); //bizarre
		
		int a = 5;
		System.out.println("isPrime(" + a + ") = " + IntegerUtils_Damani.isPrime(a)+"\n"); //straightforward
		
		int b= 171;
		System.out.println("isPrime(" + b + ") = " + IntegerUtils_Damani.isPrime(b)+"\n"); //extreme
		
		int c= 0;
		System.out.println("isPrime(" + c + ") = " + IntegerUtils_Damani.isPrime(c)+"\n"); //bizarre
		
		int m =12;
		int n=6;
		System.out.println("greatestCommonFactor(" + m+ " , " + n + ") = " + IntegerUtils_Damani.greatestCommonFactor(m,n)+"\n"); //straightforward
		
		
		int x1=-4;
		int x2=-2;
		System.out.println("greatestCommonFactor(" + x1+ " , " + x2 + ") = " + IntegerUtils_Damani.greatestCommonFactor(x1,x2)+"\n"); //extreme
		
		int p=0;
		int q=11;
		System.out.println("greatestCommonFactor(" + p+ " , " + q + ") = " + IntegerUtils_Damani.greatestCommonFactor(p,q)+"\n"); //bizarre
		
		int val= 7;
		int maximum=50;
		System.out.println("GreatestConstrainedMultiple(" + val+ " , " + maximum + ") = " + IntegerUtils_Damani.getGreatestConstrainedMultiple(val,maximum)+"\n"); //straightforward
		
		int val2=0;
		int max=7;
		System.out.println("GreatestConstrainedMultiple(" + val2+ " , " + max + ") = " + IntegerUtils_Damani.getGreatestConstrainedMultiple(val2,max)+"\n"); //extreme
		
		int val3=80;
		int max1=10;
		System.out.println("GreatestConstrainedMultiple(" + val3+ " , " + max1 + ") = " + IntegerUtils_Damani.getGreatestConstrainedMultiple(val3,max1)+"\n"); //bizarre
		
		
		int q1=21;
		int r1=4;
		System.out.println("getintegerH(" + q1 + "," + r1 +") = " + IntegerUtils_Damani.getIntegerH(q1, r1)+ "\n");//straightforward
		
		int q2=10;
		int r2=2;
		System.out.println("getintegerH(" + q2 + "," + r2 +") = " + IntegerUtils_Damani.getIntegerH(q2, r2)+ "\n");//straightforward
		
		int q3=0;
		int r3=15;
		System.out.println("getintegerH(" + q3 + "," + r3 +") = " + IntegerUtils_Damani.getIntegerH(q3, r3)+ "\n");//extreme
		
		int q4=0;
		int r4=0;
		System.out.println("getintegerH(" + q4 + "," + r4 +") = " + IntegerUtils_Damani.getIntegerH(q4, r4)+ "\n");//bizarre
		
		
		
		
		List <Integer> list = new ArrayList <Integer> ();
		list.add(1);
		list.add(17);
		list.add(-22);
		list.add(48);
		list.add(19);
		
		System.out.println("GetMaximum({1,17,-22,48,19}) = " + IntegerUtils_Damani.getMaximum((list))+"\n"); //straightforward
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(005);
		list2.add(5);
		//list2.add(500)
		
		System.out.println("GetMaximum({005,5}) = " + IntegerUtils_Damani.getMaximum((list2))+"\n"); //extreme
		
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(0);
		
		System.out.println("GetMaximum({0}) = " + IntegerUtils_Damani.getMaximum((list3))+"\n"); //bizarre
		
		int[] intArray = new int[] {2,4,6,8,10};
		System.out.println("getMinimum({2,4,6,8,10}) = " + IntegerUtils_Damani.getMinimum(intArray)+"\n"); //straightforward
		
		int[] arr= new int[] {0,-452,-105,98};
		System.out.println("getMinimum({0,-452,-105,98}) = " + IntegerUtils_Damani.getMinimum(arr)+"\n"); //extreme
		
		int[] arr2 = new int[] {0};
		System.out.println("getMinimum({0}) = " + IntegerUtils_Damani.getMinimum(arr2)+"\n"); //bizarre
		
		int[] sorted = new int[] {1,17,-48,-22,19};
		System.out.println("isSorted({1,17,-48,-22,19}) = " + IntegerUtils_Damani.isSorted(sorted)+"\n"); //straightforward
		
		int[] sorted1= new int[] {2,4,6,8,10};
		System.out.println("isSorted({2,4,6,8,10}) = " + IntegerUtils_Damani.isSorted(sorted1)+"\n"); //straightforward
	
		int[] sorted2 = new int[] {};
		System.out.println("isSorted({}) = " + IntegerUtils_Damani.isSorted(sorted2)+"\n"); //extreme
		
		int[] sorted3=new int[] {5,5};
		System.out.println("isSorted({5,5}) = " + IntegerUtils_Damani.isSorted(sorted3)+"\n"); //bizarre
		
		int[] match1=new int[] {2,4,6,8,10};
		int target1=6;
		System.out.println("getSmallestIndexOfMatch( {2,4,6,8,10} " + " ,"  + target1 + ") = " + IntegerUtils_Damani.getSmallestIndexOfMatch(match1,target1)+"\n"); //straightforward
		
		int[] match2 = new int[] {2,4,6,8,10};
		int target2 = 22;
		System.out.println("getSmallestIndexOfMatch( {2,4,6,8,10} " + " ,"  + target2 + ") = " + IntegerUtils_Damani.getSmallestIndexOfMatch(match2,target2)+"\n"); //extreme
		
		int[] match3= new int[] {10,20,30};
		int target3=-1;
		System.out.println("getSmallestIndexOfMatch( {10,20,30} " + " ,"  + target3 + ") = " + IntegerUtils_Damani.getSmallestIndexOfMatch(match3,target3)+"\n"); //extreme
		
		int[] match4 = new int[] {0,0,64,21,0};
		int target4 = 0;
		System.out.println("getSmallestIndexOfMatch( {0,0,64,21,0} " + " ,"  + target4 + ") = " + IntegerUtils_Damani.getSmallestIndexOfMatch(match4,target4)+"\n");
		
		int num1=92;
		System.out.println("reverse( " + num1+ ") = " + IntegerUtils_Damani.reverse(num1)+"\n"); //straightforward
		
		int num3=0;
		System.out.println("reverse( " + num3 + ") = " + IntegerUtils_Damani.reverse(num3)+"\n"); //extreme
		
		int num4=005;
		System.out.println("reverse(" + num4 + ") = " + IntegerUtils_Damani.reverse(num4) + "\n");//bizarre
		
		int num5=500;
		System.out.println("reverse(" + num5 + ") = " + IntegerUtils_Damani.reverse(num5) + "\n");//bizarre
		
		
		long val1=29;
		System.out.println("long( " + val1 + ") = " + IntegerUtils_Damani.sumthing(val1)+"\n"); //straightforward
		
		long v1 = 55;
		System.out.println("long( " + v1 + ") = " + IntegerUtils_Damani.sumthing(v1)+"\n"); //extreme
		
		long v2=007;
		System.out.println("long(" + v2 + ") = " + IntegerUtils_Damani.sumthing(v2) + "\n"); //bizarre
		
	}

}
